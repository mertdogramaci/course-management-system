import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import CourseTable from "../tables/CourseTable";

function CoursesPage() {
    const[courses, setCourses] = useState([]);

    useEffect(() => {
        fetch('/courses').then(response => response.json()).then(data => {
            setCourses(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Course List</h2>
                    <CourseTable courses={courses} setCourses={setCourses}/>
                </div>
            </header>
        </div>
    );
}

export default CoursesPage;