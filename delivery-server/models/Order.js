const mongoose = require('mongoose');

const orderSchema = new mongoose.Schema({
   pickupPoint: String,
   destination: String,
});

const Order = mongoose.model('Order', orderSchema);
module.exports = Order;