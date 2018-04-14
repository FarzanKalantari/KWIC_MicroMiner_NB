package default_package;

import java.util.HashMap;

/**
 * LineStorage: Stores the line and words
 */
import java.util.HashMap;

/**
 * LineStorage: Stores the line and words
 */
public class LineStorage implements StorageI {

    /**
     * Map that stores line number and corresponding sentence/line
     */
    private HashMap<Integer, String> lineMap;

    /**
     * Construct the object
     */
    public LineStorage() {
        lineMap = new HashMap<>();
    }
    //returns total number of lines from input

    public int getLineCount() {
        return lineMap.size();
    }

    /**
     * Get line based on the line number
     */
    public String getLine(int lineNumber) {
        return lineMap.get(lineNumber);
    }

    /**
     * Add a line to the storage line map which automatically calls the addWord
     * to add the storage word array map
     */
    public void setLine(int lineNumber, String line) {
        lineMap.put(lineNumber, line);

        //setURL(lineNumber, line);
        //setDescriptor(lineNumber, line);
    }
}
