import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileManagement {


    public FileManagement(String filename) throws IOException {
        FileWriter fw = null;
        File file = new File(filename);
        try {
            fw = new FileWriter(file);
            fw.write("");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
