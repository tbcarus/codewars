package MaketheDeadfishSwim;

//Write a simple parser that will parse and run Deadfish.
//
//        Deadfish has 4 commands, each 1 character long:
//
//        i increments the value (initially 0)
//        d decrements the value
//        s squares the value
//        o outputs the value into the return array
//        Invalid characters should be ignored.
//
//        Deadfish.parse("iiisdoso") =- new int[] {8, 64};

import java.util.ArrayList;
import java.util.List;

public class DeadFish {
    public static int[] parse(String data) {
        int value = 0;
        List<Integer> list = new ArrayList<>();
        for (char ch : data.toCharArray()) {
            switch (ch) {
                case 'i':
                    value++;
                    break;
                case 'd':
                    value--;
                    break;
                case 's':
                    value *= value;
                    break;
                case 'o':
                    list.add(value);
                    break;
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
