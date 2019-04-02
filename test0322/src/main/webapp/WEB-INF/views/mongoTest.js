var mongojs = require('mongojs');
var db = mongojs('node', ['product']);
var fs = require('fs');
var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');

db.products.find(function (error, data) {
    console.log(data);
});

//서버생성
var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));

app.listen(52277, function () {
    console.log('server running..');
});

app.get('/mongo', function (request, response) {
            fs.readFile('./mongoList.html', 'utf-8', function (error, data) {
                    db.products.find(function (error, results) {
                            console.log(results);
                            response.send(ejs.render(data, {
                                    data: results
                                }));
                            });
                    });
            });
app.get('/mongo/:name', function (request, response) {
    fs.readFile('./mongoList.html', 'utf-8', function (error, data) {
        console.log('파라미터:'+request.params.name);
        db.products.find({name:request.params.name},function (error, results) {
            response.send(ejs.render(data, {
                data: results
            }));
        });
    });
});

app.get('/mongoInsert', function (request, response) {
    fs.readFile('./mongoInsert.html', 'utf-8', function (error, data) {
        response.send(data);
    });
});
app.post('/mongo/:name', function (request, response) {
    var body = request.body;
    db.products.save({name:body.name, price:body.price},function(error,result){
       response.send({
           name: body.name,
           price:body.price
       }) 
    });
});

app.get('/mongo/editForm/:id', function (request, response) {
    fs.readFile('./mongoEdit.html', 'utf8', function (error, data) {
        db.products.find({_id:request.params.id}, function (error, result) {
            response.send(ejs.render(data, {
                data: result[0]
            }));
        });
    });
});

app.put('/mongo/:id', function (request, response) {
    var body = request.body;
    var temp = db.products.findOne({_id:request.params.id});
    console.log(temp);
    temp.name = body.name;
    temp.price = body.price;
    db.products.save(temp), function (error, results) {
        response.send({
            _id: body.id,
            name: body.name,
            price: body.price
        });
    };
});
app.delete('/mongo/:id', function (request, response) {
    db.products.remove({_id:request.params.id}, function (error, result) {
        if (error) {
            console.log('삭제실패');
        } else {
            response.send({
                'delete': 'success'
            });
        }
    });
});