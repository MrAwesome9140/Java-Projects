import static java.lang.System.*;

public class CircularListRunner
{
   public static void main(String [] args)
   {
      CircularList test = new CircularList();
      test.addFirst(10);
      test.addFirst(20);
      test.addLast(30);
      test.addAtPos(2, 40);
      test.addAtPos(0, 50);
      test.addAtPos(5, 60);
    
      out.println("size = " + test.size() + " first = " + 
      	           test.first() + " last = " + test.last());
      out.println(test + "\n");
      
      out.println("removeFirst = " + test.removeFirst());
      out.println("size = " + test.size() + " first = " + 
      	           test.first() + " last = " + test.last());
      out.println(test + "\n");
      
      out.println("removed = " + test.removeNode(3));
      out.println("size = " + test.size() + " first = " + 
      	           test.first() + " last = " + test.last());
      out.println(test + "\n");
      
      out.println("size = " + test.size() + " first = " + 
      	           test.first() + " last = " + test.last());
      out.println(test + "\n");
   
      out.println("found at " + test.findNode(30));
      out.println("removed = " + test.removeNode(test.findNode(30)));
      out.println("size = " + test.size() + " first = " + 
      	           test.first() + " last = " + test.last());
      out.println(test + "\n");
      
      test.rotate();
      out.println("size = " + test.size() + " first = " + 
      	           test.first() + " last = " + test.last());
      out.println(test);
   }
}