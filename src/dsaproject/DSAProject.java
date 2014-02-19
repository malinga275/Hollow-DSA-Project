/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaproject;

/**
 *
 * @author malinga
 */
public class DSAProject {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        
        BinaryTree t = new BinaryTree();
        
        t.addNode("java", 123, "gilbert", "grockz");
        t.addNode("html", 124, "Albert", "poop");
        t.addNode("kml", 156, "Lambert", "accif");
        t.addNode("php", 178, "holms", "loofh");
        t.addNode("abc", 133, "google", "eemt");
        t.addNode("ice", 133, "google", "eemt");
        t.addNode("kac", 133, "google", "eemt");
        t.inOrder();
    }
}
