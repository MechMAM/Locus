import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

type RegisterScreenProps = NativeStackScreenProps<RootStack, "Register">;

export function Register(props: RegisterScreenProps) {
  const [email, setEmail] = useState('')
  const [user, setUser] = useState('')
  const [password, setPassword] = useState<string>('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [isPasswordVisible, setIsPasswordVisible] = useState(false)
  const [isConfirmPasswordVisible, set] = useState(false)
  const [isRegistering, setIsRegistering] = useState(false)

  return (
    <View style={{ margin: 16 }}>
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
