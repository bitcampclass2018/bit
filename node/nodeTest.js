var fs = require('fs');
var express =require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var mysql = require('mysql');



//db연결
var client = mysql.createConnection({
    host:'mysql.cnwa5kgdj8hg.ap-northeast-2.rds.amazonaws.com',
    user:'bit2',
    password:'1234',
    database:'openproject'
});

//서버생성
var app = express();
app.use(bodyParser.urlencoded({
    extended:false
}));

app.listen(52274,function(){
    console.log('server running..');
});

//라우터설정
app.get('/user',function(request,response){
    fs.readFile('./register/list.html','utf-8',function(error,data){
        client.query('select * from member2',function(error,results){
            response.send(ejs.render(data,{
                data:results
            }));
        });
    });
});
app.get('/user/:idx',function(request,response){
    fs.readFile('./register/list.html','utf-8',function(error,data){
        client.query('select * from member2 where idx=?',[request.params.idx],function(error,results){
                response.send(ejs.render(data,{
                    data:results
                }));
        });
    });
});
app.get('/user/insert',function(request,response){ 
    fs.readFile('./register/insert.html','utf-8',function(error,data){
        response.send(data);
    });
});
app.post('/user/:idx',function(request,response){
    var body = request.body;
    client.query('insert into member2(id,password,name) values (?,?,?)',[body.id,body.password,body.name],
    function(error,results){
        response.send({
            id: body.id,
            password: body.password,
            name: body.name
        });
        
        
    });
});
app.get('/user/editForm/:idx',function(request,response){ 
    fs.readFile('./register/edit.html','utf8',function(error,data){
        client.query('select * from member2 where idx=?',[
            request.params.idx
        ],function(error,result){
            response.send(ejs.render(data,{
                data:result[0]
            }));
        });
    });
});
app.put('/user/:idx',function(request,response){
    var body = request.body;
    console.log(body);
   client.query('update member2 set id=?,password=?,name=? where idx=?',[
        body.id, body.password, body.name, body.idx
    ],function(error,results){
        response.send({
            id: body.id,
            password: body.password,
            name: body.name
        });
    });
});
app.delete('/user/:idx',function(request,response){
    client.query('delete from member2 where idx=?',[request.params.idx],function(error,result){
        if(error){
            console.log('삭제실패');
        }else{
            response.send({
                delete:success
            });
        }
    });
});
