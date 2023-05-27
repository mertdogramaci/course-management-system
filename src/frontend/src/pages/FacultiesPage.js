import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import FacultyTable from "../tables/FacultyTable";

function FacultiesPage() {
    const[faculties, setFaculties] = useState([]);

    useEffect(() => {
        fetch('/faculties').then(response => response.json()).then(data => {
            setFaculties(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Faculties List</h2>
                    <FacultyTable faculties={faculties} setFaculties={setFaculties}/>
                </div>
            </header>
        </div>
    );
}

export default FacultiesPage;