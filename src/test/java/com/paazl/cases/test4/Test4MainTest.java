package com.paazl.cases.test4;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4MainTest {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static Calendar calendar = Calendar.getInstance();

    /*
    Method com.paazl.cases.test4.Main.main have to be executed.
    And file com.paazl.cases.test4.testdata.new.csv have to be created already.
    This test is looking for discrepancies in files.
     */
    @Test
    public void testMain() {

        ArrayList<TestDataPojo> testDataListBefore = new ArrayList<>();
        ArrayList<TestDataPojo> testDataListAfter = new ArrayList<>();
        String row;

        try {
            //Choose filepath to read
            BufferedReader csvReader = new BufferedReader(new FileReader(
                    "C:\\RKTN\\2_5231469053578580199\\developer-testcases\\cases_1_5\\src\\main\\resources\\com\\paazl\\cases\\test4\\testdata.csv"));
            String firstLineBefore = csvReader.readLine();

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (data.length != 5) {
                    System.out.println("Wrong values number in a row");
                    continue;
                }
                try {
                    testDataListBefore.add(new TestDataPojo(data[0], data[1], data[2], Integer.parseInt(data[3]),
                            new SimpleDateFormat("dd/MM/yyyy").parse(data[4])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            csvReader.close();

            //Choose filepath to read
            BufferedReader csvReader2 = new BufferedReader(new FileReader(
                    "C:\\RKTN\\2_5231469053578580199\\developer-testcases\\cases_1_5\\src\\main\\resources\\com\\paazl\\cases\\test4\\testdata.new.csv"));
            String firstLineAfter = csvReader2.readLine();

            while ((row = csvReader2.readLine()) != null) {
                String[] data = row.split(";");
                if (data.length != 5) {
                    System.out.println("Wrong values number in a row");
                    continue;
                }
                try {
                    testDataListAfter.add(new TestDataPojo(data[0], data[1], data[2], Integer.parseInt(data[3]),
                            new SimpleDateFormat("dd/MM/yyyy").parse(data[4])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            csvReader2.close();

            assertEquals(firstLineBefore, firstLineAfter);
            assertEquals(testDataListBefore.size(), testDataListAfter.size());

            TestDataPojo dataPojoAfter;
            int elementGetter = 0;
            for (TestDataPojo testDataPojo : testDataListBefore) {
                dataPojoAfter = testDataListAfter.get(elementGetter);
                elementGetter++;
                assertEquals(testDataPojo.getName(), dataPojoAfter.getName());
                assertEquals(testDataPojo.getCity(), dataPojoAfter.getCity());
                assertEquals(testDataPojo.getCountry(), dataPojoAfter.getCountry());
                assertEquals(testDataPojo.getNumber() + 1, dataPojoAfter.getNumber());
                String strDate = formatter.format(testDataPojo.getDate());
                try {
                    calendar.setTime(formatter.parse(strDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                calendar.add(Calendar.DATE, 1);  // number of days to add
                assertEquals(calendar.getTime(), dataPojoAfter.getDate());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
