package pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

    private Map<String, AbstractFlyWeight> flyWeights = new HashMap<>();

    private AbstractFlyWeight getAbstractFlyWeight(String key) {

        if (flyWeights.containsKey(key)) {
            return flyWeights.get(key);
        }else {

        }
        return null;
    }
}
