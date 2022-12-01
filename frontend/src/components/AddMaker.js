import { Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, TextField } from "@mui/material";
import * as React from "react";

export default function AddMaker(props) {
    const [open, setOpen] = React.useState(false);
    const [maker, setMaker] = React.useState({
        name: "",
       
    });

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSave = () => {
        props.addMaker(maker);
        setOpen(false);
        console.log(maker);
    };

    return(
        <div>
            <Button size="small" variant="outlined" onClick={handleClickOpen}>Add new maker</Button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>New Maker</DialogTitle>
                <DialogContent>
                    <DialogContentText></DialogContentText>
                    <TextField
                        autoFocus
                        margin="dense"
                        label="Name"
                        value={maker.name}
                        onChange={(e) => setMaker({ ...maker, name: e.target.value })}
                        fullWidth
                        variant="standard"
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button onClick={handleSave}>Save</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}