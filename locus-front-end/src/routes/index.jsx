import React from 'react';
import {
  createBrowserRouter, Route, createRoutesFromElements,
} from 'react-router-dom';

import PrivateRoutes from './PrivateRoutes';
import LoginPage from '../pages/Login';
import Menu from '../pages/Menu';
import ListaEspacos from '../pages/Espacos/ListaEspacos';
import PaginaEspaco from '../pages/Espacos/PaginaEspaco';

const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route element={<PrivateRoutes />}>
        <Route element={<Menu />} path="/menu" />
        <Route element={<ListaEspacos />} path="/espacos" />
        <Route element={<PaginaEspaco />} exact path="/espacos/:id" />
        {/* <Route element={<MenuPedidos />} path="/pedidos" />
        <Route element={<ListaPedidos />} path="/pedidos/lista" />
        <Route element={<ListaProdutos />} path="/produtos" />
        <Route element={<ListaClientes />} path="/clientes" />
        <Route element={<ListaFuncionarios />} path="/funcionarios" /> */}
      </Route>
      <Route
        element={<LoginPage />}
        path="/"
      />
    </>,
  ),
);

export default router;
