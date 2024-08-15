const multer  = require('multer');

const mysql   = require('../database/connection');

var fileName="";
const storage = multer.diskStorage({

  destination: (req, file, cb) => { cb(null, 'C:\\VEERAMANI\\book\\e-book\\backend\\src\\uploads\\user_profile\\'); },

  filename: (req, file, cb) => {

      fileName = Date.now() + '-' + file.originalname;
      cb(null, fileName);

  },

});

function chagneProfileImage(req, res) {
 
    const upload = multer({ storage });
    
        upload.single("profile")(req, res, (err) => {

          if(err){console.log("error "+err.message); return res.status(400).send({ status:400,message: 'image data missing'})}

          const user_id = req.body.user_id;
          
          if (!user_id || !req.file) {
            return res.status(400).send({status:400, error: 'Content or image data missing'});
          }

          const sql = `update signup set profile_photo = '${fileName}' where id = ${user_id}`;

          mysql.query(sql, (err, result) => {

            if (err) {
              return res.status(500).send({status:500, message: 'Error inserting data into database' });
            }
            
            return res.status(200).send({ status: 200, message: 'Profile Image Updated Successfully' });

          });

        });
       
}

function modifyUserInfo(req, res) {

    const { name, phone, email, gender, user_id } = req.body;

    if(!name || !phone || !email || !gender || !user_id) {
      return res.status(400).send({status: 400, message: 'Fields cannot be empty!'});
    }

    const query = `UPDATE signup SET name=?, phone=?, email=?, gender=? WHERE id=?`;
    mysql.query(query,[name, phone, email, gender, user_id],(err, result) => {
      if(err) {
        const error = { message:'Error', error:err };
        console.log(error);
        return res.status(500).send({status:500, message:error.message});
    } 

        return res.status(200).send({nstatus:200, message:'Updated successfully' });

    });

}

async function setPassword(req, res) {

    const { user_id, current_password, new_password } = req.body;

    if(!user_id || !current_password || !new_password) {
      return res.status(400).send({status: 400, message: 'Fields cannot be empty!'});
    }

    const query = `UPDATE signup SET password=? WHERE id=?`;
    mysql.query(query, [ new_password, user_id ], (err, result) => {

      if(err) {
        const error = { message:'Error', error:err };
        console.log(error);
        return res.status(500).send({status:500, message:error.message});
      } 

      return res.status(200).send({status:200, message:'Updated successfully' });

    });

}

function changePassword(req, res) {

  const { user_id, email, current_password, new_password } = req.body;

  if(!user_id || !email || !current_password || !new_password) {
    return res.status(400).send({status: 400, message: 'Fields cannot be empty!'});
  }

  const query = `SELECT * FROM signup where email= ? and id = ?`;
  mysql.query(query, [email, user_id], async (err,result) => {

    if(err) {
      const error = { message:'Error', error:err };
      console.log(error);
      return res.status(500).send({status:500, error:error.message});
    } 

    if(result.length <= 0) {
      return res.status(401).send({ status:401, message:'Invalid credentials' });
    }

    if(!(current_password === result[0].password)) {
      return res.status(401).send({ status:401, message:'Incorrect Password' });
    }

    setPassword(req,res);

  });

}



module.exports = { chagneProfileImage, modifyUserInfo, changePassword };