import {
  Box, Button, Card, CardActions, CardContent, Container, Grid, Typography,
} from '@mui/material';
import React from 'react';

import { useNavigate } from 'react-router-dom';

import espacos from '../assets/espacos.jpg';
import reservas from '../assets/reservas.jpg';

function Menu() {
  const navigate = useNavigate();

  return (

    <Container component="main" maxWidth="lg">
      <Grid container spacing={2} p={3} justifyContent="center">
        <Grid item xs={5} md={5} lg={5}>
          <Card>
            <CardContent>
              <Box
                height={350}
                display="block"
                alignItems="center"
                textAlign="center"
              >
                <Typography
                  variant="h6"
                  color="primary"
                  fontWeight="bold"
                  mb={3}
                >
                  Reservas
                </Typography>
                <img
                  src={reservas}
                  alt="pedido"
                  height="auto"
                  width="100%"
                />
                <Typography
                  variant="subtitle1"
                  fontWeight="bold"
                  mb={3}
                >
                  Gerenciamento de reservas
                </Typography>
              </Box>
            </CardContent>
            <Box display="flex" justifyContent="center">
              <CardActions>
                <Button variant="contained" onClick={() => navigate('/reservas')} sx={{ marginBottom: '15px' }}>
                  <Typography variant="button" gutterBottom>
                    Selecionar
                  </Typography>
                </Button>
              </CardActions>
            </Box>
          </Card>
        </Grid>

        <Grid item xs={5} md={5} lg={5}>
          <Card>
            <CardContent>
              <Box
                height={350}
                display="block"
                alignItems="center"
                textAlign="center"
              >
                <Typography
                  variant="h6"
                  color="primary"
                  fontWeight="bold"
                  mb={3}
                >
                  Espacos
                </Typography>
                <img
                  src={espacos}
                  alt="produto"
                  height="auto"
                  width="100%"
                />
                <Typography
                  variant="subtitle1"
                  fontWeight="bold"
                  mb={3}
                >
                  Gerenciamento de espaços
                </Typography>
              </Box>
            </CardContent>
            <Box display="flex" justifyContent="center">
              <CardActions>
                <Button variant="contained" onClick={() => navigate('/espacos')} sx={{ marginBottom: '15px' }}>
                  <Typography variant="button" gutterBottom>
                    Selecionar
                  </Typography>
                </Button>
              </CardActions>
            </Box>
          </Card>
        </Grid>

      </Grid>

    </Container>

  );
}

export default Menu;
