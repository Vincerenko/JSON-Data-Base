package server;

public class RequestToDB {
    public Object start(String request, int sizeSplit) {
        ListDataBase listDataBase = new ListDataBase();
        String[] splitTypeOfRequest = request.split(" ", sizeSplit);

        switch (splitTypeOfRequest[1]) {
            case "get":
                return listDataBase.get(Integer.parseInt(splitTypeOfRequest[3]));
            case "set":
               return listDataBase.set(Integer.parseInt(splitTypeOfRequest[3]), splitTypeOfRequest[5]);
            case "delete":
               return listDataBase.delete(Integer.parseInt(splitTypeOfRequest[3]));
            case "exit":
                return "exit";
            }
        return "wrong input";
    }
}

