const express = require('express')
const app = expresss()

app.use(express.json());
app.use(express.urlencoded({extended : true}));
app.listen(3000);

console.log("server start at 3000");
