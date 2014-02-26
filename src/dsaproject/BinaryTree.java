
package dsaproject;

import java.util.ArrayList;


public class BinaryTree {
    ArrayList<String> list;
    Node root;
    int size=0;
    
    public boolean addNode(String title,int isbn,String authorFName,String authorSName)
    {
    boolean flag=false;
        Node newNode = new Node(title,isbn,authorFName,authorSName);//create a new node
        
        if(root==null)//check the tree is empty
        {
        size++;//increment size by one
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
        size++;//increment size by one
        parent.leftChild=newNode;//assign new node to parent's leftchild node
        flag= true;
        }
        
        }
        else if(name>0)//check new string is greater than current
        {
        
        current=current.rightChild;//assign  current's right node child to currrent
         if(current==null)
        {
        size++;//increment size by one
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
       
    return flag;//return insered or not
    }
    
    
    
    public boolean addNodeByIsbn(String title,int isbn,String authorFName,String authorSName)
    {
    boolean flag=false;
        Node newNode = new Node(title,isbn,authorFName,authorSName);//create a new node
        
        if(root==null)//check the tree is empty
        {
        size++;//increment size by one
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
        size++;//increment size by one
        parent.leftChild=newNode;//assign new node to parent's leftchild node
        flag= true;
        }
        
        }
        else if(isbn>current.isbn)//check new string is greater than current
        {
        
        current=current.rightChild;//assign  current's right node child to currrent
         if(current==null)
        {
        size++;//increment size by one
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
       
        
    return flag;//return insered or not
    }
    
    
    
    
    public String[] inOrder(String text)
    { list=new ArrayList<String>();
        
       String[] hom= inorder(root,text);
     list.clear();
    return hom;
    }
    
    
    
    
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
        
   String[] array1=new String[list.size()];
  list.toArray(array1);
  
         return array1;
    
    }
    
    
    
    
    public int getSize()
    {
    return size;
    }
    
    
     public boolean deleteNode(String titles)
            {
                  // Start at the top of the tree
	        Node current = root;
	        Node parent = null;
                
                
                  // When searching for a Node this will
         // tell us whether to search to the
         // right or left
                
	     
                
                // While we haven't found the Node
        // keep looking
                
                int name=titles.compareTo(current.title);
               
	        while (current!=null) 
                
                {
                   if(name<0)
                   {
                   
                       parent=current;
                       current=current.leftChild;
                        if(current.title.equals(titles))
                    {
                    break;
                    
                    }
                   }
                   else if(name>0)
                   {
                   
                       
                   parent=current;
                   current=current.rightChild;
                    if(current.title.equals(titles))
                    {
                    break;//element is in the tree pointed by current
                    
                    }
                   }
                   else
                   {
                      break;
                      
                   }
                    
	           }
              
                 
                if(current==null)
                {
                   
                return false;//element is not in the tree
                }
                
                
                //case 1:current has no left children
                if(current.leftChild==null)
                {//connect the parent with the right child of the current node
                if(parent==null)
                {
                  
                root=current.rightChild;
                }
                
                else
                {
                    //csase2:the current node has a left child
                
                    if(titles.compareTo(parent.title)<0)
                        parent.leftChild=current.rightChild;
                    
                    else
                        parent.rightChild=current.rightChild;
                }
                }
                
                else
                {
                    
               Node  parentOfRightMost=current;
                Node rightMost=current.leftChild;
                
                while(rightMost.rightChild!=null)
                {
                parentOfRightMost=rightMost;
                rightMost=rightMost.rightChild;
                }
                //replace the element in current by the element in right most
                current.title=rightMost.title;
                
                if(parentOfRightMost.rightChild==rightMost)
                    parentOfRightMost.rightChild=rightMost.leftChild;
                
                else//case3 parentofrightmost==current
                    parentOfRightMost.leftChild=rightMost.leftChild;
                }
                
 size--;
	        return true;
                
 
}
  
      public boolean deleteNodeByISBN(int isbn)
            {
                  // Start at the top of the tree
	        Node current = root;
	        Node parent = null;
                
                
                  // When searching for a Node this will
         // tell us whether to search to the
         // right or left
                
	     
                
                // While we haven't found the Node
        // keep looking
                
               
               
	        while (current!=null) 
                
                {
                   if(isbn<current.isbn)
                   {
                   
                       parent=current;
                       current=current.leftChild;
                        if(current.isbn==isbn)
                    {
                    break;
                    
                    }
                   }
                   else if(isbn>current.isbn)
                   {
                   
                       
                   parent=current;
                   current=current.rightChild;
                    if(current.isbn==isbn)
                    {
                    break;//element is in the tree pointed by current
                    
                    }
                   }
                   else
                   {
                      break;
                      
                   }
                    
	           }
              
                 
                if(current==null)
                {
                   
                return false;//element is not in the tree
                }
                
                
                //case 1:current has no left children
                if(current.leftChild==null)
                {//connect the parent with the right child of the current node
                if(parent==null)
                {
                  
                root=current.rightChild;
                }
                
                else
                {
                    //csase2:the current node has a left child
                
                    if(isbn<parent.isbn)
                        parent.leftChild=current.rightChild;
                    
                    else
                        parent.rightChild=current.rightChild;
                }
                }
                
                else
                {
                    
               Node  parentOfRightMost=current;
                Node rightMost=current.leftChild;
                
                while(rightMost.rightChild!=null)
                {
                parentOfRightMost=rightMost;
                rightMost=rightMost.rightChild;
                }
                //replace the element in current by the element in right most
                current.isbn=rightMost.isbn;
                
                if(parentOfRightMost.rightChild==rightMost)
                    parentOfRightMost.rightChild=rightMost.leftChild;
                
                else//case3 parentofrightmost==current
                    parentOfRightMost.leftChild=rightMost.leftChild;
                }
                
 size--;
	        return true;
                
 
}
     
     
     public Node searchbyTitle(String title) {
  
    
         Node current = root;    // Start at the top of the tree
 
 int comp=title.compareTo(current.title); //compare roots tittle to searching title
  
         // While we haven't found the Node
         // keep looking

  
         while (comp!= 0) {
  
               
             if (comp < 0) {
  
                   
                 current = current.leftChild; // Shift the current focus to the left child

   comp=title.compareTo(current.title); //compare current node's tittle to searching title
  
             }

   else {
  
                 
                 current = current.rightChild; // Shift the current focus to the right child

   comp=title.compareTo(current.title);  //compare current node's tittle to searching title
  
             }
  
             // if the node wasn't found
  
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
  
             if (current == null)
                 return null;
  
         }
  
         return current;
  
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
     
     
}
  

