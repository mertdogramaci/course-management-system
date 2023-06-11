import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function StudentTable(probs) {
    function remove(id) {
        fetch(`/students/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedStudents = [...probs.students].filter(i => i.id !== id);
          probs.setStudents(updatedStudents);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Department Name</th>
                    <th>Hacettepe ID</th>
                    <th>Semester ECTS</th>
                    <th>School Enrollment Date</th>
                </tr>
            </thead>
            <tbody>
                {probs.students.map((student) => {
                    return (
                        <tr key={student.student.id}>
                            <th>{student.student.id}</th>
                            <th>{student.student.firstName}</th>
                            <th>{student.student.lastName}</th>
                            <th>{student.student.hacettepeID}</th>
                            <th>{student.schoolEnrollmentDate}</th>
                            <th>{student.semesterECTS}</th>
                            <th>{student.student.department.name}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default StudentTable;