import React from "react";
import endocrinology from "../Images/endocrinology.png"


const Userviewbook = () =>{
    return(
        <section className="user-view-sect">
            <div className="container">
                <div className="row nology">
                    <div className="col-4">
                        <img width={300} src={endocrinology} alt="" />
                    </div>
                    <div className="col-8">
                        <h3 className="cology">Physcology</h3>
                        <h5>Author Name : <span>Mohan</span></h5>
                        <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                        <h5>Price : <span>299</span></h5>
                        <button className="omed">Read Demo</button>
                        <button className="omed">Add to Favorites</button>
                        <button className="omed">Buy Now</button>
                    </div>
                </div>
            </div>
        </section>

    )
}

export default Userviewbook;