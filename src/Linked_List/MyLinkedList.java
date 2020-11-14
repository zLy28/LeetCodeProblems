package Linked_List;
// Answer from Leetcode by vasuleet
class MyLinkedList {


    Node head;
    int  size;
    class Node {
        int data;
        Node next;

        Node(int d){
            this.data=d;
        }
    }


    public MyLinkedList() {
        this.head=null;
        this.size=0;
    }

    public int get(int index) {

        if(index >= this.size || index<0) {
            return -1;
        }
        else {
            Node temp = this.head;
            for(int i=0;i<index;i++) {
                temp=temp.next;
            }
            return temp.data;
        }





    }

    public void addAtHead(int val) {

        Node newnode = new Node(val);
        if(head==null) {
            this.head=newnode;
        }
        else {
            newnode.next = this.head;
            this.head=newnode;
        }
        this.size++;
    }


    public void addAtTail(int val) {

        Node newnode = new Node(val);
        if(head==null) {
            this.head=newnode;
        }
        else {

            Node temp = this.head;
            while(temp.next!=null) {
                temp=temp.next;
            }
            temp.next=newnode;

        }
        this.size++;

    }

    public void addAtIndex(int index, int val) {

        if(index<0) {
            return;
        }
        else if(index==0) {
            addAtHead(val);
        }
        else if(this.size==index) {
            addAtTail(val);
        }
        else {
            Node newnode = new Node(val);
            Node temp = this.head;
            for(int i=0;i<index-1;i++) {
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next=newnode;
            this.size++;
        }
    }
    public void removeFirst() {

        if(this.size==0) {
            return;
        }
        else if(this.size==1) {

            this.head=null;
            this.size=0;
        }
        else {
            this.head=head.next;
            this.size--;
        }


    }
    public void removeLast() {
        if (this.size == 0) {
            return;
        } else if (this.size == 1) {
            this.head =  null;
            this.size = 0;
        } else {
            Node temp = this.head;
            while(temp.next.next!=null) {
                temp=temp.next;
            }
            temp.next=null;

            this.size--;
        }

    }

    public void deleteAtIndex(int index) {

        if(index > this.size-1 || index<0) {
            return;
        }
        else if(index==0) {
            removeFirst();
        }
        else if(index==this.size-1) {

            removeLast();
        }
        else {
            Node temp = this.head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            temp.next=temp.next.next;
            this.size--;
        }

    }




}