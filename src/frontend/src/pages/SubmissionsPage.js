import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import SubmissionTable from '../tables/SubmissionTable';

function SubmissionsPage() {
    const[submissions, setSubmissions] = useState([]);

    useEffect(() => {
        fetch('/submissions').then(response => response.json()).then(data => {
            setSubmissions(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Submission List</h2>
                    <SubmissionTable submissions={submissions} setSubmissions={setSubmissions}/>
                </div>
            </header>
        </div>
    );
}

export default SubmissionsPage;