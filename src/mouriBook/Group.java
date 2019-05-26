/*
 * ΓΕ5 2018-2019
 * Άσκηση 2 
 */
package mouriBook;

import java.util.ArrayList;

/**
 *
 * @author Έλενα
 */

// Η κλαση Group δηλώνεται ως abstract δηλαδή αφηρημένη κλάση που πέριεχει τις βασικές 
// λειτουργίες και ιδιότητες που περιέχει κάθε Group
// - Ονομα
// - Περιγραφή
// - Λίστα με τα μέλη
// - Λίστα με τα Post
// * Έλεγχος αν ένας χρήστης είναι μέλος
// * Προσθήκη μέλους
// * Εκτύπωση μελών
// * Εκτύπωση τελευταίου Post
// 
// Έχουμε δύο κατηγορίες Group, openGroup και privateGroup. Στη parent κλάση Group 
// υλοποιούνται οι κοινές λειτουργίες. Η διαφορά στα δύο Group είναι πότε μπορεί να αναρτήσει
// ένας χρήστης Post. Έτσι δηλώνουμε δύο abstract μεθόδους οι οποίες υλοποιούνται στις
// δύο κατηγορίες διαφορετικά.
abstract class Group {
    // Βασικές ιδιότητες των Group 
    protected String name;
    protected String desc;
    protected ArrayList<User> memberList = new ArrayList<>();
    protected ArrayList<Post> wall = new ArrayList<>();
    
//  Στο κατασκευαστή αρχικοποίειται το όνομα και η περιγραφή του Group
    public Group(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    
//  Η μέθοδος δέχεται ως όρισμα και επιστρέφει true/fasle αν υπάρχει
//  στη λίστα μελών του Group
    public Boolean isMember(User usr){
        return this.memberList.contains(usr);
    }
    
//  Η μέθοδος δέχεται ως όρισμα έναν χρήστη και τον προσθέτει στη λίστα με τα μέλη 
    public void addMember(User usr){
//      Έλεγχος για το αν ο χρήστης είναι ήδη μέλος
        if(!this.isMember(usr)){
//          Επειδή η συσχέτηση των κλάσεων User και Group είναι many-to-many
//          καλούμε τη μέθοδο addGroup του αντικειμένου του χρήστη ώστε να προστεθεί
//          το Group στην αντίστοιχη λίστα
            this.memberList.add(usr);
            usr.addGroup(this);
        }else System.out.println(usr + " is already member");
    }
//  Η μέθοδος τυπώνει τη λίστα με τα μέλη του Group
    public void printMembers(){
//      Έλεγχος για το αν υπάρχουν μέλη, αν η λίστα είναι άδεια εμφανίζεται 
//      το αντίστοιχο μήνυμα  
        if(!this.memberList.isEmpty()){
            System.out.println(this.name + "'s Members:");
            for(User member : this.memberList){
                System.out.println(member);
            }
        }else System.out.println("Group" + this.name + " has no members");       
    }
    
//  Η μέθοδος τυπώνει τη λίστα με τα Post του Group
//  Αν η λίστα είναι άδεια τυπώνεται το αντίστοιχο μήνυμα
    public void printWall(){
        if(this.wall.isEmpty()){
            System.out.println(this.name + "'s Wall is empty");
        }else {
          System.out.println("Group " + this.name + " wall");
            for(Post post : this.wall){
                System.out.println(post);
            }  
        }
        
    }
    
    // Η μέθοδος επιστρέφει το τελεύταί Post από τη λίστα του Group
    // Αν η λίστα είναι κενή επιστρέφει τη τιμή null
    public Post getLatestPost(){      
        if(!this.wall.isEmpty()){
            return this.wall.get(this.wall.size() - 1);
        }
        return null;
        
    }
    
//  abstract μέθοδος για τη αποθήκευση Post στο Group
    abstract void addPost(Post post);
    
//  abstract μέθοδος για τη αποθήκευση απάντησης σε Post του Group
    abstract void addReplyToPost(Post original, Post reply);
    
//  Η μέθοδος επιστρέφει το όνομα του Group
    @Override
    public String toString(){
        return name;
    }
    
}
