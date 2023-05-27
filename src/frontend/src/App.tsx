
import { CssBaseline } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import React from 'react';
import LoadingScreen from './components/LoadingScreen';
import useAuth from './hooks/useAuth';
import Router from './routes';
import { enUS } from '@mui/material/locale';


function App() {
  const { isInitialized } = useAuth();

  const theme = createTheme({
    palette: {
      primary: {
        main: '#704ca3',
      },
      background: {
        default: '#F3F4F6',
      }
    }
  }, enUS);

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      {isInitialized ? <Router/> : <LoadingScreen />}
    </ThemeProvider>
  );
}

export default App;
