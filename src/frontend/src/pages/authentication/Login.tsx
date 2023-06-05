import eyeFill from '@iconify/icons-eva/eye-fill';
import eyeOffFill from '@iconify/icons-eva/eye-off-fill';
import { Icon } from '@iconify/react';
import { Alert, Button, Card, CardContent, CardHeader, Grid, IconButton, InputAdornment, Link, Stack, TextField, Typography } from '@mui/material';
import { useTheme } from '@mui/material/styles';
import { Form, FormikProvider, useFormik } from 'formik';
import React, { useState } from 'react';
import { Link as RouterLink } from 'react-router-dom';
import * as Yup from 'yup';
import useAuth from '../../hooks/useAuth';
import useIsMountedRef from '../../hooks/useIsMountedRef';
import { PATH_AUTH } from '../../routes/paths';

type InitialValues = {
  email: string;
  password: string;
  afterSubmit?: string;
};

export default function Login() {
  const theme = useTheme();
  const { login } = useAuth();
  const [showPassword, setShowPassword] = useState(false);
  const isMountedRef = useIsMountedRef();

  const LoginSchema = Yup.object().shape({
    email: Yup.string().required('Email is required'),
    password: Yup.string().required('Password is required')
  });

  const formik = useFormik<InitialValues>({
    initialValues: {
      email: '',
      password: '',
    },
    validationSchema: LoginSchema,
    onSubmit: async (values, { setErrors, setSubmitting, resetForm }) => {
      try {
        await login(values.email, values.password);
        if (isMountedRef.current) {
          setSubmitting(false);
        }
      } catch (error: any) {
        resetForm();
        if (isMountedRef.current) {
          setSubmitting(false);
          setErrors({ afterSubmit: error.message + "\nPlease try to login again!" });
        }
      }
    }
  });

  const { errors, touched, handleSubmit, getFieldProps } = formik;

  const handleShowPassword = () => {
    setShowPassword((show) => !show);
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
          <CardHeader title="Login" />
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
                  Login
                </Button>

                <Stack
                  direction="row"
                  alignItems="center"
                  justifyContent="space-between"
                  >
                  <Link component={RouterLink} variant="subtitle2" to={PATH_AUTH.register}>
                    Create an Account
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
