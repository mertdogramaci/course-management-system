import searchFill from '@iconify/icons-eva/search-fill';
import { Icon } from '@iconify/react';
import {
  Box, InputAdornment,
  OutlinedInput, Toolbar
} from '@mui/material';
import { styled } from '@mui/material/styles';

const RootStyle = styled(Toolbar)(({ theme }) => ({
  height: 84,
  display: 'flex',
  justifyContent: 'space-between',
  padding: theme.spacing(0, 1, 0, 3)
}));

const SearchStyle = styled(OutlinedInput)(({ theme }) => ({
  width: 240,
  height: 40,
    transition: theme.transitions.create(['box-shadow', 'width'], {
    easing: theme.transitions.easing.easeInOut,
    duration: theme.transitions.duration.shorter
  }),
  '&.Mui-focused': { width: 320, boxShadow: 1 },
  '& fieldset': {
    borderWidth: `1px !important`,
    borderColor: `gray !important`
  }
}));

type RequestListToolbarProps = {
  filterName: string;
  onFilterName: (value: string) => void;
};

export default function RequestListToolbar({
  filterName,
  onFilterName
}: RequestListToolbarProps) {

  return (
    <RootStyle
      sx={{
        color: 'primary.main',
        bgcolor:'primary.lighter'
      }}
    >
      <SearchStyle
        value={filterName}
        onChange={(e) => onFilterName(e.target.value)}
        placeholder="Search a request..."
        startAdornment={
          <InputAdornment position="start">
            <Box component={Icon} icon={searchFill} sx={{ color: 'text.disabled' }} />
          </InputAdornment>
        }
      />
    </RootStyle>
  );
}
