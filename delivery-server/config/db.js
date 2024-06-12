const mongoose = require('mongoose');

mongoose.connect('cmongodb+srv://aldrinvisser:Gadwin00@_@javascriptmongodb.wfoxkgg.mongodb.net/', {useNewUrlParser: true, useUnifiedTopology: true })
.then(() => console.log('MongoDB connected'))
.catch(err => console.log(err));