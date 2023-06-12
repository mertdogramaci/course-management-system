import '../../App.css';
import React, { useEffect, useState } from "react";
import ApiRoutes from '../../api/routes';
import axios from '../../api/axios';

function StatisticsPage() {
    const [numberOfUsers, setNumberOfUsers] = useState(0);
    const [numberOfStudents, setNumberOfStudents] = useState(0);
    const [numberOfInstructors, setNumberOfInstructors] = useState(0);
    const [mostDepartment, setMostDepartment] = useState([]);
    const [mostSection, setMostSection] = useState([]);
    const [averageGradeSection, setAverageGradeSection] = useState([]);
    const [lastMember, setLastMember] = useState([]);
    const [firstMember, setFirstMember] = useState([]);
    const [maxQuotaSections, setMaxQuotaSections] = useState([]);
    const [minQuotaSections, setMinQuotaSections] = useState([]);

    useEffect(() => {
        fetchMemberStatistics();
    })

    const fetchMemberStatistics = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/memberStatistics');

            if (response.status === 200) {
                setNumberOfUsers(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchStudentStatistics();
    })

    const fetchStudentStatistics = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/studentStatistics');

            if (response.status === 200) {
                setNumberOfStudents(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchInstructorStatistics();
    })

    const fetchInstructorStatistics = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/instructorStatistics');

            if (response.status === 200) {
                setNumberOfInstructors(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchDepartmentStatistics();
    }, [])

    const fetchDepartmentStatistics = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/departmentStatistics');

            if (response.status === 200) {
                setMostDepartment(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchSectionStatistics();
    }, [])

    const fetchSectionStatistics = async () => {
        try {
            const response = await axios.get(ApiRoutes.COURSES + '/courseStatistics');

            if (response.status === 200) {
                setMostSection(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchAverageGradeSectionStatistics();
    }, [])

    const fetchAverageGradeSectionStatistics = async () => {
        try {
            const response = await axios.get('/studentEnrollsSection/courseAverageStatistics');

            if (response.status === 200) {
                setAverageGradeSection(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchLastMember();
    }, [])

    const fetchLastMember = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/lastMemberStatistics');

            if (response.status === 200) {
                setLastMember(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchFirstMember();
    }, [])

    const fetchFirstMember = async () => {
        try {
            const response = await axios.get(ApiRoutes.MEMBER + '/firstMemberStatistics');

            if (response.status === 200) {
                setFirstMember(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchMaxQuotaSections();
    }, [])

    const fetchMaxQuotaSections = async () => {
        try {
            const response = await axios.get('sections/maxQuotaSections');
            console.log(response.data);

            if (response.status === 200) {
                setMaxQuotaSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    useEffect(() => {
        fetchMinQuotaSections();
    }, [])

    const fetchMinQuotaSections = async () => {
        try {
            const response = await axios.get('sections/minQuotaSections');
            console.log(response.data);

            if (response.status === 200) {
                setMinQuotaSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div className='App'>
            <ol type="1">
                <li className='Statistics'>Number of all users: <b>{numberOfUsers}</b></li>
                <br />
                <li className='Statistics'>Number of students: <b>{numberOfStudents}</b></li>
                <br />
                <li className='Statistics'>Number of instructors: <b>{numberOfInstructors}</b></li>
                <br />
                <li className='Statistics'>Department that have the most number of students: <b>{mostDepartment[1]}</b> with the number of students: <b>{mostDepartment[0]}</b></li>
                <br />
                <li className='Statistics'>
                    The course <b>{mostSection[1]}</b>: <b>{mostSection[2]}</b>&nbsp;
                    at the term <b>{(mostSection[3]) ? "Spring" : "Fall"} {mostSection[4]}</b><br />
                    which belong to the department of <b>{mostSection[5]}</b> <br />
                    has the most enrolled students with the number of students: <b>{mostSection[0]}</b>
                </li>
                <br />
                <li className='Statistics'>
                    All sections of the <b>{averageGradeSection[1]}</b>: <b>{averageGradeSection[2]}</b> course that have been opened<br />
                    so far have received an average grade of <b>{averageGradeSection[0]}</b>
                </li>
                <br />
                <li className='Statistics'>
                    The last student registered to the university is <b>{lastMember[0]} {lastMember[1]}</b> from the <b>{lastMember[2]}</b> department<br />
                    and registration date <b>{lastMember[3]}</b>
                </li>
                <br />
                <li className='Statistics'>
                    The first student registered to the university is <b>{firstMember[0]} {firstMember[1]}</b> from the <b>{firstMember[2]}</b> department<br />
                    and registration date <b>{firstMember[3]}</b>
                </li>
                <br />
                <li className='Statistics'>
                    Sections with the most quotas
                    <table className="styled-table">
                        <thead>
                            <tr>
                                <th>Section ID</th>
                                <th>Course Title</th>
                                <th>Course Name</th>
                                <th>Semester</th>
                                <th>Quota</th>
                            </tr>
                        </thead>
                        <tbody>
                            {maxQuotaSections.map((course) => (
                                <tr key={course[0]}>
                                    <td>{course[0]}</td>
                                    <td>{course[1]}</td>
                                    <td>{course[2]}</td>
                                    <td>{(course[3]) ? "Spring": "Fall"} {course[4]}</td>
                                    <td>{course[5]}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </li>
                <br />
                <li className='Statistics'>
                    Sections with the least quotas
                    <table className="styled-table">
                        <thead>
                            <tr>
                                <th>Section ID</th>
                                <th>Course Title</th>
                                <th>Course Name</th>
                                <th>Semester</th>
                                <th>Quota</th>
                            </tr>
                        </thead>
                        <tbody>
                            {minQuotaSections.map((course) => (
                                <tr key={course[0]}>
                                    <td>{course[0]}</td>
                                    <td>{course[1]}</td>
                                    <td>{course[2]}</td>
                                    <td>{(course[3]) ? "Spring": "Fall"} {course[4]}</td>
                                    <td>{course[5]}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </li>
            </ol>
        </div>
    );
}

export default StatisticsPage;