import React from "react";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../api/axios';

function CourseTable(props) {
  const remove = async (id) => {
    try {
      const response = await axios.delete(`/courses/${id}`);
      if (response.status === 200) {
        const updatedCourses = props.courses.filter(i => i.id !== id);
        props.setCourses(updatedCourses);
      }
    } catch (error) {
      console.log("error!!");
    }
  };

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
        {props.courses.map((course) => (
          <tr key={course.id}>
            <td>{course.id}</td>
            <td>{course.title}</td>
            <td>{course.ects}</td>
            <td>{course.isCompulsory ? "Yes" : "No"}</td>
            <td>{course.description}</td>
            <td>{course.department.name}</td>
            <td>
              <ButtonGroup>
                <Button
                  color="danger"
                  onClick={() => remove(course.id)}
                >
                  Delete
                </Button>
                {/* Add additional buttons or actions here */}
              </ButtonGroup>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default CourseTable;
