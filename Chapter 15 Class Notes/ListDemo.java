import java.util.LinkedList;
import java.util.ListIterator;

/**
This program demonstrates the LinkedList class.
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        /*
         * the addLast method of LinkedList can be used to populate a list
         */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast( "Diana" );
        staff.addLast( "Harry" );
        staff.addLast( "Romeo" );
        staff.addLast( "Tom" );
        
        // the list is currently: DHRT
        
        /*
         * the listIterator method creates a new iterator that is positioned
         *      at the front of the list
         * the "|" in the comment indicates the iterator position
         */
        ListIterator<String> iterator = staff.listIterator();   // |DHRT
        
        /*
         * the next method advances the iteartor over the next element in the list
         */
        iterator.next(); // D|HRT
        
        /*
         * the next method also returns the element that the iterator is passing
         */
        String name = iterator.next(); // DH|RT
        System.out.println( name );
        System.out.println( "Expected: Harry" );
        
        /*
         * the add method inserts an element at the iterator position
         *      the iterator is then positioned after the element that was added
         */
        iterator.add( "Juliet" ); // DHJ|RT
        iterator.add( "Nina" ); // DHJN|RT
        
        /*
         * the remove method removes the element returned by the last call to
         *      next or previous
         *  the remove method can only be called once after calling next or
         *      previous
         *  the remove method cannot be called after calling add
         */
        iterator.next(); // DHJNR|T
        iterator.remove(); // DHJN|T
        
        System.out.println(staff);
        System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");
        
        /*
         * the set method updates the element returned by the last call to
         *      next or previous
         */
        iterator.previous(); // DHJ|NT
        iterator.set( "Albert" ); // DHJ|AT
        
        /*
         * the hasNext method is often used in the context of a while loop
         */
        iterator = staff.listIterator(); // |DHJAT
        while( iterator.hasNext() )
        {
            String n = iterator.next();
            if( n.equals( "Juliet" ))
            {
                iterator.remove();
            }
        }
        
        /*
         * enhanced for loops work with linked lists because they implement
         *      the List interface
         */
        for( String n : staff )
        {
            System.out.print( n + " " );
        }
        System.out.println();
        System.out.println( "Expected Diana, Harry, Albert, Tom" );
        

    }
    
}




