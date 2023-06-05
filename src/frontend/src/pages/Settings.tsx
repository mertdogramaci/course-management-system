import { Box, Tab, Tabs, Typography } from '@mui/material';
import React from 'react';
import ChangePassword from '../components/Settings/ChangePassword';
import ProfileUpdate from '../components/Settings/ProfileUpdate';

interface TabPanelProps {
  children?: React.ReactNode;
  index: number;
  value: number;
}

function TabPanel(props: TabPanelProps) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

function a11yProps(index: number) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

export default function Settings() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setValue(newValue);
  };

  return (
    <Box sx={{ width: '100%', marginTop: 2 }}>
      <Tabs value={value} onChange={handleChange}>
        <Tab label={"Profile Update"} wrapped {...a11yProps(0)} />
        <Tab label={"Change Password"}  {...a11yProps(1)}  />
      </Tabs>
      <TabPanel value={value} index={0}>
        <ProfileUpdate />
      </TabPanel>
      <TabPanel value={value} index={1}>
        <ChangePassword />
      </TabPanel>
    </Box>
)}