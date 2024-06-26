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

    console.log(probs.students);

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
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
                            <th>{student.hacettepeID}</th>
                            <th>{student.schoolEnrollmentDate}</th>
                            <th>{(student.department === undefined) ? null : student.department.faculty.name}</th>
                            <th>{(student.department === undefined) ? null : student.department.name}</th>
                            <th>
                                
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default StudentTable;