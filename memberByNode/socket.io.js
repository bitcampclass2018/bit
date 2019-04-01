var socketio = require('socket.io');
var http= require('http');
var fs = require('fs');

var server = http.createServer(function (request,response){
    fs.readFile('socketHTML.html',function(error,data){
        response.writeHead(200,{'Content-Type':'text/html'});
        response.end(data);
    });
}).listen(52273,function(){
    console.log('running..');
});

var id = 0;
var io = socketio.listen(server);
//connection: 클라이언트가 연결할 때 발생하는 이벤트
io.sockets.on('connection',function(socket){
    //id 설정하기 
    id = socket.id;
    socket.on('rint',function(data){
        //private통신 (마지막으로 접속한 브라우저에서 이벤트 발생)
        io.sockets.to(id).emit('rint2',data);
    });
});


/*//소켓 서버를 생성 및 실행한다.
var io = socketio.listen(server);
//connection: 클라이언트가 연결할 때 발생하는 이벤트
io.sockets.on('connection',function(socket){
    //사용자정의이벤트
    socket.on('rint',function(data){
        //public (다른 브라우저에도 이벤트 발생)
        io.sockets.emit('rint2',data);
    });
});*/