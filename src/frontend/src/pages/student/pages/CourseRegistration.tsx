import '../../../App.css';
import React, { useEffect, useState } from "react";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';
import { Input } from "reactstrap";
import { MemberType, User, Student } from '../../../@types/user';
import SectionEnrollTable from "../tables/SectionEnrollTable";

function CourseRegistration() {
    const [sections, setSections] = useState([]);
    const { user } = useAuth();
    const [semester, setSemester] = useState(true);
    const [year, setYear] = useState(2023);
    const [studentUser, setStudentUser] = useState<Student | null>(null);

    useEffect(() => {
        if (user) {
            getStudentData(user.id);
            fetchSectionsToEnroll();
        }
    }, [semester, year, user])

    const fetchSectionsToEnroll = async () => {
        try {
            const response = await axios.get(ApiRoutes.SECTIONS_TO_ENROLL + '/' + user?.id + '/' + semester + '/' + year);

            console.log(response);

            if (response.status === 200) {
                setSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    const getStudentData = async (userId) => {
        try {
          const response = await axios.get(`members/findStudent/${userId}`);

          if (response.status === 200) {
            setStudentUser(response.data);
          }
        } catch (error) {
          console.log("error");
        }
      };

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                <h2>{`${year} ${semester ? 'Fall' : 'Spring'} Courses to Enroll`}</h2>
                    <SectionEnrollTable sections={sections} setSections={setSections} fetchSectionsToEnroll={fetchSectionsToEnroll} />
                </div>
            </header>
        </div>
    );
}

export default CourseRegistration;