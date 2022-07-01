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
public class CustomLinkedList {
    public Node head;
    public void CustomLinkedList(){
        head = null;
    }
        public void Append(Person new_data)
    {
        Node new_node = new Node(new_data);
 

        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
 

        new_node.SetLink(null);
 

        Node last = head;
        while (last.GetLink() != null)
            last=last.GetLink();
 
        last.SetLink(new_node);
    }
    public void printList()
    {
        Node tnode = head;
        while (tnode != null) {
            Person person_dummy = tnode.GetData();
            person_dummy.ContentOut();
            tnode = tnode.GetLink();
        }
    }
    public Person search(String x)
    {
        Node current = head;

        while (current != null)
        {
            Person person_dummy = current.GetData();
            String name = person_dummy.GetName();

            if (name.equals(x))         
                return person_dummy; 

            current = current.GetLink();
        }
        
        return null;
    }
    public Person SearchPopular()
    {
        Node current = head;   
        
        int max_popularity_count=0;
        Person temp = null;
        while (current != null)
        {               
            Person person = current.GetData();
            int temp_pop_count = person.GetHitCount ()* person.GetFriendListCount();
            if( max_popularity_count < temp_pop_count){
                max_popularity_count = temp_pop_count;
                temp = person;
            }
            current = current.GetLink();

        }
        return temp;
    }
    public String GetPersonNamesFromFriendName(String param1)
    {
        Node current = head;   
        
        Person temp = null;
        String person_names = "";
        while (current != null)
        {    
            
            Person person = current.GetData();
            boolean flag = person.SearchInFriendList(param1);
            if (flag){
                person_names += person.GetName() + " ";
            }
            current = current.GetLink();

        }
        return person_names;
    }
    void deleteNode(Person key)
    {

        Node temp = head, prev = null;
 

        if (temp != null && temp.GetData() == key) {
            head = temp.GetLink(); 
            return;
        }
 

        while (temp != null && temp.GetData() != key) {
            prev = temp;
            temp = temp.GetLink();
        }
 
        if (temp == null)
            return;
 
        prev.SetLink(temp.GetLink());
    }
    public String DatabasetoString() {
        String persons = "";
        Node tnode = head;
        while (tnode != null) {
            Person person_dummy = tnode.GetData();
            persons += person_dummy.GetName() + " ";
            tnode = tnode.GetLink();
        }
        return persons;
    }
}
