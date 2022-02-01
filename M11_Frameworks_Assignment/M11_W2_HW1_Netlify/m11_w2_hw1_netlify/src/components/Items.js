import PropTypes from 'prop-types';
import React, { Component, useState } from 'react';
import Item from './Item';


//use arrow function for simple things and changing states
const Items = ({onDelete, items, addCount, remCount, tCounter}) => {

    return (
        <div className = "item">
            <div>

                {/* map through item- which will create a new array */}
                {
                    items.map((item) => ( 
                    <Item key={item.id}
                    item = {item}
                    onDelete={onDelete}
                    addCount={addCount}
                    remCount={remCount}
                    tCounter={tCounter}
                    >
                    </Item>))
                } 
            </div>
        </div>
        
        );
};

export default Items;


