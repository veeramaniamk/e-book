const express           = require('express');
const bodyParser        = require('body-parser');
const cors              = require('cors');

const user              = require('./src/router/user');
const designer          = require('./src/router/publisher');
const admin             = require('./src/router/admin');

const app               = express();

app.use(cors());
app.use(bodyParser.json());

app.get('/', (req, res)=>{res.send("E-Book")});

app.use('/asserts', express.static('C:\\VEERAMANI\\book\\e-book\\backend\\src\\uploads\\user_profile\\'));
app.use('/books', express.static('C:\\VEERAMANI\\book\\e-book\\backend\\src\\uploads\\books\\'));
app.use('/cover_image', express.static('C:\\VEERAMANI\\book\\e-book\\backend\\src\\uploads\\cover_image\\'));
app.use('/demo_page', express.static('C:\\VEERAMANI\\book\\e-book\\backend\\src\\uploads\\demo_file\\'));
app.use('/category_image', express.static('C:\\VEERAMANI\\book\\e-book\\backend\\src\\uploads\\category_images\\'));

app.use('/user', user);
app.use('/admin', admin);
app.use('/publisher', designer);

const PORT = 2000;
app.listen(PORT, ()=>{console.log(`http://localhost:${PORT}/`)});