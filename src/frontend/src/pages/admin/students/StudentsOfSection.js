import '../../../App.css';
import React, { useEffect, useState } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import StudentTable from './StudentTable';
import StudentSectionTable from './StudentSectionTable';

function StudentsOfSection() {
    const [students, setStudents] = useState([]);
    const { id } = useParams();

    useEffect(() => {
        fetchAllSections();
    })

    const fetchAllSections = async () => {
        try {
            const response = await axios.get(ApiRoutes.COURSES + "/section/" + id);

            if (response.status === 200) {
                setStudents(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    console.log(students);

    return (
        <div className='App'>
            <header className="App-header">
                <div className="App-intro">
                    <h2>Student List</h2>
                    <StudentSectionTable students={students} setStudents={setStudents}/>
                </div>
            </header>
        </div>
    );
}

export default StudentsOfSection;