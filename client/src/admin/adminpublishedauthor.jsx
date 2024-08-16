import React from "react";
import { Link } from "react-router-dom";
import image from "../Images/image 5.png"


const Adminpublishedauthor = () =>{
    return(
        <section>
            <div className="container">
                <div className="row">
                <center><h4 className="pub-auth">Published Author</h4></center>
                <div className="col-4">
                    <Link className="publish-link" to="/adminpublisherbook">
                    <div className="pub-auth-pho">
                        <img src={image} alt="" />
                    </div>
                    <div>
                        <h4>DR lekha </h4>
                        <p>Books Published <span>6</span> </p>
                    </div>
                    </Link>
                </div>
                <div className="col-4">
                    <Link className="publish-link" to="">
                    <div className="pub-auth-pho">
                        <img src={image} alt="" />
                    </div>
                    <div>
                        <h4>DR lekha </h4>
                        <p>Books Published <span>6</span> </p>
                    </div>
                    </Link>
                </div>
                <div className="col-4">
                    <Link className="publish-link" to="">
                    <div className="pub-auth-pho">
                        <img src={image} alt="" />
                    </div>
                    <div>
                        <h4>DR lekha </h4>
                        <p>Books Published <span>6</span> </p>
                    </div>
                    </Link>
                </div>
                <div className="col-4">
                    <Link className="publish-link" to="">
                    <div className="pub-auth-pho">
                        <img src={image} alt="" />
                    </div>
                    <div>
                        <h4>DR lekha </h4>
                        <p>Books Published <span>6</span> </p>
                    </div>
                    </Link>
                </div>
                </div>
            </div>
            
        </section>
        // <h3>hello</h3>
    )
}


export default Adminpublishedauthor;