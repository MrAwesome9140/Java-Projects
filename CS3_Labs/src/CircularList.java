public class CircularList
{
   private ListNode head; // front of the LinkedList
   private ListNode tail; // last node of the LinkedList
   private int size; // size of the LinkedList
   
   // constructs a new CircularList
   public CircularList()
   {
      head = null;
      tail = null;
      size = 0;
   }
   
   // returns the size of the array
   public int size()
   {
      return size;
   }
   
   // returns whether the list is empty
   public boolean isEmpty()
   {
      return size==0;
   }
   
   // returns the value of the first node
   public Integer first()
   {
      return (Integer) head.getValue();
   }
   
   // returns the value of the last node
   public Integer last()
   {
      return (Integer) tail.getValue();
   }

   // adds a node to the front of the list
   public void addFirst(Integer value)
   {
     ListNode temp = new ListNode(value, null); // Create new ListNode
     temp.setNext(head); // Front is next to temp
     if(tail!=null)
      tail.setNext(temp); // Makes it circular, head is in front of tail
     head = temp; // Front becomes temp
     size++; // Increase size
     if(size==1)
        tail = temp; // Temp is head and tail
   }
   
   // adds a node to the end of the list
   public void addLast(Integer value)
   {
     ListNode temp = new ListNode(value, null); // Create new ListNode
     if(tail!=null)
      tail.setNext(temp); // Temp comes after current tail
     temp.setNext(head); // Makes list circular, head comes after tail
     tail = temp; // Tail is temp
     size++; // Increase size
   }
    
   // adds a node at the position pos 
   public void addAtPos(int pos, Integer value)
   {
      if(pos==0)
         addFirst(value); // Add value at head
      else if(pos==size)
         addLast(value); // Add value at tail
      else {
         ListNode temp = head;
         int i = 0;
         // Traverse through list until we reach the
         // position before the one where we want to add the new node
         while (i < pos - 1) {
            temp = temp.getNext();
            i++;
         }
         ListNode add = new ListNode(value, null); // Create new ListNode
         add.setNext(temp.getNext()); // Set temp's next to be node currently at position pos
         temp.setNext(add); // Let temp be the node after the node at the index before it
         size++; // Increase size
      }
   }
   
   // removes the first node and returns the value of the removed node or -1 if the list is empty
   public Integer removeFirst()
   {
      if(head!=null){
         int val = (int)head.getValue(); // Store value of front
         tail.setNext(head.getNext()); // Set node next to head to be next to tail
         head = head.getNext(); // Head becomes node after current head
         size--; // Reduce size
         return val; // Return value of previous head
      }
      else
         return -1;
   }
   
   // removes the node at position pos and returns the value of the removed node or -1 if pos is not a valid position
   public Integer removeNode(int pos)
   {
       if(pos<0)
          return -1;
       else{
          ListNode temp = head;
          int i = 0;
          // Traverse through list until we reach the
          // position before the one where we want to remove the node
          while(i<pos-1) {
             temp = temp.getNext();
             i++;
          }
          int val = (int)temp.getNext().getValue(); // Save value of node we are removing
          temp.setNext(temp.getNext().getNext()); // Set the node after temp to be the node after the node we are removing
          size--; // Reduce size
          return val;
       }
   } 
   
   // finds and returns the position of find, or -1 if not found
   public int findNode(Integer find)
   {
       int i = 0;
       ListNode temp = head;
       // Travers through list until we find the value, or else return -1
       while(i<size){
          if(temp.getValue()==find)
             return i;
          i++;
       }
       return -1;
   }  
   
   // rotates the list as described in the word document
   public void rotate()
   {
      //Move head and tail one node forward each
      tail = head;
      head = tail.getNext();
   }
   
   // returns the list of values in the LinkedList
   public String toString()
   {
      String output = "";
      ListNode temp = head;
      int i = 0;
      while(i<size){
         System.out.print(temp.getValue()+" ");
         temp = temp.getNext();
         i++;
      }
      return output;
   }
         
}