/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author shreyesh
 */
public class WriteFileUtil {

    private Path path;

    public WriteFileUtil(String fileName) {
        this.path = Paths.get("src/data", fileName);
    }

    public boolean write(List<String> columnData, List<List<String>> data) {
        try (FileWriter csvWriter = new FileWriter(path.toString())) {
            csvWriter.append(String.join(",", columnData));
            csvWriter.append("\n");

            for (List<String> rowData : data) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            return true;
        } catch (IOException io) {
            return false;
        }
    }
}
