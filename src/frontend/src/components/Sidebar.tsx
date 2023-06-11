import ChatIcon from '@mui/icons-material/Chat';
import HomeIcon from '@mui/icons-material/Home';
import PeopleIcon from '@mui/icons-material/People';
import PersonIcon from '@mui/icons-material/Person';
import SettingsIcon from '@mui/icons-material/Settings';
import CourseIcon from '@mui/icons-material/Book'
import TranscriptIcon from '@mui/icons-material/Pages'
import Timetable from '@mui/icons-material/CalendarMonth'
import { Divider, ListItemButton, ListItemIcon, ListItemText } from '@mui/material';
import List from '@mui/material/List';
import React from 'react';
import { useNavigate } from 'react-router-dom';
import useAuth from '../hooks/useAuth';
import { PATH_MAIN, ROOTS_MAIN } from '../routes/paths';
import HistoryIcon from '@mui/icons-material/History';
import LibraryAddCheckIcon from '@mui/icons-material/LibraryAddCheck';

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
          <HomeIcon color="primary" />
        </ListItemIcon>
        <ListItemText primary={"Main Page"} />
      </ListItemButton>

      <Divider/>

      { user?.memberType === "ADMIN" && (
        <>
        <ListItemButton onClick={() => handleClick(PATH_MAIN.log)}>
        <ListItemIcon>
          <HistoryIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Process history"} />
      </ListItemButton>
       </>
      )}

      { user?.memberType !== "ADMIN" && (
        <>
        <ListItemButton onClick={() => handleClick(PATH_MAIN.courses)}>
        <ListItemIcon>
          <CourseIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"My Courses"} />
        </ListItemButton>
        <ListItemButton onClick={() => handleClick(PATH_MAIN.courseRegistration)}>
        <ListItemIcon>
          <LibraryAddCheckIcon color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Course Registration"} />
      </ListItemButton>

          <ListItemButton onClick={() => handleClick(PATH_MAIN.transcript)}>
            <ListItemIcon>
              <TranscriptIcon color="primary" />
            </ListItemIcon>
            <ListItemText primary={"Transcript"} />
          </ListItemButton>

          <ListItemButton onClick={() => handleClick(PATH_MAIN.timetable)}>
            <ListItemIcon>
              <Timetable color="primary" />
            </ListItemIcon>
            <ListItemText primary={"Weekly Timetable"} />
          </ListItemButton>

          <ListItemButton onClick={() => handleClick(PATH_MAIN.courses)}>
            <ListItemIcon>
              <Timetable color="primary" />
            </ListItemIcon>
            <ListItemText primary={"Homeworks"} />
          </ListItemButton>

      <ListItemButton onClick={() => handleClick(PATH_MAIN.courses)}>
        <ListItemIcon>
          <Timetable color = "primary" />
        </ListItemIcon>
        <ListItemText primary={"Course Registration"} />
      </ListItemButton>
        <ListItemButton onClick={() => handleClick(PATH_MAIN.profile)}>
          <ListItemIcon>
            <PersonIcon color = "primary" />
          </ListItemIcon>
          <ListItemText primary={"Profile"} />
        </ListItemButton>

        <ListItemButton onClick={() => handleClick(PATH_MAIN.advisor)}>
          <ListItemIcon>
            <PersonIcon color = "primary" />
          </ListItemIcon>
          <ListItemText primary={"Advisor Information"} />
        </ListItemButton>

        <ListItemButton onClick={() => handleClick(PATH_MAIN.settings)}>
        <ListItemIcon>
          <SettingsIcon color="primary" />
        </ListItemIcon>
        <ListItemText primary={"Settings"} />
      </ListItemButton>
       </>
      )}

    </List>
  )
}
