import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function FacultyTable(probs) {
    function remove(id) {
        fetch(`/faculties/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedFaculties = [...probs.faculties].filter(i => i.id !== id);
          probs.setFaculties(updatedFaculties);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.faculties.map((faculty) => {
                    return (
                        <tr key={faculty.id}>
                            <th>{faculty.id}</th>
                            <th>{faculty.name}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/faculties/" + faculty.id}>Edit</Button>
                                    <Button size="sm" color="primary" onClick={() => remove(faculty.id)}>Delete</Button>
                                </ButtonGroup>
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default FacultyTable;