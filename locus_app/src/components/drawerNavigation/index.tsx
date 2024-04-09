import * as React from "react";
import { View } from "react-native";
import { Card, Text, Drawer } from "react-native-paper";

export const MenuNavigation = () => {
  const [active, setActive] = React.useState('');
  return (
    <View>
      <Card>
        <Text>
          Olá mundo!
        </Text>
      </Card>
      <Drawer.Section title="Menu">
        <Drawer.Item
          label="Home"
          active={active === 'home'}
          onPress={() => setActive('home')}
        />
        <Drawer.Item
          label="Reservas"
          active={active === 'reserva'}
          onPress={() => setActive('reserva')}
        />
        <Drawer.Item
          label="Apartamentos"
          active={active === 'apartamento'}
          onPress={() => setActive('apartamento')}
        />
      </Drawer.Section>
    </View>
  )
}



