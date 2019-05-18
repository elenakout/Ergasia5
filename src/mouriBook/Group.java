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
abstract class Group {
    String name;
    String desc;
    ArrayList<User> memberList = new ArrayList<>();
    ArrayList<Post> wall = new ArrayList<>();
    
    public Group(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    
    public Boolean isMember(User usr){
        return this.memberList.contains(usr);
    }
    
    public void addMember(User usr){
        if(!this.isMember(usr)){
            this.memberList.add(usr);
            usr.addGroup(this);
        }else System.out.println(usr + " is already member");
    }
    
    public void printMembers(){
        if(!this.memberList.isEmpty()){
            System.out.println(this.name + "'s Members:");
            for(User member : this.memberList){
                System.out.println(member);
            }
        }
    }
    
    public void printWall(){
        System.out.println("Group " + this.name + " wall");
        for(Post post : this.wall){
            System.out.println(post);
            }
    }
    
    public Post getLatestPost(){
        return this.wall.get(this.wall.size() - 1);
    }
        
    abstract void addPost(Post post);
    
    abstract void addReplyToPost(Post original, Post reply);
    
}
