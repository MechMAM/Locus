import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import * as SecureStore from 'expo-secure-store';
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

import axios from "../../config/axios";

type RegistroUsuarioScreenProps = NativeStackScreenProps<RootStack, "RegistroUsuario">;

export function RegistroUsuario(props: RegistroUsuarioScreenProps) {
  const [username, setUsername] = useState('')
  const [email, setEmail] = useState('')
  const [role, setRole] = useState('')
  const [password, setPassword] = useState<string>('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [isPasswordVisible, setIsPasswordVisible] = useState(false)
  const [isConfirmPasswordVisible, set] = useState(false)
  const [isRegistering, setIsRegistering] = useState(false)

  const handleSubmit = async () => {
    const accessToken = await SecureStore.getItemAsync('userToken');
    try {
      await axios.post('/api/auth/signup', {
        username,
        email,
        role,
        password
      }, {
        headers: { Authorization: `Bearer ${accessToken}` }
      });
      props.navigation.push('Home');
    } catch (error) {
      setErro(error.response.data.message);
    }
  }

  return (
    <View style={{ margin: 16 }}>
      <TextInput
        style={{ marginTop: 16 }}
        label={'Usuário'}
        value={username}
        onChangeText={setUsername}
        placeholder='Informe o nome do usuário' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Email'}
        value={email}
        onChangeText={setEmail}
        placeholder='Informe o e-mail do usuário' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Papel'}
        value={role}
        onChangeText={setRole}
        placeholder='Informe o papel do usuário' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Senha'}
        value={password}
        secureTextEntry={!isPasswordVisible}
        onChangeText={setPassword}
        placeholder='Informe a senha do usuário' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Confirmar a Senha'}
        value={confirmPassword}
        secureTextEntry={!isConfirmPasswordVisible}
        onChangeText={setConfirmPassword}
        placeholder='Informe a senha do usuário novamente' />

      <Button
        style={{ marginTop: 16 }}
        mode='contained'
        onPress={() => {
          console.log('Usuário criado com sucesso')
          // navigation.navigate('Home')
        }}>Criar conta e Acessar</Button>

      <Button
        style={{ marginTop: 16 }}
        onPress={() => setIsRegistering(false)}>Cancelar</Button>
    </View>
  )
}
