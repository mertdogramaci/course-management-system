import React, { useEffect, useState } from "react";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../../api/axios';

function CourseTable(props) {
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
            <td>{section.id}</td>
            <td>{section.section.course.title}</td>
            <td>{section.section.course.description}</td>
            <td>{section.section.course.isCompulsory ? "Yes" : "No"}</td>
            <td>{section.grade}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default CourseTable;
