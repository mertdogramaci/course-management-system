import React, { useState, useEffect } from "react";
import useAuth from '../hooks/useAuth';
import ApiRoutes from '../api/routes';
import axios from '../api/axios';
import { Button } from "reactstrap";
import { Navigate } from "react-router-dom";

function HomePage() {
    const { user } = useAuth();
    const [advisor, setAdvisor] = useState([]);
    const [department, setDepartment] = useState([]);

    useEffect(() => {
        fetchAdvisor();
    }, [])

    useEffect(() => {
        fetchStudent();
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

    const fetchStudent = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/getDepartment/' + user.id);

            if (response.status === 200) {
                setDepartment(response);
                console.log(department);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div>
            <div>
                <h4>Aktif Akademik Dönem Bilgileri</h4>

            </div>
            <div>
                <h4>Advisor Information</h4>
                <p>{advisor.firstName} {advisor.lastName}</p>
                <p>{advisor.email}</p>
                <Button onClick={Navigate(``)}>Detail</Button>
            </div>
            <div>
                <h4>Öğrenim Bilgileri</h4>
                <p>{department.name}</p>
            </div>
        </div>
    );
}

export default HomePage;