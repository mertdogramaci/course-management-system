import ChatIcon from '@mui/icons-material/Chat';
import EventIcon from '@mui/icons-material/Event';
import HomeIcon from '@mui/icons-material/Home';
import PeopleIcon from '@mui/icons-material/People';
import PersonIcon from '@mui/icons-material/Person';
import SettingsIcon from '@mui/icons-material/Settings';
import FacultyIcon from '@mui/icons-material/School'
import DepartmentIcon from '@mui/icons-material/HomeWork'
import CourseIcon from '@mui/icons-material/Book'
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
      <ListItemButton onClick={() => handleClick(PATH_MAIN.faculties)}>
        <ListItemIcon>
          <FacultyIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Faculties"} />
      </ListItemButton>
      <ListItemButton onClick={() => handleClick(PATH_MAIN.departments)}>
        <ListItemIcon>
          <DepartmentIcon color = "primary"/>
        </ListItemIcon>
        <ListItemText primary={"Departments"} />
      </ListItemButton>
      <ListItemButton onClick={() => handleClick(PATH_MAIN.myCourses)}>
        <ListItemIcon>
          <CourseIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"My Courses"} />
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
