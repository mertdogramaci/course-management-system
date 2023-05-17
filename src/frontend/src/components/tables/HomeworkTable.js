import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function HomeworkTable(probs) {
    function remove(id) {
        fetch(`/homeworks/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedHomeworks = [...probs.homeworks].filter(i => i.id !== id);
          probs.setHomeworks(updatedHomeworks);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Issue Date</th>
                    <th>Due Date</th>
                    <th>Course</th>
                    <th>Section</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.homeworks.map((homework) => {
                    return (
                        <tr key={homework.id}>
                            <th>{homework.id}</th>
                            <th>{homework.title}</th>
                            <th>{homework.surname}</th>
                            <th>{homework.content}</th>
                            <th>{homework.issueDate}</th>
                            <th>{homework.dueDate}</th>
                            <th>{homework.section.course.title}</th>
                            <th>{homework.section.semester} {homework.section.year}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/homeworks/" + homework.id}>Edit</Button>
                                    <Button size="sm" color="primary" onClick={() => remove(homework.id)}>Delete</Button>
                                </ButtonGroup>
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default HomeworkTable;