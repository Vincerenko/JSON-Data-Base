package server;

public class RequestToDB {
    public  void start(String request) {
        ListDataBase listDataBase = new ListDataBase();
            String[] splitTypeOfRequest = request.split(" ", 5);

            switch (splitTypeOfRequest[1]) {
                case "get":
                    listDataBase.get(Integer.parseInt(splitTypeOfRequest[3]));
                    break;
                case "set":
                    listDataBase.set(Integer.parseInt(splitTypeOfRequest[3]), splitTypeOfRequest[6]);
                    break;
                case "delete":
                    listDataBase.delete(Integer.parseInt(splitTypeOfRequest[4]));
                    break;
                case "exit":
                    return;
            }

    }
}
