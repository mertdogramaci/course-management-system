import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function CourseTable(probs) {
    function remove(id) {
        fetch(`/courses/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedCourses = [...probs.courses].filter(i => i.id !== id);
          probs.setCourses(updatedCourses);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>ECTS</th>
                    <th>Compulsory</th>
                    <th>Description</th>
                    <th>Department Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.courses.map((course) => {
                    return (
                        <tr key={course.id}>
                            <th>{course.id}</th>
                            <th>{course.title}</th>
                            <th>{course.ects}</th>
                            <th>{course.isCompulsory}</th>
                            <th>{course.description}</th>
                            <th>{course.department.name}</th>
                            <th>
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/Courses/" + course.id}>Edit</Button>
                                    <Button size="sm" color="primary" onClick={() => remove(course.id)}>Delete</Button>
                                </ButtonGroup>
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default CourseTable;