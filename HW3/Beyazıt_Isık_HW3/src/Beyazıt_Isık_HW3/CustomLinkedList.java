/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beyazıt_Isık_HW3;
import java.io.FileWriter;   

import java.io.IOException;   
/**
 *
 * @author Beyazit
 */
public class CustomLinkedList {
    public Node head;
    public void CustomLinkedList(){
        head = null;
    }
    public void Append(char[][] new_data)
    {
        Node new_node = new Node(new_data);
 

        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
 

        new_node.link=(null);
 

        Node last = head;
        while (last.link != null)
            last=last.link;
 
        last.link=new_node;
    }
    public String printList()
    {
        String string= new String("");
        int count =1;
        Node tnode = head;
        while (tnode != null) {
            System.out.println("Shape"+ count);
            string=(string +"Shape"+ count+"\n"); 
            string=(string +printMatrix(tnode.data));
            string=(string +"\n");  
            tnode = tnode.link;
            count ++;
        }
        //System.out.println("PRINT IT now  \n" +string); //debug purposes
        return string;
    }
    
    public String printMatrix(char char_matrix[][]){
        int min =1000;//there is a bug for the min when the matrix is in below first lines min always become zero so that Shape three does not become left aligned Line 103
        int temp=0;
        String string= new String("");
        int entercount=0;
        int maxenter=0;
        boolean exit_flag=false;
        for(int j = 0; j < 11;j++)
        {
            for(int i = 0; i < 14;i++)
            {  
                if(char_matrix[j][i]== '*')
                {

                    if(!exit_flag)
                    {
                        entercount=j;
                    }
                    exit_flag=true;

                    if(temp<min)
                    {
                        min=temp;
                    }
                    maxenter=j;
                    
                }
                else if (((int) char_matrix[j][i]== 0) && !exit_flag)
                {
                    temp++;
                }
            }
            temp=0;

        }
        maxenter+=1;
        //System.out.println(min);
        for(; entercount < maxenter;entercount++)
        {
            for(int i = 0; i < 14;i++)
            {  
                if (char_matrix[entercount][i]== '*'){
                    for(int k = 0; k<min; k++)
                    {
                        //string=(string +"\b");
                        string=string.trim();
                        System.out.print("\b");
                    }
                    string=(string +"*");
                    System.out.print("*");
                }
                else{
                    string=(string +" ");
                    System.out.print(" ");
                }
            }
        string=(string +"\n");
        System.out.println();
        System.out.println();
        //System.out.println("printing"+string);
        
        }
        //matrix_forstring= char_matrix;
        return string;
    }
    public void MatrixToFile(String path, String matrix_file_string) {
        String string= matrix_file_string;
        try 
        {  
            FileWriter filewrite = new FileWriter(path);  
            
            filewrite.write(string);   

            filewrite.close();   
        } 
        catch (IOException e) 
        {  
            System.out.println("Unexpected error occurred");  
            e.printStackTrace();  
        }  
      
    }
}
