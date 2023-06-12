import { Grid, useTheme } from '@mui/material';
import React from 'react';
import { Outlet } from 'react-router-dom';
import Header from '../components/Header/Header';
import Sidebar from '../components/Sidebar';

export default function MainLayout() {
  const theme = useTheme();

  return (
    <>
      <Header />
      <Grid
        container
        sx={{
          maxWidth: '91rem',
          mx: 'auto',
          spacing: 0,
        }}
      >
        <Grid
          item
          xs={2}
          sx={{
            position: 'sticky',
            top: 0,
            pt: 8,
            height: '1000vh'
          }}
        >
          <Sidebar />
        </Grid>
        <Grid
          item
          xs={9}
          sx={{
            pt: 8,
            display: 'flex',
            flex: 1,
            flexDirection: 'column',
            overflow: 'auto',
            alignItems: 'center',
            borderLeftColor: 'gray',
            borderLeftStyle: 'solid',
            borderLeftWidth: 1,
          }}
        >
          <Outlet />
        </Grid>
      </Grid>
   </>
  )
}
