import React from "react";
import readingbook from "../Images/readingbook.webp"
import { Link } from "react-router-dom";


const register = () =>{
    return (
        <section className="contact_section layout_padding">
          <div className="container">
            <div className="row">
              <div className="col-md-6">
                <div className="heading_container">
                  <h2>Register</h2>
                </div>
                <form action="#">
                  <div>
                    <input type="Name" placeholder="Name" />
                  </div>
                  <div>
                    <input type="email" placeholder="Email" />
                  </div>
                  <div>
                    <input type="DOB" placeholder="DOB" />
                  </div>
                  <div>
                    <input type="Mobile Number" placeholder="Mobile Number" />
                  </div>
                  <div>
                    <input type="Address" placeholder="Address" />
                  </div>
                  <div>
                    <input type="password" placeholder="password" />
                  </div>
                  <div className="btn-box">
                    <button type="submit">Register</button>
                  </div>
                  <div>
               <center><p>Have an account? <Link className="linktag-regis" to="/login   " >Login</Link></p></center> 
              </div>
                </form>
              </div>
              <div className="col-md-6">
                <div className="img-box">
                  <img className="bok-rea-register" src={readingbook} alt="" />
                </div>
              </div>
            </div>
          </div>
        </section>
      );
}
export default register;
// module.exports = register;