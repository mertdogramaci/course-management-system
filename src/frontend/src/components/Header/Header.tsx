
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import { IconButton, Link, MenuItem, Popover } from '@mui/material';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { useTheme } from '@mui/material/styles';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import React from 'react';
import { Link as RouterLink, useNavigate } from 'react-router-dom';
import useAuth from '../../hooks/useAuth';
import { PATH_ADMIN, PATH_AUTH, PATH_MAIN } from '../../routes/paths';
import { isAdmin } from '../../utils';



export default function Header() {

  let ADMIN_MENU_OPTIONS = [
    {
      label: "header.manage-button.enrollment-requests.text",
      linkTo: PATH_ADMIN.enrollmentRequests
    },
    {
      label: "header.manage-button.fp-requests.text",
      linkTo: PATH_ADMIN.forgotPasswordRequests
    }
  ];

  const theme = useTheme();
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const [anchorEl, setAnchorEl] = React.useState<HTMLButtonElement | null>(null);

  const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const open = Boolean(anchorEl);
  const id = open ? 'simple-popover' : undefined;

  return (
    <AppBar position="fixed" sx={{ background: theme.palette.primary.main }}>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Typography
            variant="h6"
            noWrap
            component="div"
            fontWeight={800}
            sx={{ mr: 2 }}
            onClick={() => navigate(PATH_MAIN.feed)}
          >
            LinkedHU_CENG
          </Typography>

          <Box sx={{ flexGrow: 1, display: 'flex', justifyContent: 'center' }}>
          </Box>
          {isAdmin(user) && (
            <Box>
              <IconButton
                sx={{ color: 'white', mr: 2 }}
                onClick={handleClick}
              >
                <AdminPanelSettingsIcon fontSize='large' />
              </IconButton>
              <Popover
                  anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'center',
                  }}
                  transformOrigin={{
                    vertical: 'top',
                    horizontal: 'center',
                  }}
                  id={id}
                  open={open}
                  anchorEl={anchorEl}
                  onClose={handleClose}
                >
                  {ADMIN_MENU_OPTIONS.map((option) => [
                    <MenuItem
                      key={option.label}
                      to={option.linkTo}
                      component={RouterLink}
                      onClick={handleClose}
                      sx={{ typography: 'body2', py: 1, px: 2 }}
                    >
                      {option.label}
                    </MenuItem>
                  ])}
                </Popover>
              </Box>
            )
          }
          <Box>
            <Link component={RouterLink} sx={{ color: 'white' }} onClick={logout} to={PATH_AUTH.login}>
              {"header.logout"}
            </Link>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}