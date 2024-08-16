import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import anaesthesia from "../Images/anaesthesia 1.png"

const Adminhome = () => {
  const [activeTab, setActiveTab] = useState('home');

  const handleTabClick = (tab) => {
    setActiveTab(tab);
  };

  return (
    <div className="container mt-5">
       <center><h3 className="aprov-bok">Approving Books</h3></center>
      {/* Nav tabs */}
      <ul className="nav nav-tabs tab-ull" id="myTab" role="tablist">
        <li className="nav-item" role="presentation">
          <button
            className={` tab-sty ${activeTab === 'home' ? 'active' : ''}`}
            id="home-tab"
            data-bs-toggle="tab"
            type="button"
            role="tab"
            aria-controls="home"
            aria-selected={activeTab === 'home'}
            onClick={() => handleTabClick('home')}
          >
            New
          </button>
        </li>
        <li className="nav-item" role="presentation">
          <button
            className={` tab-sty ${activeTab === 'profile' ? 'active' : ''}`}
            id="profile-tab"
            data-bs-toggle="tab"
            type="button"
            role="tab"
            aria-controls="profile"
            aria-selected={activeTab === 'profile'}
            onClick={() => handleTabClick('profile')}
          >
            Approved
          </button>
        </li>
        <li className="nav-item" role="presentation">
          <button
            className={` tab-sty ${activeTab === 'contact' ? 'active' : ''}`}
            id="contact-tab"
            data-bs-toggle="tab"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected={activeTab === 'contact'}
            onClick={() => handleTabClick('contact')}
          >
            Rejected
          </button>
        </li>
      </ul>

      {/* Tab panes */}
      <div className="tab-content" id="myTabContent">
        <div
          className={`tab-pane fade ${activeTab === 'home' ? 'show active' : ''}`}
          id="home"
          role="tabpanel"
          aria-labelledby="home-tab"
        >
            <div className="row tab-conn">
                <div className="col-1"></div>
                <div className="col-3">
                    <img width={200} src={anaesthesia} alt="" />
                    <h3 className="thesia">Anesthesia</h3>
                </div>
                <div className="col-7">
                    <h4>Argun</h4>
                    <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                    <button className="tab-read">Readmore</button>
                    <div className="apr-ject">
                        <div><button className="approve-butt">Approve</button></div>
                        <div><button className="reject-butt">Reject</button></div>
                    </div>
                </div>
                <div className="col-1"></div>
            </div>
            <div className="row tab-conn">
                <div className="col-1"></div>
                <div className="col-3">
                    <img width={200} src={anaesthesia} alt="" />
                    <h3 className="thesia">Anesthesia</h3>
                </div>
                <div className="col-7">
                    <h4>Argun</h4>
                    <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                    <button className="tab-read">Readmore</button>
                    <div className="apr-ject">
                        <div><button className="approve-butt">Approve</button></div>
                        <div><button className="reject-butt">Reject</button></div>
                    </div>
                </div>
                <div className="col-1"></div>
            </div>
        </div>
        <div
          className={`tab-pane fade ${activeTab === 'profile' ? 'show active' : ''}`}
          id="profile"
          role="tabpanel"
          aria-labelledby="profile-tab"
        >
            <div className="row tab-conn">
                <div className="col-1"></div>
                <div className="col-3">
                    <img width={200} src={anaesthesia} alt="" />
                    <h3 className="thesia">Anesthesia</h3>
                </div>
                <div className="col-7">
                    <h4>Argun</h4>
                    <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                    <button className="tab-read">Readmore</button>
                    <div className="apr-ject">
                        <div><button className="approve-butt">Approved</button></div>
                        {/* <div><button className="reject-butt">Reject</button></div> */}
                    </div>
                </div>
                <div className="col-1"></div>
            </div>
            <div className="row tab-conn">
                <div className="col-1"></div>
                <div className="col-3">
                    <img width={200} src={anaesthesia} alt="" />
                    <h3 className="thesia">Anesthesia</h3>
                </div>
                <div className="col-7">
                    <h4>Argun</h4>
                    <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                    <button className="tab-read">Readmore</button>
                    <div className="apr-ject">
                        <div><button className="approve-butt">Approved</button></div>
                        {/* <div><button className="reject-butt">Reject</button></div> */}
                    </div>
                </div>
                <div className="col-1"></div>
            </div>
        </div>
        <div
          className={`tab-pane fade ${activeTab === 'contact' ? 'show active' : ''}`}
          id="contact"
          role="tabpanel"
          aria-labelledby="contact-tab"
        >
            <div className="row tab-conn">
                <div className="col-1"></div>
                <div className="col-3">
                    <img width={200} src={anaesthesia} alt="" />
                    <h3 className="thesia">Anesthesia</h3>
                </div>
                <div className="col-7">
                    <h4>Argun</h4>
                    <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                    <button className="tab-read">Readmore</button>
                    <div className="apr-ject">
                        {/* <div><button className="approve-butt">Approve</button></div> */}
                        <div><button className="reject-butt">Rejected</button></div>
                    </div>
                </div>
                <div className="col-1"></div>
            </div>
            <div className="row tab-conn">
                <div className="col-1"></div>
                <div className="col-3">
                    <img width={200} src={anaesthesia} alt="" />
                    <h3 className="thesia">Anesthesia</h3>
                </div>
                <div className="col-7">
                    <h4>Argun</h4>
                    <p>Anesthesia is a medical procedure that uses drugs to temporarily and controllably block sensation or awareness for medical or veterinary purposes. </p>
                    <button className="tab-read">Readmore</button>
                    <div className="apr-ject">
                        {/* <div><button className="approve-butt">Approve</button></div> */}
                        <div><button className="reject-butt">Rejected</button></div>
                    </div>
                </div>
                <div className="col-1"></div>
            </div>
        </div>
      </div>
    </div>
  );
};

export default Adminhome;
