/* eslint-disable react/prop-types */
import React from 'react';
import {
  BusinessCenter, Groups, HolidayVillage, School, SpatialAudio, TheaterComedy, VideoCameraBack,
} from '@mui/icons-material';
import { Box, Typography } from '@mui/material';

export default function Propositos(props) {
  const { id } = props;

  const getProposito = () => {
    switch (id) {
      case '12e15420-aa66-4a05-a12b-a0c327617604':
        return (
          <Box display="flex">
            <School color="success" />
            <Typography>
              &nbsp;
              Colações de Grau
            </Typography>
          </Box>
        );
      case '4395af86-adf2-4981-88c0-707f263084f5':
        return (
          <Box display="flex">
            <BusinessCenter color="success" />
            <Typography>
              &nbsp;
              Eventos Empresariais
            </Typography>
          </Box>
        );
      case '396d18a8-4fa2-4628-9933-e25baa2b2edb':
        return (
          <Box display="flex">
            <SpatialAudio color="success" />
            <Typography>
              &nbsp;
              Recitais
            </Typography>
          </Box>
        );
      case 'b07a727e-048d-408e-b339-1246ae20304a':
        return (
          <Box display="flex">
            <HolidayVillage color="success" />
            <Typography>
              &nbsp;
              Convenções
            </Typography>
          </Box>
        );
      case '24416651-334d-44d3-a875-245d19a2e0a5':
        return (
          <Box display="flex">
            <Groups color="success" />
            <Typography>
              &nbsp;
              Peças Teatrais
            </Typography>
          </Box>
        );
      case '4e127215-0d0f-48cc-81e7-31783d0a0129':
        return (
          <Box display="flex">
            <TheaterComedy color="success" />
            <Typography>
              &nbsp;
              Seminários
            </Typography>
          </Box>
        );
      case '74346f81-3da1-470f-a2ac-44f38a5efa9a':
        return (
          <Box display="flex">
            <VideoCameraBack color="success" />
            <Typography>
              &nbsp;
              Palestras
            </Typography>
          </Box>
        );

      default:
        throw new Error('Id inválido');
    }
  };

  return (
    <div>
      {getProposito()}
    </div>
  );
}
