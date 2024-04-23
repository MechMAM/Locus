import { View } from "react-native"
import { TextInput, Button } from "react-native-paper"
import { useState } from "react"
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

type RegisterScreenProps = NativeStackScreenProps<RootStack, "Empresa">;

export function Empresa(props: RegisterScreenProps) {
    const [nome, setNome] = useState('')
    const [cnpj, setCNPJ] = useState('')
    const [email, setEmail] = useState("")
    const [razaoSocial, setRazaoSocial] = useState('')

    return (
        <View style={{ margin: 16 }}>
            <TextInput
                style={{ marginTop: 16 }}
                label={'Nome'}
                value={nome}
                onChangeText={setNome}
                placeholder='Informe o nome da empresa' />

            <TextInput
                style={{ marginTop: 16 }}
                label={'CNPJ'}
                value={cnpj}
                onChangeText={setCNPJ}
                placeholder='Insira o CNPJ da empresa' />

            <TextInput
                style={{ marginTop: 16 }}
                label={'E-mail'}
                value={email}
                onChangeText={setEmail}
                placeholder='Informe o e-mail da empresa' />

            <TextInput
                style={{ marginTop: 16 }}
                label={'Razão Social'}
                value={razaoSocial}
                onChangeText={setRazaoSocial}
                placeholder='Informe a Razão Social da empresa' />

            <Button
                style={{ marginTop: 16 }}
                mode='contained'
                onPress={() => {
                    console.log('Empresa Criada')
                    // navigation.navigate('Home')
                }}>Criar Empresa</Button>
        </View>
    )
}