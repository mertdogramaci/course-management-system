function EnrolledSectionsTable(probs) {
    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Title</th>
                    <th>Course Name</th>
                    <th>Semester</th>
                    <th>Year</th>
                    <th>Instructor Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {probs.sections.map((section) => {
                    return (
                        <tr key={section.section.id}>
                            <th>{section.section.id}</th>
                            <th>{section.section.course.title}</th>
                            <th>{section.section.course.description}</th>
                            <th>{(section.section.semester) ? "Spring" : "Fall"}</th>
                            <th>{section.section.year}</th>
                            <th>{section.section.instructor.firstName} {section.section.instructor.lastName}</th>
                            <th>
                                
                            </th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default EnrolledSectionsTable;