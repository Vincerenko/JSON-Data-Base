package server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListDataBase listDataBase = new ListDataBase();
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           String[] typeOfRequest = sc.nextLine().split(" ",3);
           if (typeOfRequest[0].equals("get")) {
              listDataBase.get(Integer.parseInt(typeOfRequest[1]));
           }
           else if (typeOfRequest[0].equals("set")){
               listDataBase.set(Integer.parseInt(typeOfRequest[1]),typeOfRequest[2]);
           }
           else if (typeOfRequest[0].equals("delete")) {
               listDataBase.delete(Integer.parseInt(typeOfRequest[1]));
           }
           else if(typeOfRequest[0].equals("exit")){
               return;
           }
       }
    }
}
