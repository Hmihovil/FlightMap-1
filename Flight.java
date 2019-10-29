/*
Camryn Rogers
cpr170030
CS 3345.003
 */
package flight;

import java.io.*;
import java.util.*;

public class Flight {

    public static void main(String[] args) throws FileNotFoundException {
        
        // Create scanners/print writers for files
        Scanner in_data = new Scanner(new File(args[0]));
        Scanner in_query = new Scanner(new File(args[1]));
        PrintWriter out_file = new PrintWriter(new File(args[2]));
        
        // Set scanner delimiters to "|"
        in_data.useDelimiter("\\||\\r");

        in_query.useDelimiter("\\||\\r");
        
        // Create lists for file reading
        String in_city = "", out_city = "", go_to_next_line = "",
                time_or_cost = null;
        int cost = 0, time = 0;
        
        // Create the graph with all of the info from the file
        Graph graph = new Graph();
        
        // While the data file has information, read and add to graph
        while(in_data.hasNext()){
            in_city = in_data.next();
            System.out.println(in_city);
            out_city = in_data.next();
            System.out.println(out_city);
            cost = in_data.nextInt();
            System.out.println(cost);
            time = in_data.nextInt();
            System.out.println(time);
            
            graph.addEdge(in_city, out_city, cost, time);
            if(in_data.hasNext())
                go_to_next_line.equals(in_data.nextLine());
        }
        
        // While the query file has information, read and output to file
        while(in_query.hasNext()){
            in_city = in_query.next();
            out_city = in_query.next();
            time_or_cost = in_query.next();
            
        // Call shortest path algorithm to print out info
        graph.Dij(in_city, out_city, time_or_cost);
        }
        
        // Close scanners/printwriters
        in_data.close();
        in_query.close();
        out_file.close();
    }
    
}
