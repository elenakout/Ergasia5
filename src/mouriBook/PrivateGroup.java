/*
 * ΓΕ5 2018-2019
 * Άσκηση 2 
 */
package mouriBook;

/**
 *
 * @author Έλενα
 */

// Το PrivateGroup είναι μία υποκατηγορία του Group έτσι τη δηλώνουμε ως child της κλάσης Group με τη χρήση του extends.
// Στο PrivateGroup για να αναρτήσει Post οποιοσδήποτε χρήστης, πρέπει να είναι μέλος ο ίδιος
public class PrivateGroup extends Group{
    
//  Η κλάση δεν έχει δικές της ιδιότητες έτσι κατασκευαστή χρησιμοποιούμε το
//  κατασκευαστή super() που κληρονομεί από τη parent κλαση Group 
    public PrivateGroup(String name, String desc){
        super(name, desc);
    }

//  Υλοποίηση της abstract μεθόδου addPost()
//  Η μέθοδος δέχεται ως όρισμα ένα Post και ελέγχει αν ο χρήστης είναι
//  μέλος του Group και μπορεί να αναρτήσει Post. Αν δεν είναι μέλος τυπώνει 
//  αντίστοιχο μήνυμα
    @Override
    void addPost(Post post) {
        if(this.isMember(post.getPostUser())){
            this.wall.add(post);
        }else System.out.println("User " + post.getPostUser() + " cannot post on Open Private" + this.name);
    }

//  Υλοποίηση της abstract μεθόδου aadReplyToPost
//  Η μέθοδος λαμβάνει ώς ορίσματα το αρχικό Post και την απάντηση
//  Μέτα τον έλεγχο αν ο χρήστης είναι μέλος στο Group αποθηκεύει το Post
//  Αν δεν είναι μέλος τυπώνει αντίστοιχο μήνυμα
    @Override
    void addReplyToPost(Post original, Post reply) {
        if(this.isMember(reply.getPostUser())){
           original.addReply(reply);
        }else System.out.println("User " + reply.getPostUser() + " cannot post on Private Group " + this.name);
    }

    
}
