/* eslint-disable no-plusplus */
/* eslint-disable react/prop-types */
import React from 'react';
import {
} from '@mui/icons-material';
import {
  Box, Modal, Typography,
} from '@mui/material';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 600,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

export default function ModalErro(props) {
  const { error, open, setOpen } = props;
  // const [open, setOpen] = useState(false);

  // const handleOpen = () => {
  //   setOpen(true);
  // };
  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="h2" mb={2}>
            Houve um problema em reservar:
          </Typography>
          <Typography id="modal-modal-title" variant="body1" color="error">
            {`${error}`}
          </Typography>
        </Box>
      </Modal>
    </div>
  );
}
