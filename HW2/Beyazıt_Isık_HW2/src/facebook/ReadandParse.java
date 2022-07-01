/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

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
    private DataBase database;

    public ReadandParse() {
        this.database = new DataBase();
        try {
            this.myfile = new File("src/facebook/Input.txt");
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

    public void get_func() {
        String data = get_line();
        String parts[] = data.split(" ");
        String param1;
        String param2;
        char c = data.charAt(0);
        switch (c) {
            case 'I':
                {
                    param1 = parts[1];
                    Person person = database.SearchName(param1);
                    if (person != null) {
                        person.IncreaseHit();
                        
                    } else {
                        Person person_new = new Person(param1);
                        database.AddPerson(person_new);
                    }       break;
                }
            case 'F':
                param1 = parts[1];
                param2 = parts[2];
                database.AddFriend(param1, param2);
                break;
            case 'D':
                {
                    param1 = parts[1];
                    Person person = database.SearchName(param1);
                    if (person == null) 
                    {
                        System.out.println(param1 + " is not in Database");
                        return;
                    }       database.DeletePerson(param1);
                    
                    //System.out.println(param1);
                    break;
                }
            case 'P':
                {
                    param1 = parts[1];
                    Person person = database.SearchName(param1);
                    if (person == null) {
                        System.out.println(param1 + " is not in Database ");
                    } 
                    else if (person.FriendList == null) {
                        System.out.println(param1 + " has no friend");
                    } 
                    else {
                        String friend_names = person.GetFriendNames();
                        System.out.println(param1 + " friends are " + friend_names);
                        
                    }       break;
                }
            case 'W':
                database.FindMostPopular();
                break;
            case 'O':
                database.OutputList(); //
                break;
            case 'X':
                //System.out.println(database.toString());
                reader.close();      
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
