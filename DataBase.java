package server;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataBase {
    private static final FileHandler FILE_HANDLER = new FileHandler();

    public String set(String key, String value) throws IOException {
        FILE_HANDLER.setToFileKeyAndValue(key, value);
        return "{\"response\":\"OK\"}";
    }

    public String get(String key) throws FileNotFoundException {
        if (FILE_HANDLER.ifContainsKey(key)) {
            return "{\"response\":\"OK\",\"value\":\"" + FILE_HANDLER.getFromFileByKey(key) + "\"}";
        } else {
            return "{\"response\":\"ERROR\",\"reason\":\"No such key\"}";
        }

    }

    public String delete(String key) throws IOException {
        if (FILE_HANDLER.ifContainsKey(key)) {
            FILE_HANDLER.deleteFromFileByKey(key);
            return "{\"response\":\"OK\"}";
        } else {
            return "{\"response\":\"ERROR\",\"reason\":\"No such key\"}";
        }

    }

    public String chooseTypeRequestByNameOfFile(String nameOfFile) throws IOException {
        switch (nameOfFile) {
            case "testDelete.json":
                FILE_HANDLER.deleteInFileFromOtherFile(nameOfFile);
                return "{\"response\":\"OK\"}";
            case "testGet.json":
                String value = FILE_HANDLER.getInFileFromOtherFile(nameOfFile);
                if (!value.equals("")) {
                    return "{\"response\":\"OK\",\"value\":\""+value+"\"}";
                }
               return "{\"response\":\"ERROR\",\"reason\":\"No such key\"}";
            case "testSet.json":
                FILE_HANDLER.setToFileFromOtherFile(nameOfFile);
                return  "{\"response\":\"OK\"}";
            default:
                return "{\"response\":\"ERROR\",\"reason\":\"Wrong name of file\"}";
        }

    }

}
