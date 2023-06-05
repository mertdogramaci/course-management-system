import eyeFill from '@iconify/icons-eva/eye-fill';
import eyeOffFill from '@iconify/icons-eva/eye-off-fill';
import { Icon } from '@iconify/react';
import { Alert, AlertColor, Button, Card, CardContent, CardHeader, Grid, IconButton, InputAdornment, Link, MenuItem, Snackbar, Stack, TextField, Typography, useTheme } from '@mui/material';
import { Form, FormikProvider, useFormik } from 'formik';
import React, { useState } from 'react';
import { Link as RouterLink } from 'react-router-dom';
import * as Yup from 'yup';
import { MemberType } from '../../@types/user';
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import { EnrollmentRequestDTO } from '../../dto/authentication';
import useIsMountedRef from '../../hooks/useIsMountedRef';
import { PATH_AUTH } from '../../routes/paths';

type InitialValues = {
  name: string;
  surname: string;
  hacettepeID: string;
  memberType: MemberType;
  email: string;
  password: string;
  passwordConfirmation: string;
  afterSubmit?: string;
};

export default function Enrollment() {
  const theme = useTheme();
  const [showPassword, setShowPassword] = useState(false);
  const [snackbarOpen, setSnackbarOpen] = useState<boolean>(false);
  const [snackbarMessage, setSnackbarMessage] = useState<string>("");
  const [snackbarAlertType, setSnackbarAlertType] = useState<AlertColor | undefined>(undefined);
  const isMountedRef = useIsMountedRef();

  const EnrollmentSchema = Yup.object().shape({
    name: Yup.string().min(2, 'Too Short!').max(50, 'Too Long!').required('First name required'),
    surname: Yup.string().min(1, 'Too Short!').max(50, 'Too Long!').required('Last name required'),
    hacettepeID: Yup.string().min(8, 'Student ID cannot be shorter than 8 characters!').max(15, 'Too Long!').required('Student ID required'),
    email: Yup.string().email('Email must be a valid email address').required('Email is required'),
    password: Yup.string().required('Password is required').min(8, 'Password cannot be shorter than 8 characters!').matches(/^(?=.*[a-z])/, 'Must contain at least one lowercase character')
    .matches(/^(?=.*[A-Z])/, 'Must contain at least one uppercase character'),
    passwordConfirmation: Yup.string()
    .nullable()
    .oneOf([Yup.ref('password'), null], 'Passwords must match')
    .required('Password confirmation is required')
  });

  const formik = useFormik<InitialValues>({
    initialValues: {
      name: '',
      surname: '',
      hacettepeID: '',
      memberType: MemberType.STUDENT,
      email: '',
      password: '',
      passwordConfirmation: ''
    },
    validationSchema: EnrollmentSchema,
    onSubmit: async (values, { setErrors, setSubmitting, resetForm }) => {
      try {
        let memberEnumKey = Object.keys(MemberType)[Object.values(MemberType).indexOf(values.memberType)];
        const enrollmentRequestDTO = new EnrollmentRequestDTO(values.name, values.surname, values.hacettepeID, values.email, values.password, memberEnumKey);
        const response = await axios.post(ApiRoutes.ENROLLMENT, enrollmentRequestDTO);

        if (response.status === 200) {
          if (response.data.messageType === "ERROR") {
            setSnackbarAlertType("error");
          } else {
            setSnackbarAlertType("success");
          }
          setSnackbarMessage(response.data.message);
          setSnackbarOpen(true);
          resetForm();
        }
        if (isMountedRef.current) {
          setSubmitting(false);
        }
      } catch (error: any) {
        setSnackbarAlertType("error");
        setSnackbarMessage(error.data.message);
        setSnackbarOpen(true);
        if (isMountedRef.current) {
          setErrors({ afterSubmit: error.message });
          setSubmitting(false);
        }
      }
    }
  });

  const { errors, touched, handleSubmit, getFieldProps } = formik;

  const handleShowPassword = () => {
    setShowPassword((show) => !show);
  };

  const handleCloseSnackbar = (event?: React.SyntheticEvent | Event, reason?: string) => {
    if (reason === 'clickaway') {
      return;
    }
    setSnackbarOpen(false);
  };

  return (
    <Grid
      container
      sx={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        minHeight: '100vh',
        backgroundPosition: 'center',
        backgroundSize: 'cover',
      }}
    >
      <Snackbar open={snackbarOpen} autoHideDuration={5000} onClose={handleCloseSnackbar}>
        <Alert onClose={handleCloseSnackbar} severity={snackbarAlertType} sx={{ width: '100%' }}>
          {snackbarMessage}
        </Alert>
      </Snackbar>
      <Grid
        item
        sx={{
          display: 'flex',
          flexDirection: 'column',
          alignItems:'center',
          backgroundColor: 'rgba(255, 255, 255, 0.8)',
          padding: 2,
          borderRadius: 2,
          boxShadow: 2
        }}
      >
        <Typography
          variant='h5'
          sx={{
            color: theme.palette.primary.main,
            fontWeight: 700,
            mb: 2
          }}
        >
          LinkedHU_CENG
        </Typography>
        <Card
          elevation={4}
          sx={{
              minWidth: 500,
          }}>
          <CardHeader title="Enrollment" />
          <CardContent>
            <FormikProvider value={formik}>
              <Form autoComplete="off" noValidate onSubmit={handleSubmit}>
                <Stack spacing={3}>
                  {errors.afterSubmit && <Alert severity="error">{errors.afterSubmit}</Alert>}

                  <TextField
                    fullWidth
                    type="text"
                    label="Name"
                    {...getFieldProps('name')}
                    error={Boolean(touched.name && errors.name)}
                    helperText={touched.name && errors.name}
                  />

                  <TextField
                    fullWidth
                    type="text"
                    label="Surname"
                    {...getFieldProps('surname')}
                    error={Boolean(touched.surname && errors.surname)}
                    helperText={touched.surname && errors.surname}
                  />

                  <TextField
                    fullWidth
                    type="text"
                    label="Hacettepe ID"
                    {...getFieldProps('hacettepeID')}
                    error={Boolean(touched.hacettepeID && errors.hacettepeID)}
                    helperText={touched.hacettepeID && errors.hacettepeID}
                  />

                  <TextField
                    fullWidth
                    select
                    label="Member Type"
                    {...getFieldProps('memberType')}
                    error={Boolean(touched.memberType && errors.memberType)}
                    helperText={touched.memberType && errors.memberType}
                  >
                    {Object.values(MemberType).map((type) => {
                      if (type !== MemberType.ADMIN) {
                        return (
                          <MenuItem key={type} value={type}>
                            {type}
                          </MenuItem>
                        )
                      }
                    })}
                  </TextField>

                  <TextField
                    fullWidth
                    type="email"
                    label="Email"
                    {...getFieldProps('email')}
                    error={Boolean(touched.email && errors.email)}
                    helperText={touched.email && errors.email}
                  />

                  <TextField
                    fullWidth
                    type={showPassword ? 'text' : 'password'}
                    label="Password"
                    {...getFieldProps('password')}
                    InputProps={{
                      endAdornment: (
                        <InputAdornment position="end">
                          <IconButton onClick={handleShowPassword} edge="end">
                            <Icon icon={showPassword ? eyeFill : eyeOffFill} />
                          </IconButton>
                        </InputAdornment>
                      )
                    }}
                    error={Boolean(touched.password && errors.password)}
                    helperText={touched.password && errors.password}
                  />

                  <TextField
                    fullWidth
                    type={showPassword ? 'text' : 'password'}
                    label="Password Again"
                    {...getFieldProps('passwordConfirmation')}
                    InputProps={{
                      endAdornment: (
                        <InputAdornment position="end">
                          <IconButton onClick={handleShowPassword} edge="end">
                            <Icon icon={showPassword ? eyeFill : eyeOffFill} />
                          </IconButton>
                        </InputAdornment>
                      )
                    }}
                    error={Boolean(touched.passwordConfirmation && errors.passwordConfirmation)}
                    helperText={touched.passwordConfirmation && errors.passwordConfirmation}
                  />
                </Stack>

                <Button
                  fullWidth
                  type='submit'
                  variant="contained"
                  size="large"
                  sx={{
                    my: 3
                  }}
                >
                  Enroll
                </Button>

                <Stack
                  direction="row"
                  alignItems="center"
                  justifyContent="space-between"
                  >
                  <Link component={RouterLink} variant="subtitle2" to={PATH_AUTH.login}>
                    Already have an account?
                  </Link>
                </Stack>
              </Form>
            </FormikProvider>
          </CardContent>
        </Card>
      </Grid>
    </Grid>
  )
}
