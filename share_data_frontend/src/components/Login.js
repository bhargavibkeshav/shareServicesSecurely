import React, { useEffect, useState } from "react";
import LoginService from "../services/LoginService";
import { useNavigate } from "react-router-dom";
import HeaderBar from "./HeaderBar";
import PrivateRoutes from "../utility/PrivateRoutes";

const Login = () => {
  const [user, setLogin] = useState({
    username:"",
    psword:""

  });
  let navigate = useNavigate(); 
  const routeChange = () =>{ 
    let path = `/Login/UserHomePage`; 
    navigate(path);
  }
  const handleChange = (e) =>{
    const value = e.target.value;
    setLogin({...user,[e.target.name]:value})
  };
  const saveUser = (e) =>{
    e.preventDefault();
    LoginService.saveUser(user)
    .then((response)=>{
      /*if(response.data=='success')
      {
        console.log(response);
       routeChange();
        
      }
      else if(response.data=='fail')
      {
        alert('invalid creadentials')
      }*/
      if(response.data=='success')
      {
        routeChange();
      }
      else 
      {
        PrivateRoutes();
      }
    })
    .catch((error)=>{
      console.log(error);
    });
  };
    return(
        <>
        <div className='flex  max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
        <div className='font-medium'>
          <h1>Login</h1>
        </div>
        <div className='font-thin items-center justify-center h-14 w-full my-3'>
          <label>
            Username
          </label>
          <input 
          name = "username"
          value = {user.username}
          onChange = {(e)=>handleChange(e)}
          className='mx-3 font-mono'type="text"/>
          </div>
          <div className='font-thin items-center justify-center h-14 w-full my-3'>
          <label>
            Password
          </label>
          <input 
          name = "psword"
          value = {user.psword}
          onChange = {(e)=>handleChange(e)}
          className='mx-14 font-mono border-b'type="password"/>
          </div>
          <button onClick={saveUser}
          className='rounded text-yellow-50 font-extrabold bg-green-900 px-5 hover:text-black px-8'>
            Login
          </button>
          </div>
          </div>
        </>
    )
}

export default Login