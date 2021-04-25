package com.example111.womenssafetysystem;

import java.util.ArrayList;

class Dijesktra {

    static final int V = 20;
     int [] tt =new int[5];
   static int minDistance(int dist[], Boolean visited[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }




    static Integer dijkstra(int graph[][],int []loc, Integer src, Integer Destination) {
         int[] dist =new int[V];
        Boolean visited[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;
        int count1=-1;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);
                    loc[count]=u;
                visited[u] = true;

                   

                for (int v = 0; v < V; v++) {

                    if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];
                }

            }


        return dist[Destination];
    }

}
