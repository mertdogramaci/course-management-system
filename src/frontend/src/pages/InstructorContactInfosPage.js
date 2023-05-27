import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import InstructorContactInfoTable from '../tables/InstructorContactInfoTable';

function InstructorContactInfosPage() {
    const[instructorContactInfos, setInstructorContactInfos] = useState([]);

    useEffect(() => {
        fetch('/instructorContactInfos').then(response => response.json()).then(data => {
            setInstructorContactInfos(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Instructor List</h2>
                    <InstructorContactInfoTable instructorContactInfos={instructorContactInfos} setInstructorContactInfos={setInstructorContactInfos}/>
                </div>
            </header>
        </div>
    );
}

export default InstructorContactInfosPage;