import '../App.css';
import React, { useEffect, useState } from "react";
import AppNavbar from "../AppNavbar";
import CourseTable from "../components/tables/CourseTable";
import axios from '../api/axios';
import ApiRoutes from '../api/routes';

function CoursesPage() {
    const[courses, setCourses] = useState([]);

    useEffect(() => {
        fetchAllCourses();
    }, [])

    const fetchAllCourses = async () => {
        try {
          const response = await axios.get(ApiRoutes.COURSES);

          if (response.status === 200) {
            setCourses(response.data);
          }
        } catch (error) {
            console.log("error!!");
        }
      }

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <AppNavbar/>
                    <h2>Course List</h2>
                    <CourseTable courses={courses} setCourses={setCourses}/>
                </div>
            </header>
        </div>
    );
}

export default CoursesPage;