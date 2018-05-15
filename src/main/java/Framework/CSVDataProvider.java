package Framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVDataProvider {

    public static Iterator<Object[]> loadDataFromFile() {
        List<Object[]> list = new ArrayList<Object[]>();
        String filePath = new File("./target/classes/DataMessage.csv").getAbsolutePath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            String line = reader.readLine();

            while (line != null) {
//                String[] params = line.split("\n");
//                list.add(new Object[]{params[0]});
                line = reader.readLine();
            }
        } catch (Exception e) {
        }
        return list.iterator();
    }
}

