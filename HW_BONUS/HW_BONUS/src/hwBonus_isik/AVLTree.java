/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwBonus_isik;


 
import java.util.Scanner;
/**
 *
 * @author Beyazit
 */

 class AVLTree
 {
     private AVLNode root;     //root of the tree base thing
     private String  search_path;
     private boolean found=false; 
    
    public AVLTree()
    {
         root = null;//initializes the root as blank
    }
    int getBalance(AVLNode N) //returns the balance between child of that nodes
    { 
        if (N == null) 
            return 0; 
        return height(N.left) - height(N.right); 
    }
    private int max(int leftheight, int rightheight)//used for returning the maximum value for height calculation checkout bottom insert function?
    {
         if(leftheight>rightheight)
         {
             return leftheight;
         }
         else
         {
             return rightheight;
         }
     }
    private int height(AVLNode t )
    {
         if(t==null)
            return -1;// according to my researchs node without a child whic is null has a height of -1
         else
            return t.height;//otherwise return the recorded height
    }
    private AVLNode findMin(AVLNode node) 
    { 
        AVLNode current = node; 

        while (current.left != null) 
        current = current.left; 

        return current; 
    }
    private AVLNode rotatetotheright(AVLNode A)
    {
        AVLNode B = A.left;
        AVLNode temp = B.right;

        B.right = A;//swap
        A.left = temp;
 
        A.height = max(height(A.left), height(A.right)) + 1;//get the new heights
        B.height = max(height(B.left), height(B.right)) + 1;
 
       
        return B;//return the node
    }
 
    private AVLNode rotatetotheleft(AVLNode B)//x//y
    {
        AVLNode A = B.right;
        AVLNode temp = A.left;
 
        // Perform rotation
        A.left = B;
        B.right = temp;//swap
 
        // Update heights
        B.height = max(height(B.left), height(B.right)) + 1;
        A.height = max(height(A.left), height(A.right)) + 1;//get the new heights
 
        // Return new root
        return A;//return the node
    }
    public void insertStudent(Integer idNr, String name, String surname)//Polymorphism happened here
     {
         root = insertStudent(idNr,name,surname, root);// this method calls the insert method which works recursively
     }
    public AVLNode insertStudent(Integer idNr,String name, String surname, AVLNode node)//Polymorphism happened here
    {
        
        if (node == null)
            return (new AVLNode(idNr,name,surname));// means that if the root is null at the first node make a node 
 
        if (idNr < node.idNr)//if the idnumber of the newnode (idnr) less than the node that will be a child of that node
            node.left = insertStudent(idNr,name,surname, node.left);
        else if (idNr > node.idNr)
            node.right = insertStudent(idNr,name,surname, node.right);//if the idnumber of the newnode (idnr) greater than the node that will be a child of that node
        else
        {   System.out.println("Duplication found idNr="+idNr+" is not added to the system!");// this means that idnr already exits and can not be taken
            return node;
        }
        
        node.height = 1 + max(height(node.left), height(node.right));//calculate the nodes height max function used for taking out the maximum height of either the left node or right node add 1
 

        int balance = getBalance(node);//gets the balance
 
        
        if (balance > 1 && idNr < node.left.idNr)//Left heavy
            return rotatetotheright(node);
 
        
        if (balance < -1 && idNr > node.right.idNr)//Right heavy
            return rotatetotheleft(node);
 
        
        if (balance > 1 && idNr > node.left.idNr) // Left to right Case
        {
            node.left = rotatetotheleft(node.left);
            return rotatetotheright(node);
        }
 
        
        if (balance < -1 && idNr < node.right.idNr)// Right to left Case
        {
            node.right = rotatetotheright(node.right);
            return rotatetotheleft(node);
        }
        return node;
    }
    public void deleteStudent(int idNr)//Polymorphism happened here
     {
         root = deleteStudent(root,idNr);// this method calls the deleteStudent method which works recursively
     }
    public AVLNode deleteStudent(AVLNode root, int idNr) //Polymorphism happened here
    { 
        if (root == null) 
            return root; 
        
        if (idNr < root.idNr) //searches the nodee in the tree tree ordered as left to right in ascending order
            root.left = deleteStudent(root.left, idNr); 
        else if (idNr > root.idNr) 
            root.right = deleteStudent(root.right, idNr); 
        else
        { 
            if ((root.left == null) || (root.right == null)) // if righ child or left child is null
            { 
                AVLNode temp = null; 
                if (temp == root.left) // looks up which child is null either left or right must be null before this code
                    temp = root.right; 
                else
                    temp = root.left;
                
                if (temp == null) 
                { 
                    temp = root; 
                    root = null; 
                } 
                else 
                    root = temp; 
            } 
            else
            { 
                AVLNode temp = findMin(root.right);
                
                root.idNr = temp.idNr;
                root.Name =temp.Name;
                root.Surname =temp.Surname;
                root.right = deleteStudent(root.right, temp.idNr); 
            } 
        }
        
        if (root == null) 
            return root; 

        root.height = max(height(root.left), height(root.right)) + 1; 

        int balance = getBalance(root); 
        
        if (balance > 1 && getBalance(root.left) >= 0)//Left heavy
            return rotatetotheright(root);
 
        if (balance > 1 && getBalance(root.left) < 0)// Left to right Case
        {
            root.left = rotatetotheleft(root.left);
            return rotatetotheright(root);
        }
 
        if (balance < -1 && getBalance(root.right) <= 0)//Right heavy
            return rotatetotheleft(root);
 
        if (balance < -1 && getBalance(root.right) > 0)// Right to left Case
        {
            root.right = rotatetotheright(root.right);
            return rotatetotheleft(root);
        }
 
        return root;
    } 
      
    private AVLNode searchStudent(AVLNode r, int idNr)
    {
         while ((r != null) && !found)
         {
             int rval = r.idNr;
             if ((idNr < rval)&&!found)
             {
                 search_path=search_path+(r.idNr+" -(Left)->");
                 r = r.left;
             }
             else if ((idNr > rval)&&(!found))
             {
                 search_path=search_path+(r.idNr+" -(Right)->");
                 r = r.right;
             }
             else
             {
                 search_path=search_path+(idNr+"(Found)");
                 found = true;
             }
             if(found)
             {
                return r;
             }
            searchStudent(r, idNr);
         }
         return null;

    }
    public void processFile(String filename)
    {
        ReadandParse parser = new ReadandParse(filename);
        parser.studentParser();
    }
    public void printSearchPath(int idNr){
         AVLNode result;
         found=false;
         search_path="";
         result=searchStudent(root,idNr);
         if(found)
         {
            System.out.println(search_path);
         }
         else
         {
            System.out.println("The student with idNr:"+idNr+" is not existed in the system\n" );
         }
    }
    public void printwithinorder()//for debug
    {
        printwithinorder(root);
    }
    private void printwithinorder(AVLNode r)//for debug
    {
        if (r != null)
        {
            printwithinorder(r.left);
            System.out.print(r.idNr +" ");
            printwithinorder(r.right);
        }
    }   
 }
