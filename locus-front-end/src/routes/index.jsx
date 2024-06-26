import React from 'react';
import {
  createBrowserRouter, Route, createRoutesFromElements,
} from 'react-router-dom';

import PrivateRoutes from './PrivateRoutes';
import LoginPage from '../pages/Login';
import Menu from '../pages/Menu';
import ListaEspacos from '../pages/Espacos/ListaEspacos';
import PaginaEspaco from '../pages/Espacos/PaginaEspaco';
import ListaReservas from '../pages/Reservas/ListaReservas';

const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route
        element={<LoginPage />}
        index
      />
      <Route element={<PrivateRoutes />}>
        <Route element={<Menu />} path="/menu" />
        <Route element={<ListaEspacos />} path="/espacos" />
        <Route element={<PaginaEspaco />} path="/espacos/:id" />
        <Route element={<ListaReservas />} path="/reservas" />
        {/* <Route element={<MenuPedidos />} path="/pedidos" />
        <Route element={<ListaPedidos />} path="/pedidos/lista" />
        <Route element={<ListaProdutos />} path="/produtos" />
        <Route element={<ListaClientes />} path="/clientes" />
        <Route element={<ListaFuncionarios />} path="/funcionarios" /> */}
      </Route>
    </>,
  ),
);

export default router;
