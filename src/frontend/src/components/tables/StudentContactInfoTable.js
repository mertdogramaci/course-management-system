import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function StudentContactInfoTable(probs) {
    function remove(id) {
        fetch(`/studentContactInfos/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedStudentContactInfos = [...probs.studentContactInfos].filter(i => i.id !== id);
          probs.setStudentContactInfos(updatedStudentContactInfos);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                {probs.studentContactInfos.map((studentContactInfo) => {
                    return (
                        <tr key={studentContactInfo.id}>
                            <th>{studentContactInfo.id}</th>
                            <th>{studentContactInfo.student.name} {studentContactInfo.student.surname}</th>
                            <th>{studentContactInfo.phone}</th>
                            <th>{studentContactInfo.email}</th>
                            <th>{studentContactInfo.address}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default StudentContactInfoTable;