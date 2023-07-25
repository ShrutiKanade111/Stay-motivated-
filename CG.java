package immuta;

import java.util.HashMap;
import java.util.Map;

// Class 2
// Main class
class CG {
 
    // Main driver method
    public static void main(String[] args)
    {
 
        // Creating Map object with reference to HashMap
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "vasd");
        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");
 
        ImmutableClass s = new ImmutableClass("ABC", 101, map);
        
       // ImmutableClass ss = new ImmutableClass("bcc", 102, map1);
 
        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());
 
        // Uncommenting below line causes error
        // s.regNo = 102;
 
        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetadata());
        map.put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetadata());
        //ImmutableClass ss = new ImmutableClass("bcc", 102, map);
        
    }
}