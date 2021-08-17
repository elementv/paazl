package com.paazl.cases.test4;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static Calendar calendar = Calendar.getInstance();

    /*
     * Read and parse "testdata.csv" (located in
     * src/main/resources/com/paazl/cases/test4) into a list of POJOs. Increase
     * each POJO's "number" field by 1, and move the "date" field one day ahead.
     * Write the results to a file named "testdata.new.csv".
     */
    public static void main(String[] args) {
        // TODO Implement this
        // TODO Write unit tests

        String row;
        ArrayList<TestDataPojo> testDataList = new ArrayList<>();
        File localPath = new File(System.getProperty("user.dir"));

        try {
            //Choose filepath to read
            BufferedReader csvReader = new BufferedReader(new FileReader(localPath +
                    "\\src\\main\\resources\\com\\paazl\\cases\\test4\\testdata.csv"));
            String firstLine = csvReader.readLine(); //Ignoring the 1st line with fields names
            String[] headerFields = firstLine.split(";");
            if (headerFields.length != 5) {
                System.out.println("Wrong Data format. Please check the fields headers number.");
            }
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (data.length != 5) {
                    System.out.println("Wrong values number in a row");
                    continue;
                }
                try {
                    testDataList.add(new TestDataPojo(data[0], data[1], data[2], Integer.parseInt(data[3]),
                            new SimpleDateFormat("dd/MM/yyyy").parse(data[4])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            csvReader.close();

            //Choose filepath to write
            FileWriter csvWriter = new FileWriter(localPath +
                    "\\src\\main\\resources\\com\\paazl\\cases\\test4\\testdata.new.csv");
            csvWriter.append(firstLine);
            csvWriter.append("\n");

            for (TestDataPojo testDataPojo : testDataList) {
                csvWriter.append(testDataPojo.getName());
                csvWriter.append(";");
                csvWriter.append(testDataPojo.getCity());
                csvWriter.append(";");
                csvWriter.append(testDataPojo.getCountry());
                csvWriter.append(";");
                csvWriter.append(String.valueOf(increaseNumber(testDataPojo.getNumber()))); //increase number by 1
                csvWriter.append(";");
                csvWriter.append(increaseDate(testDataPojo.getDate())); //increase Date by 1 day
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int increaseNumber(int number) {
        return number + 1;
    }

    private static String increaseDate(Date date) {
        String strDate = formatter.format(date);
        try {
            calendar.setTime(formatter.parse(strDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE, 1);  // number of days to add
        return formatter.format(calendar.getTime());  // return the new date
    }
}