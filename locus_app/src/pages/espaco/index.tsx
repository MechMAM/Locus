import { View } from "react-native"
import { TextInput, Button, RadioButton, Text, Checkbox } from "react-native-paper"
import { useState, useEffect } from "react"
import * as SecureStore from 'expo-secure-store';
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

import axios from "../../config/axios";

type RegisterScreenProps = NativeStackScreenProps<RootStack, "Espaco">;

export function Espaco(props: RegisterScreenProps) {
  const [nome, setNome] = useState('')
  const [descricao, setDescricao] = useState('')
  const [descricaoArredores, setDescricaoArredores] = useState("")
  const [capacidade, setCapacidade] = useState('')
  const [area, setArea] = useState('')
  const [tempoLimpeza, setTempoLimpeza] = useState('')
  const [hasTaxaLimpeza, setHasTaxaLimpeza] = useState('')
  const [taxaLimpeza, setTaxaLimpeza] = useState('')
  const [precoHorario, setPrecoHorario] = useState('')
  const [acessibidade, setAcessibilidade] = useState('')
  const [diferenciais, setDiferenciais] = useState('')
  const [propositos, setPropositos] = useState('')
  const [value, setValue] = useState('sim');

  const [options, setOptions] = useState([]);
  const [selectedValues, setSelectedValues] = useState('');

  const handleSubmit = async () => {
    const accessToken = await SecureStore.getItemAsync('userToken');
    try {
      await axios.post('/api/space', {
        nome,
        descricao,
        descricaoArredores,
        capacidade,
        area,
        tempoLimpeza,
        hasTaxaLimpeza,
        precoHorario,
        acessibidade,
        diferenciais,
        propositos
      }, {
        headers: { Authorization: `Bearer ${accessToken}` }
      });
      props.navigation.push('Home');
    } catch (error) {
      setErro(error.response.data.message);
    }
  }

  // useEffect(() => {
  //   async function fetchOptions() {
  //     const response = await fetch('https://sua-api.com/opcoes');
  //     const data = await response.json();
  //     setOptions(data);
  //   }
  //   fetchOptions();
  // }, []);

  return (
    <View style={{ margin: 16 }}>
      <TextInput
        style={{ marginTop: 16 }}
        label={'Nome'}
        value={nome}
        onChangeText={setNome}
        placeholder='Informe o nome do espaço' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Descrição'}
        value={descricao}
        onChangeText={setDescricao}
        placeholder='Insira a descrição do espaço' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Descrição dos Arredores'}
        value={descricaoArredores}
        onChangeText={setDescricaoArredores}
        placeholder='Informe a descrição dos arredores do espaço' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Capacidade'}
        value={capacidade}
        onChangeText={setCapacidade}
        placeholder='Informe a capacidade do espaço' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Área'}
        value={area}
        onChangeText={setArea}
        placeholder='Informe a área do espaço' />

      <View style={{ marginTop: 16, backgroundColor: 'primary' }}>
        <Text>Tem taxa de limpeza?</Text>
        <RadioButton.Group onValueChange={newValue => setValue(newValue)} value={value} >
          <View style={{ flexDirection: 'row' }}>
            <RadioButton.Item label="Sim" value="true" style={{ marginRight: 10 }} />
            <RadioButton.Item label="Nao" value="false" style={{ marginRight: 10 }} />
          </View>
        </RadioButton.Group>
      </View>

      {options.map((option) => (
        <Checkbox.Item
          key={option.id}
          label={option.label}
          status={selectedValues.includes(option.id) ? 'checked' : 'unchecked'}
          onPress={() => handleCheckboxPress(option.id)}
        />
      ))}

      <TextInput
        style={{ marginTop: 16 }}
        label={'Tempo de Limpeza'}
        value={tempoLimpeza}
        onChangeText={setTempoLimpeza}
        placeholder='Informe o tempo de limpeza do espaço' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Tem Taxa de Limpeza?'}
        value={hasTaxaLimpeza}
        onChangeText={setHasTaxaLimpeza}
        placeholder='RADIO BUTTON' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Valor da Limpeza'}
        value={taxaLimpeza}
        onChangeText={setTaxaLimpeza}
        placeholder='Informe o valor da taxa de limpeza do espaço' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Valor do Horário'}
        value={precoHorario}
        onChangeText={setPrecoHorario}
        placeholder='Informe o valor do horário' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Acessibilidade'}
        value={acessibidade}
        onChangeText={setAcessibilidade}
        placeholder='COMBOBOX' />

      <TextInput
        style={{ marginTop: 16 }}
        label={'Diferenciais'}
        value={diferenciais}
        onChangeText={setDiferenciais}
        placeholder='COMBOBOX' />


      <TextInput
        style={{ marginTop: 16 }}
        label={'Propositos'}
        value={propositos}
        onChangeText={setPropositos}
        placeholder='COMBOBOX' />


      <Button
        style={{ marginTop: 16 }}
        mode='contained'
        onPress={() => {
          console.log('Espaço Criado')
          // navigation.navigate('Home')
        }}>Criar Espaço</Button>
    </View>
  )
}
