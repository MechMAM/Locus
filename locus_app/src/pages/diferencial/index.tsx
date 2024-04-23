import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

type RegisterScreenProps = NativeStackScreenProps<RootStack, "Diferencial">;

export function Diferencial(props: RegisterScreenProps) {
    const [nome, setNome] = useState('')
    const [descricao, setDescricao] = useState('')

    return (
        <View style={{ margin: 16 }}>
            <TextInput
                style={{ marginTop: 16 }}
                label={'Nome'}
                value={nome}
                onChangeText={setNome}
                placeholder='Informe o nome do diferencial' />

            <TextInput
                style={{ marginTop: 16 }}
                label={'Descrição'}
                value={descricao}
                onChangeText={setDescricao}
                placeholder='Insira a descrição do diferencial' />

            <Button
                style={{ marginTop: 16 }}
                mode='contained'
                onPress={() => {
                    console.log('Diferencial Criada')
                    // navigation.navigate('Home')
                }}>Criar Diferencial</Button>
        </View>
    )
}