import checkmarkFill from '@iconify/icons-eva/checkmark-fill';
import closeFill from '@iconify/icons-eva/close-fill';
import { Icon } from '@iconify/react';
import { Box, Card, IconButton, Table, TableBody, TableCell, TableContainer, TableRow, Typography } from '@mui/material';
import Paper from '@mui/material/Paper';
import { filter } from 'lodash';
import React, { useEffect, useState } from 'react';
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import RequestListHead from '../../components/RequestListHead';
import RequestListToolbar from '../../components/RequestListToolbar';

function descendingComparator(a: Anonymous, b: Anonymous, orderBy: string) {
  if (b[orderBy] < a[orderBy]) {
    return -1;
  }
  if (b[orderBy] > a[orderBy]) {
    return 1;
  }
  return 0;
}

type Anonymous = Record<string | number, string>;

function getComparator(order: string, orderBy: string) {
  return order === 'desc'
    ? (a: Anonymous, b: Anonymous) => descendingComparator(a, b, orderBy)
    : (a: Anonymous, b: Anonymous) => -descendingComparator(a, b, orderBy);
}

function applySortFilter(array: any[], comparator: (a: any, b: any) => number, query: string) {
  const stabilizedThis = array.map((el, index) => [el, index] as const);
  stabilizedThis.sort((a, b) => {
    const order = comparator(a[0], b[0]);
    if (order !== 0) return order;
    return a[1] - b[1];
  });

  if (query) {
    return filter(
      array,
      (_req) => _req.firstName.toLowerCase().indexOf(query.toLowerCase()) !== -1
    );
  }

  return stabilizedThis.map((el) => el[0]);
}

export default function EnrollmentRequests() {
  const [enrollmentRequests, setEnrollmentRequests] = useState<[]>([]);
  const [order, setOrder] = useState<'asc' | 'desc'>('asc');
  const [filterName, setFilterName] = useState('');
  const [orderBy, setOrderBy] = useState('');
  const SweetAlert = require('sweetalert2');


  let TABLE_HEAD = [
    { id: 'firstName', label: "header.manage-button.enrollment-requests.first-name"},
    { id: 'lastName', label: "header.manage-button.enrollment-requests.last-name"},
    { id: 'hacettepeID', label: 'Hacettepe ID' },
    { id: 'email', label: 'Email'  },
    { id: 'memberType', label: "header.manage-button.enrollment-requests.role"},
    { id: 'approve-deny', label: "header.manage-button.enrollment-requests.approve-deny"}
  ];

  useEffect(() => {
    fetchEnrollmentRequests();
  }, []);

  const fetchEnrollmentRequests = async () => {
    const response = await axios.get(ApiRoutes.ENROLLMENT);

    if (response) {
      setEnrollmentRequests(response.data);
    }
  }

  const handleRequestSort = (property: string) => {
    const isAsc = orderBy === property && order === 'asc';
    setOrder(isAsc ? 'desc' : 'asc');
    setOrderBy(property);
  };

  const handleFilterByName = (filterName: string) => {
    setFilterName(filterName);
  };

  const handleApprove = async (id: string) => {
    const response = await axios.post(ApiRoutes.APPROVE_ENROLLMENT + `/${id}`)

    fetchEnrollmentRequests();
    new SweetAlert("Member approved", response.data.message , "success");
  }

  const handleDeny = async (id: string) => {
    const response = await axios.delete(ApiRoutes.DENY_ENROLLMENT + `/${id}`);

    fetchEnrollmentRequests();
    new SweetAlert("Request Denied", response.data.message , "success");
  }

  function handleDenyClick(id: string) {
		new SweetAlert({
			title: 'Are you sure?',
			text: "You won't be able to revert this!",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonText: 'Yes, deny!',
			cancelButtonText: 'No, cancel!',
			cancelButtonColor: "#DC3545",
			confirmButtonColor: "#28A745",
			reverseButtons: true,
		}).then(async (result: any) => {
			if (result.isConfirmed) {
				handleDeny(id);
			} else if (result.dismiss === SweetAlert.DismissReason.cancel) { }
		})
	}

  function handleApproveClick(id: string) {
		new SweetAlert({
			title: 'Are you sure?',
			text: "You are approving this request",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonText: 'Yes, approve!',
			cancelButtonText: 'No, cancel!',
			cancelButtonColor: "#DC3545",
			confirmButtonColor: "#28A745",
			reverseButtons: true,
		}).then(async (result: any) => {
			if (result.isConfirmed) {
				handleApprove(id);
			} else if (result.dismiss === SweetAlert.DismissReason.cancel) { }
		})
	}

  const filteredRequests = applySortFilter(enrollmentRequests, getComparator(order, orderBy), filterName);

  const isRequestNotFound = filteredRequests.length === 0;

  return (
    <Card sx={{ m: 4, width: '90%' }}>
      <RequestListToolbar
        filterName={filterName}
        onFilterName={handleFilterByName}
      />
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 600 }}>
          <RequestListHead
            order={order}
            orderBy={orderBy}
            headLabel={TABLE_HEAD}
            onRequestSort={handleRequestSort}
          />
          <TableBody>
            {filteredRequests
              .map((row, index) => {
                const { id, firstName, lastName, hacettepeID, email, memberType } = row;

                return (
                  <TableRow
                    hover
                    key={hacettepeID}
                    tabIndex={-1}
                    role="cell"
                  >
                    <TableCell component="th" scope="row" padding="none" align="center">
                      <Typography variant="subtitle2" noWrap>
                        {firstName}
                      </Typography>
                    </TableCell>
                    <TableCell component="th" scope="row" padding="none" align="center">
                      <Typography variant="subtitle2" noWrap>
                        {lastName}
                      </Typography>
                    </TableCell>
                    <TableCell component="th" scope="row" padding="none" align="center">
                      <Typography variant="subtitle2" noWrap>
                        {hacettepeID}
                      </Typography>
                    </TableCell>
                    <TableCell component="th" scope="row" padding="none" align="center">
                      <Typography variant="subtitle2" noWrap>
                        {email}
                      </Typography>
                    </TableCell>
                    <TableCell component="th" scope="row" padding="none" align="center">
                      <Typography variant="subtitle2" noWrap>
                        {memberType}
                      </Typography>
                    </TableCell>
                    <TableCell align="center">
                      <IconButton onClick={() => handleApproveClick(id)}>
                        <Icon icon={checkmarkFill} width={20} height={20} color="green" />
                      </IconButton>
                      <IconButton onClick={() => handleDenyClick(id)}>
                        <Icon icon={closeFill} width={20} height={20} color="red" />
                      </IconButton>
                    </TableCell>
                  </TableRow>
                );
              })}
          </TableBody>
          {isRequestNotFound && (
            <TableBody>
              <TableRow>
                <TableCell align="center" colSpan={7}>
                  <Box sx={{ py: 3 }}>
                  {"header.manage-button.enrollment-requests.nfound"}
                  </Box>
                </TableCell>
              </TableRow>
            </TableBody>
          )}
        </Table>
      </TableContainer>
    </Card>
  )
}
