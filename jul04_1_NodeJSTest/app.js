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

//Node.js(Servlet +TomcatWAS)
app.listen(9999);//WAS포트번호 지정


app.get("/",function(reqq,res){
	var html="<html><body>";
	html+="<marquee>hi</marquee>";
	html+="</body></html>";
	res.send("zxc");
	console.log("zxc");
});

///http://195.168.9.63:9999/paramTest?x=3
app.get("/paramTest",function(rq,rs){
	var xxx=rq.query.x;//req.query.파라메터명
	rs.send(xxx);
});
//app.post();
//http://195.168.9.63:9999/calculate?x=3&y=5
//사칙연산 결과가 <h1></h1>x4로 나오게
app.get("/calculate",function(rq,rs){
	
	var xx=parseInt(rq.query.x);
	var yy=parseInt(rq.query.y);
	//이 아래 2개도 가능
	//var xx=rq.query.x*1;
	//var yy=rq.query.x*1;
	var html="<html><body>";
	html+="<h1>"+(xx+yy)+"</h1>";
	html+="<h1>"+(xx-yy)+"</h1>";
	html+="<h1>"+(xx*yy)+"</h1>";
	html+="<h1>"+(xx/yy)+"</h1>";
	html+="</body></html>";
	rs.send(html);
});
// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
