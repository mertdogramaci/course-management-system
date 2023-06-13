import React, { useEffect, useState } from "react";
import { Button, ButtonGroup } from "reactstrap";
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import useAuth from '../../hooks/useAuth';

function ProcessHistoryTable(props) {
  const sortedLogs = [...props.logs].sort((a, b) => {
    const timestampA = new Date(a.timeStamp);
    const timestampB = new Date(b.timeStamp);
    return timestampB - timestampA;
  });

  return (
    <table className="styled-table">
      <thead>
        <tr>
          <th>User email</th>
          <th>Activity</th>
          <th>Timestamp</th>
        </tr>
      </thead>
      <tbody>
        {sortedLogs.map((log) => (
          <tr key={log.id}>
            <td>{log.userEmail}</td>
            <td>{log.activity}</td>
            <td>{log.timeStamp}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default ProcessHistoryTable;
