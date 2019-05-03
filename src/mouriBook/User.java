/*
 * ΓΕ5 2018-2019
 * Άσκηση 2 
 */
package mouriBook;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
//    public String getName(){
//        return this.name;
//    }
    
//    public String getEmail(){
//        return this.email;
//    }
    
    public ArrayList getFriendsList(){
        return this.friendsList;
    }  
    
    public Boolean isFriend (User friend){    
        return (friendsList.contains(friend));
    }
    
    public void addFriend(User newFriend){
        if (isFriend(newFriend)){
            System.out.println(this.name + " and " + newFriend.toString() + " are already friends!");
        }else if(this.name.equals(newFriend.toString())){
            System.out.println("Yourself is always your friend :)");
        }else {
            this.friendsList.add(newFriend);
            System.out.println(this.name + " and " + newFriend.toString() + " are now friends!");
            newFriend.addFriendBack(this);
        }
    }
    
    private void addFriendBack(User friend){
        this.friendsList.add(friend);
    }
    
    public void addGroup(Group newgroup){
        if(!this.groupsList.contains(newgroup)){
            this.groupsList.add(newgroup);
        }else System.out.println(this.name + " is already member of " + newgroup);
    }
    
    public void printCommonFriends(User usr){
        ArrayList<User> commonList = new ArrayList<User>(this.friendsList);
        int num=1;
        commonList.retainAll(usr.getFriendsList());
        if(commonList.size() != 0){
            System.out.println("**************************************");
            System.out.println("Common friends of " + this.name + " and " + usr.toString());
            System.out.println("**************************************");
            for (User friend : commonList){
                System.out.println(num++ + ": " + friend.toString());
            }
            System.out.println("**************************************");
        }else System.out.println(this.name + " and " + usr.toString() + "don't have common friends.");
    }
    
    public void printFriendsList(){
        System.out.println(this.name + "'s Friends:");
        for (User friend : this.friendsList){
            System.out.println(friend.toString());
        }
    }
    
    public void printGroupList(){
        System.out.println(this.name + "'s Groups");
        for(Group group : groupsList){
            System.out.println(group);
        }
    }
    
    public Post createPost(String content){   
        return new Post(content, this);
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
