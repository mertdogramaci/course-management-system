function StudentSectionTable(probs) {
    return (
        <table className="styled-table">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <tbody>
                {probs.students.map((student) => {
                    return (
                        <tr key={student[1]}>
                            <th>{student[0]}</th>
                            <th>{student[1]}</th>
                            <th>{student[2]}</th>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
}

export default StudentSectionTable;