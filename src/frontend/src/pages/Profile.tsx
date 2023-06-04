import EmailIcon from '@mui/icons-material/Email';
import GitHubIcon from '@mui/icons-material/GitHub';
import LinkedInIcon from '@mui/icons-material/LinkedIn';
import PhoneIcon from '@mui/icons-material/Phone';
import { Alert, AlertColor, Avatar, Button, Card, CardContent, Container, Divider, IconButton, Link, Snackbar, Typography } from '@mui/material';
import CircularProgress from '@mui/material/CircularProgress';
import React, { useEffect, useState } from 'react';
import { Link as RouterLink, useNavigate, useParams } from 'react-router-dom';
import { ProfileDataRequestDTO } from '../@types/profile';
import { MemberType, User, Student } from '../@types/user';
import axios from '../api/axios';
import ApiRoutes from '../api/routes';
import useAuth from '../hooks/useAuth';
import { PATH_MAIN } from '../routes/paths';

export default function Profile() {
  const navigate = useNavigate();
  const { id } = useParams();
  const { user } = useAuth();
  const [profileData, setProfileData] = useState<User | null | undefined>(null);
  const [snackbarOpen, setSnackbarOpen] = useState<boolean>(false);
  const [snackbarMessage, setSnackbarMessage] = useState<string | null>(null);
  const [snackbarAlertType, setSnackbarAlertType] = useState<AlertColor | undefined>(undefined);
  const [isFriend, setIsFriend] = useState<boolean>(false);
  const [sentRequests, setSentRequests] = useState<any[]>([]);
  const [isRequestSent, setIsRequestSent] = useState<boolean>(false);
  const [studentUser, setStudentUser] = useState<Student | null>(null);

  useEffect(() => {
    if (user) {
      if (user.memberType === "STUDENT") { // Check if the user's member type is "Student"
        getStudentData(user.id); // Call the function to get the student data
      }

      if (id) {
        fetchOtherProfileData(user.id, Number(id));
        handleIsFriend();
        getAllContactRequests();
      } else {
        fetchSelfProfileData(user.id);
      }
    }
  }, [id, user]);

  useEffect(() => {
    setIsRequestSent(sentRequests.includes(Number(id)));
  }, [sentRequests])

  const fetchSelfProfileData = async (userId: number) => {
    try {
      const response = await axios.get(ApiRoutes.PROFILE);

      if (response.status === 200) {
        setProfileData(response.data);
      }
    } catch (error) {
      setSnackbarAlertType("error");
      setSnackbarMessage(error.response.data.message);
      setSnackbarOpen(true);
    }
  }

  const getStudentData = async (userId: number) => {
    try {
      const response = await axios.get(`members/findStudent/${userId}`); // Replace "students/${userId}" with the appropriate API route to fetch student data

      if (response.status === 200) {
        setStudentUser(response.data); // Assign the fetched student data to the studentUser state variable
      }
    } catch (error) {
      setSnackbarAlertType('error');
      setSnackbarMessage(error.response.data.message);
      setSnackbarOpen(true);
    }
  };

  const fetchOtherProfileData = async (requesterId: number, requestedId: number) => {
    try {
      const profileDataRequset = new ProfileDataRequestDTO(requesterId, requestedId);
      const response = await axios.post(ApiRoutes.PROFILE, profileDataRequset);

      if (response.status === 200) {
        setProfileData(response.data);
      }
    } catch (error) {
      setSnackbarAlertType("error");
      setSnackbarMessage(error.response.data.message);
      setSnackbarOpen(true);
    }
  }

  const handleCloseSnackbar = (event?: React.SyntheticEvent | Event, reason?: string) => {
    if (reason === 'clickaway') {
      return;
    }
    setSnackbarOpen(false);
  };

  const handleIsFriend = async () => {
    const response = await axios.get(ApiRoutes.LIST_CONTACTS);

    if (response.status === 200) {
      const isF = response.data.find((c) => c.id === Number(id));
      setIsFriend(!!isF);
    }
  }

  const handleAddFriend = async () => {
    const addFriendId = Number(id);

    var request = ApiRoutes.CONNECTION_REQUEST + "?friendId=" + addFriendId;
    const response = await axios.post(request);

    if (response.status === 200) {
      window.location.reload();
    }
  }

  const handleDeleteUser = async () => {
    const response = await axios.delete(`members/${id}`);

    if (response.status === 200) {
      setSnackbarAlertType("success");
      setSnackbarMessage(response.data.message);
      setSnackbarOpen(true);
      navigate('/feed');
    }
  }

  const getAllContactRequests = async () => {
    const response = await axios.get("contact/listRequests");

    if (response.status === 200) {
      setSentRequests(response.data.map(r => r?.receiveMember?.id));
    }
  }

  return (
    <Container sx={{ paddingBottom: 4 }}>
      <Snackbar open={snackbarOpen} autoHideDuration={5000} onClose={handleCloseSnackbar}>
        <Alert onClose={handleCloseSnackbar} severity={snackbarAlertType} sx={{ width: '100%' }}>
          {snackbarMessage}
        </Alert>
      </Snackbar>
      {profileData ?
        (<>
          <div style={{ marginTop: 2, height: 180, display: 'flex', flexDirection: 'row' }}>
          <div  style={{ width: 180, display: 'flex', flex: 1, alignItems: 'center', justifyContent:'center' }}>
            {
              profileData.profilePhoto
                ? <Avatar src={profileData.profilePhoto} sx={{ width: 150, height: 150 }} />
                : <Avatar sx={{ width: 150, height: 150 }} />
            }
          </div>
          <div style={{ display: 'flex', flex: 2, justifyContent: 'center', flexDirection: 'column' }}>
            <Typography variant='h6' fontWeight={800} sx={{ marginBottom: 1 }}>
              {profileData.firstName + ' ' + profileData.lastName}
            </Typography>
            <Typography variant='body2'>
              {MemberType[profileData.memberType]}
            </Typography>
            {user?.memberType === "STUDENT" && (
                <Typography variant='body2'>
                  Hacettepe ID: {studentUser?.hacettepeID}
                </Typography>
              )}
          </div>
          <div style={{ display: 'flex', flex: 3, flexDirection: 'column', justifyContent: 'center', alignItems: 'flex-end' }}>
            <div style={{ display: 'flex', marginRight: 4 }}>
              <EmailIcon sx={{ marginRight: 1, color: 'gray' }} />
              <Typography variant='body1'>
                {profileData.email}
              </Typography>
            </div>
            {
              profileData.phoneNumber && (
                <div style={{ display: 'flex', marginRight: 4 }}>
                  <PhoneIcon sx={{ marginRight: 1, color: 'gray' }} />
                  <Typography variant='body1'>
                    {profileData.phoneNumber}
                  </Typography>
                </div>
              )
            }
            {
              (!isFriend && user?.id !== 1 && !isRequestSent) && (
                <Button variant='contained' size="small" sx={{ display: id === undefined ? "none" : "block", marginTop: 1 }} onClick={handleAddFriend}>ADD FRIEND</Button>
              )
            }
            {
              user?.id === 1 && (
                <Button variant='contained' color='error' size='small' onClick={handleDeleteUser}>Delete User</Button>
              )
            }
            {
              (isRequestSent) && (
                <Typography color="limegreen">Your friend request is pending</Typography>
              )
            }
          </div>
        </div>
        {profileData.about && (
          <div style={{ display: 'flex', marginTop: 12, paddingLeft: 12, paddingRight: 12 }}>
            <Card sx={{ width: '100%', backgroundColor: 'rgba(255,255,255,0.2)'}}>
              <CardContent>
                <Typography gutterBottom variant="h6" component="div" sx={{ marginBottom: 0.5 }}>
                  {"About"}
                </Typography>
                <Divider />
                <Typography variant="body1" color="text.primary" sx={{ marginTop: 0.5, whiteSpace: 'pre-line'  }}>
                  {profileData.about}
                </Typography>
              </CardContent>
            </Card>
          </div>
        )}
      </>
      )
      : (snackbarMessage !== null ?
        (
          <>
            <div style={{ width: '100%', height: '100vh', display: 'flex', flex: 1, justifyContent: 'center', alignItems: 'center' }}>
              <Link component={RouterLink} sx={{ textDecoration: 'none' }} to={PATH_MAIN.feed}>
                An error occured. Go to main page.
              </Link>
            </div>
          </>
        ) : <CircularProgress />
      )
      }
    </Container>
  )
}
