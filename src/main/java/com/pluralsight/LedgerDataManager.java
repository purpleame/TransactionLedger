package com.pluralsight;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class LedgerDataManager {
    private String print;
    private String fileName;
        FileWriter fileWriter = new FileWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

    // getters
    public String getFileName() {return fileName;}
    // setters
    public void setFileName(String fileName) {this.fileName = fileName;}

    // methods
    public void initFile(String userFileName) {
        try {
            FileReader fileReader = new FileReader("src\\main\\resources\\" + userFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
