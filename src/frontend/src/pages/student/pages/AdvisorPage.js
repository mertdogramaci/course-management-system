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
            <p>Name Surname:&emsp;{advisor.firstName} {advisor.lastName}</p>
            <p>Faculty:&emsp;&emsp;&emsp;&emsp;&ensp;&nbsp;{(advisor.department === undefined) ? null : advisor.department.faculty.name}</p>
            <p>Department:&emsp;&emsp;&ensp;&nbsp;{(advisor.department === undefined) ? null : advisor.department.name}</p>
            <p>Phone Number:&emsp;{advisor.phoneNumber}</p>
            <p>Email:&emsp;&emsp;&emsp;&emsp;&emsp;{advisor.email}</p>
        </div>
    );
}

export default AdvisorPage;