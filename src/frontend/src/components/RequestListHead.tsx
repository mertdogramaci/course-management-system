import { Box, TableCell, TableHead, TableRow, TableSortLabel } from '@mui/material';

type RequestListHeadProps = {
  order: 'asc' | 'desc';
  orderBy: string;
  headLabel: any[];
  onRequestSort: (property: string) => void;
};

export default function RequestListHead({
  order,
  orderBy,
  headLabel,
  onRequestSort,
}: RequestListHeadProps) {
  return (
    <TableHead>
      <TableRow>
        {headLabel.slice(0, -1).map((headCell) => (
          <TableCell
            key={headCell.id}
            align="center"
            sortDirection={orderBy === headCell.id ? order : false}
          >
            <TableSortLabel
              hideSortIcon
              active={orderBy === headCell.id}
              direction={orderBy === headCell.id ? order : 'asc'}
              onClick={() => onRequestSort(headCell.id)}
            >
              {headCell.label}
              {orderBy === headCell.id ? (
                <Box sx={{
                  //...visuallyHidden
                  }}>
                  {order === 'desc' ? 'sorted descending' : 'sorted ascending'}
                </Box>
              ) : null}
            </TableSortLabel>
          </TableCell>
        ))}
        <TableCell
          key={headLabel[headLabel.length - 1].id}
          align="center"
        >
          {headLabel[headLabel.length - 1].label}
        </TableCell>
      </TableRow>
    </TableHead>
  );
}
