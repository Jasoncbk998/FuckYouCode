import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class tools {
    public static String printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\t");
        }
        return sb.toString();
    }



}