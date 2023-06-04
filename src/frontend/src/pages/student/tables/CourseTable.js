import React, { useEffect, useState } from "react";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../../api/axios';

function CourseTable(props) {
  const [course, setCourse] = useState([]);
  const [grade, setGrade] = useState([]);

  const remove = async (id) => {
    try {
      const response = await axios.delete(`/studentEnrollsSection/${id}`);
      if (response.status === 200) {
        const updatedSections = props.sections.filter(i => i.id !== id);
        props.setSections(updatedSections);
      }
    } catch (error) {
      console.log("error!!");
    }
  };

  return (
    <table className="styled-table">
      <thead>
        <tr>
          <th>Section ID</th>
          <th>Course Title</th>
          <th>Course Name</th>
          <th>Compulsory</th>
          <th>Grade</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {props.sections.map((section) => (
          <tr key={section.id}>
            <td>{section.id}</td>
            <td>{section.section.course.title}</td>
            <td>{section.section.course.description}</td>
            <td>{section.isCompulsory ? "Yes" : "No"}</td>
            <td>{section.grade}</td>
            <td>
              <ButtonGroup>
                <Button
                  color="danger"
                  onClick={() => remove(section.id)}
                >
                  Drop
                </Button>
              </ButtonGroup>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default CourseTable;
