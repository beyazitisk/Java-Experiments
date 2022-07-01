/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beyazıt_Isık_HW3;

/**
 *
 * @author Beyazit
 */
// A BFS based solution to count number of
// islands in a graph. 
import Beyazıt_Isık_HW3.QueueNode;
import Beyazıt_Isık_HW3.CustomLinkedList;

class MatrixFinder
{
    private CustomLinkedList linkedlist;
    public char [][] temp_matrix;
    public MatrixFinder(int mat[][])  
    {   
        this.temp_matrix = new char[11][14];
        this.linkedlist =new CustomLinkedList();
    }
    // Row x Col matrix
    static final int Row = 11; 
    static final int Col = 14 ;
    static class ikili
    {
            int first, second;
            public ikili(int first, int second)
            {
                    this.first = first;
                    this.second = second;
            }
    }


    boolean isSafe(int mat[][], int i, int j, boolean vis[][])
    {
            return (i >= 0) && (i < Row) &&
                    (j >= 0) && (j < Col) &&
                    (mat[i][j]==1 && !vis[i][j]);
    }

    void Search(int mat[][], boolean visit[][],
                                    int visiti, int visitj)
    {

            int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };//to check all neighbours 1 row index 1 col index like (-1,-1) , (-1,0)


            Queuex<ikili> queue = new Queuex<ikili>();
            queue.enqueue(new ikili(visiti, visitj));
            visit[visiti][visitj] = true;


            
            while (!queue.isEmpty())
            {
                    int i = queue.peek().first;
                    int j = queue.peek().second;
                    queue.dequeue();
                    this.temp_matrix[i][j]= '*';
                    for (int k = 0; k < 8; k++)
                    {
                            if (this.isSafe(mat, i + row[k],j + col[k], visit))
                            {
                                this.temp_matrix[i+row[k]][j + col[k]]= '*';
                                
                                visit[i + row[k]][j + col[k]] = true;
                                queue.enqueue(new ikili(i + row[k], j + col[k]));
                            }
                    }
                    
            }
    }


    public Object ShapeFind(int mat [][])
    {
            
            boolean [][]visit = new boolean[Row][Col];


            int res = 0;
            for (int i = 0; i < Row; i++)
            {
                    for (int j = 0; j < Col; j++)
                    {
                            if (mat[i][j]==1 && !visit[i][j])
                            {
                                    this.Search(mat, visit, i, j);
                                    linkedlist.Append(temp_matrix);
                                    this.temp_matrix = new char[11][14];
                                    res++;
                            }
                    }
            }
            return linkedlist ;
    }


}

