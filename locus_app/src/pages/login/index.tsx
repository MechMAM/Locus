import React, {useEffect, useState} from 'react'
import { Dimensions, StyleSheet, View } from 'react-native'
import { Button, Card, Text, TextInput } from 'react-native-paper'
import api from '../../config/axios'

export const Login = () => {

  const [showLoading, setShowLoading] = useState(false)
  const [displayName, setDisplayName] = useState('')
  const [email, setEmail] = useState('')
  const [user, setUser] = useState('')
  const [password, setPassword] = useState<string>('')
  const [isPasswordVisible, setIsPasswordVisible] = useState(false)
  const [confirmPassword, setConfirmPassword] = useState('')
  const [isConfirmPasswordVisible, setIsConfirmPasswordVisible] = useState(false)
  const [isRegistering, setIsRegistering] = useState(false)
  const [accessToken, setAccessToken] = useState('')

  const [openDialog, setOpenDialog] = useState(false)
  const [dialogTitle, setDialogTitle] = useState('')
  const [dialogDescription, setDialogDescription] = useState('')
  // const navigate = useNavigate();


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

  const LoginScreen = () => {
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
            console.log(user,password,accessToken);
            // navigation.navigate('Home')
          }}>Acessar</Button>
          
          <Button 
            style={{ marginTop: 16 }}
            onPress={() => setIsRegistering(true)}
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

  const RegisterAccountScreen = () => {
    return (
      <View style={{margin: 16}}>
        <TextInput
          style={{ marginTop: 16 }}
          label={'Usuário'}
          value={user}
          onChangeText={setUser}
          placeholder='Usuário' />

        <TextInput
          style={{ marginTop: 16 }}
          label={'Email'}
          value={email}
          onChangeText={setEmail}
          placeholder='Insira seu Email' />

        <TextInput
          style={{ marginTop: 16 }}
          label={'Senha'}
          value={password}
          secureTextEntry={!isPasswordVisible}
          onChangeText={setPassword}
          placeholder='******' />

        <TextInput
          style={{ marginTop: 16 }}
          label={'Confirme a Senha'}
          value={confirmPassword}
          secureTextEntry={!isConfirmPasswordVisible}
          onChangeText={setConfirmPassword}
          placeholder='******' />

        <Button 
          style={{ marginTop: 16 }}
          mode='contained'
          onPress={() => {
          console.log('Criando conta e fazendo acesso')
          // navigation.navigate('Home')
        }}>Criar conta e Acessar</Button>

        <Button 
          style={{ marginTop: 16 }}
          onPress={() => setIsRegistering(false)}>Cancelar</Button>
      </View>
    )
  }

  return (
      <View style={{
        flexGrow: 1,
        padding: 16,
        width: Dimensions.get('window').width
      }}>
          <Card>
              {
                !isRegistering
                  ? <LoginScreen />
                  : <RegisterAccountScreen />
              }
          </Card>
      </View>
  )
}
