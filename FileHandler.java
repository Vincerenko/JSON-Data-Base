package server;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private final String FILE_NAME = "/Users/asanin/IdeaProjects/JSON Database/JSON Database/task/src/server/data/db.json";
    private String templatePathForReadFromFile = "/Users/asanin/IdeaProjects/JSON Database/JSON Database/task/src/client/data/";
    private static final Gson GSON = new Gson();

    public void setToFileKeyAndValue(String key, String value) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            out.println(key);
            out.println(value);
            return;
        }
    }

    public String getFromFileByKey(String key) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(FILE_NAME), "UTF-8")) {
            String value = "";
            String result = "";
            while (in.hasNextLine()) {
                value = in.nextLine();
                if (value.equals(key)) {
                    result = in.nextLine();
                    break;
                }
            }
            return result;
        }
    }

    public boolean ifContainsKey(String key) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(FILE_NAME), "UTF-8")) {
            while (in.hasNextLine()) {
                if (in.nextLine().equals(key)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void deleteFromFileByKey(String key) throws IOException {
        List<String> data = new ArrayList<>();
        try (Scanner in = new Scanner(new File(FILE_NAME), "UTF-8")) {

            String check;
            while (in.hasNextLine()) {
                check = in.nextLine();
                if (check.equals(key)) {
                    in.nextLine();
                    continue;
                }
                data.add(check);

            }
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, false))) {
            for (String s : data)
                out.println(s);
        }

    }

    public ReceiverSet setToFileFromOtherFile(String nameOfFile) throws IOException {
        ReceiverSet receiverSet;
        try (Scanner in = new Scanner(new File(templatePathForReadFromFile + nameOfFile), "UTF-8")) {
            String line;
                line = in.nextLine();
                receiverSet = GSON.fromJson(line, ReceiverSet.class);
                setToFileKeyAndValue(receiverSet.getKey(), receiverSet.getValue());
            return receiverSet;
        }

    }

    public ReceiverSet requestToClient(String nameOfFile) throws IOException {
        ReceiverSet receiverSet;
        try (Scanner in = new Scanner(new File(templatePathForReadFromFile + nameOfFile), "UTF-8")) {
            String line;
            line = in.nextLine();
            receiverSet = GSON.fromJson(line, ReceiverSet.class);
            return receiverSet;
        }

    }

    public ReceiverDelete deleteInFileFromOtherFile(String nameOfFile) throws IOException {
        ReceiverDelete receiverDelete = null;
        try (Scanner in = new Scanner(new File(templatePathForReadFromFile + nameOfFile), "UTF-8")) {
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                receiverDelete = GSON.fromJson(line, ReceiverDelete.class);
                deleteFromFileByKey(receiverDelete.getKey());
            }
        }
        return receiverDelete;
    }

    public String getInFileFromOtherFile(String nameOfFile) throws IOException {
        String key = null;
        try (Scanner in = new Scanner(new File(templatePathForReadFromFile + nameOfFile), "UTF-8")) {
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                ReceiverGet receiverGet = GSON.fromJson(line, ReceiverGet.class);
                key = getFromFileByKey(receiverGet.getKey());
            }
        }
        return key;
    }

    public String getKeyInFileFromOtherFile(String nameOfFile) throws IOException {
        String key = null;
        String line = null;
        try (Scanner in = new Scanner(new File(templatePathForReadFromFile + nameOfFile), "UTF-8")) {

            while (in.hasNextLine()) {
                line = in.nextLine();
                ReceiverGet receiverGet = GSON.fromJson(line, ReceiverGet.class);
                key = getFromFileByKey(receiverGet.getKey());
            }
        }
        return line;
    }

}
