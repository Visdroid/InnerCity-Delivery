import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectFileGenerator {

   
    public static void main(String[] args){
         //Frontend Directories are identified here
         String[] frontendDirectories = {"delivery-app/public","delivery-app/src/components/Auth",
         "delivery-app/src/components/Order",
         "delivery-app/src/components/Map",
         "delivery-app/src/services"};

         //Frontend Directories are identified here
         String[] backendDirectories = {"delivery-server/controllers","delivery-server/models","delivery-server/routes","delivery-server/config"};

         //Create Frontend Directories
         createDirectories(frontendDirectories);

         //Create Backend Directories
         createDirectories(backendDirectories);
         
         //Create Frontend Files
         createFile("delivery-app/public/index.html", "");
         
         createFile("delivery-app/public/app.js", "");
         createFile("delivery-app/src/index.js", "");

         createFile("delivery-app/src/components/Auth/Login.js", "");
         createFile("delivery-app/src/components/Auth/RegisterUser.js", "");
         createFile("delivery-app/src/components/Auth/RegisterDriver.js", "");

         createFile("delivery-app/src/components/Order/CreateOrder.js", "");
         createFile("delivery-app/src/components/Order/OrderList.js", "");

         createFile("delivery-app/src/components/Map/MapView.js", "");

         createFile("delivery-app/src/services/AuthService.js", "");
         createFile("delivery-app/src/services/OrderService.js", "");

         //Create Backend Files here
         createFile("delivery-server/app.js", getAppJSContent());
         createFile("delivery-server/controllers/authController.js", "");
         createFile("delivery-server/controllers/orderController.js", "");
         createFile("delivery-server/models/User.js", getUserModelContent());
         createFile("delivery-server/models/Driver.js", getDriverModelContent());
         createFile("delivery-server/models/Order.js", getOrderModelContent());
         createFile("delivery-server/routes/authRoutes.js", "");
         createFile("delivery-server/routes/orderRoutes.js", "");
         createFile("delivery-server/config/db.js", getDBConfigContent());

    }
    private static void createDirectories(String[] directories){
        for(String directory: directories) {
            new File(directory).mkdirs();
        }
    }

    private static void createFile(String filePath, String content){
        try{
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Created file: " + filePath);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private static String getAppJSContent(){
        return "const express = require();\n" +
        "const app = express();n\n" +
        "app.listen(3000, () => console.log('Server running on port 3000'));";
    }

    private static String  getUserModelContent(){
        return "const mongoose = require('mongoose');\n\n" +
        "const userSchema = new mongoose.schema({\n" +
        "   name: String,\n"+
        "   surname: String,\n" +
        "});\n\n" +
        "const User = mongoose.model('User', userSchema);\n" +
        "module.exports = User;";
    }
    private static String getDriverModelContent(){
        return "const mongoose = require('mongoose');\n\n" +
        "const driverSchema = new mongoose.Schema({\n" + 
        "   name: String,\n" +
        "   surname: String,\n" +
        "});\n\n" +
        "const Driver = mongoose.model('Driver', driverSchema);\n" +
        "module.exports = Driver;";
    }
    private static String getOrderModelContent(){
        return "const mongoose = require('mongoose');\n\n" +
        "const orderSchema = new mongoose.Schema({\n" +
        "   pickupPoint: String,\n" +
        "   destination: String,\n" +
    
        "});\n\n" +
        "const Order = mongoose.model('Order', orderSchema);\n" +
        "module.exports = Order;";

    }
    private static String getDBConfigContent(){
        return "const mongoose = require('mongoose');\n\n" +
        "mongoose.connect('cmongodb+srv://aldrinvisser:Gadwin00@_@javascriptmongodb.wfoxkgg.mongodb.net/', {useNewUrlParser: true, useUnifiedTopology: true })\n" + 
        ".then(() => console.log('MongoDB connected'))\n" +
        ".catch(err => console.log(err));";
    }
}