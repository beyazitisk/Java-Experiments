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
public class Friend
{
    private String Name;
    private Friend next=null;


 
    public String GetName()
    {
        return Name;
    }
    public Friend GetNext()
    {
        return next;
    }
    public void SetName(String new_name)
    {
        Name= new_name;
    }
    public void SetNext(Friend new_next)
    {
        next= new_next;
    }
} 

