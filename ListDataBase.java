package server;

import java.util.ArrayList;
import java.util.List;

/**
 * Class like real Array List, but for the task restricted by 100 cells in array
 */

public class ListDataBase {
    private static final List<String> STRING_ARRAY_LIST = new ArrayList<>(1010);

    public ListDataBase() {
        for (int i = 0; i < 1100; i++) {
            STRING_ARRAY_LIST.add("");
        }
    }


    public int set(int index, String value) {
        if (index < 1001 && index > 0) {
            STRING_ARRAY_LIST.set(index, value);
            System.out.println("OK");
        }
        return index;
    }

    public int get(int index){
        if (index < 1001 && index > 0 && !STRING_ARRAY_LIST.get(index).equals("")) {
            System.out.println(STRING_ARRAY_LIST.get(index));
        }
        else{
            System.out.println("ERROR");
        }
        return index;
    }
    public int delete(int index) {
        if (index < 1001 && index > 0) {
            STRING_ARRAY_LIST.remove(index);
            STRING_ARRAY_LIST.set(index, "");
            System.out.println("OK");
            return index;
        } else {
            System.out.println("ERROR");
            return index;
        }
    }
}
