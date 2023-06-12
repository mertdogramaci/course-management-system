import React from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";

function SectionsTable(probs) {
    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Title</th>
                    <th>Course Name</th>
                    <th>Semester</th>
                    <th>Year</th>
                    <th>Quota</th>
                    <th>Instructor Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.sections.map((section) => {
                    return (
                        <tr key={section[0]}>
                            <th>{section[0]}</th>
                            <th>{section[1]}</th>
                            <th>{section[2]}</th>
                            <th>{(section[3]) ? "Spring" : "Fall"}</th>
                            <th>{section[4]}</th>
                            <th>{(section[5] === null) ? 0 : section[5]} / {section[6]}</th>
                            <th>{section[7]} {section[8]}</th>
                            <th>
                                
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default SectionsTable;