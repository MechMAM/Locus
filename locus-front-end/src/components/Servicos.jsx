/* eslint-disable react/prop-types */
import React from 'react';
import {
  FreeBreakfast, Groups, SurroundSound, Translate, VideoCameraFront, WbIncandescent,
} from '@mui/icons-material';
import { Box, Typography } from '@mui/material';

export default function Servicos(props) {
  const { id } = props;

  const getServico = () => {
    switch (id) {
      case 'e3e0cc93-818a-444f-8e08-6066cfbcc745':
        return (
          <Box display="flex">
            <VideoCameraFront />
            <Typography>
              &nbsp;
              Recursos de vídeo
            </Typography>
          </Box>
        );
      case 'cca48982-ad0f-4dad-8ba0-688833c25b03':
        return (
          <Box display="flex">
            <Translate />
            <Typography>
              &nbsp;
              Recursos de tradução simultânea
            </Typography>
          </Box>
        );
      case 'f523c8b2-719d-4029-b5b3-b5f75b69fe02':
        return (
          <Box display="flex">
            <WbIncandescent />
            <Typography>
              &nbsp;
              Recursos de Iluminação
            </Typography>
          </Box>
        );
      case '70f85cc8-8786-4122-9184-39238fac767a':
        return (
          <Box display="flex">
            <SurroundSound />
            <Typography>
              &nbsp;
              Recursos de áudio
            </Typography>
          </Box>
        );
      case 'a1a71037-98d9-41a1-b8ff-8f9ba3870383':
        return (
          <Box display="flex">
            <FreeBreakfast />
            <Typography>
              &nbsp;
              Coffe Break
            </Typography>
          </Box>
        );
      case 'b0b19d81-5321-4130-9956-6b6fe2dde534':
        return (
          <Box display="flex">
            <Groups />
            <Typography>
              &nbsp;
              Equipe de Palco
            </Typography>
          </Box>
        );

      default:
        throw new Error('Id inválido');
    }
  };

  return (
    <div>
      {getServico()}
    </div>
  );
}
