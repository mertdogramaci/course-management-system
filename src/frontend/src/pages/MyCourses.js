import React, { useEffect, useState } from "react";
import axios from '../api/axios';
import ApiRoutes from '../api/routes';
import useAuth from '../hooks/useAuth';

function MyCourses() {
    const[sections, setSections] = useState([]);
    const { user } = useAuth();

    useEffect(() => {
        fetchAllSections();
    }, [])

    const fetchAllSections = async () => {
        try {
          const response = await axios.get(ApiRoutes.STUDENT_ENROLLS_SECTION + "/" + user.id);
          console.log(sections);

          if (response.status === 200) {
            setSections(response.data);
          }
        } catch (error) {
            console.log("error!!");
        }
      }

    return (
        <div>
        </div>
    );
}

export default MyCourses;