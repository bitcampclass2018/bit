var fs=require('fs');
var ejs = require('ejs');
var mysql = require('mysql');
var express = require('express');
var bodyParser = require('body-parser');

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

//서버실행
app.listen(52275,function(){
    console.log('server running..');
});

//라우터
app.get('/',function(request,response){ 
    fs.readFile('list.html','utf-8',function(error,data){
        client.query('select * from member2',function(error,results){
            response.send(ejs.render(data,{
                data:results
            }));
        });
    });
});
app.get('/delete/:idx',function(request,response){
    client.query('delete from member2 where idx=?',[request.params.idx],function(){
        response.redirect('/');
    });
});
app.get('/insert',function(request,response){ 
    fs.readFile('insert.html','utf-8',function(error,data){
        response.send(data);
    });
});
app.post('/insert',function(request,response){ 
    var body = request.body;
    client.query('insert into member2(id,password,name) values (?,?,?)',[body.id,body.password,body.name],
    function(){
        response.redirect('/');
    });
});
app.get('/edit/:idx',function(request,response){ 
    fs.readFile('edit.html','utf8',function(error,data){
        client.query('select * from member2 where idx=?',[
            request.params.idx
        ],function(error,result){
            response.send(ejs.render(data,{
                data:result[0]
            }));
        });
    });
});
app.post('/edit/:id',function(request,response){ 
    var body =request.body;
    client.query('update member2 set id=?,password=?,name=?',[
        body.id, body.password, body.name
    ],function(){
        response.redirect('/');
    });
});
