import React, {useEffect, useState} from 'react'
import { Dimensions, StyleSheet, View } from 'react-native'
import { Button, Card, Text, TextInput } from 'react-native-paper'
import api from '../../config/axios'
import { NativeStackScreenProps } from '@react-navigation/native-stack'
import { RootStack } from '../../../App'

type LoginScreenProps = NativeStackScreenProps<RootStack, "Login">;

export const Login = (props : LoginScreenProps) => {

  const [showLoading, setShowLoading] = useState(false)
  const [displayName, setDisplayName] = useState('')
  const [user, setUser] = useState('')
  const [password, setPassword] = useState<string>('')
  const [isPasswordVisible, setIsPasswordVisible] = useState(false)
  const [isRegistering, setIsRegistering] = useState(false)
  const [accessToken, setAccessToken] = useState('')

  const [openDialog, setOpenDialog] = useState(false)
  const [dialogTitle, setDialogTitle] = useState('')
  const [dialogDescription, setDialogDescription] = useState('')

  // useEffect(() => {
  //   // return firebaseauth.onAuthStateChanged(onAuthStateChanged) // faz o unsibcribe dos metodos quando desmonta o componente
  //   setIsRegistering(false)
  // }, [])

  /*
  // Verifica o estado da autenticação do usuário
  const onAuthStateChanged = async (user: any) => {
    const firebaseUser = user

    if (user) {
      // Aqui é feito os demais tratamentos com as informações do usuário
      // Navigation.navigate('Home')
    }

    setShowLoading(false) hiruzen 123456
  }
  */

  const handleLogin = async () => {
    try {
      const response = await api
        .post('/api/auth/signin',
        {
          username: user,
          password,
        })
      setAccessToken(response.data.accessToken);
        // .then((response) => {
        //   setAccessToken(response.data.accessToken);
        // })
        // .catch((e) => console.error(e))
    } catch (error) {
      console.log(error);
    }
    // api
    // .post('/api/auth/signin',{
    //   username: user,
    //   password,
    // })
    // .then((response) => {
    //   setAccessToken(response.data.accessToken);
    //   console.log(response.data.accessToken);
    //   // setUserId(response.data.id);
    //   setEmail(response.data.email);
    //   // setIsLogged(true);
    //   // setErro('');
    //   // navigate('/menu');
    // })
    // .catch((error) => {
    //   console.log(error.error);
    //   // setErro(error.response.data.message);
    // });
  }

    return (
      <View style={{margin: 16}}>
        <TextInput
          style={{ marginTop: 16 }}
          label={'Usuário'}
          value={user}
          onChangeText={setUser}
          placeholder='Insira seu usuário' />


        <TextInput
          style={{ marginTop: 16 }}
          label={'Senha'}
          value={password}
          secureTextEntry={!isPasswordVisible}
          onChangeText={setPassword}
          placeholder='******' />

          <Button 
            style={{ marginTop: 16 }}
            mode='contained'
            onPress={async () => {
            console.log('Fazendo acesso');
            await handleLogin();
            console.log(`Usuário: ${user}, senha: ${password} e token de acesso ${accessToken}`);
            // navigation.navigate('Home')
          }}>Acessar</Button>
          
          <Button 
            style={{ marginTop: 16 }}
            onPress={() => props.navigation.push('Register')}
          >
            'Criar Conta'
          </Button>

        <TextInput
          style={{ marginTop: 16 }}
          label={'Token'}
          value={accessToken}
          placeholder='Este é o token' />
      </View>
    )
  }
