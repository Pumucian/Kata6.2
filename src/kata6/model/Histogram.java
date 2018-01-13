package kata6.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
    private final Map<T, Integer> map = new HashMap<>();
    
    public int getKey(T key){
        return map.get(key);
    }
    
    public Set<T> keySet(){
        return map.keySet();
    }
    
    public void increment(T key, int value){
        map.put(key, map.containsKey(key)
                ? map.get(key) + value : value);
    }
}
