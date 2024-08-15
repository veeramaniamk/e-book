const express           = require('express');
const book              = require('../publisher/add_book');
const getBooks          = require('../publisher/get_books');
const udpateBook        = require('../publisher/update_book');
const router            = express.Router();

router.post('/add_books', book.add_book);
router.post('/get_book', getBooks.getBooks);
router.post('/update_book', udpateBook.udpateBook);
router.post('/delete_book', udpateBook.deleteBook);

module.exports = router;