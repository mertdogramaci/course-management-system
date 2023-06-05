import { useEffect, useState } from "react";
import useAuth from '../../../hooks/useAuth';
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';

function TimeTable() {
    const { user } = useAuth();

    const initialLectureState = {
        courseCode: "",
        name: ""
    }
    const timetable = new Array(7).fill(0).map(row => new Array(8).fill(initialLectureState));
    
    const [lectures, setLectures] = useState([]);

    useEffect(() => {
        fetchAllCourses();
    }, [])

    const fetchAllCourses = async () => {
        try {
            const response = await axios.get(ApiRoutes.TIMETABLE + '/' + user.id);

            if (response.status === 200) {
                setLectures(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    for (let index = 0; index < lectures.length; index++) {
        let i = lectures[index].timeSlot.day;
        let startTime = lectures[index].timeSlot.startTime;
        let j = 0;

        if (startTime < "08:40:00") {
            j = 0;
        } else if (startTime < "09:40:00") {
            j = 1;
        } else if (startTime < "10:40:00") {
            j = 2;
        } else if (startTime < "11:40:00") {
            j = 3;
        } else if (startTime < "12:40:00") {
            j = 4;
        } else if (startTime < "13:30:00") {
            j = 5;
        } else if (startTime < "14:30:00") {
            j = 6;
        } else if (startTime < "15:30:00") {
            j = 7;
        } else if (startTime < "16:30:00") {
            j = 8;
        } else {
            j = 9;
        }

        timetable[i][j] = {courseCode: lectures[index].section.course.title, name: lectures[index].section.course.description};
    }

    return (
        <div>
            <center><h2>Weekly Timetable</h2></center>
            <table className="styled-table">
                <thead>
                    <tr>
                        <th>TIMES/DAYS</th>
                        <th>MONDAY</th>
                        <th>TUESDAY</th>
                        <th>WEDNESDAY</th>
                        <th>THURSDAY</th>
                        <th>FRIDAY</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>08.40<br/>09.30</th>
                        <th>{timetable[0][0].courseCode}<br/>{timetable[0][0].name}</th>
                        <th>{timetable[1][0].courseCode}<br/>{timetable[1][0].name}</th>
                        <th>{timetable[2][0].courseCode}<br/>{timetable[2][0].name}</th>
                        <th>{timetable[3][0].courseCode}<br/>{timetable[3][0].name}</th>
                        <th>{timetable[4][0].courseCode}<br/>{timetable[4][0].name}</th>
                    </tr>
                    <tr>
                        <th>09.40<br/>10.30</th>
                        <th>{timetable[0][1].courseCode}<br/>{timetable[0][1].name}</th>
                        <th>{timetable[1][1].courseCode}<br/>{timetable[1][1].name}</th>
                        <th>{timetable[2][1].courseCode}<br/>{timetable[2][1].name}</th>
                        <th>{timetable[3][1].courseCode}<br/>{timetable[3][1].name}</th>
                        <th>{timetable[4][1].courseCode}<br/>{timetable[4][1].name}</th>
                    </tr>
                    <tr>
                        <th>10.40<br/>11.30</th>
                        <th>{timetable[0][2].courseCode}<br/>{timetable[0][2].name}</th>
                        <th>{timetable[1][2].courseCode}<br/>{timetable[1][2].name}</th>
                        <th>{timetable[2][2].courseCode}<br/>{timetable[2][2].name}</th>
                        <th>{timetable[3][2].courseCode}<br/>{timetable[3][2].name}</th>
                        <th>{timetable[4][2].courseCode}<br/>{timetable[4][2].name}</th>
                    </tr>
                    <tr>
                        <th>11.40<br/>12.30</th>
                        <th>{timetable[0][3].courseCode}<br/>{timetable[0][3].name}</th>
                        <th>{timetable[1][3].courseCode}<br/>{timetable[1][3].name}</th>
                        <th>{timetable[2][3].courseCode}<br/>{timetable[2][3].name}</th>
                        <th>{timetable[3][3].courseCode}<br/>{timetable[3][3].name}</th>
                        <th>{timetable[4][3].courseCode}<br/>{timetable[4][3].name}</th>
                    </tr>
                    <tr>
                        <th>13.30<br/>14.20</th>
                        <th>{timetable[0][4].courseCode}<br/>{timetable[0][4].name}</th>
                        <th>{timetable[1][4].courseCode}<br/>{timetable[1][4].name}</th>
                        <th>{timetable[2][4].courseCode}<br/>{timetable[2][4].name}</th>
                        <th>{timetable[3][4].courseCode}<br/>{timetable[3][4].name}</th>
                        <th>{timetable[4][4].courseCode}<br/>{timetable[4][4].name}</th>
                    </tr>
                    <tr>
                        <th>14.30<br/>15.20</th>
                        <th>{timetable[0][5].courseCode}<br/>{timetable[0][5].name}</th>
                        <th>{timetable[1][5].courseCode}<br/>{timetable[1][5].name}</th>
                        <th>{timetable[2][5].courseCode}<br/>{timetable[2][5].name}</th>
                        <th>{timetable[3][5].courseCode}<br/>{timetable[3][5].name}</th>
                        <th>{timetable[4][5].courseCode}<br/>{timetable[4][5].name}</th>
                    </tr>
                    <tr>
                        <th>15.30<br/>16.20</th>
                        <th>{timetable[0][6].courseCode}<br/>{timetable[0][6].name}</th>
                        <th>{timetable[1][6].courseCode}<br/>{timetable[1][6].name}</th>
                        <th>{timetable[2][6].courseCode}<br/>{timetable[2][6].name}</th>
                        <th>{timetable[3][6].courseCode}<br/>{timetable[3][6].name}</th>
                        <th>{timetable[4][6].courseCode}<br/>{timetable[4][6].name}</th>
                    </tr>
                    <tr>
                        <th>16.30<br/>17.20</th>
                        <th>{timetable[0][7].courseCode}<br/>{timetable[0][7].name}</th>
                        <th>{timetable[1][7].courseCode}<br/>{timetable[1][7].name}</th>
                        <th>{timetable[2][7].courseCode}<br/>{timetable[2][7].name}</th>
                        <th>{timetable[3][7].courseCode}<br/>{timetable[3][7].name}</th>
                        <th>{timetable[4][7].courseCode}<br/>{timetable[4][7].name}</th>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default TimeTable;