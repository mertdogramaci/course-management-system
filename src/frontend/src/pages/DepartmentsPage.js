import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import StudentTable from "../tables/DepartmentTable";

function DepartmentsPage() {
    const[departments, setDepartments] = useState([]);

    useEffect(() => {
        fetch('/departments').then(response => response.json()).then(data => {
            setDepartments(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Department List</h2>
                    <StudentTable departments={departments} setDepartments={setDepartments}/>
                </div>
            </header>
        </div>
    );
}

export default DepartmentsPage;