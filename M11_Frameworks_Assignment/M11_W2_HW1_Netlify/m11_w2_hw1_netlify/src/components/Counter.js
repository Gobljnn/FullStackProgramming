// import PropTypes from 'prop-types';
import React, { Component } from 'react';
import {useState} from 'react';




const Counter = ({reset, addItem, reload}) => {

  //use statehook to see the initial value of num to 0
  const [num, setNum] = useState(0)

  //on form submit instead of reloading page execute addItem fnc
  const onSubmit = (e) => {

    //used to prevent refresh of page
    e.preventDefault()

    //adds num as 0
     addItem({num})
  }

  return (
  
  <div className="item item-top">

    <form action="" className="item item-top" onSubmit={onSubmit}>

    <div className="label">
    <label>Refresh</label>
      <i className="fa fa-repeat icons" aria-hidden="true"
          onClick={() => reset()}
        ></i>
    </div>
    
    <div className="label">
    <label>Reset</label>
      <i className="fa fa-refresh icons" aria-hidden="true"
        onClick={() => reload()}>
        </i>
    </div>

    <div className="label">
      <label>Add</label>
      <input className="icons icons-sub" 
              type='submit' 
              value = "+"
              onChange = {(e) => setNum(e.target.value)}
              ></input>
    </div>
    </form>
      
  </div>);
};

export default Counter;


