import '../../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../../AppNavbar";
import HomeworkTable from "../tables/HomeworkTable";

function HomeworksPage() {
    const[homeworks, setHomeworks] = useState([]);

    useEffect(() => {
        fetch('/homeworks').then(response => response.json()).then(data => {
            setHomeworks(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Homework List</h2>
                    <HomeworkTable homeworks={homeworks} setHomeworks={setHomeworks}/>
                </div>
            </header>
        </div>
    );
}

export default HomeworksPage;