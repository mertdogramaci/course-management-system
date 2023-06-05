import eyeFill from '@iconify/icons-eva/eye-fill';
import eyeOffFill from '@iconify/icons-eva/eye-off-fill';
import { Icon } from '@iconify/react';
import { Alert, AlertColor, Button, Card, CardContent, Grid, IconButton, InputAdornment, Snackbar, TextField } from '@mui/material';
import { Form, FormikProvider, useFormik } from 'formik';
import React, { useState } from 'react';
import * as Yup from 'yup';
import axios from '../../api/axios';
import ApiRoutes from '../../api/routes';
import useAuth from '../../hooks/useAuth';
import useIsMountedRef from '../../hooks/useIsMountedRef';

type InitialValues = {
	oldPassword: string;
	newPassword: string;
	confirmPassword: string;
	afterSubmit?: string;
};

export default function ChangePassword() {
	const [showPassword, setShowPassword] = useState(false);
	const [showNewPassword, setShowNewPassword] = useState(false);
	const [snackbarOpen, setSnackbarOpen] = useState<boolean>(false);
	const [snackbarMessage, setSnackbarMessage] = useState<string>("");
  const [snackbarAlertType, setSnackbarAlertType] = useState<AlertColor | undefined>(undefined);
	const isMountedRef = useIsMountedRef();
	const { user } = useAuth();

	const changePasswordSchema = Yup.object().shape({
		oldPassword: Yup.string()
			.required("Required"),
		newPassword: Yup.string()
			.required("Required")
			.matches(/^(?=.*[a-z])/, 'Must contain at least one lowercase character')
    	.matches(/^(?=.*[A-Z])/, 'Must contain at least one uppercase character')
			.min(8, 'Password cannot be shorter than 8 characters!'),
		confirmPassword: Yup.string()
			.oneOf([Yup.ref("newPassword")], "Passwords must match")
			.required("Required"),
	});

	const formik = useFormik<InitialValues>({
		initialValues: {
			oldPassword: '',
			newPassword: '',
			confirmPassword: ''
		},
		validationSchema: changePasswordSchema,
		onSubmit: async (values, { setErrors, setSubmitting, resetForm }) => {
			try {
				if (user) {
					const response = await axios.post(ApiRoutes.CHANGE_PASSWORD, {
						userID: user.id,
						oldPassword: values.oldPassword,
						newPassword: values.newPassword});

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

	const handleShowPassword = () => {
		setShowPassword((show) => !show);
	};

	const handleShowNewPassword = () => {
		setShowNewPassword((show) => !show);
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
					<FormikProvider value={formik}>
						<Form autoComplete="off" noValidate onSubmit={handleSubmit}>
							{errors.afterSubmit && <Alert severity="error">{errors.afterSubmit}</Alert>}
							<TextField
								type={showPassword ? 'text' : 'password'}
								label="Old Password"
								sx={{ m: 1, width: '97.5%' }}
								{...getFieldProps('oldPassword')}
								InputProps={{
										endAdornment: (
											<InputAdornment position="end">
												<IconButton onClick={handleShowPassword} edge="end">
													<Icon icon={showPassword ? eyeFill : eyeOffFill} />
												</IconButton>
											</InputAdornment>
										)
									}}
								error={Boolean(touched.oldPassword && errors.oldPassword)}
								helperText={touched.oldPassword && errors.oldPassword}
							/>

							<TextField
								type={showNewPassword ? 'text' : 'password'}
								label="New Password"
								sx={{ m: 1, width: '97.5%' }}
								{...getFieldProps('newPassword')}
								InputProps={{
										endAdornment: (
											<InputAdornment position="end">
												<IconButton onClick={handleShowNewPassword} edge="end">
													<Icon icon={showNewPassword ? eyeFill : eyeOffFill} />
												</IconButton>
											</InputAdornment>
										)
									}}
								error={Boolean(touched.newPassword && errors.newPassword)}
								helperText={touched.newPassword && errors.newPassword}
							/>

							<TextField
								type={showNewPassword ? 'text' : 'password'}
								label="Confirm Password"
								sx={{ m: 1, width: '97.5%' }}
								{...getFieldProps('confirmPassword')}
								InputProps={{
										endAdornment: (
											<InputAdornment position="end">
												<IconButton onClick={handleShowNewPassword} edge="end">
													<Icon icon={showNewPassword ? eyeFill : eyeOffFill} />
												</IconButton>
											</InputAdornment>
										)
									}}
								error={Boolean(touched.confirmPassword && errors.confirmPassword)}
								helperText={touched.confirmPassword && errors.confirmPassword}
							/>

							<div style ={{ display: "flex", alignItems: 'center', justifyContent: "flex-end", marginTop: 8 }}>
								<Button variant="contained" type='submit'>Save Changes</Button>
							</div>
						</Form>
					</FormikProvider>
				</CardContent>
			</Card>
		</Grid>
	)
}
