/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beyazıt_Isık_HW3;


/**
 *
 * @author Beyazit
 * @param <E>
 */

public class QueueNode<E> {//generic type yapıldı genel kullanım için ikili cinsten alıyor ve tutuyor
    E key;
    QueueNode next;
 

    public QueueNode(E key)//creates ikili node
    {
        this.key = key;
        this.next = null;
    }
}
 

class Queuex<ikili> {
    QueueNode front, rear;
 
    public Queuex()
    {
        this.front = this.rear = null;
    }
 
    void enqueue(ikili key)
    {
 
        QueueNode temp = new QueueNode(key);
 
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
 
        this.rear.next = temp;
        this.rear = temp;
    }
 
    // Method that removes front of the ikili
    void dequeue()
    {
        if (this.front == null)
            return;
 
        QueueNode temp = this.front;
        this.front = this.front.next;
 
        if (this.front == null)
            this.rear = null;
    }
    public boolean isEmpty(){
        return rear == null && front == null; //true if queue is empty false if not
    }
    public ikili peek()
    {
        if (isEmpty()) {
            System.out.println("SYSTEM ERROR NO ONE IN THE QUEUE!");
        }
 
        return (ikili) front.key;
    }
}

