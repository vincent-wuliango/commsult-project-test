import Button from '@mui/material/Button';
import DeleteIcon from "@material-ui/icons/Delete";
import EditIcon from "@material-ui/icons/Edit";
import Stack from '@mui/material/Stack';

function ButtonEditDelete() {
    return(
    <Stack spacing={2} direction="row">
        <Button variant="contained" 
        onClick={() => {
            alert('clicked');
        }} color="success" size="small" startIcon={<EditIcon/>}>Edit</Button>

        <Button variant="contained" style={{marginLeft: "10px"}} color="error" size="small" startIcon={<DeleteIcon />}>Delete</Button>
    </Stack>
    )
}

export default ButtonEditDelete