package exercise;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int[] array;
    
    public synchronized void add (Integer number) {
        var arr = ArrayUtils.add(this.array, number);
        array = arr;
    }
    
    public  Integer get(Integer index) {
        return array[index];
    }
    
    public  Integer getSize() {
        return array.length;
    }
    // END
}
