import { useReducer, useEffect, useMemo, createContext, Dispatch } from 'react';
import * as SecureStore from 'expo-secure-store';

import { PaperProvider } from 'react-native-paper';
import { SafeAreaView } from 'react-native-safe-area-context';
import { MenuNavigation } from './src/components/drawerNavigation';
import MenuBottomNavigation from './src/components/bottomNavigation';
import { NavigationContainer, useNavigation } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { View } from 'react-native';
import { red100 } from 'react-native-paper/lib/typescript/styles/themes/v2/colors';


import { Login } from './src/pages/login';
import { Register } from './src/pages/register';
import { Endereco } from './src/pages/endereco';
import { RegistroUsuario } from './src/pages/cadastro_usuario';
import { Espaco } from './src/pages/espaco';
import { Home } from './src/pages/home';

import api from './src/config/axios';
import { State } from 'react-native-paper/lib/typescript/components/TextInput/types';
// import { state, dispatch } from './src/config/Authentication';
// import { authContext, AuthContext } from './src/config/Authentication';

export const AuthContext = createContext({});


export type RootStack = {
  Login: undefined;
  Register: undefined;
  Endereco: undefined;
  Empresa: undefined;
  TipoEspaco: undefined;
  Acessibilidade: undefined;
  Diferencial: undefined;
  Servico: undefined;
  Proposito: undefined;
  Espaco: undefined;
  RegistroUsuario: undefined;
  Home: undefined;
}

const Stack = createNativeStackNavigator<RootStack>();

export default function App() {
  const [state, dispatch] = useReducer(
    (prevState, action) => {
      switch (action.type) {
        case 'RESTORE_TOKEN':
          return {
            ...prevState,
            userToken: action.token,
            isLoading: false,
          };
        case 'SIGN_IN':
          return {
            ...prevState,
            isSignout: false,
            userToken: action.token,
          };
        case 'SIGN_OUT':
          return {
            ...prevState,
            isSignout: true,
            userToken: null,
          };
      }
    },
    {
      isLoading: true,
      isSignout: false,
      userToken: null,
    }
  );

  useEffect(() => {
    // Fetch the token from storage then navigate to our appropriate place
    const bootstrapAsync = async () => {
      let userToken;

      try {
        userToken = await SecureStore.getItemAsync('userToken');
      } catch (e) {
        // Restoring token failed
      }

      // After restoring token, we may need to validate it in production apps

      // This will switch to the App screen or Auth screen and this loading
      // screen will be unmounted and thrown away.
      dispatch({ type: 'RESTORE_TOKEN', token: userToken });
    };

    bootstrapAsync();
  }, []);

  const authContext = useMemo(
    () => ({
      signIn: async (username, password) => {
        let accessToken = '';
        try {
          console.log(username, password);
          const response = await api
            .post('/api/auth/signin',
              {
                username,
                password,
              })
          console.log(response, username, password);
          accessToken = response.data.accessToken;
          console.log({ accessToken });
          await SecureStore.setItemAsync('userToken', accessToken);
          dispatch({ type: 'SIGN_IN', token: accessToken });
        } catch (error) {
          console.log({ error });
        }
        // In a production app, we need to send some data (usually username, password) to server and get a token
        // We will also need to handle errors if sign in failed
        // After getting token, we need to persist the token using `SecureStore`
        // In the example, we'll use a dummy token

      },
      signOut: () => dispatch({ type: 'SIGN_OUT' }),
      signUp: async (data) => {
        // In a production app, we need to send user data to server and get a token
        // We will also need to handle errors if sign up failed
        // After getting token, we need to persist the token using `SecureStore`
        // In the example, we'll use a dummy token

        dispatch({ type: 'SIGN_IN', token: 'dummy-auth-token' });
      },
    }),
    []
  );

  return (
    <PaperProvider>
      <AuthContext.Provider value={authContext}>
        <NavigationContainer>
          <Stack.Navigator>
            {state.userToken === null ? (
              <>
                <Stack.Screen
                  name='Login'
                  component={Login}
                  options={{ title: 'Plataforma Locus' }}
                />
                <Stack.Screen
                  name='Register'
                  component={Register}
                  options={{ title: 'Locus - Registre-se' }}
                />
              </>
            ) : (
              <>
                <Stack.Screen
                  name='Home'
                  component={Home}
                  options={{ title: 'Plataforma Locus' }}
                />
                <Stack.Screen
                  name='Endereco'
                  component={Endereco}
                  options={{ title: 'Cadastro de Endereço' }}
                />
                <Stack.Screen
                  name='RegistroUsuario'
                  component={RegistroUsuario}
                  options={{ title: 'Cadastro de Usuário' }}
                />
                <Stack.Screen
                  name='Espaco'
                  component={Espaco}
                  options={{ title: 'Cadastro de Espaço' }}
                />
              </>
            )}
          </Stack.Navigator>
        </NavigationContainer>
      </AuthContext.Provider>
    </PaperProvider>
  );
}
