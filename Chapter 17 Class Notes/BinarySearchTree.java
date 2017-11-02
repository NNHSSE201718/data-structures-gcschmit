/**
This class implements a binary search tree whose
nodes hold objects that implement the Comparable
interface.
 */
public class BinarySearchTree
{  
    private Node root;

    /**
    Constructs an empty tree.
     */
    public BinarySearchTree()
    {  
        this.root = null;
    }

    /**
    Inserts a new node into the tree.
    @param obj the object to insert
     */
    public void add(Comparable obj) 
    {  
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        
        if( this.root == null )
        {
            this.root = newNode;
        }
        else
        {
            this.root.addNode( newNode );
        }
    }

    /**
    Tries to find an object in the tree.
    @param obj the object to find
    @return true if the object is contained in the tree
     */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        while( current != null )
        {
            int diff = obj.compareTo( current.data );
            if( diff == 0 )
            {
                return true;
            }
            else if( diff < 0 )
            {
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }
        
        return false;
    }

    /**
    Tries to remove an object from the tree. Does nothing
    if the object is not contained in the tree.
    @param obj the object to remove
     */
    public void remove(Comparable obj)
    {
        // find the node to be removed
        
        Node toBeRemoved = this.root;
        Node parent = null;
        boolean found = false;
        
        while( !found && toBeRemoved != null )
        {
            int diff = obj.compareTo( toBeRemoved.data );
            if( diff == 0 )
            {
                found = true;
            }
            else
            {
                parent = toBeRemoved;
                if( diff < 0 )
                {
                    toBeRemoved = toBeRemoved.left;
                }
                else
                {
                    toBeRemoved = toBeRemoved.right;
                }
            }   
        }
        
        if( !found )
        {
            return;
        }
        
        // toBeRemoved refers to the element to remove
        
        // if one of the children is empty, use the other child
        //      Case 1 & 2
        if( toBeRemoved.left == null || toBeRemoved.right == null )
        {
            Node newChild;
            if( toBeRemoved.left == null )
            {
                newChild = toBeRemoved.right;
            }
            else
            {
                newChild = toBeRemoved.left;
            }
            
            if( parent == null )
            {
                root = newChild;
            }
            else if( parent.left == toBeRemoved )
            {
                parent.left = newChild;
            }
            else
            {
                parent.right = newChild;
            }
            
            return;
        }
        
        // neither subtree of the node to be removed is empty (case 3)
        
        // find the smallest element of the right subtree
        Node smallestParent = toBeRemoved;
        Node smallest = toBeRemoved.right;
        while( smallest.left != null )
        {
            smallestParent = smallest;
            smallest = smallest.left;
        }
        
        // smallest contains the smallest child in the right subtree
        
        // move data
        toBeRemoved.data = smallest.data;
        
        // unlink child
        if( smallestParent == toBeRemoved )
        {
            smallestParent.right = smallest.right;
        }
        else
        {
            smallestParent.left = smallest.right;
        }
    }

    /**
    Prints the contents of the tree in sorted order.
     */
    public void print()
    {  
        BinarySearchTree.print( this.root );
        System.out.println();
    }  

    /**
    Prints a node and all of its descendants in sorted order.
    @param parent the root of the subtree to print
     */
    private static void print(Node parent)
    {  
        if( parent == null )
        {
            return;
        }
        
        BinarySearchTree.print( parent.left );
        System.out.print( parent.data + " " );
        BinarySearchTree.print( parent.right );
    }

    /**
    A node of a tree stores a data item and references
    to the left and right child nodes.
     */
    class Node
    {  
        public Comparable data;
        public Node left;
        public Node right;
        
        /**
        Inserts a new node as a descendant of this node.
        @param newNode the node to insert
         */
        public void addNode(Node newNode)
        {  
            int diff = newNode.data.compareTo( data );
            if( diff < 0 )
            {
                if( left == null )
                {
                    left = newNode;
                }
                else
                {
                    left.addNode( newNode );
                }
            }
            else if( diff > 0 )
            {
                if( right == null )
                {
                    right = newNode;
                }
                else
                {
                    right.addNode (newNode );
                }
            }
        }
    }
}


