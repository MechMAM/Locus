import { PaperProvider } from 'react-native-paper';
import { SafeAreaView } from 'react-native-safe-area-context';

// import { Home } from './src/pages/home';
import { Login } from './src/pages/login';
import { MenuNavigation } from './src/components/drawerNavigation';
import MenuBottomNavigation from './src/components/bottomNavigation';
import { NavigationContainer, useNavigation } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { View } from 'react-native';
import { red100 } from 'react-native-paper/lib/typescript/styles/themes/v2/colors';
import { Register } from './src/pages/register';

export type RootStack = {
  Login: undefined;
  Register: undefined;
}

const Stack = createNativeStackNavigator<RootStack>();

export default function App() {
  return (
    <PaperProvider>
        <NavigationContainer>
          <Stack.Navigator>
            <Stack.Screen name='Login' component={Login} />
            <Stack.Screen name='Register' component={Register}/>
          </Stack.Navigator>
        </NavigationContainer>
    </PaperProvider>
  );
}
