import React from "react";

function SectionTable(probs) {
    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Name</th>
                    <th>Semester</th>
                    <th>Year</th>
                    <th>Classroom Info</th>
                    <th>Quota</th>
                </tr>
            </thead>
            <tbody>
                {probs.sections.map((section) => {
                    return (
                        <tr key={section.id}>
                            <th>{section.id}</th>
                            <th>{section.course.title}</th>
                            <th>{section.semester}</th>
                            <th>{section.year}</th>
                            <th>{section.classroomInfo}</th>
                            <th>{section.quota}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default SectionTable;