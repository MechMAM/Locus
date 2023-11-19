/* eslint-disable react/prop-types */
import React from 'react';
import {
  Accessibility, Accessible, Wc, WheelchairPickup,
} from '@mui/icons-material';
import { Box, Typography } from '@mui/material';

export default function Acessibilidades(props) {
  const { id } = props;

  const getAcessibilidade = () => {
    switch (id) {
      case '244ebbd3-1c4d-485e-99c0-0d94db3b4cf0':
        return (
          <Box display="flex">
            <WheelchairPickup color="primary" />
            <Typography>
              &nbsp;
              Estacionamento PcD
            </Typography>
          </Box>
        );
      case 'd7bd1ead-f9ed-4024-98af-f652442db2a4':
        return (
          <Box display="flex">
            <Wc color="primary" />
            <Typography>
              &nbsp;
              Banheiros Acessíveis
            </Typography>
          </Box>
        );
      case '6bc3ac3a-c152-4427-81d5-42f8a8f22afa':
        return (
          <Box display="flex">
            <Accessible color="primary" />
            <Typography>
              &nbsp;
              Acesso ao palco sem degraus
            </Typography>
          </Box>
        );
      case '945e7971-a6f7-4c2a-8cb0-f1fb0f304e05':
        return (
          <Box display="flex">
            <Accessibility color="primary" />
            <Typography>
              &nbsp;
              Portas com mais de 81cm
            </Typography>
          </Box>
        );
      case '623020c3-91c4-4b1e-86c7-50514a616333':
        return (
          <Box display="flex">
            <Accessible color="primary" />
            <Typography>
              &nbsp;
              Entrada sem degraus
            </Typography>
          </Box>
        );

      default:
        throw new Error('Id inválido');
    }
  };

  return (
    <div>
      {getAcessibilidade()}
    </div>
  );
}
