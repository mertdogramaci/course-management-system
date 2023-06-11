import React, { useState, useEffect } from "react";
import useAuth from '../hooks/useAuth';
import ApiRoutes from '../api/routes';
import axios from '../api/axios';
import { Button } from "reactstrap";
import { Navigate, useNavigate } from "react-router-dom";

function HomePage() {
    const { user } = useAuth();
    const [advisor, setAdvisor] = useState([]);
    const [department, setDepartment] = useState([]);
    const [grade, setGrade] = useState([]);
    const [theWord, setTheWord] = useState([]);

    let navigate = useNavigate();

    const routeChange = () => {
        let path = `/advisor`;
        navigate(path);
    }

    useEffect(() => {
        fetchAdvisor();
    }, [])

    useEffect(() => {
        fetchDepartment();
    }, [])

    useEffect(() => {
        fetchGrade();
        if (grade === 1) {
            setTheWord("st");
        } else if (grade === 2) {
            setTheWord("nd");
        } else if (grade === 3) {
            setTheWord("rd");
        } else {
            setTheWord("th");
        }
    }, [])

    const fetchAdvisor = async () => {
        try {
            const response = await axios.get(ApiRoutes.ADVISOR + '/studentId/' + user.id);

            if (response.status === 200) {
                setAdvisor(response.data.instructor);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    const fetchDepartment = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/getDepartment/' + user.id);

            if (response.status === 200) {
                setDepartment(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    const fetchGrade = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/getYear/' + user.id);

            if (response.status === 200) {
                setGrade(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div>
            <div className="home">
                <h4>Active Academic Term Information</h4>
                <p>2022-2023 Spring</p>
            </div>
            <div className="home">
                <h4>Advisor Information</h4>
                <p>{advisor.firstName} {advisor.lastName}</p>
                <p>{advisor.email}</p>
                <Button onClick={routeChange}>Detail</Button>
            </div>
            <div className="home">
                <h4>Education Information</h4>
                <p>Faculty of {(department.faculty === undefined) ? null : department.faculty.name} / {department.name}</p>
                <p> {grade}{theWord} year</p>
            </div>
        </div>
    );
}

export default HomePage;