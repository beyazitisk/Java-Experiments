/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beyazıt_Isık_HW3;

import Beyazıt_Isık_HW3.Handler;
/**
 *
 * @author Beyazit
 */
public class main {

    /**
     * @param args the command line arguments
     */
 // Driver code
public static void main(String[] args)
    {

            Handler hand= new Handler(); //for handshake with other methods
            hand.ReadShapeFile("src/Beyazıt_Isık_HW3/HW3Q2.txt");
            hand.OutputShapes();
            hand.OutputShapesToFile("src/Beyazıt_Isık_HW3/Results.txt");
    }
    
}
