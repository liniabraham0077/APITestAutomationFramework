package utilities;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class CSVManager {

    public static HashMap<String, String> findCatFactRowFromCSV(String value, String fileName, String key1, String key2, String key3) throws Exception {
        HashMap<String, String> csvRowMap = new HashMap<String, String>();
        try {
            CSVReader reader;
            reader = new CSVReader(new FileReader(getFileFromResource(fileName)));
            String[] row = null;
            int index = 0;
            while ((row = reader.readNext()) != null) {
                if (row[0].equals(String.valueOf(value))) {
                    csvRowMap.put(key1, row[0]);
                    csvRowMap.put(key2, row[1]);
                    csvRowMap.put(key3, row[2]);
                    break;
                }
                index++;
            }
            reader.close();

        } catch (IOException | CsvValidationException | URISyntaxException e) {
            e.printStackTrace();
        }
        return csvRowMap;
    }

    public static List<HashMap<String, String>> transformResponse(List<HashMap<String, String>> arr, String key1, String key2, String key3) {

        Set<String> keyNamesToInclude = Set.of(key1, key2, key3);

        Set<String> keys = new HashSet<>(keyNamesToInclude);
        List<HashMap<String, String>> copies = arr.stream().map(e -> {
            HashMap<String, String> copy = new HashMap<>();
            keys.forEach(k -> {
                String value = e.get(k);
                if (value != null)
                    copy.put(k, e.get(k));
            });
            return copy;
        }).collect(Collectors.toList());
        return copies;
    }

    public static ArrayList<HashMap<String, String>> getAllCSVRecords(String filePath, String key1, String key2, String key3) {
        ArrayList<HashMap<String, String>> myArrList = null;
        CSVReader reader;
        HashMap<String, String> map;

        try {
            myArrList = new ArrayList<HashMap<String, String>>();
            reader = new CSVReaderBuilder(new FileReader(getFileFromResource(filePath)))
                    .withCSVParser(new CSVParserBuilder()
                            .build())
                    .withSkipLines(1)
                    .build();

            String[] row = null;
            int indexOfLoop = 0;
            while ((row = reader.readNext()) != null) {
                map = new HashMap<String, String>();
                map.put(key1, row[0]);
                map.put(key2, row[1]);
                map.put(key3, row[2]);
                myArrList.add(map);

            }
            reader.close();

        } catch (IOException | CsvValidationException | URISyntaxException e) {
            e.printStackTrace();
        }
        return myArrList;
    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = CSVManager.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }


    }

}
