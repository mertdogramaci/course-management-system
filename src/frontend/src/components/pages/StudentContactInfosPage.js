import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import StudentContactInfoTable from "../tables/StudentContactInfoTable";

function StudentContactInfosPage() {
    const[studentContactInfos, setStudentContactInfos] = useState([]);

    useEffect(() => {
        fetch('/studentContactInfos').then(response => response.json()).then(data => {
            setStudentContactInfos(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>StudentContactInfo List</h2>
                    <StudentContactInfoTable studentContactInfos={studentContactInfos} setStudentContactInfos={setStudentContactInfos}/>
                </div>
            </header>
        </div>
    );
}

export default StudentContactInfosPage;