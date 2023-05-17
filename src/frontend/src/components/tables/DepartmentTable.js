import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function StudentTable(probs) {
    function remove(id) {
        fetch(`/departments/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedDepartments = [...probs.departments].filter(i => i.id !== id);
          probs.setDepartments(updatedDepartments);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Faculty</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.departments.map((department) => {
                    return (
                        <tr key={department.id}>
                            <th>{department.id}</th>
                            <th>{department.name}</th>
                            <th>{department.faculty.name}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/departments/" + department.id}>Edit</Button>
                                    <Button size="sm" color="primary" onClick={() => remove(department.id)}>Delete</Button>
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