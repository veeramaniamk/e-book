import React, { useState } from "react";
import readingbook from "../Images/online-reading.jpg";
import { Link, useNavigate } from "react-router-dom";

const Login = ({ onLogin }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();

    // Simulate login (this is where you would normally verify credentials)
    if (email === "admin@example.com") {
      onLogin('admin');
      navigate('/adminhome');
    } else if (email === "publisher@example.com") {
      onLogin('publisher');
      navigate('/publisherhome');
    } else if (email === "user@example.com") {
      onLogin('user');
      navigate('/userhome');
    } else {
      alert("Invalid credentials");
    }
  };

  return (
    <section className="contact_section layout_padding">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="heading_container">
              <h2>Login</h2>
            </div>
            <form onSubmit={handleSubmit}>
              <div>
                <input
                  type="email"
                  placeholder="Email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
              </div>
              <div>
                <input
                  type="password"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </div>
              <div className="btn-box">
                <button type="submit">Login</button>
              </div>
              <div>
                <center>
                  <p>
                    Don't have an account?{" "}
                    <Link className="linktag-regis" to="/register">
                      Signup
                    </Link>
                  </p>
                </center>
              </div>
            </form>
          </div>
          <div className="col-md-6">
            <div className="img-box">
              <img className="bok-rea-login" src={readingbook} alt="Reading Book" />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Login;
