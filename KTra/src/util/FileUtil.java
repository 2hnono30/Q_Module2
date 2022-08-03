package util;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public ArrayList<String> fileRead (String filePath){
        ArrayList<String> fileData = new ArrayList<>();
        String temp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((temp = bufferedReader.readLine())!= null && !temp.trim().isEmpty()) fileData.add(temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileData;
    }
    public <Type> void fileWrite(String filePath,ArrayList<Type> fileData){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            for (Object temp: fileData) bufferedWriter.write(temp.toString() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
