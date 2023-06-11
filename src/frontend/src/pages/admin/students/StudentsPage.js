import '../../../App.css';
import React, { useEffect, useState } from "react";
import StudentTable from "./StudentTable";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';

function StudentsPage() {
    const[students, setStudents] = useState([]);

    useEffect(() => {
        fetchAllStudents();
    }, [])

    const fetchAllStudents = async () => {
        try {
            const response = await axios.get(ApiRoutes.STUDENTS);
    
            if (response.status === 200) {
                setStudents(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }


    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <h2>Student List</h2>
                    <StudentTable students={students} setStudents={setStudents}/>
                </div>
            </header>
        </div>
    );
}

export default StudentsPage;