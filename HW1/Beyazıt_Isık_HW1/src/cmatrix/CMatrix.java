/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmatrix;
import java.util.Random;
/**
 *
 * @author Beyazit
 */
public class CMatrix {
     private long [][] elements; // Keeps the elements of matrix in two dimensional array
     private int row; // row size
     private int col; // column size
     private Random rand = new Random();
     private long [][] temp;
    public CMatrix(int row, int col){ //Constructor
        this.row = row;
        this.col = col;
        this.elements= new long [this.row][this.col];

    }
    public CMatrix(){ // Constructor generate matrix of size 10x10
        this.row=10;
        this.col=10;
        this.elements= new long [this.row][this.col];
    }


    public void AssignRandom(){ //Assigning random variables in range 1 - 10000
        for(int j=0;j<this.row;j++)
        {
            for(int i=0;i<this.col;i++)
            {
                this.elements[j][i]= rand.nextInt(10000);
            }
        }
    }
    public void printMatrix(){ // Printing matrix in matrix form
        for(int j = 0; j < this.row;j++)
        {
            for(int i = 0; i < this.col;i++)
            {  
                System.out.print(this.elements[j][i]+" ");
            }
            System.out.println();
            System.out.println();

        }
        System.out.println();
        System.out.println();
    }
    public void printMatrixWithPrime(){ //Prints the matrix with “*” sign near the prime elements
        long half;
        int prime = 0;
        for(int j = 0; j < this.row;j++)
        {   
            for(int i = 0; i < this.col;i++)
            {
                
                if (this.elements[j][i] == 0 || this.elements[j][i] == 1)
                {
                    System.out.print(this.elements[j][i]+" ");
                }  
                else
                {
                    half= (this.elements[j][i])/2;
                    for(int k=2; k<=half;k++)
                    {
                        if(((this.elements[j][i])%k )== 0)
                        {
                            prime=1;
                            break;
                        }
                    }
                    if(prime==1)
                    { 
                        System.out.print(this.elements[j][i]+" ");
                        prime=0;
                    }
                    else
                    {   
                        System.out.print(this.elements[j][i]+"* "); 
                    }             
                }
            }
            System.out.println();
            System.out.println();

        }
    }
    public CMatrix multiplyMatrices(CMatrix Multiplicand){ // Multiply two matrices and informs the user about time lapse
        int startTime = (int) System.currentTimeMillis();
        temp = new long[this.row][Multiplicand.col];
        for(int j = 0; j < this.row;j++)
        {
            for(int i = 0; i < Multiplicand.col;i++)
            {  
                for(int k = 0; k< this.col; k++)
                {
                    temp [j][i] += this.elements[j][k] * Multiplicand.elements[k][i];     
                }
            }
        }
        int endTime = (int) System.currentTimeMillis();
        endTime = endTime - startTime;
        System.out.println("The duration of multiplication of matrices " + this.row + "x" + this.col + " * " +  Multiplicand.row + "x" + Multiplicand.col + " is "+ endTime + " millisecond");
        System.out.println();
        return CMatrix.this;
    }
} 

