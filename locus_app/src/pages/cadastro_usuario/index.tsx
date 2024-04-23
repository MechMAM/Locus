import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

type CadastroUsuarioScreenProps = NativeStackScreenProps<RootStack, "CadastroUsuario">;

export function RegistroUsuario(props: CadastroUsuarioScreenProps) {
  const [usuario, setUsuario] = useState('')
  const [email, setEmail] = useState('')
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
        value={usuario}
        onChangeText={setUsuario}
        placeholder='Informe o nome do usuário' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Email'}
        value={email}
        onChangeText={setEmail}
        placeholder='Informe o e-mail do usuário' />

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
