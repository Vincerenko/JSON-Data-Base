package server;

public class RequestToDbMap {
    public Object start(String request, int sizeSplit) {
        MapDataBase mapDataBase = new MapDataBase();
        String[] splitTypeOfRequest = request.split(" ", sizeSplit);

        switch (splitTypeOfRequest[1]) {
            case "get":
                return mapDataBase.get(splitTypeOfRequest[3]);
            case "set":
                return mapDataBase.set(splitTypeOfRequest[3], splitTypeOfRequest[5]);
            case "delete":
                return mapDataBase.delete(splitTypeOfRequest[3]);
            case "exit":
                return "{\"response\":\"OK\"}";
        }
        return "wrong input";
    }
}
