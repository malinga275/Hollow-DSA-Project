
package dsaproject;


public class BinaryTree {
    
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
     
}
  

