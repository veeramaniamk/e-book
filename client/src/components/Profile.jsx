import React from "react";


const Profile = () =>{
    return(
        <section className="contact_section layout_padding">
        <div className="container">
          <div className="row">
            <div className="col-3"></div>
            <div className="col-6">
              <div className="heading_container">
                <h2>Profile</h2>
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
                  <button type="submit">Editprofile</button>
                </div>
              </form>
            </div>
            <div className="col-3"></div>
          </div>
        </div>
      </section>
    )   
}

export default Profile;