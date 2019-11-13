import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ConfigReader {
    public ArrayList<Command> getCommands(String filePath) throws FileNotFoundException{
        File file = new File(filePath);
        if(!file.isFile()){
            throw new FileNotFoundException("Could not find file: " + file.getPath());
        }
        if(filePath.substring(filePath.length()-4).equals(".xls")){
            return parseXls(file);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    private ArrayList<Command> parseXls(File file){
        ArrayList<Command> commandList = new ArrayList<Command>();
        Workbook workbook;
        FileInputStream fileInputStream;
        Sheet sheet;
        try{
            fileInputStream = new FileInputStream(file);
            workbook  = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
            sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                commandList.add(new Command(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString()));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return commandList;
    }
}
