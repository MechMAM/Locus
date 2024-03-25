import { PaperProvider } from 'react-native-paper';
import { SafeAreaView } from 'react-native-safe-area-context';
import { Home } from './src/pages/home';

export default function App() {
  return (
    <PaperProvider>
      <SafeAreaView>
        <Home/>
      </SafeAreaView>
    </PaperProvider>
    

  );
}