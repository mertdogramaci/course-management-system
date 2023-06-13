import '../../App.css';
import React, { useEffect, useState } from "react";
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import useAuth from '../../hooks/useAuth';
import { Input } from "reactstrap";
import { MemberType, User, Student } from '../../@types/user';
import ProcessHistoryTable from "./ProcessHistoryTable";

function ProcessHistory() {
    const [logs, setLogs] = useState([]);
    const { user } = useAuth();

    useEffect(() => {
        if (user) {
            fetchLogs();
        }
    }, [user])

    const fetchLogs = async () => {
        try {
            const response = await axios.get(ApiRoutes.FETCH_LOG);

            console.log(response);

            if (response.status === 200) {
                setLogs(response.data);
            }
        } catch (error) {
            console.log("error!!");
        }
    }

    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                <h2> Process History </h2>
                    <ProcessHistoryTable logs={logs} setLogs={setLogs} />
                </div>
            </header>
        </div>
    );
}

export default ProcessHistory;