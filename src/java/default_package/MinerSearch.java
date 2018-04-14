package default_package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sql.db.SQLCreate;

public class MinerSearch {

    private SQLCreate sqlCreate = SQLCreate.instance();

    //gets sorted lines from database and puts them an arraylist
    public ArrayList<String> getSortedLines() throws SQLException {

        Statement stmt = null;
        Connection con = sqlCreate.connect();
        String sql = "Select SortedLine from KWICdata";
        ArrayList<String> sortedLines = new ArrayList<>();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println();

            while (rs.next()) {
                //System.out.println("result sorted statement: " + rs.getString("SortedLine"));
                sortedLines.add(rs.getString("SortedLine"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();
        }
        return sortedLines;
    }

    //gets input lines from database and puts them an arraylist
    public ArrayList<String> getInputLines() throws SQLException {
        ArrayList<String> inputLines = new ArrayList<String>();
        Statement stmt = null;
        Connection con = sqlCreate.connect();
        String sql = "Select InputLine from KWICdata where InputLine IS NOT NULL";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                inputLines.add(rs.getString("InputLine"));
                //System.out.println("result input statement: " + rs.getString("InputLine"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            con.close();
        }
        return inputLines;
    }

    //takes keyword search and outputs corresponding original input
    public ArrayList<String> getOutputFromKeywords(String keywords) throws SQLException {
        ArrayList<String> sortedLines = getSortedLines();
        ArrayList<String> inputLines = getInputLines();
        ArrayList<String> outputLines = new ArrayList<String>();

        for (int i = 0; i < sortedLines.size(); i++) {
            //checks if sorted line contains a combination of keyword input
            if (sortedLines.get(i).contains(keywords)) {
//				System.out.println("keyword contained in: " + sortedLines.get(i));
                for (int j = 0; j < inputLines.size(); j++) {
                    //checks if url is same as sorted line with original input line meaning we found a match from sorted keywords to original input
                    if (sortedLines.get(i).substring(sortedLines.get(i).lastIndexOf(" ") + 1).matches(inputLines.get(j).substring(inputLines.get(j).lastIndexOf(" ") + 1))) {
                        //doesn't allow addition of duplicate to output list
                        if (!outputLines.contains(inputLines.get(j))) {
                            outputLines.add(inputLines.get(j));
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < outputLines.size(); i++) {
//            System.out.println("output from keywords: " + outputLines.get(i));
//        }
        return outputLines;
    }

}
