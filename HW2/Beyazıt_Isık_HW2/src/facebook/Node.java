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
public class Node  {

    private Person data;
    private Node link;

    Node(Person d) {
        data = d;
        link = null;
    }

    public Person GetData() {
        return data;
    }

    public Node GetLink() {
        return link;
    }

    public void SetData(Person new_data) {
        data = new_data;
    }

    public void SetLink(Node new_link) {
        link = new_link;
    }
}
