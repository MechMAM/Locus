import {
  createContext, useContext,
} from 'react';

export const AuthContext = createContext();

export function useAuthContext() {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('Fora do AuthProvider');
  }
  return context;
}

// export function AuthContextProvider({ children }) {
//   const [accessToken, setAccessToken] = useState('');
//   // const value = useMemo(
//   //   () => ({ accessToken, setAccessToken }),
//   //   [accessToken],
//   // );
//   // const accessToken = useMemo(() => ({ accessToken: '' }), []);

//   return (
//     <UserContext.Provider value={{ accessToken, setAccessToken }}>

// {children}
// </UserContext.Provider>
//   );
// }
