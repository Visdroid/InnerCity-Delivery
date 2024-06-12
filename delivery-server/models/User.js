const mongoose = require('mongoose');

const userSchema = new mongoose.schema({
   name: String,
   surname: String,
});

const User = mongoose.model('User', userSchema);
module.exports = User;