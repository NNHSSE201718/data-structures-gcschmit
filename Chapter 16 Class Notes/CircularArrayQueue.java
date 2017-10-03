import java.util.NoSuchElementException;

/**
An implementation of a queue as a circular array.
 */
public class CircularArrayQueue
{
    private Object[] elements;
    private int currentSize;
    private int head;
    private int tail;

    
    /**
     * Constructs an empty queue.
     */
    public CircularArrayQueue()
    {
        final int INITIAL_SIZE = 10;
        this.elements = new Object[INITIAL_SIZE];
        this.currentSize = 0;
        head = 0;
        tail = 0;
    }


    /**
     * Checks whether this queue is empty.
     * @return true if this queue is empty
     */
    public boolean empty()
    {
        return ( this.currentSize == 0 );
    }

    
    /**
     * Adds an element to the tail of this queue.
     * @param newElement the element to add
     */
    public void add( Object newElement )
    {
        this.growIfNecessary();
        
        this.currentSize++;
        elements[this.tail] = newElement;
        this.tail++;
        this.tail %= this.elements.length;
    }
    

    /**
     * Removes an element from the head of this queue.
     * @return the removed element
     */
    public Object remove()
    {
        if( this.currentSize == 0 )
        {
            throw new NoSuchElementException(); 
        }
        
        Object removed = this.elements[head];
        this.head = (this.head + 1) % this.elements.length;
        this.currentSize--;
        return removed;
    }


    /**
    Grows the element array if the current size equals the capacity.
     */


}//CircularArrayQueue
