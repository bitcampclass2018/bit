var mongojs = require('mongojs');
var db = mongojs('node');
var fs = require('fs');
var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var socketio = require('socket.io');
var cors = require('cors');
var http = require('http');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(cors());

var server = http.createServer(app).listen(52273,function(){
    console.log('서버시작되었습니다.');
});

var io = socketio.listen(server);

        io.sockets.on('connection', function (socket) {
            socket.on('join', function (data) {
                socket.join(data);
            });
            //message이벤트
            socket.on('message', function (data) {
                db.chat.save({
                    isbn: data.isbn,
                    userName: data.userName,
                    message: data.message,
                    time: data.time
                });
                io.sockets.in(data.isbn).emit('message', data);
            });
            socket.on('first',function(data){
               io.sockets.in(data.isbn).emit('first',data); 
            });


        });
app.get('/chat', function (request, response) {
    fs.readFile('./Test.html', 'utf-8', function (error, data) {
        response.send(data);
    });
});

app.post('/chat/:isbn', function (request, response) {
    var body = request.body;
    console.log(request.params.isbn);
    (function (error, result) {
        response.send({
            isbn: body.isbn,
            bookTitle: body.bookTitle,
            userName: body.userName
        });
    })();
});



app.get('/chat/:data', function (request, response) {
        var jsonData = JSON.parse(request.params.data);
        db.chat.find({
            isbn: jsonData.isbn
        }, function (error, results) {
            console.log("찾아낸 채팅목록");
            var arr = {data:results, isbn:jsonData.isbn,
                      bookTitle:jsonData.bookTitle,
                      userName:jsonData.userName};
            $.ajax({
                url:'http://localhost/sentence/chat/K892533939',
                type:'GET',
                data:JSON.stringify(arr),
                dataType:'json',
                contentType:'application/json; charset=utf-8',
                async:true,
                success:function(data){
                    console.log('톰캣으로 전송');
                    console.log(JSON.stringify(data));
                },error:function(error){
                    console.error();
                }
            });
        });

    });


/*app.get('/chat/:data', function (request, response) {
    fs.readFile('./mobile.html', 'utf-8', function (error, data) {
        var jsonData = JSON.parse(request.params.data);
        db.chat.find({
            isbn: jsonData.isbn
        }, function (error, results) {
            response.send(ejs.render(data, {
                data: results,
                isbn: jsonData.isbn,
                bookTitle: jsonData.bookTitle,
                userName: jsonData.userName
            }));
        });

    });

});*/