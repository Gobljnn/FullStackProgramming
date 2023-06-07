import React from 'react';
import PropTypes from 'prop-types';
import 'font-awesome/css/font-awesome.css';

function NavBar(props){

        return (
        <div className="nav2 navbar navbar-light bg-light">
            <div className="title">
                <nav className="navbar">
                    <div className="navbar-brand">
                    <i className="fa fa-shopping-cart fa-lg m-2"></i>
                    <span className="badge rounded-pill bg-primary" style={{width: 50}}>{props.totalCount}</span>
                    Products
                    </div>
                </nav>
                <h2>{props.title}</h2>

            </div>
            
        </div>);

}

NavBar.defaultProps = {
    title: 'React App (Shopping Cart)',
}

NavBar.propTypes = {
    title: PropTypes.string,
}

export default NavBar;
