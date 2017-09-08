import java.util.LinkedList;
import java.util.ListIterator;

/**
   This program demonstrates the LinkedList class.
*/
public class ListDemo
{
   public static void main(String[] args)
   {
       LinkedList<String> staff = new LinkedList<>();
       staff.addLast( "Diana" );
       staff.addLast( "Harry" );
       staff.addLast( "Romeo" );
       staff.addLast( "Tom" );
       
       // the list is currently: DHRT

       // | in the comments indicates the iterator position
       
       ListIterator<String> iterator = staff.listIterator();    // |DHRT

                    // |DHRT
                    // D|HRT
                    // DH|RT

      // Add more elements after second element

                    // DHJ|RT
                    // DHJN|RT

                    // DHJNR|T

      // Remove last traversed element

                    // DHJN|T

      // Print all elements

      System.out.println(staff);
      System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");
   }
}
