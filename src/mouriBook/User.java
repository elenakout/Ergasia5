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
public class User {
    
    private String name;
    private String email;
    private ArrayList<User> friendsList = new ArrayList<>();
    private ArrayList<Group> groupsList = new ArrayList<>();

    User(String usrName, String usrEmail) {
        this.name = usrName;
        this.email = usrEmail;
    }
    
    public String getName(){
        return this.name;
    }
    
//    public String getEmail(){
//        return this.email;
//    }
    
    public ArrayList getFriendsList(){
        return this.friendsList;
    }  
    
    private Boolean isFriend (User friend){    
        return (friendsList.contains(friend));
    }
    
    public void addFriend(User newFriend){
        if (isFriend(newFriend)){
            System.out.println(this.name + " and " + newFriend.getName() + " are already friends!");
        }else if(this.toString().equals(newFriend.toString())){
            System.out.println("Yourself is always your friend :)");
        }else {
            friendsList.add(newFriend);
            System.out.println(this.name + " and " + newFriend.getName() + " are now friends!");
            
        }
    }
    
    public void addGroup(String newgroup){
        
    }
    
    public void printCommonFriends(User usr){
        ArrayList<User> commonList = new ArrayList<User>(this.friendsList);
        int num=1;
        commonList.retainAll(usr.getFriendsList());
        System.out.println("**************************************");
        System.out.println("Common friends of " + this.name + " and " + usr.getName());
        System.out.println("**************************************");
        for (User friend : commonList){
            System.out.println(num++ + ": " + friend.getName());
        }
    }
    
    public void printFriendsList(){
        System.out.println(this.name + "'s Friends:");
        for (User friend : this.friendsList){
            System.out.println(friend.getName());
        }
    }
    
    public void printGroupList(){
        System.out.println(this.name + "'s Groups");
    }
    
    @Override
    public String toString(){
        return name + " " + email;
    }
    
}
