import './App.css';
import HeaderBar from './components/HeaderBar';
import AddUser from './components/AddUser';
import Login from './components/Login';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import PrivateRoutes from './utility/PrivateRoutes';
import UserHomePage from './components/UserHomePage';
function App() {
  return (
    <>
  
  <div className="App">
  <HeaderBar/>
      <BrowserRouter>
      <Routes>
          <Route element = {<PrivateRoutes/>}>
            <Route element={<UserHomePage/>} path="/UserHomePage"/>
          </Route>
          <Route index element={<AddUser />} />
          <Route element={<AddUser/>} path="/AddUser"  />
          <Route element = {<Login/>} path="/Login" >
            </Route>
        </Routes>
      </BrowserRouter>
    </div>
  </>
  );
  
}

export default App;
