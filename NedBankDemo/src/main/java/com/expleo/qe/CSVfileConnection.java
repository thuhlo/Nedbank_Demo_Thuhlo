package com.expleo.qe;

import net.thucydides.core.annotations.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVfileConnection
{

    @Step("Get all data from CSV File")
    public static ArrayList<DataModel> readCSVfile() throws IOException {

        String fileName = "testData";
        int lineCounter = 0;
        String fileLine;
        int count = 0;
        ArrayList<DataModel> arData = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName + ".txt");
        BufferedReader myInput = new BufferedReader(new InputStreamReader(fis));
        DataModel objModel;


        while (((fileLine = myInput.readLine()) != null)) {

            StringTokenizer st = new StringTokenizer(fileLine, ",");

            if (lineCounter != 0) {
                while (st.hasMoreElements()) {

                    objModel = new DataModel(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
                            st.nextToken(), st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
                    arData.add(objModel);

                }
            }
            lineCounter++;
        }
        myInput.close();
        return arData;
    }


    @Step("Get all data from CSV File")
    public static ArrayList<ProductModel> readComputerSpecsfile() throws IOException {

        String fileName = "computerSpecs.txt";
        int lineCounter = 0;
        String fileLine;
        int count = 0;
        ArrayList<ProductModel> arData = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader myInput = new BufferedReader(new InputStreamReader(fis));
        ProductModel objModel;


        while (((fileLine = myInput.readLine()) != null)) {

            StringTokenizer st = new StringTokenizer(fileLine, ",");

           // if (lineCounter != 0) {
                while (st.hasMoreElements()) {

                    objModel = new ProductModel(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken()
                            ,st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
                    arData.add(objModel);
                }
           // }
           // lineCounter++;
        }
        System.out.println("CSV connection file size : " + arData.size());
        myInput.close();
        return arData;
    }
}
