import React, { useEffect, useState } from "react";
import '../../App.css';
import AppNavbar from "../../AppNavbar";
import SectionTable from "../tables/SectionTable";

function SectionsPage() {
    const[sections, setSections] = useState([]);

    useEffect(() => {
        fetch('/sections').then(response => response.json()).then(data => {
            setSections(data);
        })
    }, [])

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Section List</h2>
                    <SectionTable sections={sections} setSections={setSections}/>
                </div>
            </header>
        </div>
    );
}


export default SectionsPage;