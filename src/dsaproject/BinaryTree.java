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
    
 
}
