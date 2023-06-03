import ChatIcon from '@mui/icons-material/Chat';
import EventIcon from '@mui/icons-material/Event';
import HomeIcon from '@mui/icons-material/Home';
import PeopleIcon from '@mui/icons-material/People';
import PersonIcon from '@mui/icons-material/Person';
import SettingsIcon from '@mui/icons-material/Settings';
import SlideshowIcon from '@mui/icons-material/Slideshow';
import WorkIcon from '@mui/icons-material/Work';
import { ListItemButton, ListItemIcon, ListItemText } from '@mui/material';
import List from '@mui/material/List';
import React from 'react';
import { useNavigate } from 'react-router-dom';
import useAuth from '../hooks/useAuth';
import { PATH_MAIN, ROOTS_MAIN } from '../routes/paths';

export default function Sidebar() {
  const { user } = useAuth();
  const navigate = useNavigate();

  const handleClick = (route: string) => {
    navigate(route)
  };

  return (
    <List
      sx={{ width: '100%', maxWidth: 400, bgcolor: 'primary' }}
      component="nav"
    >
      <ListItemButton onClick={() => handleClick(ROOTS_MAIN)}>
        <ListItemIcon>
          <HomeIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Main Page"}/>
      </ListItemButton>
      <ListItemButton onClick={() => handleClick(PATH_MAIN.jobs)}>
        <ListItemIcon>
          <WorkIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Jobs"} />
      </ListItemButton>
      <ListItemButton onClick={() => handleClick(PATH_MAIN.events)}>
        <ListItemIcon>
          <EventIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Events"} />
      </ListItemButton>
      <ListItemButton onClick={() => handleClick(PATH_MAIN.presentations)}>
        <ListItemIcon>
          <SlideshowIcon color = "primary"/>
        </ListItemIcon>
        <ListItemText primary={"Presentations"} />
      </ListItemButton>
      { user?.memberType !== "ADMIN" && (
        <>
        <ListItemButton onClick={() => handleClick(PATH_MAIN.chat)}>
         <ListItemIcon>
           <ChatIcon  color = "primary"/>
         </ListItemIcon>
         <ListItemText primary={"Chat"} />
        </ListItemButton>
          <ListItemButton onClick={() => handleClick(PATH_MAIN.myNetwork)}>
          <ListItemIcon>
            <PeopleIcon color = "primary" />
          </ListItemIcon>
          <ListItemText primary={"My Network"} />
        </ListItemButton>
        <ListItemButton onClick={() => handleClick(PATH_MAIN.profile)}>
          <ListItemIcon>
            <PersonIcon color = "primary" />
          </ListItemIcon>
          <ListItemText primary={"Profile"} />
        </ListItemButton>
       </>
      )}
      <ListItemButton onClick={() => handleClick(PATH_MAIN.settings)}>
        <ListItemIcon>
          <SettingsIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Settings"} />
      </ListItemButton>
    </List>
  )
}
