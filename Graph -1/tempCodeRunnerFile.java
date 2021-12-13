public static void main(String[] args) throws IOException {
        
            System.out.println("Enter the number of vertices and edges : ");
            String[] ve = br.readLine().split("\s");
            int n = Integer.parseInt(ve[0]);
            int e = Integer.parseInt(ve[1]);
            int adj_matrix[][] = new int[n][n];
            
            System.out.println("Enter the edges : ");
            for(int i=0; i<e; i++){
                String[] str_arr = br.readLine().split("\s");
                int v1 = Integer.parseInt(str_arr[0]);
                int v2 = Integer.parseInt(str_arr[1]);
                adj_matrix[v1][v2] = 1;
                adj_matrix[v2][v1] = 1;
            }

            System.out.println("\nThe Adjacency Matrix is : \n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(adj_matrix[i][j] + " ");
                System.out.println();
            }

            // print the Depth First Traversal of graph
            //DF(adj_matrix);
            BF(adj_matrix);
    }