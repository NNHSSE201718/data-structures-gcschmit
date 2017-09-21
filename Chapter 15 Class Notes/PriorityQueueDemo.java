import java.util.PriorityQueue;

/**
This program demonstrates a priority queue of work orders. The
most important work orders are removed first.
 */
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        //create PriorityQueue of WorkOrder
        PriorityQueue<WorkOrder> q = new PriorityQueue<>();

        // add several WorkOrder objects
        q.add( new WorkOrder( 3, "shampoo carpets" ));
        q.add( new WorkOrder( 7, "empty trash" ));
        q.add( new WorkOrder( 8, "water plants" ));
        q.add( new WorkOrder( 10, "remove pencil sharpener shavings" ));
        q.add( new WorkOrder( 6, "replace light bulb" ));

        // display WorkOrder and you "finish"/remove from the list
        while (q.size() > 0)
        {
            System.out.println( q.remove());
        }
    }
}
