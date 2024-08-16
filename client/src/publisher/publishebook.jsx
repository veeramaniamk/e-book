import React from "react";
import ebookpublishing from "../Images/ebookpublishing.webp"

const Publishebook = () =>{
    return(
        <section className="contact_section layout_padding">
        <div className="container">
          <div className="row">
            <div className="col-md-6">
              <div className="heading_container">
                <h2>Publish E-Book  </h2>
              </div>
              <form action="#">
  <div>
    <label>Book Image</label>
    <input type="file" accept="image/*" />
  </div>
  <div>
    {/* <label>Book Title</label> */}
    <input type="text" placeholder="Book Title" />
  </div>
  <div>
    <label>Upload PDF</label>
    <input type="file" accept="application/pdf" />
  </div>
  <div>
    {/* <label>Author Name</label> */}
    <input type="text" placeholder="Author Name" />
  </div>
  <div>
    {/* <label>Publisher Name</label> */}
    <input type="text" placeholder="Publisher Name" />
  </div>
  <div>
    {/* <label>Year of Publication</label> */}
    <input type="number" placeholder="Year" />
  </div>
  <div className="btn-box">
    <button type="submit">Publish</button>
  </div>
</form>

            </div>
            <div className="col-md-6">
              <div className="img-box">
                <img className="bok-rea-register" src={ebookpublishing} alt="" />
              </div>
            </div>
          </div>
        </div>
      </section>
    )
}

export default Publishebook;