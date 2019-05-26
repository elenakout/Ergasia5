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

// Η κλάση User περιέχει τις βασικές λειτουργίες και ιδιότητες της οντότητας χρήστης
// σύμφωνα με την εκφώνηση:
// - Όνομα
// - Email
// - Φίλοι
// - Groups
// * Προσθήκη φίλου
// * Προσθήκη Group
// * Δημιουργία Post
// καθώς και τις υπόλοιπες ζητούμενες μεθόδους

public class User {
    // Βασικά χαρακτηριστικά χρήστη
    private String name;
    private String email;
    
    // Λίστα με τους φίλους του χρήστη
    private ArrayList<User> friendsList = new ArrayList<>();
    
    // Λίστα με τα Group που είναι εγγεγραμένος ο χρήστης
    private ArrayList<Group> groupsList = new ArrayList<>();
    
    // Ο κατασκευαστής αρχικοποιεί το όνομα και το email του χρήσητη
    User(String usrName, String usrEmail) {
        this.name = usrName;
        this.email = usrEmail;
    }

// Δημιουργήθηκαν οι αντίστοιχοι getters και setters για τα βασικά πεδία της κλάσης αλλά απο τη στιγμή που δεν χρησιμοποιούνται 
// στο κώδικα αφαιρέθηκαν.    
//    public String getName(){
//        return this.name;
//    }
    
//    public String getEmail(){
//        return this.email;
//    }
    
//    public void setName(String name){
//        this.name = name;
//    }
//    
//    public void setEmail(String email){
//        this.email = email;
//    }
    
    // Η μέθοδος επιστρέφει τη λίστα με τους φίλους του χρήστη
    public ArrayList getFriendsList(){
        return this.friendsList;
    }  
    
    // Η μέθοδος δέχεται ώς παράμετρο έναν άλλο χρήστη και επιστέφει true ή false
    // ανάλογα με το αν είναι φίλοι ή όχι.
    public Boolean isFriend (User friend){
        // Ο χρήστης δεν μπορεί να είναι φίλος με τον εαυτό του
        if(this.name.equals(friend.toString())){
            return true;           
        }
        return (friendsList.contains(friend));
    }
    
    // Η μέθοδος προσθέτει στη λίστα φίλων έναν άλλο χρήστη. 
    public void addFriend(User newFriend){
        // Έλεγχος για το αν πρόκειται για το ίδιο πρόσωπο ή
        // για χρήστη που είναι ήδη φίλος, με τη κλήση της μεθόδου isFriend()
        if (isFriend(newFriend)){
            System.out.println(this.name + " and " + newFriend.toString() + " are already friends!");
        }else {
        // Αν o έλεγχος επιστρέψει false προσθέτουμε το φίλο στη λίστα
            this.friendsList.add(newFriend);
        // Επειδή η σχέση είναι αφίδρομή προσθέτουμε το χρήστη στη λίστα φίλων του νέου του φίλου
        // με τη κλήση της εσωτερικής μεθόδου addFriendBack(). Η μέθοδος καλέιτε στο αντικείμενο
        // του νέου φίλου.
            newFriend.addFriendBack(this);
            System.out.println(this.name + " and " + newFriend.toString() + " are now friends!");
            
        }
    }
    
    // Η μέθοδος υλοποιεί την αμφίδρομη σχεση των φίλων. Δεν έχει έλεγχο για το αν είναι φήδη φίλοι
    // γιατι η κλήση της γίνεται στη μέθοδο addFriend() μέτα που έχει κάνει τον απαραίτητο ελέγχο.
    // Ειναι private γιατι η κλήση της γίνεται απο μέθοδο της κλάσης και δεν θέλουμε να είναι ορατή
    // από τις υπολοιπες κλάσεις του προγράμματος.
    private void addFriendBack(User friend){
        this.friendsList.add(friend);
    }
    
    // Η μέθοδος δέχεται ως παράμετρο ένα Group και προσθέτει το χρήστη σε αυτό
    // μόνο αν δεν είναι ήδη μέλος
    public void addGroup(Group newgroup){
        // Έλεγχος για το αν ο χρήστης ανήκει στο Group
        // Αν δεν ανήκει προσθέτουμε το Group στη λίστα με τα Group.
        // Διαφορετικά εμφανίζεται μήνυμα λάθους.
        if(!this.groupsList.contains(newgroup)){           
            this.groupsList.add(newgroup);
        }else System.out.println(this.name + " is already member of " + newgroup);
    }
    
    // Η μέθοδος δέχεται ως παράμετρο έναν άλλο χρήστη και επιστρέφει μία λίστα
    // με τους κοινούς φίλους των δύο χρηστών
    public void printCommonFriends(User usr){
        // Για την εύρεση των κοινών φίλων χρησιμοποίουμε τη μέθοδο του ArrayList retain().
        // H μέθοδος αφαιρεί απο το πίνακα που τη καλεί όλα τα μή κοινά στοιχοία που έχει με το πίνακα που βάζουμε ως
        // ορισμα στη κληση της μεθόδου. Επειδή η retain διαγράφει στοιχεία του αρχικού πίνακα, για να μη χάσουμε
        // τα αρχικά περιεχόμενα του πίνακα που είναι οι φίλοι του χρήστη, δημιουργούμε ενα αντιγραφο του πίνακα (commonlist)
        // και καλούμε τη retain() στο ανίγραφο.
        ArrayList<User> commonList = new ArrayList<User>(this.friendsList);
        int num=1;
        commonList.retainAll(usr.getFriendsList());
        // Τώρα η commonlist περιέχει τους κοινούς φίλους αν υπάρχουν αλλιώς είναι κενός.
        // Αφού ελέξουμε αν υπάρχουν κοινοί φίλοι, εκτυπώνουμε τη λίστα και αν είναι άδεια 
        // επιστρέφουμε το ανάλογο μήνυμα.
        if(!commonList.isEmpty()){
            System.out.println("**************************************");
            System.out.println("Common friends of " + this.name + " and " + usr.toString());
            System.out.println("**************************************");
            for (User friend : commonList){
                System.out.println(num++ + ": " + friend.toString());
            }
            System.out.println("**************************************");
        }else System.out.println(this.name + " and " + usr.toString() + "don't have common friends.");
    }
    
    // Η μέθοδος τυπώνει τους φίλους ενός χρήστη
    public void printFriendsList(){
        System.out.println(this.name + "'s Friends:");
        for (User friend : this.friendsList){
            // Χρησιμοποιούμε τη toString μέθοδο που έχουμε κάνει Override και
            // και εκτυπώνει τα ονόματα των φίλων.
            System.out.println(friend.toString());
        }
    }
    
    // Η μέθοδος τυπώνει τα Groups στα οποία έχει γραφτεί ο χρήστης
    public void printGroupList(){
        System.out.println(this.name + "'s Groups");
        for(Group group : groupsList){
            System.out.println(group.toString());
        }
    }
    
    // Η μέθοδος παίρνει σαν όρισμα ένα String με το κείμενο του Post
    // και δημιουργεί ένα καινουριο αντικείμενο Post περνόντας σαν όρίσματα
    // στο κατασκευαστή της κλάσης Post το κείμενο και τον ίδιο το χρήστη.
    // Επιστρέφει το αντικείμενο Post που δημιουργήθηκε.
    public Post createPost(String content){   
        return new Post(content, this);
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
