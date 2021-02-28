/**
 * Class to store LS Data objects called keys and values
 * @author Deon Fourie
 */
public class LSData implements Comparable<LSData>{

    private String key;
    private String value;
    /**
     * Constructor to initialize key and value LSData objects
     * @param key
     * @param value
     */
    public LSData(String key, String value) {
        this.key = key;
        this.value = value;
    }
    /**
     * A dummy class
     * @param key
     */
    public LSData(String key) {
        this(key , "");
    }
    /**
     * Method to get the value of a LSData object
     * @return
     */
    public String getvalue() {
        return value;
    }
    /**
     * Method to het the key of a LSData oject
     * @return
     */
    public String getkey() {
        return this.key;
    }
    /**
     * Boolean to determine if a given query  == the current key
     * @param stage
     * @param day
     * @param startTime
     * @return
     */
    public boolean equals(String stage, String day, String startTime) {
        return (this.key.equals(stage+"_"+day+"_"+startTime));
    }
    /**
     * Method to check equality
     * @param other
     * @return
     */
    public boolean equals(LSData query) {
        return this.key.equals(query.getkey());
    }
    /**
     * Compares this key to the paramters key
     */
    public int compareTo(LSData other) {
        return this.key.compareTo( other.getkey() );
    }
    /**
     * To string that prints the value in a readable way
     */
    public String toString() {
        return "KEY: " + key + " AREAS : " + value.replace("-", ", ");
    }

}