var mongojs = require('mongojs');
var db = mongojs('node');
var fs = require('fs');
var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var moment = require('moment');
var socketio = require('socket.io');


var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));
var io = socketio();
var server = require('http').createServer(app);
io.attach(server);
server.listen(52273);
/*
var server = http.createServer(function (request, response){
    fs.readFile('socketPage.html', function(error, data){
        response.writeHead(200,{'Content-Type':'text/html'});
        response.end(data);
    });
}).listen(52273, function(){
    console.log('running...');
});
*/
app.get('/chat', function (request, response) {
    fs.readFile('./Test.html', 'utf-8', function (error, data) {
        response.send(data);
    });
});


app.post('/chat/:isbn', function (request, response) {
    var body = request.body;
    (function (error, result) {
        response.send({
            isbn: body.isbn,
            bookTitle: body.bookTitle,
            userName: body.userName
        });
    })();
});



app.get('/chat/:data', function (request, response) {
    fs.readFile('./socketPage2.html', 'utf-8', function (error, data) {
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
        
        io.sockets.on('connection', function (socket) {
            socket.on('join', function () {
                socket.join(jsonData.isbn);
            });
            //message이벤트
            socket.on('message', function (data) {
                io.sockets.to(jsonData.isbn).emit('message', data);
                db.chat.save({
                    isbn: jsonData.isbn,
                    userName: jsonData.userName,
                    message: data.message,
                    time: data.time
                });
            });


        });
    });

});
                /*io.sockets.in(jsonData.isbn).emit('message', data);*/