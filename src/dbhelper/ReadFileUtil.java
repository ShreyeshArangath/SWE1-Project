/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;
<<<<<<< HEAD
=======

>>>>>>> 5eb92d5cfcd447aae9288439fb209c2387a55f00
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
<<<<<<< HEAD
 * @author shreyesh
 */
public class ReadFileUtil {
    private Path path;
    public ReadFileUtil(String fileName){
        path = Paths.get("src/data", fileName);
    }

    public List<List<String>> readFile(){
        List<List<String>> records = new ArrayList<>();
        String path = this.path.toString();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        catch (FileNotFoundException ex) {}
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next().strip());
            }
        }
        return values;
    }

     public static void main(String[] args) {

        ReadFileUtil r = new ReadFileUtil("regular-product.data");
        System.out.println(r.readFile());

    }
}
=======
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
>>>>>>> 5eb92d5cfcd447aae9288439fb209c2387a55f00
