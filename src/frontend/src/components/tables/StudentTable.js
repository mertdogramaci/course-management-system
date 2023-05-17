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
                    <th>Department Name</th>
                    <th>Student ID</th>
                    <th>School Enrollment Date</th>
                    <th>Semester ECTS</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.students.map((student) => {
                    return (
                        <tr key={student.id}>
                            <th>{student.id}</th>
                            <th>{student.name}</th>
                            <th>{student.surname}</th>
                            <th>{student.department.name}</th>
                            <th>{student.studentID}</th>
                            <th>{student.schoolEnrollmentDate}</th>
                            <th>{student.semesterECTS}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/students/" + student.id}>Edit</Button>
                                    <Button size="sm" color="primary" onClick={() => remove(student.id)}>Delete</Button>
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