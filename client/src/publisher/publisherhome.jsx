import React from "react";
import endocrinology from "../Images/endocrinology.png"
import nursing from "../Images/nursing.png"
import physcology from "../Images/physcology.png"


const Publisherhome = () => {
    return(
<section >
    <div className="container">
   <center><h3 className="section-cate-front">Published books</h3></center>
        <div className="row">
            <div className="col-4 layout-hei">
                <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={endocrinology} alt="" /></center>
                    <center><h4 className="chaitary">Psychiatry</h4></center>
                </div>
            </div>
            <div className="col-4 layout-hei">
            <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={nursing} alt="" /></center>
                    <center><h4 className="chaitary">Nursing</h4></center>
                </div>
            </div>
            <div className="col-4 layout-hei">
            <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={physcology} alt="" /></center>
                    <center><h4 className="chaitary">Physcology</h4></center>
                </div>
            </div>
            <div className="col-4 layout-hei">
            <div className="bookfront-layout">
                    <center><img className="bookfront-img" src={physcology} alt="" /></center>
                    <center><h4 className="chaitary">Physcology</h4></center>
                </div>
            </div>
        </div>
    </div>
</section>
    )
}

export default Publisherhome;