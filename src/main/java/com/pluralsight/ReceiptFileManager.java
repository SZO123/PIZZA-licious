package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//This class saves the order details into a receipt file inside the receipts folder.
public class ReceiptFileManager {

    public ReceiptFileManager(Order order) throws IOException {

        try {
            //create receipts folder if it doesn't exist
            File folder = new File("receipts");
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get current date and time
            LocalDateTime now = LocalDateTime.now();

            //format date and time for file name
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String formattedDate = now.format(formatter);

            //set file name with formatted date
            String fileName = "receipts/" + formattedDate + ".txt";

            //create and write order details to the receipt file
            FileWriter fw = new FileWriter(fileName, false);
            fw.write(order.toString());
            fw.close();

            //print confirmation
            System.out.println("Receipt successfully saved as " + fileName);

        } catch (IOException e) {
            System.out.println("Unable to save receipt!");
        }
    }
}