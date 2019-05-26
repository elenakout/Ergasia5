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

// Το OpenGroup είναι μία υποκατηγορία του Group έτσι τη δηλώνουμε ως child της κλάσης Group με τη χρήση του extends.
// Στο OpenGroup για να αναρτήσει Post κάποιος χρήστης αρκεί να είναι μέλος τουλάχιστον ένας φίλος του
// (ή και ο ίδιος φυσικα).
public class OpenGroup extends Group{
    
//  Η κλάση δεν έχει δικές της ιδιότητες έτσι κατασκευαστή χρησιμοποιούμε το
//  κατασκευαστή super() που κληρονομεί από τη parent κλαση Group 
    public OpenGroup(String name, String desc){
        super(name, desc);
    }
    
//  Η μέθοδος δέχεται ΄ώς όρισμα έναν χρήστη και επιστρέφει true/false αν ο χρήστης
//  έχει κάποιο φίλο στο Group. Δηλώνεται ως private και η κλήση της γίνεται από τις 
//  μεθόδους addPost και addReplyPost
    private Boolean checkFriends(User usr){
        // Για να δούμε αν έχει κάποιο στο Group χρησιμοποίουμε τη μέθοδο του ArrayList retain().
        // H μέθοδος αφαιρεί απο το πίνακα που τη καλεί όλα τα μή κοινά στοιχοία που έχει με το πίνακα που βάζουμε ως
        // ορισμα στη κληση της μεθόδου. Επειδή η retain διαγράφει στοιχεία του αρχικού πίνακα, για να μη χάσουμε
        // τα αρχικά περιεχόμενα του πίνακα που είναι τα μέλη του Group, δημιουργούμε ενα αντιγραφο του πίνακα (friendsInGroup)
        // και καλούμε τη retain() στο ανίγραφο.
        ArrayList<User> friendsInGroup = new ArrayList<>(this.memberList);
        friendsInGroup.retainAll(usr.getFriendsList());

//      Επειδή μας ενδιαφέρει αν έχει έστω έναν φίλο επιστρέφουμε
//      true όταν ο πίνακας δεν είναι άδειος και false αν είναι.
        return (!friendsInGroup.isEmpty());
    }
   
//  Η υλοποίηση της abstract μεθόδου addPost()
//  Η μέθοδος δέχεται ως όρισμα ένα Post και ελέγχει αν ο χρήστης είναι
//  μέλος του Group ή έχει έστω ένα φίλο που έιναι μέλος και μπορεί να αναρτήσει Post. 
//  Αν δεν έχει δικαίωμα να κάνει ανάτρηση ο χρήστης τυπώνει το αντίστοιχο μήνυμα    
    @Override
    void addPost(Post post) {
        if(this.isMember(post.getPostUser()) || this.checkFriends(post.getPostUser())){
            this.wall.add(post);
        }else System.out.println("User " + post.getPostUser() + " cannot post on Open Group" + this.name);
    }

//  Υλοποίηση της abstract μεθόδου aadReplyToPost
//  Η μέθοδος λαμβάνει ώς ορίσματα το αρχικό Post και την απάντηση
//  Μέτα τον έλεγχο αν ο χρήστης μπορέι να αναρτήσει στο Group αποθηκεύει το Post
//  Αν δεν μπορεί τυπώνει αντίστοιχο μήνυμα
    @Override
    void addReplyToPost(Post original, Post reply) {
        if(this.isMember(reply.getPostUser()) || this.checkFriends(reply.getPostUser())){
           original.addReply(reply);           
        }else System.out.println("User " + reply.getPostUser() + " cannot post on Open Group" + this.name);
    }

    

    
}
