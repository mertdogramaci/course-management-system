import '../../../App.css';
import React, { useEffect, useState } from "react";
import CourseTable from "../tables/CourseTable";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';

function CoursesPage() {
    const[sections, setSections] = useState([]);
    const { user } = useAuth();

    useEffect(() => {
        fetchAllCourses();
    }, [])

    const fetchAllCourses = async () => {
        try {
          const response = await axios.get(ApiRoutes.COURSES + '/' + user.id);

          if (response.status === 200) {
            setSections(response.data);
          }
        } catch (error) {
            console.log("error!!");
        }
      }

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <h2>Course List</h2>
                    <CourseTable sections={sections} setSections={setSections}/>
                </div>
            </header>
        </div>
    );
}

export default CoursesPage;