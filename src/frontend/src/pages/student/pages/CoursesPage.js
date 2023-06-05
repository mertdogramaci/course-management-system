import '../../../App.css';
import React, { useEffect, useState } from "react";
import CourseTable from "../tables/CourseTable";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';
import { Input } from "reactstrap";

function CoursesPage() {
    const [sections, setSections] = useState([]);
    const { user } = useAuth();
    const [semester, setSemester] = useState([]);
    const [year, setYear] = useState([]);

    useEffect(() => {
        fetchAllCourses();
    }, [])

    const fetchAllCourses = async () => {
        try {
            const response = await axios.get(ApiRoutes.COURSES + '/' + user.id);

            if (response.status === 200) {
                setSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    function selectTerm(semester, year) {
        setSemester(semester);
        setYear(year);
    }

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <span>
                        Term
                        &nbsp;&nbsp;
                        <Input type="select" name="term" className="dropdownTerm">
                            <option onClick={selectTerm}>2022 - 2023 Spring</option>
                            <option onClick={selectTerm}>2022 - 2023 Fall</option>
                            <option onClick={selectTerm}>2021 - 2022 Spring</option>
                            <option onClick={selectTerm}>2021 - 2022 Fall</option>
                            <option onClick={selectTerm}>2020 - 2021 Spring</option>
                        </Input>
                    </span>
                    <h2>Course List</h2>
                    <CourseTable sections={sections} setSections={setSections} />
                </div>
            </header>
        </div>
    );
}

export default CoursesPage;