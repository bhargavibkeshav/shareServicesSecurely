//import React from 'react'
import React, { useEffect, useState } from "react";
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import UserService from '../services/UserService';
import Login from "./Login";
const AddUser = () => {
  let navigate = useNavigate(); 
  const routeChange = () =>{ 
    let path = `./Login`; 
    navigate(path);
  }
  const [user, setUser] = useState({
    id : "",
    firstName:"",
    lastName:"",
    username:"",
    psword:"",
    email:""

  });
  const handleChange = (e) =>{
    const value = e.target.value;
    setUser({...user,[e.target.name]:value})
  };
  const saveUser = (e) =>{
    e.preventDefault();
    UserService.saveUser(user)
    .then((response)=>{
      if(response.data=='success')
      {
        console.log(response);
        routeChange();
      }
      else if(response.data=='fail')
      {
        alert('invalid fields')
      }
    })
    .catch((error)=>{
      console.log(error);
    });
  };
  return (
    <>
    <div className='flex  max-w-2xl mx-auto shadow border-b'>
      <div className='px-8 py-8'>
        <div className='font-medium'>
          <h1>User Details</h1>
        </div>
        <div className='font-thin items-center justify-center h-14 w-full my-3'>
          <label>
            FirstName
          </label>
          <input
          name = "firstName"
          value = {user.firstName}
          onChange = {(e)=>handleChange(e)}
          className='mx-3 font-mono'type="text"/>
        </div>
        <div className='font-thin items-center justify-center h-14 w-full my-3'>
          <label>
            LastName
          </label>
          <input 
          name = "lastName"
          value = {user.lastName}
          onChange = {(e)=>handleChange(e)}
          className='mx-3 font-mono'type="text"/>
        </div>
        <div className='font-thin items-center justify-center h-14 w-full my-3'>
          <label>
            User Name
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
        <div className='font-thin items-center justify-center h-14 w-full my-3'>
          <label>
            Email
          </label>
          <input
          name = "email"
          value = {user.email}
          onChange = {(e)=>handleChange(e)} 
          className='mx-14 font-mono border-b'type="email"/>
        </div>
        <div className='font-thin items-center justify-center h-14 w-full my-3  space-x-5'>
          <button onClick ={saveUser}
           className='rounded text-yellow-50 font-extrabold bg-black px-5 hover:text-green-900'>
            Register
          </button>
          <button onClick = {routeChange}
          className='rounded text-yellow-50 font-extrabold bg-green-900 px-5 hover:text-black px-8'>
            Login
          </button>
        </div>
      </div>
    </div>
  </>
  )
}

export default AddUser