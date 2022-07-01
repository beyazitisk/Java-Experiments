/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwBonus_isik;

/**
 *
 * @author Beyazit
 */
public class AVLNode {    
    
     public Integer idNr;// Holds the students id numbers
     public String Name; // name of the student
     public String Surname;//surname of the student
     public int height;//height of the node if height -1 it is the node at the bottom
     public AVLNode left;// left node that nodes point like below left and 
     public AVLNode right;//below right nodes
     
     public AVLNode(Integer idNr, String Name, String Surname)
     {
         this.idNr = idNr;
         this.Name= Name;
         this.Surname=Surname;
         height = 0;
         left = null;//initalized null 
         right = null;
     }
     void setName(String n, String s)
     {
         this.Name= n;
         this.Surname=s;
     }

 }