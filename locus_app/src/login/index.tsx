import React, {useEffect, useState} from 'react'
import { Dimensions, StyleSheet, View } from 'react-native'
import { Button, Card, Text, TextInput } from 'react-native-paper'

export const Login = () => {

  const [showLoading, setShowLoading] = useState(false)
  const [displayName, setDisplayName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState<string>('')
  const [isPasswordVisible, setIsPasswordVisible] = useState(false)
  const [confirmPassword, setConfirmPassword] = useState('')
  const [isConfirmPasswordVisible, setIsConfirmPasswordVisible] = useState(false)
  const [isRegistering, setIsRegistering] = useState(false)

  const [openDialog, setOpenDialog] = useState(false)
  const [dialogTitle, setDialogTitle] = useState('')
  const [dialogDescription, setDialogDescription] = useState('')


  useEffect(() => {
    // return firebaseauth.onAuthStateChanged(onAuthStateChanged) // faz o unsibcribe dos metodos quando desmonta o componente
    setIsRegistering(false)
  }, [])

  /*
  // Verifica o estado da autenticação do usuário
  const onAuthStateChanged = async (user: any) => {
    const firebaseUser = user

    if (user) {
      // Aqui é feito os demais tratamentos com as informações do usuário
      // Navigation.navigate('Home')
    }

    setShowLoading(false)
  }
  */

  const LoginScreen = () => {
    return (
      <View style={{margin: 16}}>
        <TextInput
          style={{ marginTop: 16 }}
          label={'nome'}
          value={displayName}
          onChangeText={setDisplayName}
          placeholder='Nome de usuário' />


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
            onPress={() => {
            console.log('Fazendo acesso')
            // navigation.navigate('Home')
          }}>Acessar</Button>
          
          <Button 
            style={{ marginTop: 16 }}
            onPress={() => setIsRegistering(true)}>Criar Conta</Button>
      </View>
    )
  }

  const RegisterAccountScreen = () => {
    return (
      <View style={{margin: 16}}>
        <TextInput
          style={{ marginTop: 16 }}
          label={'nome'}
          value={displayName}
          onChangeText={setDisplayName}
          placeholder='Nome de usuário' />

        <TextInput
          style={{ marginTop: 16 }}
          label={'Email'}
          value={email}
          onChangeText={setEmail}
          placeholder='email@dominio.com' />

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
