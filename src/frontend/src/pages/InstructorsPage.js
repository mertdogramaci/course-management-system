import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import InstructorTable from '../tables/InstructorTable';

function InstructorsPage() {
    const[instructors, setInstructors] = useState([]);

    useEffect(() => {
        fetch('/instructors').then(response => response.json()).then(data => {
            setInstructors(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Instructor List</h2>
                    <InstructorTable instructors={instructors} setInstructors={setInstructors}/>
                </div>
            </header>
        </div>
    );
}

export default InstructorsPage;