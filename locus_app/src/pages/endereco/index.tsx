import { View } from "react-native";
import { TextInput, Button } from "react-native-paper";
import { useState } from "react";
import * as SecureStore from 'expo-secure-store';
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

import axios from "../../config/axios";

type EnderecoScreenProps = NativeStackScreenProps<RootStack, "Endereco">;

export function Endereco(props: EnderecoScreenProps) {
  const [bairro, setBairro] = useState('');
  const [logradouro, setLogradouro] = useState('');
  const [numero, setNumero] = useState('');
  const [complemento, setComplemento] = useState('');
  const [cidade, setCidade] = useState('');
  const [estado, setEstado] = useState('');
  const [pais, setPais] = useState('');
  const [cep, setCep] = useState('');
  const [erro, setErro] = useState('');

  const handleSubmit = async () => {
    const accessToken = await SecureStore.getItemAsync('userToken');
    try {
      await axios.post('/api/address', {
        bairro,
        logradouro,
        complemento,
        cidade,
        estado,
        pais,
        cep,
        numero
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
        label={'Bairro'}
        value={bairro}
        onChangeText={setBairro}
        placeholder='Informe o Bairro' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Logradouro'}
        value={logradouro}
        onChangeText={setLogradouro}
        placeholder='Insira o Logradouro' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Número'}
        value={numero}
        onChangeText={setNumero}
        placeholder='Informe o número' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Complemento'}
        value={complemento}
        onChangeText={setComplemento}
        placeholder='Informe o Complemento' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Cidade'}
        value={cidade}
        onChangeText={setCidade}
        placeholder='Informe a Cidade' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Estado'}
        value={estado}
        onChangeText={setEstado}
        placeholder='Informe o Estado' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'País'}
        value={pais}
        onChangeText={setPais}
        placeholder='Informe o País' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'CEP'}
        value={cep}
        onChangeText={setCep}
        placeholder='Informe o CEP' />

      <Button
        style={{ marginTop: 16 }}
        mode='contained'
        onPress={async () => { await handleSubmit(); }}>Cadastrar Endereço</Button>
      <TextInput
        style={{ marginTop: 16 }}
        value={erro}
      />
    </View>
  )
}
