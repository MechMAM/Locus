import React, { useContext, useEffect, useState } from 'react';
import {
  Box,
  Button, Card, CardActions, CardContent, CardMedia, Container, Divider, Grid, Typography,
} from '@mui/material';

import { useNavigate } from 'react-router-dom';
import imgEspacos from '../../assets/espacos.jpg';
import { AuthContext } from '../../context/AuthContext';
import axios from '../../config/axios';

export default function ListaEspacos() {
  const { accessToken } = useContext(AuthContext);

  const [espacos, setEspacos] = useState([]);

  const navigate = useNavigate();

  const getEspacos = async () => {
    try {
      const response = await axios.get('/api/space', { headers: { Authorization: `Bearer ${accessToken}` } });
      setEspacos(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getEspacos();
  }, []);

  return (
    <Container>
      <Grid container spacing={2} p={3} justifyContent="center">
        {espacos.map((espaco) => (
          <Grid item xs={4} md={4} lg={4} key={espaco.id}>
            <Card sx={{ maxWidth: 345 }}>
              <CardMedia
                sx={{ height: 140 }}
                image={imgEspacos}
                title="espacos"
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  {espaco.nome}
                </Typography>
                <Typography variant="body2" color="text.secondary" mb={1}>
                  {espaco.descricao}
                </Typography>
                <Divider />
                <Box display="flex" mt={1} mb={1}>
                  <Typography variant="body2" color="text.primary">
                    Capacidade de público: &nbsp;
                  </Typography>
                  <Typography variant="body2" color="text.primary">
                    {espaco.capacidade}
                  </Typography>
                </Box>
                <Divider />
                <Box display="flex" mt={1} mb={1}>
                  <Typography variant="body2" color="text.primary">
                    Valor horário de locação: &nbsp;
                  </Typography>
                  <Typography variant="body2" color="text.primary">
                    {espaco.precoHorario}
                  </Typography>
                </Box>
                {espaco.hasTaxaLimpeza ? (
                  <Box display="flex" mt={1} mb={1}>
                    <Typography variant="body2" color="text.primary">
                      Valor taxa de limpeza: &nbsp;
                    </Typography>
                    <Typography variant="body2" color="text.primary">
                      {espaco.taxaLimpeza}
                    </Typography>
                  </Box>

                ) : (
                  <Typography variant="body2" color="text.primary">
                    Não há taxa de Limpeza
                  </Typography>
                )}
              </CardContent>
              <CardActions>
                {/* <Button size="small">Share</Button> */}
                <Button size="small" onClick={() => navigate(`/espacos/${espaco.id}`)}>Saiba Mais</Button>
              </CardActions>
            </Card>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
}
