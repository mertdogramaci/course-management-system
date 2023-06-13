import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';

function StudentTable(probs) {

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Student ID</th>
                    <th>School Enrollment Date</th>
                    <th>Faculty</th>
                    <th>Department Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.students.map((student) => {
                    return (
                        <tr key={student.id}>
                            <th>{student.id}</th>
                            <th>{student.firstName}</th>
                            <th>{student.lastName}</th>
                            <th>{student.email}</th>
                            <th>{student.phoneNumber}</th>
                            <th>{student.hacettepeID}</th>
                            <th>{student.schoolEnrollmentDate}</th>
                            <th>{(student.department === undefined) ? null : student.department.faculty.name}</th>
                            <th>{(student.department === undefined) ? null : student.department.name}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/studentEnrollsSection/" + student.id}>Show Enrolled Sections</Button>
                                    &ensp;
                                    <Button size="sm" color="primary" tag={Link} to={"/members/" + student.id}>Edit</Button>
                                </ButtonGroup>
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default StudentTable;