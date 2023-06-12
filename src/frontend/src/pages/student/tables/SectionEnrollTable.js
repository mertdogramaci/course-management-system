import React, { useEffect, useState } from "react";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';

function SectionEnrollTable(props) {
    const { user } = useAuth();
    const SweetAlert = require('sweetalert2');

    const handleEnrollClick = (section_id) => {
        const response = axios.post(ApiRoutes.ENROLL_SECTION + "/" + user.id + "/" + section_id);

        console.log("finished");

        window.location.reload();
        // new SweetAlert("Member approved", response.data.message , "success");
    };

  return (
    <table className="styled-table">
      <thead>
        <tr>
          <th>Section ID</th>
          <th>Course Title</th>
          <th>Course Name</th>
          <th>Compulsory</th>
        </tr>
      </thead>
      <tbody>
        {props.sections.map((section) => (
          <tr key={section.id}>
            <td>{section.id}</td>
            <td>{section.course.title}</td>
            <td>{section.course.description}</td>
            <td>{(section.course.isCompulsory) ? "Yes" : "No"}</td>
            <td>
            <Button onClick={() => handleEnrollClick(section.id)}>Enroll</Button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default SectionEnrollTable;
