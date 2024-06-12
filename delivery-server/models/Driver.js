const mongoose = require('mongoose');

const driverSchema = new mongoose.Schema({
   name: String,
   surname: String,
});

const Driver = mongoose.model('Driver', driverSchema);
module.exports = Driver;