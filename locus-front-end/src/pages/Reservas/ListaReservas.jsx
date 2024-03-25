import React, { useContext, useEffect, useState } from 'react';

import {
  Box,
  Card, CardContent, Container, Divider, Grid, Typography,
} from '@mui/material';

import { AttachMoney, EventNote, LocationOn } from '@mui/icons-material';
import { AuthContext } from '../../context/AuthContext';
import axios from '../../config/axios';

export default function ListaReservas() {
  const { accessToken } = useContext(AuthContext);
  const [reservas, setReservas] = useState([]);
  const [result, setResult] = useState([]);

  const getReservas = async () => {
    try {
      const response = await axios.get('/api/booking', { headers: { Authorization: `Bearer ${accessToken}` } });
      setResult(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getReservas();
  }, []);

  useEffect(() => {
    setReservas(result.sort((a, b) => (new Date(a.dataInicio) - new Date(b.dataInicio))));
  }, [result]);

  return (
    <Container>
      <Grid container spacing={3} p={3}>
        {reservas.map((reserva) => (
          <Grid item xs={12} md={12} lg={12} key={reserva.id}>
            <Card>
              <CardContent>
                <Typography color="text.primary" gutterBottom variant="h6" mb={2}>
                  {`Reserva para o espaço ${reserva.espaco.nome}`}
                </Typography>
                <Grid container spacing={2}>
                  <Grid item xs={6} md={6} lg={6}>
                    <Box display="flex">
                      <EventNote color="warning" />
                      &nbsp;
                      <Typography variant="body1">
                        {`Início da reserva ${new Date(reserva.dataInicio).toLocaleDateString('pt-BR')}`}
                        &nbsp;
                      </Typography>
                      <Typography variant="body1">
                        {` - Horário: ${new Date(reserva.dataInicio).toLocaleTimeString('pt-BR')}`}
                      </Typography>
                    </Box>
                  </Grid>
                  <Grid item xs={6} md={6} lg={6}>

                    <Box display="flex">
                      <EventNote color="warning" />
                      &nbsp;
                      <Typography variant="body1">
                        {`Fim da reserva ${new Date(reserva.dataFim).toLocaleDateString('pt-BR')}`}
                        &nbsp;
                      </Typography>
                      <Typography variant="body1">
                        {` - Horário: ${new Date(reserva.dataFim).toLocaleTimeString('pt-BR')}`}
                      </Typography>
                    </Box>
                  </Grid>
                  <Grid item xs={6} md={6} lg={6}>
                    <Box display="flex" alignItems="center">
                      <LocationOn color="primary" />
                      &nbsp;
                      <Box>
                        <Typography variant="body1" color="text.primary">
                          {`Endereco: Rua ${reserva.espaco.endereco.logradouro}, ${reserva.espaco.endereco.numero}, ${reserva.espaco.endereco.complemento}`}
                        </Typography>
                        <Typography variant="body1" color="text.primary">
                          {`${reserva.espaco.endereco.cidade} - ${reserva.espaco.endereco.estado}`}
                        </Typography>
                      </Box>
                    </Box>
                  </Grid>
                  <Grid item xs={6} md={6} lg={6}>
                    <Box display="flex">
                      <AttachMoney color="success" />
                      <Typography variant="body1" color="text.primary">
                        {`Valor da reserva: R$ ${Number(reserva.preco).toFixed(2)}`}
                      </Typography>

                    </Box>
                  </Grid>

                  <Grid item xs={12} md={12} lg={12}>
                    <Box mt={1} mb={1}>
                      <Divider />
                    </Box>
                    <Typography variant="body1">
                      {`Descrição do espaço: ${reserva.espaco.descricao}`}
                      &nbsp;
                    </Typography>
                  </Grid>
                </Grid>
                <Box mt={1} mb={1}>

                  <Divider />
                </Box>
              </CardContent>
              <Box display="flex" justifyContent="end" m={1}>
                {/* <CardActions>
                <Button
                variant="contained"
                color="success"
                onClick={inserirReserva}>
                Reservar
                </Button>
              </CardActions> */}
              </Box>
            </Card>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
}
