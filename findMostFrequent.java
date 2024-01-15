import java.util.HashMap;
import java.util.Map;

public class findMostFrequent {
    public static String findMostFrequent(String text, int minLength, int maxLength){


    Map<String, Integer> substrCounts = new HashMap<>();
  
    // Đếm số lần xuất hiện các substring    

    int maxCount = 0;
    String mostFrequent = "";

    for(String substr : substrCounts.keySet()) {
        int currentCount = substrCounts.get(substr);
        if(currentCount > maxCount){
            maxCount = currentCount;
            mostFrequent = substr; 
        }
    }

    return mostFrequent + ": " + maxCount; 
}
public static void main(String[] args) {
    String text = "ALHKJKSBDIUJABOAUHDABOIHOABABAB";
    findMostFrequent(text,1,3);
    
}
}
