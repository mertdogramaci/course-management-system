import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import StudentTable from "../tables/StudentTable";

function StudentsPage() {
    const[students, setStudents] = useState([]);

    useEffect(() => {
        fetch('/students').then(response => response.json()).then(data => {
            setStudents(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Student List</h2>
                    <StudentTable students={students} setStudents={setStudents}/>
                </div>
            </header>
        </div>
    );
}

export default StudentsPage;