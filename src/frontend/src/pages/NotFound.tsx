import { Grid, Link, Typography } from '@mui/material';
import React from 'react';
import { Link as RouterLink } from 'react-router-dom';
import { PATH_MAIN } from '../routes/paths';

export default function NotFound() {
  return (
    <div style={{
      display: 'flex',
      flexDirection: 'column',
      flex: 1,
      height: '100vh',
      justifyContent: 'center',
      alignItems: 'center',
      backgroundPosition: 'center',
      backgroundSize: 'cover',
    }}>
      <Grid sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems:'center',
        backgroundColor: 'rgba(255, 255, 255, 0.8)',
        padding: 2,
        borderRadius: 2,
        boxShadow: 2
      }}>
        <Typography variant='h5'>404</Typography>
        <div>
          The page you are looking for is not found!
        </div>
        <Link component={RouterLink} variant="body2" to={PATH_MAIN.root}>
          Go to the main page
        </Link>
      </Grid>
    </div>
  )
}
