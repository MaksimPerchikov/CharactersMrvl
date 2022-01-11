package prob;

import ru.mrvl.model.Comics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        iList.add(2);
        iList.add(1);
        iList.add(6);
        iList.add(3);

        List<Integer> sort = iList
                .stream()
                        .sorted()
                                .collect(Collectors.toList());

        System.out.println(sort);

    }
}
