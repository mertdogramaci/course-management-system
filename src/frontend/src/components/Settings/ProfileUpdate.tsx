import { Alert, AlertColor, Avatar, Box, Button, Card, CardContent, Grid, Snackbar, TextField } from '@mui/material';
import { Form, FormikProvider, useFormik } from 'formik';
import React, { useEffect, useState } from 'react';
import { User, Student } from '../../@types/user';
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import useIsMountedRef from '../../hooks/useIsMountedRef';
import useAuth from '../../hooks/useAuth';

type InitialValues = {
  firstName: string;
  lastName: string;
  hacettepeId: string;
  email: string;
  profilePhoto?: string;
  phoneNumber?: string;
  address?: string;
  afterSubmit?: string;
};

export default function ProfileUpdate() {
  const [imageData, setImageData] = useState<File>();
  const [imagePreview, setImagePreview] = useState<string | null>(null);
  const [userData, setUserData] = useState<User | null>(null);
  const [snackbarOpen, setSnackbarOpen] = useState<boolean>(false);
  const [snackbarMessage, setSnackbarMessage] = useState<string>("");
  const [snackbarAlertType, setSnackbarAlertType] = useState<AlertColor | undefined>(undefined);
  const isMountedRef = useIsMountedRef();
  const { user } = useAuth();
  const [studentUser, setStudentUser] = useState<Student | null>(null);

  useEffect(() => {
    if (user) {
        if (user.memberType === "STUDENT") {
            getStudentData(user.id);
          }
    }

    fetchUserData();
  }, [user]);

  useEffect(() => {
    if (userData) {
      setFieldValue('firstName', userData.firstName);
      setFieldValue('lastName', userData.lastName);
      setFieldValue('hacettepeId', studentUser?.hacettepeID);
      setFieldValue('email', userData.email);
      setFieldValue('profilePhoto', userData.profilePhoto);
      setFieldValue('phoneNumber', userData.phoneNumber);
      setFieldValue('address', userData.address);
    }
  }, [userData]);

  const fetchUserData = async () => {
    const response = await axios.get(ApiRoutes.PROFILE);

    if (response.status === 200) {
      setUserData(response.data);
    }
  }

  const getStudentData = async (userId: number) => {
    try {
      const response = await axios.get(`members/findStudent/${userId}`);

      if (response.status === 200) {
        setStudentUser(response.data);
      }
    } catch (error) {
      setSnackbarAlertType('error');
      setSnackbarMessage(error.response.data.message);
      setSnackbarOpen(true);
    }
  };


  const formik = useFormik<InitialValues>({
    initialValues: {
      firstName: '',
      lastName: '',
      hacettepeId: '',
      email: ''
    },
    onSubmit: async (values, { setErrors, setSubmitting, resetForm }) => {
      try {
        if (userData) {
          const formData = getFromData(values);
          const response = await axios.put(`/members/${userData.id}`, formData);

          if (response.status === 200) {
            if (response.data.messageType === "ERROR") {
              setSnackbarAlertType("error");
            } else {
              setSnackbarAlertType("success");
            }
            setSnackbarMessage(response.data.message);
            setSnackbarOpen(true);
            fetchUserData();
          }
        }
        if (isMountedRef.current) {
          setSubmitting(false);
        }
      } catch (error: any) {
        setSnackbarAlertType("error");
        setSnackbarMessage(error.data.message);
        setSnackbarOpen(true);
        if (isMountedRef.current) {
          setSubmitting(false);
          setErrors({ afterSubmit: error.message });
        }
      }
    }
  });

  const { errors, touched, handleSubmit, getFieldProps, setFieldValue } = formik;

  const getFromData = (values: InitialValues) : FormData => {
    const formData = new FormData();
    formData.append('firstName', values.firstName);
    formData.append('lastName', values.lastName);
    formData.append('hacettepeId', values.hacettepeId);
    formData.append('email', values.email);
    imageData && formData.append('profilePhoto', imageData);
    values.phoneNumber && formData.append('phoneNumber', values.phoneNumber);
    values.address && formData.append('address', values.address);

    return formData;
  }

  const handleChangeImage = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.target.files) {
      setImageData(event.target.files[0]);
      setImagePreview(URL.createObjectURL(event.target.files[0]));
    }
  }

  const handleCloseSnackbar = (event?: React.SyntheticEvent | Event, reason?: string) => {
    if (reason === 'clickaway') {
      return;
    }
    setSnackbarOpen(false);
  };

  return (
    <Grid
      container
      spacing={2}
      sx={{ padding: 4 }}
    >
      <Snackbar open={snackbarOpen} autoHideDuration={5000} onClose={handleCloseSnackbar}>
        <Alert onClose={handleCloseSnackbar} severity={snackbarAlertType} sx={{ width: '100%' }}>
          {snackbarMessage}
        </Alert>
      </Snackbar>
      <Card sx={{ width: '%100', backgroundColor: 'rgba(255,255,255,0.2)'}}>
        <CardContent>
        <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: 2 }}>
                <div  style={{ display: 'flex', flex: 1, alignItems: 'center', justifyContent:'center' }}>
                  {imagePreview
                    ? <Avatar src={imagePreview} sx={{ width: 150, height: 150, mb: 2 }}/>
                    : (
                      userData?.profilePhoto
                      ? <Avatar src={`${userData?.profilePhoto}`} sx={{ width: 150, height: 150, mb: 2 }} />
                      : <Avatar sx={{ width: 150, height: 150, mb: 2 }} />
                    )}
                </div>

                <Button variant="contained" component="label">
                  {"Upload Image"}
                  <input
                    accept='image/*'
                    type="file"
                    onChange={handleChangeImage}
                    hidden
                  />
                </Button>
              </Box>
          <FormikProvider value={formik}>
            <Form autoComplete="off" noValidate onSubmit={handleSubmit}>
              {errors.afterSubmit && <Alert severity="error">{errors.afterSubmit}</Alert>}

              <TextField
                label={"Name"}
                sx={{ m: 1, width: '48%' }}
                {...getFieldProps('firstName')}
                error={Boolean(touched.firstName && errors.firstName)}
                helperText={touched.firstName && errors.firstName}
              />

              <TextField
                label={"Surname"}
                sx={{ m: 1, width: '48%' }}
                {...getFieldProps('lastName')}
                error={Boolean(touched.firstName && errors.firstName)}
                helperText={touched.firstName && errors.firstName}
              />

              <TextField
                label="Email"
                disabled
                sx={{ m: 1, width: '97.5%' }}
                {...getFieldProps('email')}
                error={Boolean(touched.email && errors.email)}
                helperText={touched.email && errors.email}
              />

              <TextField
                label="Hacettepe ID"
                disabled
                sx={{ m: 1, width: '48%' }}
                {...getFieldProps('hacettepeId')}
                error={Boolean(touched.hacettepeId && errors.hacettepeId)}
                helperText={touched.hacettepeId && errors.hacettepeId}
              />

              <TextField
                label={"Phone Number"}
                sx={{ m: 1, width: '48%' }}
                {...getFieldProps('phoneNumber')}
                error={Boolean(touched.phoneNumber && errors.phoneNumber)}
                helperText={touched.phoneNumber && errors.phoneNumber}
              />

              <TextField
                label={"Address"}
                sx={{ m: 1, width: '97.5%' }}
                multiline
                rows={5}
                {...getFieldProps('address')}
                error={Boolean(touched.address && errors.address)}
                helperText={touched.address && errors.address}
              />

              <div style ={{ display: "flex", alignItems: 'center', justifyContent: "flex-end", marginTop: 8 }}>
                <Button variant="contained" type='submit'>{"Save Changes"}</Button>
              </div>
            </Form>
          </FormikProvider>
        </CardContent>
      </Card>
    </Grid>
  )
}
