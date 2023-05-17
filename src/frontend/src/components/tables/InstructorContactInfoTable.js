import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function InstructorContactInfoTable(probs) {
    function remove(id) {
        fetch(`/instructorContactInfos/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedInstructorContactInfos = [...probs.instructorContactInfos].filter(i => i.id !== id);
          probs.setInstructorContactInfos(updatedInstructorContactInfos);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Instructor Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                {probs.instructorContactInfos.map((instructorContactInfo) => {
                    return (
                        <tr key={instructorContactInfo.id}>
                            <th>{instructorContactInfo.id}</th>
                            <th>{instructorContactInfo.instructor.name} {instructorContactInfo.instructor.surname}</th>
                            <th>{instructorContactInfo.phone}</th>
                            <th>{instructorContactInfo.email}</th>
                            <th>{instructorContactInfo.address}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default InstructorContactInfoTable;