// Mohammad Malik
import java.util.Scanner;
import java.util.HashMap;

public class cmsc401{

public static HashMap<Integer, Integer> hmap = new HashMap<>();

    static class Graph{
        int vertices;
        int matrix[][];

        public Graph(int vertex) {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight) {

            matrix[source][destination] = weight + hmap.get(destination);
            matrix[destination][source] = weight + hmap.get(source);
        }

        int getMinimumVertex(boolean [] mst, int [] key){
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <vertices ; i++) {
                if(mst[i]==false && minKey>key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        public void dijkstra_GetMinDistances(int sourceVertex){
            boolean[] spt = new boolean[vertices];
            int [] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;

            for (int i = 0; i <vertices ; i++) {
                distance[i] = INFINITY;
            }

            distance[sourceVertex] = 0;

            for (int i = 0; i <vertices ; i++) {

                int vertex_U = getMinimumVertex(spt, distance);

                spt[vertex_U] = true;

                for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
                    if(matrix[vertex_U][vertex_V]>0){

                        if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY){
                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            
                            if(newKey<distance[vertex_V])
                                distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            printDijkstra(sourceVertex, distance);
        }

        public void printDijkstra(int sourceVertex, int [] key){
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + key[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph(vertices);
        //hmap.put(0, 0);
        //hmap.put(1, 0);

        for(int i = 0; i < vertices - 2; i++){
            int cityNum = sc.nextInt();
            int motelPrice = sc.nextInt();
            hmap.put(cityNum-1, motelPrice);
        } 

        for(int i = 0; i < edges; i++){
            int source = sc.nextInt() - 1;
            int destination = sc.nextInt() - 1;
            int weight = sc.nextInt();
            graph.addEdge(source, destination, weight);
        }
        
        int sourceVertex = 0;
        graph.dijkstra_GetMinDistances(sourceVertex);
        sc.close();
    }
}