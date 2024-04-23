// import {
//   createContext, useReducer
// } from 'react';

// export const AuthContext = createContext();

// export const [state, dispatch] = useReducer(
//   (prevState, action) => {
//     switch (action.type) {
//       case 'RESTORE_TOKEN':
//         return {
//           ...prevState,
//           userToken: action.token,
//           isLoading: false,
//         };
//       case 'SIGN_IN':
//         return {
//           ...prevState,
//           isSignout: false,
//           userToken: action.token,
//         };
//       case 'SIGN_OUT':
//         return {
//           ...prevState,
//           isSignout: true,
//           userToken: null,
//         };
//     }
//   },
//   {
//     isLoading: true,
//     isSignout: false,
//     userToken: null,
//   }
// );

// export const authContext = useMemo(
//   () => ({
//     signIn: async (username, password) => {
//       let accessToken = '';
//       try {
//         const response = await api
//           .post('/api/auth/signin',
//             {
//               username,
//               password,
//             })
//         accessToken = response.data.accessToken;
//         await SecureStore.setItemAsync('userToken', accessToken);
//       } catch (error) {
//         console.log(error);
//       }
//       // In a production app, we need to send some data (usually username, password) to server and get a token
//       // We will also need to handle errors if sign in failed
//       // After getting token, we need to persist the token using `SecureStore`
//       // In the example, we'll use a dummy token

//       dispatch({ type: 'SIGN_IN', token: accessToken });
//     },
//     signOut: () => dispatch({ type: 'SIGN_OUT' }),
//     signUp: async (data) => {
//       // In a production app, we need to send user data to server and get a token
//       // We will also need to handle errors if sign up failed
//       // After getting token, we need to persist the token using `SecureStore`
//       // In the example, we'll use a dummy token

//       dispatch({ type: 'SIGN_IN', token: 'dummy-auth-token' });
//     },
//   }),
//   []
// );