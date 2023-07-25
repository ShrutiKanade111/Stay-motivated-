package immuta;

import java.util.HashMap;
import java.util.Map;
 
// Class 1
// An immutable class
final class ImmutableClass {
 
    // Member attributes of final class
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;
 
    // Constructor of immutable class
    // Parameterized constructor
    public ImmutableClass(String name, int regNo,
                   Map<String, String> metadata1)
    {
 
        // This keyword refers to current instance itself
        this.name = name;
        this.regNo = regNo;
        //Deep copy means creating the new object and putting value into that object as shallow copy is copying the reference rather direct object
        //if we copy reference it means 2 reference accessing the same object and can change the same
        // Creating Map object with reference to HashMap
        // Declaring object of string type
		
		/*
		 * Map<String, String> tempMap = new HashMap<>();
		 * 
		 * // Iterating using for-each loop for (Map.Entry<String, String> entry :
		 * metadata1.entrySet()) { tempMap.put(entry.getKey(), entry.getValue()); }
		 * 
		 */
        this.metadata = new HashMap<>(metadata1);
    }
 
    // Method 1
    public String getName() { return name; }
 
    // Method 2
    public int getRegNo() { return regNo; }
   
    // Note that there should not be any setters
 
    // Method 3
    // User -defined type
    // To get meta data
    public Map<String, String> getMetadata()
    {
 
        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();
 
        for (Map.Entry<String, String> entry :
             this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
 
