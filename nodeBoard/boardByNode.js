var mongojs = require('mongojs');
var db = mongojs('node');
var fs = require('fs');
var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');


//서버생성
var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));

app.listen(52278, function () {
    console.log('server running..');
});

app.get('/board', function (request, response) {
    fs.readFile('./boardList.html', 'utf-8', function (error, data) {
        db.board.find(function (error, results) {
            response.send(ejs.render(data, {
                data: results
            }));
        });
    });
});
app.get('/board/:num', function (request, response) {
    fs.readFile('./boardList.html', 'utf-8', function (error, data) {
        console.log('파라미터:' + request.params.num);
        db.board.find({
            num: request.params.num
        }, function (error, results) {
            response.send(ejs.render(data, {
                data: results
            }));
        });
    });
});

app.get('/boardInsert', function (request, response) {
    fs.readFile('./boardInsert.html', 'utf-8', function (error, data) {
        response.send(data);
    });
});
app.post('/board/:name', function (request, response) {
    var body = request.body;
    db.count.find().count(function (error, cntResult) {
        db.count.save({
            _id: cntResult + 1,
            name: body.name
        }, function (error, result) {
            db.board.save({
                num: cntResult + 1,
                name: body.name,
                password: body.password,
                description: body.description
            }, function (error, result) {
                response.send({
                    num: cntResult + 1,
                    name: body.name,
                    password: body.password,
                    description: body.description
                });
            });
        });
    });
});
app.get('/board/editForm/:num', function (request, response) {
    fs.readFile('./boardEdit.html', 'utf8', function (error, data) {
        let b = Number(request.params.num);
        db.board.find({num: b}, function (error, result) {
            response.send(ejs.render(data, {
                data: result[0]
            }));
        });
    });
});

app.put('/board/:num', function (request, response) {
    var body = request.body;
    let b = Number(request.params.num);
    console.log('body.description:'+body.description);
    console.log(b);
    db.board.update({num: b}, {name: body.name},{password:body.password},
       {$set: {description: body.description}}, function (error, results) {
        response.send({
            num: b,
            name: body.name,
            password: body.password,
            description: body.description
        });
    });

});
app.delete('/board/:num', function (request, response) {
    let b= request.params.num*1;
    db.board.remove({num: b}, function (error, result) {
        if (error) {
            console.log('삭제실패');
        } else {
            response.send({
                'delete': 'success'
            });
        }
    });
});
