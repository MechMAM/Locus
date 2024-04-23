import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

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