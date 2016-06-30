package bynull.functional.search;

import java.util.List;
import java.util.Optional;

/**
 * Created by bynull on 30.06.16.
 */
public class JavaSearch {

    public static Optional<Man> search(List<Man> firstGroup, List<Man> secondGroup)  {

        for (Man manFromFirstGroup : firstGroup) {
            System.out.println("Get and handle current user from the first group: " + manFromFirstGroup.name());

            System.out.println(String.format(" - Looking for the man: '%s' in the second group", manFromFirstGroup.name()));
            if (!secondGroup.contains(manFromFirstGroup)){
                System.out.println(String.format(" - '%s' not found in the second group", manFromFirstGroup.name()));
                continue;
            }

            System.out.println(String.format(" - A match was found: '%s'", manFromFirstGroup.name()));
            return Optional.of(manFromFirstGroup);
        }

        System.out.println("There is no a man who stay in both groups");
        return Optional.empty();
    }
}
