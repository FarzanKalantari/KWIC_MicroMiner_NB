package default_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * InputText: Reads the input text area and parses the input to the Line Storage
 */
public class InputText {

        /**
         * Stores lines to the Line Storage object
         */


        public LineStorage readAndStore(String text, StorageI lineStorage) throws IOException {

                // Count line
                int lineCounter = 0;

                // Line
                String line;

                String[] lines = text.split("\\r?\\n");
                
                for(int i = 0; i < lines.length; i++){
                    if ((line = lines[i]) != null) {
                        // Skip empty lines
                        if (!"".equals(line)) {
                                // Add line to the Line Storage
//                                 System.out.println("line before s\\: " + line);
//                                line.split("\\s+");
//                                System.out.println("line after s\\: " + line);
//                                line = String.join(" ",line);
//                                System.out.println("line after join: " + line);

                                lineStorage.setLine(lineCounter, line);

                                lineCounter++;
                        }
                    }
                }

                // Return line storage
                return (LineStorage) lineStorage;
        }

}
