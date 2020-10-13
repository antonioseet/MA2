/**
 * Name: Tony Barrera
 * CptS 233: MicroAssignment #2
 * Date: 9/7/2020
 * gitRepo URL: https://github.com/antonioseet/MA2.git
 */

// A BTree 
class Btree { 
	public BTreeNode root; // Pointer to root node 
	public int degree; // Minimum degree 
	
	// Constructor (Initializes tree as empty) 
	Btree(int degree) { 
		this.root = null; 
		this.degree = degree; 
	} 

	// function to traverse the tree 
	public void traverse() { 
		if (this.root != null) 
			this.root.traverse();
		
		System.out.println(); 
	} 

	// function to search a key in this tree 
	public BTreeNode search(int k) { 
		if (this.root == null) 
			return null; 
		else
			return this.root.search(k); 
	} 


	// A utility function to insert a new key in the subtree rooted with 
    // this node. The assumption is, the node must be non-full when this 
    // function is called 
    public void insertNonFull(int k) {
	} 
  
    // A utility function to split the child y of this node. i is index of y in 
    // child array C[].  The Child y must be full when this function is called 
    public void splitChild(int i, BTreeNode y) {
	} 
   
  
} 

// A BTree node 
class BTreeNode { 
	int[] keys; // An array of keys 
	int degree; // Minimum degree (defines the range for number of keys) 
	BTreeNode[] childPointers; // An array of child pointers 
	int n; // Current number of keys 
	boolean isLeaf; // Is true when node is leaf. Otherwise false 

	// Constructor 
	BTreeNode(int degree, boolean leaf) { 
		this.degree = degree; 
		this.isLeaf = leaf; 
		this.keys = new int[2 * degree - 1]; // t = 3 #keys = 5
		this.childPointers = new BTreeNode[2 * degree]; 
		this.n = 0; 
	} 

	// A function to traverse all nodes in a subtree rooted with this node 
	public void traverse() { 

		// There are n keys and n+1 children, traverse through n keys 
		// and first n children 
		int i = 0; 
		for (i = 0; i < this.n; i++) { 

			// If this is not leaf, then before printing key[i], 
			// traverse the subtree rooted with child C[i]. 
			if (this.isLeaf == false) { 
				childPointers[i].traverse(); 
			} 
			System.out.print(keys[i] + " "); 
		} 

		// Print the subtree rooted with last child 
		if (isLeaf == false) 
			childPointers[i].traverse(); 
	} 

	// A function to search a key in the subtree rooted with this node. 
	BTreeNode search(int k) { // returns NULL if k is not present. 

		for(int i = 0; i < keys.length; i++)
		{
			int child = keys[i];
			if(k == child)
			{
				return this;
			}
			else if(k < child && childPointers[i] != null)
			{
				if(childPointers[i].search(k) != null )
				{
					return childPointers[i];
				}
			}
			else if(childPointers[i+1] != null)
			{
				if(childPointers[i+1].search(k) != null )
				{
					return childPointers[i+1];
				}
			}
		}
		
		return null;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 