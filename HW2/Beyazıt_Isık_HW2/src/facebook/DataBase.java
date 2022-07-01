/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

/**
 *
 * @author Beyazit
 */
public class DataBase implements DataBaseInterface {
    public Node head;
    CustomLinkedList linker = new CustomLinkedList();

    public Person SearchName(String tName) {
        Person person = linker.search(tName);
        return person;

    }

    public void OutputList() {
        linker.printList();
    }

    public boolean AddPerson(Person tNewPerson) {
        
        linker.Append(tNewPerson);
        return true;
    }

    public boolean DeletePerson(String pName) {
        String person_names= linker.GetPersonNamesFromFriendName(pName);
        Person person = this.SearchName(pName);
        if(person_names.equals("") )
        {
            linker.deleteNode(person);
            System.out.println(pName +" is deleted ");

            return true;
        }
        else{
            System.out.println(pName +" cant be deleted "+ pName +" is friend of " + person_names);
            return false;
        }
    }

    @Override
    public String toString() {
        String persons = "";
        persons = linker.DatabasetoString();
        return persons;
    }

    public boolean AddFriend(String Name1, String Name2) {
        Person person1 = this.SearchName(Name1);
        Person person2 = this.SearchName(Name2);
        if ((person1 != null) && (person2 != null)) {
            if(person1.FriendList !=null)
            {
                boolean is_friend_flag = person1.SearchInFriendList(Name2);
                if(is_friend_flag == true)
                {
                    System.out.println("No need to add");

                }
                else
                {
                    person1.Append(person2);
                    System.out.println(Name2 +" is Friend of " +Name1);
                }
            }
            else
            {
                person1.Append(person2);
                System.out.println(Name2 +" is Friend of " +Name1);
            }
        }
        return false;
    }

    public void FindMostPopular() {
        Person most_popular = linker.SearchPopular();
        System.out.println("Most popular person is "+ most_popular.GetName());
    }
}
