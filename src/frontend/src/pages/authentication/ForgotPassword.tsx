import { Alert, AlertColor, Button, Card, CardContent, CardHeader, Grid, Link, Snackbar, Stack, TextField, Typography } from '@mui/material';
import { useTheme } from '@mui/material/styles';
import { Form, FormikProvider, useFormik } from 'formik';
import React, { useState } from 'react';
import { Link as RouterLink } from 'react-router-dom';
import * as Yup from 'yup';
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import useIsMountedRef from '../../hooks/useIsMountedRef';
import { PATH_AUTH } from '../../routes/paths';

type InitialValues = {
  email: string;
  afterSubmit?: string;
};

export default function ForgotPassword() {
  const theme = useTheme();
  const [snackbarOpen, setSnackbarOpen] = useState<boolean>(false);
  const [snackbarMessage, setSnackbarMessage] = useState<string>("");
  const [snackbarAlertType, setSnackbarAlertType] = useState<AlertColor | undefined>(undefined);
  const isMountedRef = useIsMountedRef();

  const LoginSchema = Yup.object().shape({
    email: Yup.string().required('Email is required'),
  });

  const formik = useFormik<InitialValues>({
    initialValues: {
      email: '',
    },
    validationSchema: LoginSchema,
    onSubmit: async (values, { setErrors, setSubmitting, resetForm }) => {
      try {
        const response = await axios.post(ApiRoutes.FORGOT_PASSWORD, {
          email: values.email
        })

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
        resetForm();
        if (isMountedRef.current) {
          setSubmitting(false);
          setErrors({ afterSubmit: error.message });
        }
      }
    }
  });

  const { errors, touched, handleSubmit, getFieldProps } = formik;

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
          <CardHeader title="Forgot Password" />
          <CardContent>
            <FormikProvider value={formik}>
              <Form autoComplete="off" noValidate onSubmit={handleSubmit}>
                <Stack spacing={3}>
                  {errors.afterSubmit && <Alert severity="error">{errors.afterSubmit}</Alert>}

                  <TextField
                    fullWidth
                    type="email"
                    label="Email"
                    {...getFieldProps('email')}
                    error={Boolean(touched.email && errors.email)}
                    helperText={touched.email && errors.email}
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
                  Reset Password
                </Button>

                <Stack alignItems="center">
                  <Link component={RouterLink} variant="subtitle2" to={PATH_AUTH.login}>
                     Go Login Page
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
