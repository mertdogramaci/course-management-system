import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function InstructorTable(probs) {
    function remove(id) {
        fetch(`/instructors/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedInstructors = [...probs.instructors].filter(i => i.id !== id);
          probs.setInstructors(updatedInstructors);
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
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.instructors.map((instructor) => {
                    return (
                        <tr key={instructor.id}>
                            <th>{instructor.id}</th>
                            <th>{instructor.name}</th>
                            <th>{instructor.surname}</th>
                            <th>{instructor.department.name}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/Instructors/" + instructor.id}>Edit</Button>
                                    <Button size="sm" color="primary" onClick={() => remove(instructor.id)}>Delete</Button>
                                </ButtonGroup>
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default InstructorTable;