package AirbnbPet;

import java.util.List;

public class helpers {
    public static boolean substringInCollection(String substr, List<String> collection) {
        substr = substr.toLowerCase();
        for (String str : collection) {
            str = str.toLowerCase();
            if (str.contains(substr))
                return true;
        }
        return false;
    }
}
