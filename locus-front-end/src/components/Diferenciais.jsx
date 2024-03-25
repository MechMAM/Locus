/* eslint-disable react/prop-types */
import React from 'react';
import { BabyChangingStation, ChildCare, FamilyRestroom } from '@mui/icons-material';
import { Box, Typography } from '@mui/material';

export default function Diferenciais(props) {
  const { id } = props;

  const getDiferencial = () => {
    switch (id) {
      case '81bb0c41-8d4b-414d-927b-674a3aaba1b9':
        return (
          <Box display="flex">
            <FamilyRestroom color="warning" />
            <Typography>
              &nbsp;
              Banheiro Família
            </Typography>
          </Box>
        );
      case '34de170f-b7af-4667-be69-946a1728e20f':
        return (
          <Box display="flex">
            <ChildCare color="warning" />
            <Typography>
              &nbsp;
              Espaço Kids
            </Typography>
          </Box>
        );
      case 'c9b26ca0-ff3e-43a2-b682-d1e82314d11b':
        return (
          <Box display="flex">
            <BabyChangingStation color="warning" />
            <Typography>
              &nbsp;
              Fraldário
            </Typography>
          </Box>
        );

      default:
        throw new Error('Id inválido');
    }
  };

  return (
    <div>
      {getDiferencial()}
    </div>
  );
}
