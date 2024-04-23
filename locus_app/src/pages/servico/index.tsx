import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

type RegisterScreenProps = NativeStackScreenProps<RootStack, "Servico">;

export function Servico(props: RegisterScreenProps) {
    const [nome, setNome] = useState('')
    const [descricao, setDescricao] = useState('')

    return (
        <View style={{ margin: 16 }}>
            <TextInput
                style={{ marginTop: 16 }}
                label={'Nome'}
                value={nome}
                onChangeText={setNome}
                placeholder='Informe o nome do serviço' />

            <TextInput
                style={{ marginTop: 16 }}
                label={'Descrição'}
                value={descricao}
                onChangeText={setDescricao}
                placeholder='Insira a descrição do serviço' />

            <Button
                style={{ marginTop: 16 }}
                mode='contained'
                onPress={() => {
                    console.log('Serviço Criada')
                    // navigation.navigate('Home')
                }}>Criar Serviço</Button>
        </View>
    )
}