import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function SubmissionTable(probs) {
    function remove(id) {
        fetch(`/submissions/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          const updatedSubmissions = [...probs.submissions].filter(i => i.id !== id);
          probs.setSubmissions(updatedSubmissions);
        });
    }

    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Mark</th>
                    <th>Content</th>
                    <th>Student ID</th>
                    <th>Homework ID</th>
                </tr>
            </thead>
            <tbody>
                {probs.submissions.map((submission) => {
                    return (
                        <tr key={submission.id}>
                            <th>{submission.id}</th>
                            <th>{submission.marks}</th>
                            <th>{submission.content}</th>
                            <th>{submission.student.id}</th>
                            <th>{submission.homework.id}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default SubmissionTable;