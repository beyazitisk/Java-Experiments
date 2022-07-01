/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmatrix;

/**
 *
 * @author Beyazit
 */
public class Main {
    public static void main(String[] args){
    //For Part 1 Of The Homework STARTS FROM HERE
    
    CMatrix m1 = new CMatrix();
     m1.AssignRandom();
    m1.printMatrix();
    System.out.println("");
    m1.printMatrixWithPrime();
    CMatrix m2 = new CMatrix(10,20);
    m2.AssignRandom();
    CMatrix m3 = new CMatrix(20,10);
    m3.AssignRandom();
    CMatrix m4 = new CMatrix();
    m4 = m2.multiplyMatrices(m3);
    m4.printMatrixWithPrime();
    // END OF PART 1 OF THE EXPERIMENT
    
    
    //For Part 1 Of The Homework  STARTS FROM HERE
    CMatrix m5 = new CMatrix(1200,1200);
    m5.AssignRandom();
    CMatrix m6 = new CMatrix(1200,1200);
    m6.AssignRandom();
    CMatrix m7 = new CMatrix();
    m7 = m5.multiplyMatrices(m6);
    // END OF PART 2 OF THE EXPERIMENT
    }
}
