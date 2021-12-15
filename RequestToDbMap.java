package server;

import java.io.IOException;

public class RequestToDbMap {
    public Object start(String request, int sizeSplit) throws IOException {
        DataBase dataBase = new DataBase();
        String[] splitTypeOfRequest = request.split(" ", sizeSplit);
        if (splitTypeOfRequest[0].equals("-in")) {
            return dataBase.chooseTypeRequestByNameOfFile(splitTypeOfRequest[1]);
        }
        switch (splitTypeOfRequest[1]) {
            case "get":
                return dataBase.get(splitTypeOfRequest[3]);
            case "set":
                return dataBase.set(splitTypeOfRequest[3], splitTypeOfRequest[5]);
            case "delete":
                return dataBase.delete(splitTypeOfRequest[3]);

            case "exit":
                return "{\"response\":\"OK\"}";
        }
        return "wrong input";
    }
}
