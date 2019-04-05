var http = require('http');
var fs = require('fs');
var socketio = require('socket.io');
//웹 서버를 만든다.
var server = http.createServer(function (request, response){
    fs.readFile('HTMLPage.html', function(error, data){
        response.writeHead(200,{'Content-Type':'text/html'});
        response.end(data);
    });
}).listen(52273, function(){
    console.log('running...');
});

//소켓서버를 만든다.
var io = socketio.listen(server); //웹서버에 연결
io.sockets.on('connection',function(socket){
    //message 이벤트
    socket.on('message',function(data){
        //클라이언트의 message이벤트를 발생시킨다.
        io.sockets.emit('message',data);
    });
});