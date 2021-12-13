import java.io.*;
import java.util.*;

/*
    sort = E logE
    picking n-1 edges with cycle detection = EV
    so time = E logE + EV
    
    for improvement hint watch "complexity of kruskal's algo"
*/
public class Kruskal {
 
    private static class Edge implements Comparable<Edge>{
        int v1, v2, weight;

        public Edge(){} // default constructor
        public Edge(int v1, int v2, int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Edge o){
            return this.weight - o.weight; // to sort the Edge array according to weight
        }
    }
    private static int V = 0;
    public static void main(String[] args) throws IOException {
        Edge[] input = takeInput();
        Arrays.sort(input); // sorts the Edge array in increasing order of weights
        Edge[] output = findMST(input);    // Minimum spanning tree
        print(output);
    }
    private static void print(Edge[] output) {
        for(Edge i : output){
            // need to write v in sorted manner
            int smaller_v = i.v1 < i.v2 ? i.v1 : i.v2;
            int larger_v = i.v1 < i.v2 ? i.v2 : i.v1;
            System.out.println(smaller_v + " " + larger_v + " " + i.weight);
        }
    }
    private static Edge[] takeInput() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split("\\s");
            int n = Integer.parseInt(ve[0]);
            if(n == 0) return null; // if no vertex then array out of bound exc
            V = n; // no of  vertices -1
            int e = Integer.parseInt(ve[1]);

            Edge[] input = new Edge[e];

            for(int i=0; i<e; i++){
                input[i] = new Edge();
                String[] str_arr = br.readLine().split("\\s");
                input[i].v1 = Integer.parseInt(str_arr[0]);
                input[i].v2 = Integer.parseInt(str_arr[1]);
                input[i].weight = Integer.parseInt(str_arr[2]);
            }

            return input;
    }
    private static Edge[] findMST(Edge[] input){
        Edge[] output = new Edge[V-1];
        int[] parent = new int[V];
        for(int i=0; i<V; i++) parent[i] = i; // initialize parent of every vertiex as itself
        int count = 0;
        for(int i=0; i<input.length; i++){
            int v1 = input[i].v1;
            int v2 = input[i].v2;
            // Union find algo.. if parents same then cycle will form
            int sourceParent = topMostParent(v1, parent);
            int destParent = topMostParent(v2, parent);
            if(sourceParent == destParent) continue;
            output[count++] = new Edge(v1, v2, input[i].weight); // add edge to output array
            parent[sourceParent] = destParent; // chaneg the source parent's parent.. not the immediate one
            if(count == V-1) break; // acyclic graph (tree) have -1 edges
        }
        return output;
    }
    private static int topMostParent(int v, int[] parent) {
        while(v != parent[v]) v = parent[v];
        return v;
    }   
}