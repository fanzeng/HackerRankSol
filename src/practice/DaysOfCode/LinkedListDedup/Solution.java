package practice.DaysOfCode.LinkedListDedup;

import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{

    public static Node removeDuplicates(Node head) {
      //Write your code here

      int currentVal;
      if (head == null) return head;
      Node deduped = new Node(head.data);
      Node dedupedHead = deduped;
      Node p = head.next;
      int previousVal = deduped.data;

      while(p != null){
          currentVal = p.data;
        //   System.out.println("currentVal = " + currentVal);
          if (currentVal != previousVal) {
              Node d = new Node(currentVal);
              deduped.next = d;
              previousVal = currentVal;
            //   System.out.println("deduped.data=" + deduped.data);
              deduped = deduped.next;
          }
          p = p.next;
      }
      return dedupedHead;
    }

    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }