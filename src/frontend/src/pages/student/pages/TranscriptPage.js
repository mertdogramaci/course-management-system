import '../../../App.css';
import React, { useEffect, useState } from "react";
import CourseTable from "../tables/CourseTable";
import axios from '../../../api/axios';
import ApiRoutes from '../../../api/routes';
import useAuth from '../../../hooks/useAuth';
import Transcript from '../../../components/transcript/Transcript';
import { PDFViewer } from '@react-pdf/renderer';

function TranscriptPage() {
    const [sections, setSections] = useState([]);
    const { user } = useAuth();

    useEffect(() => {
        fetchAllCourses();
    }, [])

    const fetchAllCourses = async () => {
        try {
            const response = await axios.get(ApiRoutes.COURSES + '/' + user.id);

            if (response.status === 200) {
                setSections(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div>
            <PDFViewer width={1000} height={760} >
                <Transcript />
            </PDFViewer>
        </div>
    );
}

export default TranscriptPage;