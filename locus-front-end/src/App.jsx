import React from 'react';
import { RouterProvider } from 'react-router-dom';

import { CssBaseline } from '@mui/material';
import router from './routes';

import Header from './components/Header';

function App() {
  return (
    <>
      <CssBaseline />
      <Header />
      <RouterProvider router={router} />
    </>
  );
}

export default App;
