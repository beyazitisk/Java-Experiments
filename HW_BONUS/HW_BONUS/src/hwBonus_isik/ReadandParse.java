/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwBonus_isik;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 *
 * @author Beyazit
 */
public class ReadandParse {

    private File myfile;
    private Scanner reader;
    Scanner IntegerScanner = new Scanner(System.in);
    
    public ReadandParse(String path) {
        try {
            this.myfile = new File(path);
            this.reader = new Scanner(myfile);
        } catch (FileNotFoundException x) {
            System.out.println("There is an error in reading file please check if the file path correct ");
            x.printStackTrace();
        }
    }
    private String get_line() {
        String data = this.reader.nextLine();
        return data;
    }

    public void studentParser() {
        AVLTree AVLHandler = new AVLTree(); 
        int i =0;
        String starting_params = get_line();
        String starting_params_parts[] = starting_params.split(" ");
        Integer add = Integer.valueOf(starting_params_parts[0]);
        Integer delete=Integer.valueOf(starting_params_parts[1]);
        
        for(i =0; i <add; i++)
        {
            String data = get_line();
            String parts[] = data.split(" ");
            Integer idval = Integer.valueOf(parts[0]);
            AVLHandler.insertStudent(idval, parts[1],parts[2]);
            //System.out.println(" ");
        }
        for(i = 0; i <delete; i++)
        {
            String data = get_line();
            String parts[] = data.split(" ");
            Integer idval = Integer.valueOf(parts[0]);        
            AVLHandler.deleteStudent(idval);
            //System.out.println(" ");
            
        }
        int choice;
        System.out.println("Type the value that you want to search or type 0 to terminate the program\n");
        choice= IntegerScanner.nextInt();                 
        while (choice != 0)
        {
            AVLHandler.printSearchPath(choice);
            System.out.println("Type the value that you want to search or type 0 to terminate the program\n");
            choice= IntegerScanner.nextInt(); 
        }
        //AVLHandler.printwithinorder(); //to see the tree debug purposes
    }
}
