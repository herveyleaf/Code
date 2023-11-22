package Java;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args){
        String[] english = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] chinese = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for(int i = 0; i < 7; i++){
            hashMap.put(english[i], chinese[i]);
        }
        System.out.println("HashMap实现的Map是无序的");
        Set<String> keys = hashMap.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
        }
        TreeMap<String, String> TreeMap = new TreeMap<String, String>(hashMap);
        System.out.println("\nTreeMap实现的Map是按字符串升序排序的");
        keys = TreeMap.keySet();
        it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
        }
    }
}
