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
                                <ButtonGroup>
                                    <Button size="sm" color="primary" tag={Link} to={"/studentEnrollsSection/section/" + section[0]}>Show Student List</Button>
                                    &ensp;
                                    <Button size="sm" color="primary" tag={Link} to={"/sections/" + section[0]}>Edit</Button>
                                </ButtonGroup>
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default SectionsTable;