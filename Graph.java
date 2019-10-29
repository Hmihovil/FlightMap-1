/*
Camryn Rogers
cpr170030
CS 3345.003
 */
package flight;

import java.util.*;

public class Graph {
    
    int num_v = 0;
    ArrayList<Vertex> vertArray = new ArrayList<Vertex>();
    
    // Add edge to graph
    public boolean addEdge(String source, String destination, int cost, int time){
        
        // Create vertices for source and destination
        Vertex sourceVert = null, destVert = null, currVert = null;
        
        // Get the start and end vertices
        for(int i = 0; i < vertArray.size(); i++){
            currVert = vertArray.get(i);
            if(source.equals(currVert.name)){
                sourceVert = currVert;
            }
            else if(destination.equals(currVert.name)){
                destVert = currVert;
            }
        }
        
        // If null, create vertex and add it to the vertex array
        if(sourceVert == null){
            sourceVert = new Vertex(source, vertArray.size());
            vertArray.add(sourceVert);
        }
        
        if(destVert == null){
            destVert = new Vertex(destination, vertArray.size());
            vertArray.add(destVert);
        }
        
        // Create an edge with vertices
        sourceVert.addEdge(destVert, cost, time);
        
        // Return true
        return true;
    }
    
    // Vertex and Edge classes
    public class Vertex implements Comparator<Vertex>{
        String name = null;
        int cost = 0;
        boolean known = false;
        ArrayList AdjList = new ArrayList<>();
        int number;
        
        // Constructor
        Vertex(){}
        
        // Overloaded Constructor
        Vertex(String name, int number){
            this.name = name;
            this.number = number;
        }
        
        // Create edge class
        public class Edge{
            int cost;
            int time;
            Vertex end;
            
            // Edge constructor
            Edge(){}
            
            // Edge overloaded constructor
            Edge(Vertex end, int cost, int time){
                this.end = end;
                this.cost = cost;
                this.time = time;
            }
        }
        
        // Add edge to vertex
        public void addEdge(Vertex destination, int cost, int time){
            AdjList.add(new Edge(destination, cost, time));
        }
        
        @Override
        public int compare(Vertex ver1, Vertex ver2){
            
            if(ver1.cost < ver2.cost)
                return -1;
            if(ver1.cost > ver2.cost)
                return 1;
            return 0;
        }
    }

    // Dij. algo
    public String Dij(String source, String destination, String CorT){
    
        // Create vertices for source and destination
        Vertex sourceVert = null, destVert = null, currVert = null;
        boolean money = false;
        
        if(CorT.equals("C")){
            money = true;
        }
        
        for(int i = 0; i < vertArray.size(); i++){
            currVert = vertArray.get(i);
            if(source.equals(currVert.name)){
                sourceVert = currVert;
            }
            else if(destination.equals(currVert.name)){
                destVert = currVert;
            }    
        }
        
        // Some variables
        int numVerts = vertArray.size();
        int dist[] = new int[numVerts];
        Set<Integer> settled = new HashSet<Integer>();
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(numVerts, new Vertex());
        ArrayList<Vertex> adj = vertArray;
        
        // Initialize to max value
        for(int i = 0; i < numVerts; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        if(sourceVert == null || destVert == null){
            return "No flight available";
        }
        
        // Add source to priority queue
        pq.add(sourceVert);
        dist[sourceVert.number] = 0;
        
       /* while(settled.size() != numVerts){
            int x = pq.remove().number;
            settled.add(x);
            neighbors(adj, settled, dist, x, money, pq);
        }*/
        
        return "";
        
    }
    
    public void neighbors(ArrayList<Vertex> adj, Set<Integer> settled, int dist[], 
            int x, boolean money,PriorityQueue<Vertex> pq ){
        
        // Distances
        int edgeDist  = -1, newDist = -1;
        /*
        for(int i = 0; i < adj.get(x).AdjList.size(); i++){
            Vertex v = (Vertex)adj.get(x).AdjList.get(i);
            
            // If vertex hasn't been settled, do it
            if(!settled.contains(v.number)){
                edgeDist = v.cost;
                newDist = dist[x] + edgeDist;
                
                if(newDist < dist[v.number])
                    dist[v.number] = newDist;
                
                Vertex toAdd = new Vertex(v.name, v.number);
                toAdd.cost = dist[v.number];
                pq.add(toAdd);
            }
            
        }
        */
    }
    
}
