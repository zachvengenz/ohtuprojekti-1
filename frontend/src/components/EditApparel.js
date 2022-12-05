import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
  TextField,
} from "@mui/material";
import * as React from "react";

export default function EditApparel(props) {
  const [open, setOpen] = React.useState(false);
  const [apparel, setApparel] = React.useState({
    name: "",
    type: "",
    price: "",
    maker: "",
  });

  const handleClickOpen = () => {
    setOpen(true);
    console.log(props.data);
    setApparel({
      name: props.data.name,
      type: props.data.type,
      price: props.data.price,
      maker: props.data.maker.name,
    });
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSave = () => {
    props.updateApparel(apparel, props.data._links.apparel.href);
    setOpen(false);
  };

  return (
    <div>
      <Button size="small" variant="outlined" onClick={handleClickOpen}>
        Edit
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle> Edit Apparel</DialogTitle>
        <DialogContent>
          <DialogContentText></DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            label="Name"
            value={apparel.name}
            onChange={(e) => setApparel({ ...apparel, name: e.target.value })}
            fullWidth
            variant="standard"
          />
          <TextField
            autoFocus
            margin="dense"
            label="Type"
            value={apparel.type}
            onChange={(e) => setApparel({ ...apparel, type: e.target.value })}
            fullWidth
            variant="standard"
          />
          <TextField
            autoFocus
            margin="dense"
            label="Price"
            value={apparel.price}
            onChange={(e) => setApparel({ ...apparel, price: e.target.value })}
            fullWidth
            variant="standard"
          />
          <TextField
            autoFocus
            margin="dense"
            label="Maker"
            value={apparel.maker}
            onChange={(e) => setApparel({ ...apparel, maker: e.target.value })}
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
