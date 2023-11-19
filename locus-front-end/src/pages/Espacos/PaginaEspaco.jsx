import React, { useContext, useEffect, useState } from 'react';

import {
  Box,
  Button,
  Card,
  CardActions,
  CardContent,
  Container, Divider, Grid, TextField, Typography,
} from '@mui/material';
import { useParams } from 'react-router-dom';
import axios from '../../config/axios';
import { AuthContext } from '../../context/AuthContext';
import Diferenciais from '../../components/Diferenciais';
import Propositos from '../../components/Propositos';
import Acessibilidades from '../../components/Acessibilidades';

export default function PaginaEspaco() {
  const { id } = useParams();
  const { accessToken } = useContext(AuthContext);

  const [espaco, setEspaco] = useState('');
  const [dataInicio, setDataInicio] = useState('');
  const [dataFim, setDataFim] = useState('');
  const [horaInicio, setHoraInicio] = useState('');
  const [horaFim, setHoraFim] = useState('');
  const [valorReserva, setValorReserva] = useState(0);
  const [endereco, setEndereco] = useState(0);

  const [acessibilidades, setAcessibilidades] = useState([]);
  const [diferenciais, setDiferenciais] = useState([]);
  const [propositos, setPropositos] = useState([]);

  const getDados = async () => {
    try {
      const response = await axios.get(`/api/space/${id}`, { headers: { Authorization: `Bearer ${accessToken}` } });
      setEspaco(response.data);
      setEndereco(response.data.endereco);
      setAcessibilidades(response.data.acessibilidades);
      setDiferenciais(response.data.diferenciais);
      setPropositos(response.data.propositos);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getDados();
  }, []);

  useEffect(() => {
    if (dataInicio !== '' && dataFim !== '' && horaInicio !== '' && horaFim !== '') {
      const data1 = Date.parse(`${dataInicio}T${horaInicio}`);
      const data2 = Date.parse(`${dataFim}T${horaFim}`);
      const precoReserva = (
        ((data2 - data1) / (1000 * 60 * 60))
        * Number(espaco.precoHorario)
        + Number(espaco.taxaLimpeza));
      setValorReserva(precoReserva.toFixed(2));
    }
    // console.log(Intl.DateTimeFormat().resolvedOptions().timeZone);
    // console.log(new Date(Date.parse(`${dataInicio}T${horaInicio}`)).toISOString());
  }, [dataInicio, dataFim, horaInicio, horaFim]);

  return (
    <Container>
      <Grid container spacing={2} p={2} justifyContent="center">
        <Grid item xs={12} md={12} lg={12}>
          <Typography variant="h5">
            {espaco.nome}
          </Typography>
          <Divider />
        </Grid>
        <Grid item xs={12} md={6} lg={6}>
          <Typography variant="h6">
            {espaco.descricao}
          </Typography>
          <Typography variant="body1">
            {espaco.descricaoArredores}
          </Typography>
          <Box mt={1} mb={1}>
            <Divider />
          </Box>
          <Typography variant="body1">
            {`Capacidade: ${espaco.capacidade} pessoas`}
          </Typography>
          <Typography variant="body1">
            {`Área: ${espaco.area} m²`}
          </Typography>
          <Typography variant="body1" color="text.primary" mt={1}>
            {`Valor horário de locação: R$ ${espaco.precoHorario}`}
          </Typography>
          {espaco.hasTaxaLimpeza ? (
            <Typography variant="body1" color="text.primary">
              {`Valor taxa de limpeza: R$ ${espaco.taxaLimpeza}`}
            </Typography>

          ) : (
            <Typography variant="body2" color="text.primary">
              Não há taxa de Limpeza
            </Typography>
          )}
          <Box mt={1} mb={1}>
            <Divider />
          </Box>
          <Typography variant="body1" color="text.primary" mt={1}>
            {`Endereco: Rua ${endereco.logradouro}, ${endereco.numero}, ${endereco.complemento}`}
          </Typography>
          <Typography variant="body1" color="text.primary">
            {`${endereco.cidade} - ${endereco.estado}`}
          </Typography>
          <Box mt={1} mb={1}>
            <Divider />
          </Box>
          <Typography variant="h6" color="text.primary">
            Diferenciais:
          </Typography>
          {diferenciais.map((diferencial) => (
            <Diferenciais id={diferencial.id} />
          ))}
          <Box mt={1} mb={1}>
            <Divider />
          </Box>
          <Typography variant="h6" color="text.primary">
            Finalidades do espaço:
          </Typography>
          {propositos.map((proposito) => (
            <Propositos id={proposito.id} />
          ))}
          <Box mt={1} mb={1}>
            <Divider />
          </Box>
          <Typography variant="h6" color="text.primary">
            Diferenciais:
          </Typography>
          {acessibilidades.map((acessibilidade) => (
            <Acessibilidades id={acessibilidade.id} />
          ))}
        </Grid>
        <Grid item xs={12} md={6} lg={6}>
          <Card>
            <CardContent>
              <Typography color="text.primary" gutterBottom variant="h6">
                Faça sua reserva
              </Typography>
              <Grid container spacing={2}>
                <Grid item xs={6} md={6} lg={6}>

                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    type="date"
                    id="dataInicio"
                    label="Data de Início da reserva"
                    autoFocus
                    value={dataInicio}
                    onChange={(e) => setDataInicio(e.target.value)}
                    InputLabelProps={{ shrink: true }}
                    inputProps={{ min: new Date().toLocaleDateString('en-ca') }}
                  />
                </Grid>
                <Grid item xs={6} md={6} lg={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    type="time"
                    id="horaInicio"
                    label="Hora inicial"
                    value={horaInicio}
                    InputLabelProps={{ shrink: true }}
                    onChange={(e) => setHoraInicio(e.target.value)}
                  />
                </Grid>
                <Grid item xs={6} md={6} lg={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    type="date"
                    id="dataFim"
                    label="Data fim da reserva"
                    value={dataFim}
                    onChange={(e) => setDataFim(e.target.value)}
                    InputLabelProps={{ shrink: true }}
                    inputProps={{ min: new Date().toLocaleDateString('en-ca') }}
                  />
                </Grid>
                <Grid item xs={6} md={6} lg={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    type="time"
                    id="horaFim"
                    label="Hora final"
                    value={horaFim}
                    InputLabelProps={{ shrink: true }}
                    onChange={(e) => setHoraFim(e.target.value)}
                  />
                </Grid>
              </Grid>
              <Divider />
              <Typography variant="body2" mt={1}>
                {`Para este período o custo da reserva será de R$ ${valorReserva}`}
              </Typography>
            </CardContent>
            <Box display="flex" justifyContent="end" m={1}>
              <CardActions>
                <Button variant="contained" color="success">Reservar</Button>
              </CardActions>
            </Box>
          </Card>
        </Grid>

      </Grid>
    </Container>
  );
}
