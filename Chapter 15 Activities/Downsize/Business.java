package Downsize;

import java.util.LinkedList;
import java.util.ListIterator;

/**
Business utility methods.
 */
public class Business
{
    /**
    Removes every nth element from the linked list
    @param employeeNames the linked list to remove from
    @param n the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {
        ListIterator<String> i = employeeNames.listIterator();
        int count = 0;
        while( i.hasNext())
        {
            count++;
            i.next();
            if( count % n == 0 )
            {
                i.remove();
            }
        }
    }
}
