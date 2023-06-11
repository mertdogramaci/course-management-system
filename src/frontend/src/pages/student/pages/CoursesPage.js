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
    const [semester, setSemester] = useState(true);
    const [year, setYear] = useState(2023);

    useEffect(() => {
        fetchAllCourses();
    }, [semester, year])

    const fetchAllCourses = async () => {
        try {
            const response = await axios.get(ApiRoutes.COURSES + '/' + user.id + '/' + semester + '/' + year);

            if (response.status === 200) {
                setSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    const selectTerm = async (event) => {
        if (event.target.value === "0") {
            setSemester(true);
            setYear(2023);
        } else if (event.target.value === "1") {
            setSemester(false);
            setYear(2022);
        } else if (event.target.value === "2") {
            setSemester(true);
            setYear(2022);
        } else if (event.target.value === "3") {
            setSemester(false);
            setYear(2021);
        } else if (event.target.value === "4") {
            setSemester(true);
            setYear(2021);
        }
    }

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <span>
                        Term
                        &nbsp;&nbsp;
                        <Input type="select" name="term" className="dropdownTerm" onClick={selectTerm}>
                            <option value={"0"}>2022 - 2023 Spring</option>
                            <option value={"1"}>2022 - 2023 Fall</option>
                            <option value={"2"}>2021 - 2022 Spring</option>
                            <option value={"3"}>2021 - 2022 Fall</option>
                            <option value={"4"}>2020 - 2021 Spring</option>
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