import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utility {

    private static final Gson gson = new Gson();


    public static <T> T getDataFromJsonFile(String path, Class<T> tClass) {
        try {
            return gson.fromJson(new JsonReader(new FileReader(path)), tClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeCsvFile(List<Data> finalSellers, String path, String... headers) {

        try {

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers));

            for (Data t : finalSellers) {
                csvPrinter.printRecord(t.getName(), t.getScore());
            }

            csvPrinter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
