/* eslint-disable react/prop-types */
/* eslint-disable react/jsx-no-constructed-context-values */
import React, { useState } from 'react';
import { AuthContext } from './AuthContext';

export default function AuthProvider({ children }) {
  const [accessToken, setAccessToken] = useState('');
  const [userId, setUserId] = useState('');
  const [email, setEmail] = useState('');
  const [isLogged, setIsLogged] = useState(false);
  return (
    <AuthContext.Provider value={{
      accessToken, setAccessToken, userId, setUserId, email, setEmail, isLogged, setIsLogged,
    }}
    >
      {children}
    </AuthContext.Provider>
  );
}
