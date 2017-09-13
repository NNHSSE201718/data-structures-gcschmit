import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;

/**
This program checks which words in a file are not present in a dictionary.
 */
public class SpellCheck
{
    public static void main(String[] args)
    throws FileNotFoundException
    {
        // Read the dictionary and the document
        Set<String> dictionaryWords = readWords( "words" );
        Set<String> documentWords = readWords( "alice30.txt" );

        // Print all words that are in the document but not the dictionary

        /*
         * the enhanced for loop works with sets (so does iterators with the
         *        hasNext method)
         */
        for( String word : documentWords )
        {
            if( !dictionaryWords.contains( word ))
            {
                System.out.println( word );
            }
        }
        
        /*
         * Remove all words in the document with less than 4 letters.
         *      Print the number of unique words in the document with more
         *          than three letters.
         */
        
        System.out.println( "unique words: " + documentWords.size());
        
        /*
         * An Iterator only supports three methods: hasNext, next, and remove.
         */
        Iterator<String> i = documentWords.iterator();
        while( i.hasNext() )
        {
            if( i.next().length() < 4 )
            {
                i.remove();
            }
        }
        
        System.out.println( "unique words (> 3 letters): " + documentWords.size());
    }

    /**
    Reads all words from a file.
    @param filename the name of the file
    @return a set with all lowercased words in the file. Here, a
    word is a sequence of upper- and lowercase letters.
     */
    public static Set<String> readWords(String filename)
    throws FileNotFoundException
    {
        /*
         * The implementation of the Set doesn't matter; so, store the
         *       reference in a variable of type Set.
         */
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner( new File( filename ));

        // use any characters other than a-z or A-Z as deliminters
        in.useDelimiter( "[^a-zA-Z]+" );

        while( in.hasNext())
        {
            /*
             * adding dupliates is ignored
             *      (so is removing elements that don't exist)
             */
            words.add( in.next().toLowerCase() );
        }
        
        return words;
    }
}
