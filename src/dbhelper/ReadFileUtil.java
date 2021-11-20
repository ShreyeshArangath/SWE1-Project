/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author matth
 */

public class ReadFileUtil {
    private Path path;
    
    public ReadFileUtil(String file) {
        path = Paths.get("src/data", file);
    }
    
    public List<List<String>> readFile() {
        List<List<String>> info = new ArrayList<>();
        String path = this.path.toString();
        
        try (Scanner scanner = new Scanner(new File(path))) {
            while(scanner.hasNextLine()) {
                info.add(getInfoFromLine(scanner.nextLine()));
            }
        }
        catch (FileNotFoundException e) {
            
        }
        return info;
    }
    
    private List<String> getInfoFromLine(String line) {
        List<String> value = new ArrayList<String>();
        
        try (Scanner rowScan = new Scanner(line)) {
            rowScan.useDelimiter(",");
            
            while(rowScan.hasNext()) {
                value.add(rowScan.next().strip());
            }
        }
        return value;
    }
    
    public static void main(String[] args) {
        ReadFileUtil read = new ReadFileUtil("Items.txt");
        System.out.println(read.readFile());
    }
}
