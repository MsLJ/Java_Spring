var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));


app.listen(8888);

var io = require("socket.io")();
io.listen(9999);

io.sockets.on("connection", function (socket) {
    console.log("aa");
});


app.get("/product.reg", function (req, res) {
    var db = require("mongojs")("195.168.9.65/xe", ['jul07_product']);
    var name = req.query.n;
    var price = req.query.p * 1;
    var s = { p_name: name, p_price: price };
    db.jul07_product.insertOne(s, function (err, result) {

        db.jul07_product.find(function (err2, result2) {
            io.sockets.emit("ss", result2);
            // 등록성공했을때
            // DB에서 전체조회

        });

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.send(result);
    });

});
app.get("/product.get", function (req, res) {
    var db = require("mongojs")("195.168.9.65/xe", ['jul07_product']);
    // 들어왔을때 화면상에 불러오기위해서
    db.jul07_product.find(function (err, result) {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.send(result);

    });
});

// catch 404 and forward to error handler
app.use(function (req, res, next) {
    next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 500);
    res.render('error');
});

module.exports = app;
