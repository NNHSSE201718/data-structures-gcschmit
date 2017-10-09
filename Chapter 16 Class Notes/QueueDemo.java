public class QueueDemo
{
   public static void main(String[] args)
   {
      CircularArrayQueue q = new CircularArrayQueue();

      //add to q
      q.add( "Tom" );
      q.add( "Diana" );
      q.add( "Harry" );
      q.add( "a" );
      q.add( "b" );
      q.add( "c" );
      q.add( "d" );
      q.add( "e" );
      q.add( "f" );
      q.add( "g" );
      q.add( "h" );
      q.add( "i" );
      q.add( "j" );
      q.add( "k" );

      while (!q.empty())
      {
         System.out.println( q.remove());
      }
   }
}
