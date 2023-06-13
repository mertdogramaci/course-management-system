import React, { useEffect, useState } from "react";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';

function CourseTable(props) {
  const { user } = useAuth();
  const SweetAlert = require('sweetalert2');

  const handleDropClick = async (ses_id) => {
    try {
      const response = await axios.delete(ApiRoutes.DROP_COURSE + "/" + user.id + "/" + ses_id);

      SweetAlert.fire({
        title: "Course dropped!",
        text: response.data.message,
        icon: "success",
        confirmButtonText: "OK",
      }).then(() => {
        window.location.reload();
      });
    } catch (error) {
      console.log(error);
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
        </tr>
      </thead>
      <tbody>
        {props.sections.map((section) => (
          <tr key={section.id}>
            <td>{section.section.id}</td>
            <td>{section.section.course.title}</td>
            <td>{section.section.course.description}</td>
            <td>{(section.section.course.isCompulsory) ? "Yes" : "No"}</td>
            <td>{section.grade}</td>
            <td>
              <Button onClick={() => handleDropClick(section.id)}>Drop Course</Button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default CourseTable;
