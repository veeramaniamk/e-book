import React from "react";
import { Link } from "react-router-dom";
import 'primeicons/primeicons.css';
        
 // Import Link from react-router-dom

const Publishernavnar = () => {
  return (
    <header className="header_section">
      <div className="container-fluid">
        <nav className="navbar navbar-expand-lg custom_nav-container">
          <Link className="navbar-brand" to="/index.html">
            <span>Medical E-Book</span>
          </Link>

          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className=""></span>
          </button>

          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <Link className="nav-link pl-lg-0" to="/publisherhome">
                  Home 
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/publishebook">
                  PublishBook
                </Link>
              </li>
              {/* <li className="nav-item">
                <Link className="nav-link" to="/adminpurchased">
                  Purchased
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/adminrevived">
                  Revived
                </Link>
              </li> */}
              <li className="nav-item">
                <Link className="nav-link" to="/profile">
                  Profile
                </Link>
              </li>
            </ul>
            <form className="search_form"> {/* Fixed typo from 'from' to 'form' */}
              <input type="text" className="form-control" placeholder="Search here..." />
              <button className="" type="submit">
              <span className="pi pi-search"></span>
              </button>
            </form>
          </div>
        </nav>
      </div>
    </header>
  );
};

export default Publishernavnar;
