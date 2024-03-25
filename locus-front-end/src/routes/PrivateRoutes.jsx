import React, { useContext } from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';

export default function PrivateRoutes() {
  const {
    isLogged,
  } = useContext(AuthContext);

  // const verificaToken = async () => {
  //   const novosDados = await verifyToken(accessToken, id, email);
  //   setAccessToken(novosDados.accessToken);
  //   setIsLogged(novosDados.isLogged);
  // };

  // useEffect(() => {
  //   verificaToken();
  // }, []);
  return (
    isLogged ? <Outlet /> : <Navigate to="/" />
  );
}
