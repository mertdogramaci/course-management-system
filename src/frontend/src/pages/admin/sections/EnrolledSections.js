import '../../../App.css';
import React, { useEffect, useState } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import SectionsTable from './SectionsTable';
import EnrolledSectionsTable from './EnrolledSectionsTable';

function EnrolledSections() {
    const [sections, setSections] = useState([]);
    const { id } = useParams();

    useEffect(() => {
        fetchAllSections();
    })

    const fetchAllSections = async () => {
        try {
            const response = await axios.get(ApiRoutes.COURSES + "/" + id);

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
                    <h2>Sections List for {(sections[0]) ? sections[0].student.firstName : " "} {(sections[0]) ? sections[0].student.lastName : " "}</h2>
                    <EnrolledSectionsTable sections={sections} setSections={setSections}/>
                </div>
            </header>
        </div>
    );
}

export default EnrolledSections;