const express        = require('express');
const router         = express.Router();
const user           = require('../user/authentication');
const update         = require('../user/updateuser');
const books          = require('../user/get_books');
const buyBook        = require('../user/buy_book');
const getBook        = require('../user/get_single_book');
const review         = require('../user/review');
const { checkBookSaved, deleteSavedBook, getSavedBook } = require('../user/saved_list');
const { checkFinishedBook, getFinishedBook } = require('../user/finished_book_list');

//common apis
router.post('/signup', user.signup);
router.post('/signin', user.signin);
router.post('/update_profile_image', update.chagneProfileImage);
router.post('/update_user_info', update.modifyUserInfo);
router.post('/change_password', update.changePassword);

//user page apis
router.post('/get_books', books.getAllBooks);
router.post('/buy_book', buyBook.buyBook);
router.post('/get_single_book', getBook.getBook);

//review
router.post('/send_review',review.addReview);
router.post('/get_book_review',review.viewBookReview);
router.post('/delete_review',review.deleteReivew);

router.post('/save_book', checkBookSaved);
router.post('/remove_saved_book', deleteSavedBook);
router.post('/get_saved_book', getSavedBook);

router.post('/finish_book', checkFinishedBook);
router.post('/get_finished_book', getFinishedBook);

module.exports = router;
