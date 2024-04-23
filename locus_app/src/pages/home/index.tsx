import { View } from "react-native";
import { Card, Text, Button, MD3Colors } from "react-native-paper";
import { NativeStackScreenProps } from "@react-navigation/native-stack";
import { RootStack } from "../../../App";

type HomeScreenProps = NativeStackScreenProps<RootStack, "Home">;

export function Home(props: HomeScreenProps) {
  return (
    <View>
      <Card style={{ padding: 8 }}>
        <Text variant="titleMedium">
          Menu
        </Text>
        <Button
          style={{ marginTop: 16 }}
          icon="map-marker-plus-outline"
          // buttonColor={MD3Colors.primary30}
          mode="contained"
          onPress={() => { props.navigation.push('Endereco') }}
          contentStyle={{ flexDirection: "row-reverse" }}
        >
          Cadastrar endereço
        </Button>
        <Button
          style={{ marginTop: 16 }}
          icon="account-plus-outline"
          // buttonColor={MD3Colors.primary30}
          mode="contained"
          onPress={() => { props.navigation.push('RegistroUsuario') }}
          contentStyle={{ flexDirection: "row-reverse" }}
        >
          Cadastrar usuário
        </Button>
        <Button
          style={{ marginTop: 16 }}
          icon="domain-plus"
          // buttonColor={MD3Colors.primary30}
          mode="contained"
          onPress={() => { props.navigation.push('Espaco') }}
          contentStyle={{ flexDirection: "row-reverse" }}
        >
          Cadastrar espaço
        </Button>
        <Button
          style={{ marginTop: 16 }}
          icon="home-group-plus"
          // buttonColor={MD3Colors.primary30}
          mode="contained"
          onPress={() => { props.navigation.push('Endereco') }}
          contentStyle={{ flexDirection: "row-reverse" }}
        >
          Cadastrar empresa
        </Button>
      </Card>
    </View>
  )
}
