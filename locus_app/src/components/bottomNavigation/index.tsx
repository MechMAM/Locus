import * as React from 'react';
import { useState } from 'react';
import { BottomNavigation, Text } from 'react-native-paper';
import { Home } from '../../pages/home';
import { Login } from '../../pages/login';

const HomeRoute = () => <Home />;

const LoginRoute = () => <Login />;

// const RecentsRoute = () => <Text>Recents</Text>;

// const NotificationsRoute = () => <Text>Notifications</Text>;

const MenuBottomNavigation = () => {

  const [index, setIndex] = useState(0);
  const [routes] = useState([
    { key: 'home', title: 'Home', focusedIcon: 'home' },
    { key: 'login', title: 'Login', focusedIcon: 'login' },
  ]);

  const renderScene = BottomNavigation.SceneMap({
    home: HomeRoute,
    login: LoginRoute,
    // recents: RecentsRoute,
    // notifications: NotificationsRoute,
  });

  return (
    <BottomNavigation
      navigationState={{ index, routes }}
      onIndexChange={setIndex}
      renderScene={renderScene}
    />
  );
};

export default MenuBottomNavigation;