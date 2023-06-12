import '../../../App.css';
import React, { useEffect, useState } from "react";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import SectionsTable from './SectionsTable';

function SectionsPage() {
    const [sections, setSections] = useState([]);

    useEffect(() => {
        fetchAllSections();
    })

    const fetchAllSections = async () => {
        try {
            const response = await axios.get(ApiRoutes.SECTIONS);

            if (response.status === 200) {
                setSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div className='App'>
            <header className="App-header">
                <div className="App-intro">
                    <h2>Sections List</h2>
                    <SectionsTable sections={sections} setSections={setSections}/>
                </div>
            </header>
        </div>
    );
}

export default SectionsPage;