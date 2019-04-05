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
app.get('/chat/:isbn',function(request,response){
    fs.readFile('./socketPage2.html','utf-8',function(error,data){
        db.chat.find(function(error,results){
            response.send(ejs.render(data,{
                data:results
            }));;
        });
    });
});

app.post('/chat/:isbn',function(request,response){
   var body = request.body;
    io.sockets.on('connection',function(socket){
    var roomName = null;
    //join이벤트
    socket.on('join',function(){
       roomName=body.bookTitle;
        socket.join(body.bookTitle);
    });
    //message이벤트
    socket.on('message',function(data){
        io.sockets.in(roomName).emit('message',data);
        db.chat.save({
        isbn:body.isbn,
        userName: body.userName,
        text:data,
        time:moment().format('YYYY[-]MM[-]DD HH[:]mm')
    });
});
    });
});





