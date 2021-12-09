package server;

import java.util.Scanner;

public class Stage1 {
    public static void start() {
        ListDataBase listDataBase = new ListDataBase();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] typeOfRequest = sc.nextLine().split(" ", 3);
            switch (typeOfRequest[0]) {
                case "get":
                    listDataBase.get(Integer.parseInt(typeOfRequest[1]));
                    break;
                case "set":
                    listDataBase.set(Integer.parseInt(typeOfRequest[1]), typeOfRequest[2]);
                    break;
                case "delete":
                    listDataBase.delete(Integer.parseInt(typeOfRequest[1]));
                    break;
                case "exit":
                    return;
            }
        }
    }
}
