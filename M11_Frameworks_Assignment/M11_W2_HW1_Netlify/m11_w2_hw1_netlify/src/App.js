import './App.css';
import Counter from './components/Counter';
import NavBar from './components/NavBar';
import {useState } from 'react';
import Items from './components/Items';
import React from 'react';



function App() {

  //empty object array for item state  
  let [items, setItems]=useState(
    []
  )

  //On Delete 
  const deleteItem = (id) =>{
    setItems(items.filter((item) => item.id !== id))
  }

//Add 1 to specified item
  const addICount = (id) =>{

    setItems(
      items.map
      ((item) => item.id === id ? {...item, num: item.num + 1 } : item)
    )
  }

//Subtract 1 from specified item
  const remICount = (id) =>{
    setItems(items.map(
      (item) => item.id === id ? {...item, num: item.num - 1 } : item
    
    ))
  }

  //add a new product to the cart
  const addIItem = (item) => {
    const id = items.length + 1;
    const newItem = {id, ...item}
    setItems([...items, newItem])
  }

  //reset all current products in cart to 0
  const IReset  = () => {
    setItems(
      items.map
      ((item) => item.num != 0 ? {...item, num: item.num = 0 } : item)
    )
  }

  //Reload window
  const IRestart = () => {
    window.location.reload();
  }

  return (
    <div className="App">

      <NavBar totalCount = {items.filter((item) => item.num > 0).length} ></NavBar>

      <div className="containers">

      <Counter
        reset={IReset}
        addItem={addIItem}
        reload={IRestart}
      ></Counter>

      {
        items.length> 0 ? (
            <Items 
              
              items={items} 
              onDelete={deleteItem}
              addCount={addICount}
              remCount={remICount}
              >
            </Items>) : (

            <h1>No Items in the cart</h1>

            )
      }

      </div>
    </div>

    );
}

export default App;

