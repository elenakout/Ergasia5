/*
 * ΓΕ5 2018-2019
 * Άσκηση 2 
 */
package mouriBook;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Έλενα
 */

// Η κλαση Post υλοποιεί τις λειτουργίες και τις ιδιότητες της οντότητας Post 
// - Timestamp
// - Κείμενο 
// - Χρήστης
// - Απαντήσεις στο Post
// * Προσθήκη απάντησης στο Post
// * Προβολή απαντήσεων του Post

class Post {
    // Βασικές ιδιότητες του Post
    private Date dateAdded;
    private String postContent;
    private User postUser;
    
    // Οι απαντήσεις στο Post αποθηκεύονται σε ενα ArrayList με αντικείμενα της κλάσης Post
    private ArrayList<Post> postReplies = new ArrayList<>();
    
    // Ο κατασκευαστής αρχικόποιεί τα πεδία της κλάσης
    // Έχει ορίσματα το χρήστη που δημιουργησε το Post 
    // και το κείμενο. Η ημερομίνία του Post καταχωρήται αυτόματα
    // με τη new Date()
    public Post(String content, User usr){ 
        this.dateAdded = new Date();
        this.postContent = content;
        this.postUser = usr;
    }
    
    // Η μέθοδος επιστρέφει τη λίστα με τις απαντήσεις του Post
    public ArrayList<Post> getPostReplies(){
        return this.postReplies;
    }
    
    // Η μέθοδος επιστρέφει τον χρήστη που δημιούργησε το Post
    public User getPostUser(){
        return this.postUser;
    }
    
    // Η μέθοδος αποθηκέυει στη λίστα με τις απαντήσεις το αντικείμενο τύπου Post
    // που δέχεται ωσ όρισμα.
    public void addReply(Post post){
        this.postReplies.add(post);
    }
    
    // Για τη μέθοδο toString() χρησιμοποιουμε το StringBuilder για
    // κατασκευάσουμε το string που απαιτεί η εκφώνηση να εμφανιστεί, επειδή η μέθοδος
    // toString επιστρέφει ένα μόνο String κι εμείς χρειάζεται να κάνουμε μία επανάληψη στη
    // λίστα με τις απαντήσεις του Post και να τις τύπώσουμε σε μία νέα σειρα.
    @Override
    public String toString(){
        //Δημιουργία αντικειμένου StringBuilder 
        StringBuilder str = new StringBuilder();
        // Με τη μέθοδο appent(String)προσθέτουμε τα πέδία του Post 
        str.append("| " + this.dateAdded.toString() + " | "+ this.postUser.toString() + " : " + this.postContent );
        // Αν υπάρχουν απαντήσεις στο Post
        if(!this.postReplies.isEmpty()){
            // Για κάθε απάντηση καλούμε τη μέθοδο append(String) και προσθέτουμε
            // τα πεδία της απάντησης σε μία καινούρια σειρά
            for(Post post : this.postReplies){
                str.append("\n -> " + post);
            }
        }  
        // Επιστρέφουμε το String που έχει δημιουργηθεί.
        return str.toString();
    }
}
