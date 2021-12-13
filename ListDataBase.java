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


    public String set(int index, String value) {
        if (index < 1001 && index > 0) {
            STRING_ARRAY_LIST.set(index, value);
        }
        return "Received: OK";
    }

    public String get(int index) {
        if (index < 1001 && index > 0 && !STRING_ARRAY_LIST.get(index).equals("")) {
            return "Received: " + STRING_ARRAY_LIST.get(index);
        } else {
            return "Received: ERROR";
        }

    }

    public String delete(int index) {
        if (index < 1001 && index > 0) {
            STRING_ARRAY_LIST.remove(index);
            STRING_ARRAY_LIST.set(index, "");
            return "Received: OK";
        }
        return "Received: ERROR";

    }
}
