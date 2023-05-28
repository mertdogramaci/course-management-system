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
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Student ID</th>
                    <th>School Enrollment Date</th>
                    <th>Semester ECTS</th>
                    <th>Department Name</th>
                </tr>
            </thead>
            <tbody>
                {probs.students.map((student) => {
                    return (
                        <tr key={student.id}>
                            <th>{student.id}</th>
                            <th>{student.name}</th>
                            <th>{student.surname}</th>
                            <th>{student.studentID}</th>
                            <th>{student.schoolEnrollmentDate}</th>
                            <th>{student.semesterECTS}</th>
                            <th>{student.department.name}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default StudentTable;