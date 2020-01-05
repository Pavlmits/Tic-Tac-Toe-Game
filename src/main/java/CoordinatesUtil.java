import java.util.HashMap;
import java.util.Map;

public class CoordinatesUtil {

    public static Map<XyValue, Integer> getCoordinates(){
        final Map<XyValue, Integer> xyMap = new HashMap<>();
        xyMap.put(new XyValue("1","3"), 0);
        xyMap.put(new XyValue("2","3"), 1);
        xyMap.put(new XyValue("3","3"), 2);
        xyMap.put(new XyValue("1","2"), 3);
        xyMap.put(new XyValue("2","2"), 4);
        xyMap.put(new XyValue("3","2"), 5);
        xyMap.put(new XyValue("1","1"), 6);
        xyMap.put(new XyValue("2","1"), 7);
        xyMap.put(new XyValue("3","1"), 8);
        return xyMap;
    }
}
