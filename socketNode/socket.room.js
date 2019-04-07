var fs = require('fs');

var server = require('http').createServer();
var io = require('socket.io').listen(server);

server.listen(52273,function(){
    console.log('running..');
});
server.on('request',function(request,response){
    fs.readFile('RoomPage.html',function (error,data){
        response.writeHead(200,{'Content-Type':'text/html'});
        response.end(data);
    });
});
io.sockets.on('connection',function(socket){
    var roomName = null;
    //join이벤트
    socket.on('join',function(data){
       roomName=data;
        socket.join(data);
    });
    //message이벤트
    socket.on('message',function(data){
        io.sockets.in(roomName).emit('message','test');
    });
});