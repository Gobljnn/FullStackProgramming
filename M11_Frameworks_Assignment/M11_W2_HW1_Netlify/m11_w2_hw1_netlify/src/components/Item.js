import React from 'react';

const Item = ({item, onDelete, addCount, remCount}) => {

  return (
  <div className="item">
      <div className={ `itemNum icons ${item.num <= 0 ?  'icons-red icons-zero' : '' }`}
      key={item.id}>
      {item.num > 0 ? (item.num) : (item.num = 0, 'ZERO')}

      </div>
      <div className="item item-btn">
                    
                    <i className="fa fa-plus-square icons icons-green" aria-hidden="true" 
                    onClick={ () => addCount(item.id)}
                    ></i>

                    <i className="fa fa-minus-square icons icons-red" aria-hidden="true"
                    onClick={() => remCount(item.id)}
                    ></i>

                    <i className="fa fa-trash icons icons-garb" aria-hidden="true"
                    onClick={() => onDelete(item.id)}
                    ></i>
            </div>
  </div>
  );
};

export default Item;
