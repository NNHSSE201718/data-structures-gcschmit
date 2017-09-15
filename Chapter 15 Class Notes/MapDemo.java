import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
This program demonstrates a map that maps names to colors.
 */
public class MapDemo
{
    public static void main(String[] args)
    {
        //create Map: favoriteColors
        
        /*
         * The Map interface is a generic. The first type is the type of the key;
         *      the second, the type of the value.
         */
        Map<String, Color> favoriteColors = new HashMap<>();
        
        favoriteColors.put( "Isha", Color.BLUE );
        favoriteColors.put( "Adam", Color.ORANGE );
        favoriteColors.put( "Aidan", new Color( 0x47, 0x7F, 0xEB ));
        favoriteColors.put( "Shilpa", Color.CYAN );
        favoriteColors.put( "Handa", Color.BLUE );

        //create Set<String> keySet
        Set<String> keySet = favoriteColors.keySet();

        // Print all keys and values in the map
        for( String key : keySet )
        {
            System.out.println( key + ": " + favoriteColors.get( key ));
        }
    }
}
