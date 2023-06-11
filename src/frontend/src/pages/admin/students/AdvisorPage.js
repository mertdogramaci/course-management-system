import React, { useState, useEffect } from "react";
import useAuth from '../../../hooks/useAuth';
import ApiRoutes from '../../../api/routes';
import axios from '../../../api/axios';

function AdvisorPage() {
    const { user } = useAuth();
    const [advisor, setAdvisor] = useState([]);

    useEffect(() => {
        fetchAdvisor();
    }, [])

    const fetchAdvisor = async () => {
        try {
            const response = await axios.get(ApiRoutes.ADVISOR + '/studentId/' + user.id);

            if (response.status === 200) {
                setAdvisor(response.data.instructor);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div className="advisor">
            <p>Name Surname:&nbsp;{advisor.firstName} {advisor.lastName}</p>
            <p>Faculty:&nbsp;{(advisor.department === undefined) ? null : advisor.department.faculty.name}</p>
            <p>Department:&nbsp;{(advisor.department === undefined) ? null : advisor.department.name}</p>
            <p>Phone Number:&nbsp;{advisor.phoneNumber}</p>
            <p>Email:&nbsp;{advisor.email}</p>
        </div>
    );
}

export default AdvisorPage;