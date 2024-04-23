import React, {useContext, useEffect, useState} from 'react'
import { Dimensions, StyleSheet, View } from 'react-native'
import { Button, Card, Text, TextInput } from 'react-native-paper'
import api from '../../config/axios'
import { NativeStackScreenProps } from '@react-navigation/native-stack'
import { RootStack } from '../../../App';
import { AuthContext } from '../../../App'

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

  const { signIn }= useContext(AuthContext);

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
            signIn({user, password})
            // await handleLogin();
          }}>Acessar</Button>

          <Button
            style={{ marginTop: 16 }}
            onPress={() => {props.navigation.push('RegistroUsuario')}}
          >
            'Criar Conta'
          </Button>
      </View>
    )
  }
