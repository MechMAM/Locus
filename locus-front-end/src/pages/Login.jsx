import React, { useContext, useState } from 'react';
import {
  Avatar,
  Button,
  TextField,
  Typography,
  Container,
  createTheme,
  ThemeProvider,
  Box,
} from '@mui/material';
import { LockOutlined } from '@mui/icons-material';
import { useNavigate } from 'react-router-dom';
import api from '../config/axios';
import { AuthContext } from '../context/AuthContext';

const defaultTheme = createTheme();

export default function Login() {
  const {
    setAccessToken, setIsLogged,
  } = useContext(AuthContext);
  const [usuario, setUsuario] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    api
      .post('/api/auth/signin', {
        username: usuario,
        password: senha,
      })
      .then((response) => {
        setAccessToken(response.data.accessToken);
        setIsLogged(true);
        setErro('');
        navigate('/menu');
      })
      .catch((error) => {
        // console.log(error);
        setErro(error.response.data.message);
      });
  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs">
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'primary.main' }}>
            <LockOutlined color="primary.light" />
          </Avatar>
          <Typography component="h1" variant="h5">
            Login
          </Typography>
          <Box
            component="form"
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}
          >
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Usuário"
              name="email"
              autoComplete="email"
              autoFocus
              value={usuario}
              onChange={(e) => setUsuario(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Senha"
              type="password"
              id="password"
              autoComplete="current-password"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              sx={{ mt: 3, mb: 2 }}
            >
              Entrar
            </Button>
          </Box>
        </Box>
        <p>{erro}</p>
      </Container>
    </ThemeProvider>
  );
}
