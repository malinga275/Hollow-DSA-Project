package dsaproject;


public class Node {
    
    String title;//this is the key of the tree
    int isbn;//book isbn number
    String authorFName;//author's first name
    String authorSName;//author lastname
    
    Node leftChild;//left child of the parent book
    Node rightChild;//right child of the parent book
    
    
    public Node(String title,int isbn,String authorFName,String authorSName)
    
    {
    //set users data to node class attributes
    
    this.title=title;
    this.isbn=isbn;
    this.authorFName=authorFName;
    this.authorSName=authorSName;
    
    }


    
    public String[] getData()
    {
    
        String[] array= new String[4];
        array[0]=title;
        array[1]=String.valueOf(isbn);
        array[2]=authorFName;
        array[3]=authorSName;
        return array;
    
    }
}
