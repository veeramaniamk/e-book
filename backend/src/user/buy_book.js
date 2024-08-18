const mysql = require("../database/connection");

const buyBook = (req, res) => {

    const { user_id, publisher_id, book_id, price, transaction_id } = req.body;

    if(!publisher_id || !user_id || !book_id || !price || !transaction_id) {
        return res.status(400).send({status: 400, message: 'Fields cannot be empty!'});
    }

    const query = `INSERT INTO purchased_books(user_id, publisher_id, book_id, price, transaction_id) VALUES (?, ?, ?, ?, ?)`;

    mysql.query(query, [user_id, publisher_id, book_id, price, transaction_id ], (err, result) => {
        if(err) {
            const error = { message:'Error', error:err };
            console.log(error);
            return res.status(500).send({status:500, message:error.message});
        }

        return res.status(200).send({status:200, message:"Success"});
    })

}

module.exports = { buyBook };
