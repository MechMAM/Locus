import { PaperProvider } from 'react-native-paper';
import { SafeAreaView } from 'react-native-safe-area-context';

// import { Home } from './src/pages/home';
import { Login } from './src/pages/login';
import { MenuNavigation } from './src/components/drawerNavigation';
import MenuBottomNavigation from './src/components/bottomNavigation';


export default function App() {
  return (
    <PaperProvider>
      <SafeAreaView>
        <Login />
        <MenuBottomNavigation />
      </SafeAreaView>
    </PaperProvider>
  );
}