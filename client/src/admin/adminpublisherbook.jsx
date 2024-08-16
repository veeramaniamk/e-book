import React from "react";
import endocrinology from "../Images/endocrinology.png"
import nursing from "../Images/nursing.png"
import physcology from "../Images/physcology.png"
import { Link } from "react-router-dom";


const Adminpublisherbook = () =>{
    return(
        <section>
            <div className="container">
                <div className="row">
                    <center><h2 className="author-pub-nam">Author Name : <span>Dr Lekhah</span></h2></center>
                    <center><h4 className="author-publed">Published books</h4></center>
                    <div className="col-4 layout-hei">
                    <Link className="crinology" to="">
                <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={endocrinology} alt="" /></center>
                    <center><h4 className="chaitary">Psychiatry</h4></center>
                </div>
                    </Link>
                    </div>
                    <div className="col-4 layout-hei">
                     <Link className="crinology" to="" >
            <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={nursing} alt="" /></center>
                    <center><h4 className="chaitary">Nursing</h4></center>
                </div>
                     </Link>
                                 </div>
                                 <div className="col-4 layout-hei">
                     <Link className="crinology">
            <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={physcology} alt="" /></center>
                    <center><h4 className="chaitary">Physcology</h4></center>
                </div>
                     </Link>
                     </div>
                </div>
            </div>
        </section>
    )
}


export default Adminpublisherbook;