const express        = require('express');
const router         = express.Router();
const user           = require('../user/authentication');
const update         = require('../user/updateuser');

router.post('/signup', user.signup);
router.post('/signin', user.signin);
router.post('/update_profile_image', update.chagneProfileImage);
router.post('/update_user_info', update.modifyUserInfo);
router.post('/change_password', update.changePassword);

module.exports = router;