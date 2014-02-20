/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaproject;

/**
 *
 * @author malinga
 */
public class BinaryTree {
    
    Node root;
    int size=0;
    
    public boolean addNode(String title,int isbn,String authorFName,String authorSName)
    {
    boolean flag=false;
        Node newNode = new Node(title,isbn,authorFName,authorSName);//create a new node
        
        if(root==null)//check the tree is empty
        {
        
        root=newNode;
        flag= true;
        }
    else
        {
        Node current=root;
        Node parent=null;
        
        while(current!=null)
        {
        
        parent=current;
        int name=title.compareTo(current.title);
           if(name==0)
           {
           flag=false;
           break;
           }
           else
           {
        if(name<0)
        {
            
        current=current.leftChild;
        if(current==null)
        {
        
        parent.leftChild=newNode;
        flag= true;
        }
        
        }
        else if(name>0)
        {
        
        current=current.rightChild;
         if(current==null)
        {
        
        parent.rightChild=newNode;
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
       
        size++;
    return flag;
    }
    
    public void inOrder()
    {
        inorder(root);
    
    
    }
    
    public void inorder(Node root)
    {
    if(root!=null)
    {
  
    inorder(root.leftChild);//visit leftchild node
        
        System.out.println("Book Title: "+root.title+"\n"+"ISBN No: "+root.isbn+"\n"+"Author First Name: "+root.authorFName+"\n"+"Author SurName: "+root.authorSName+"\n....................\n");//visit parent node
        
        inorder(root.rightChild);//visit right child node
       
    }
    
    }
    
    public int getSize()
    {
    return size;
    }
    public boolean deleteNode(String title)
            {
	        Node current = root;
	        Node parent = root;
	        boolean isItALeftChild = true;
	        while (current.title != title) {
	            parent = current;	 
                    {
                     int name=title.compareTo(current.title);	 
	            if (name < 0) {	 
	                isItALeftChild = true;	 	               	 
	                current = current.leftChild;	 
	            } else 
                    {	 	               	 
	                isItALeftChild = false;	 	 
	                current = current.rightChild;	 
	            }	 	          	 
	            if (current == null)
	                return false;	 
	        }	 	    	 
	        if (current.leftChild == null && current.rightChild == null) 
                {	 	 
	            if (current == root)
	                root = null;	 	          	 
	            else if (isItALeftChild)
	                parent.leftChild = null;	 	       	 
	            else
	                parent.rightChild = null;	 
	        }	 	      	 
	        else if (current.rightChild == null) 
                {	 
	            if (current == root)
	                root = current.leftChild;	 	            	 
	            else if (isItALeftChild)
	                parent.leftChild = current.leftChild;	 	           	 
	            else
	                parent.rightChild = current.leftChild;	 
	        }	 	 
	        else if (current.leftChild == null) 
                {	 
	            if (current == root)
	                root = current.rightChild;	 	            	 
	            else if (isItALeftChild)
	                parent.leftChild = current.rightChild;	 	     	 
	            else
	                parent.rightChild = current.rightChild;	 
	        }	 	       	 
	        else 
                {	 
	            Node replacement = getReplacementNode(current);	 	            	 
	            if (current == root)
	                root = replacement;	 	            	 
	            else if (isItALeftChild)
	                parent.leftChild = replacement;	 	           	 
	            else
	                parent.rightChild = replacement;	 
	            replacement.leftChild = current.leftChild;	 
	        }
	 	size--;
	        return true;	 
	    }
 
 
}
}
  

