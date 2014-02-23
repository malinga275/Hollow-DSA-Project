
package dsaproject;

<<<<<<< HEAD

public class BinaryTree {
    
=======
import java.util.ArrayList;


public class BinaryTree {
    ArrayList<String> list;
>>>>>>> origin/version13
    Node root;
    int size=0;
    
    public boolean addNode(String title,int isbn,String authorFName,String authorSName)
    {
    boolean flag=false;
        Node newNode = new Node(title,isbn,authorFName,authorSName);//create a new node
        
        if(root==null)//check the tree is empty
        {
        
        root=newNode;//assign new node to root;
        flag= true;//make true thata new node has been inserted  to tree
        }
    else
        {
        Node current=root;//assign current node to root
        Node parent=null;//make parent null
        
        while(current!=null)//until current is  a aleaf
        {
        
        parent=current;//assign current to parent
        int name=title.compareTo(current.title);//compare the two strings
           if(name==0)//check if the strings are equal
           {
           flag=false;//make it false preventing same keys are inseted to tree
           break;//return from the while loop
           }
           else
           {
        if(name<0)//check new string is less than current
        {
            
        current=current.leftChild;//assign  current's left node child to currrent
        if(current==null)//check the current is the leaf
        {
        
        parent.leftChild=newNode;//assign new node to parent's leftchild node
        flag= true;
        }
        
        }
        else if(name>0)//check new string is greater than current
        {
        
        current=current.rightChild;//assign  current's right node child to currrent
         if(current==null)
        {
        
        parent.rightChild=newNode;//assign new node to parent's rightchild node
        flag= true;
        }
         
        }
        else
        {
        flag=false;
        }
        }
        }
        }
       
        size++;//increment size by one
    return flag;//return insered or not
    }
    
    
    
<<<<<<< HEAD
    
    
    public void inOrder()
    {
        inorder(root);
    
    
=======
    public boolean addNodeByIsbn(String title,int isbn,String authorFName,String authorSName)
    {
    boolean flag=false;
        Node newNode = new Node(title,isbn,authorFName,authorSName);//create a new node
        
        if(root==null)//check the tree is empty
        {
        
        root=newNode;//assign new node to root;
        flag= true;//make true thata new node has been inserted  to tree
        }
    else
        {
        Node current=root;//assign current node to root
        Node parent=null;//make parent null
        
        while(current!=null)//until current is  a aleaf
        {
        
        parent=current;//assign current to parent
           if(isbn==current.isbn)//check if the strings are equal
           {
           flag=false;//make it false preventing same keys are inseted to tree
           break;//return from the while loop
           }
           else
           {
        if(isbn<current.isbn)//check new string is less than current
        {
            
        current=current.leftChild;//assign  current's left node child to currrent
        if(current==null)//check the current is the leaf
        {
        
        parent.leftChild=newNode;//assign new node to parent's leftchild node
        flag= true;
        }
        
        }
        else if(isbn>current.isbn)//check new string is greater than current
        {
        
        current=current.rightChild;//assign  current's right node child to currrent
         if(current==null)
        {
        
        parent.rightChild=newNode;//assign new node to parent's rightchild node
        flag= true;
        }
         
        }
        else
        {
        flag=false;
        }
        }
        }
        }
       
        size++;//increment size by one
    return flag;//return insered or not
    }
    
    
    
    
    public String[] inOrder(String text)
    { list=new ArrayList<String>();
        
       String[] hom= inorder(root,text);
     
    return hom;
>>>>>>> origin/version13
    }
    
    
    
    
<<<<<<< HEAD
    public void inorder(Node root)
    {
    if(root!=null)
    {
  
    inorder(root.leftChild);//visit leftchild node
        
        System.out.println("Book Title: "+root.title+"\n"+"ISBN No: "+root.isbn+"\n"+"Author First Name: "+root.authorFName+"\n"+"Author SurName: "+root.authorSName+"\n....................\n");//visit parent node
        
        inorder(root.rightChild);//visit right child node
       
    }
=======
    public String[] inorder(Node root,String titles)
    {
           
    if(root!=null)
    {
   boolean flag=root.title.contains(titles);
        if(flag==true)
        {
            
    list.add(root.title);
   list.add(String.valueOf(root.isbn));
   list.add(root.authorFName);
   list.add(root.authorSName);
        }
    inorder(root.leftChild,titles);//visit leftchild node
       
        
        //visit parent node
        
        inorder(root.rightChild,titles);//visit right child node
        
       }
        System.out.println(list.size());
   String[] array1=new String[list.size()];
  list.toArray(array1);
  
         return array1;
>>>>>>> origin/version13
    
    }
    
    
    
    
<<<<<<< HEAD
    
=======
>>>>>>> origin/version13
    public int getSize()
    {
    return size;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
 public Node searchbyTitle(String title) {
  
  		
         Node current = root;    // Start at the top of the tree
	
	int comp=title.compareTo(current.title); //compare roots tittle to searching title
=======
=======
>>>>>>> origin/version13
    
    public boolean deleteNode(String title)
            {
                  // Start at the top of the tree
	        Node current = root;
	        Node parent = root;
                
                
                  // When searching for a Node this will
         // tell us whether to search to the
         // right or left
                
	        boolean isItALeftChild = true;
                
                // While we haven't found the Node
        // keep looking
                
                
<<<<<<< HEAD
	        while (!current.title.equals(title)) 
=======
	        while (current!=null) 
>>>>>>> origin/version13
                
                {
                    
	            parent = current;	 
                     // If we should search to the left
                    
                     int name=title.compareTo(current.title);	 
	            if (name < 0) {	 
	                isItALeftChild = true;	
// Shift the focus Node to the left child                        
	                current = current.leftChild;	 
	            } else 
                    {	 	               	 
	                isItALeftChild = false;	 
                         
                           // Greater than focus node so go to the right
                        
                          // Shift the focus Node to the right child
	                current = current.rightChild;	 
	            }	 	          	 
	            if (current == null)
	                return false;	 
	        	 
                    
                     // If Node doesn't have children delete it
	        if (current.leftChild == null && current.rightChild == null) 
                {	 	 // If root delete it 
	            if (current == root)
	                root = null;	
// If it was marked as a left child
           // of the parent delete it in its parent
                    
	            else if (isItALeftChild)
	                parent.leftChild = null;	 	       	 
	            else
	                parent.rightChild = null;
                    
                     // Vice versa for the right child
	        }
                
                 // If no right child
	        else if (current.rightChild == null) 
                {	 
	            if (current == root)
	                root = current.leftChild;
                    
                    // If focus Node was on the left of parent
            // move the focus Nodes left child up to the
            // parent node
                    
	            else if (isItALeftChild)
	                parent.leftChild = current.leftChild;	 	           	 
	            else
	                parent.rightChild = current.leftChild;
                    // Vice versa for the right child
	        }	 	
                 // If no left child
	        else if (current.leftChild == null) 
                {	 
	            if (current == root)
	                root = current.rightChild;
                    
                    // If focus Node was on the left of parent
            // move the focus Nodes right child up to the
             // parent node
	            else if (isItALeftChild)
	                parent.leftChild = current.rightChild;	 	     	 
	            else
	                parent.rightChild = current.rightChild;	 
	        }	 	       	 
	        else 
                {	 // Two children so I need to find the deleted nodes
         // replacement
	            Node replacement = getReplacementNode(current);	
 // If the focusNode is root replace root
            // with the replacement                    
	            if (current == root)
	                root = replacement;	

                      // If the deleted node was a left child
            // make the replacement the left child
	            else if (isItALeftChild)
	                parent.leftChild = replacement;	 	           	 
	            else
	                parent.rightChild = replacement;	 
	            replacement.leftChild = current.leftChild;	 
	        }
	 		 
	    }
 size--;
	        return true;
 
}
     public Node getReplacementNode(Node replacedNode) {
 
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
  
         Node current = replacedNode.rightChild;
  
         // While there are no more left children
  
        while (current != null) {
  
             replacementParent = replacement;
  
             replacement = current;
  
             current = current.leftChild;
  
         }
  
         // If the replacement isn't the right child
         // move the replacement into the parents
         // leftChild slot and move the replaced nodes
         // right child into the replacements rightChild
  
         if (replacement != replacedNode.rightChild) {
  
             replacementParent.leftChild = replacement.rightChild;
             replacement.rightChild = replacedNode.rightChild;
  
        }
  
         return replacement;
  
     }
     
     public Node searchbyTitle(String title) {
  
    
         Node current = root;    // Start at the top of the tree
 
 int comp=title.compareTo(current.title); //compare roots tittle to searching title
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> origin/version13
  
         // While we haven't found the Node
         // keep looking

<<<<<<< HEAD
<<<<<<< HEAD
	 
=======
  
>>>>>>> master
=======
  
>>>>>>> origin/version13
         while (comp!= 0) {
  
               
             if (comp < 0) {
  
                   
                 current = current.leftChild; // Shift the current focus to the left child

<<<<<<< HEAD
<<<<<<< HEAD
		 comp=title.compareTo(current.title); //compare current node's tittle to searching title
  
             }

		 else {
  
                 
                 current = current.rightChild; // Shift the current focus to the right child
		 comp=title.compareTo(current.title);  //compare current node's tittle to searching title
=======
=======
>>>>>>> origin/version13
   comp=title.compareTo(current.title); //compare current node's tittle to searching title
  
             }

   else {
  
                 
                 current = current.rightChild; // Shift the current focus to the right child

   comp=title.compareTo(current.title);  //compare current node's tittle to searching title
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> origin/version13
  
             }
  
             // if the node wasn't found
  
<<<<<<< HEAD
<<<<<<< HEAD
             if (current == null){
                 return null;
  }
         }
  
         return current;
  
     }
    
=======
=======
             if (current == null)
                 return null;
  
         }
  
         return current;
  }
     public Node searchbyIsbn(int isbn) {
  
  		
         Node current = root;    // Start at the top of the tree
	
	
         // While we haven't found the Node
         // keep looking

	 
        while(isbn!=current.isbn){
  
               
             if (isbn < current.isbn) {
  
                   
                 current = current.leftChild; // Shift the current focus to the left child

		 
             }

		 else {
  
                 
                 current = current.rightChild; // Shift the current focus to the right child

		 
             }
  
             // if the node wasn't found
  
>>>>>>> origin/version13
             if (current == null)
                 return null;
  
         }
  
         return current;
<<<<<<< HEAD
  }
     
>>>>>>> master
=======
  
     }
   public String[] searchbyKeyword(String title) {
  
       ArrayList<String> list=new ArrayList<String>();
         Node current = root;    // Start at the top of the tree
 
 int comp=title.compareTo(current.title); //compare roots tittle to searching title
  if(comp==0)
  {
   list.add(current.title);
   list.add(String.valueOf(current.isbn));
   list.add(current.authorFName);
   list.add(current.authorSName);
    System.out.println(current.title);
  }
         // While we haven't found the Node
         // keep looking

  
         while (comp!= 0) {
  
               
             if (comp < 0) {
  
                   
                 current = current.leftChild; // Shift the current focus to the left child

 
   boolean flag=current.title.contains(title);
   if(flag==true)
   {
   list.add(current.title);
   list.add(String.valueOf(current.isbn));
   list.add(current.authorFName);
   list.add(current.authorSName);
    System.out.println(current.title);
   }
   //compare current node's tittle to searching title
  
             }

   else {
  
                 
                 current = current.rightChild; // Shift the current focus to the right child

 //compare current node's tittle to searching title
   boolean flag=current.title.contains(title);
   if(flag==true)
   {
  list.add(current.title);
   list.add(String.valueOf(current.isbn));
   list.add(current.authorFName);
   list.add(current.authorSName);
       System.out.println(current.title);
   }
             }
  
             // if the node wasn't found
  
             if (current == null)
                 return null;
  
         }
  String[] array1=new String[list.size()];
  list.toArray(array1);
         return array1;
  } 
     
     
>>>>>>> origin/version13
}
  

