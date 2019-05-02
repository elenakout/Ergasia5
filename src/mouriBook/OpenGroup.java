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
public class OpenGroup extends Group{
    
    public OpenGroup(String name, String desc){
        super(name, desc);
    }
    
    private Boolean checkFriends(User usr){
        ArrayList<User> friendsInGroup = new ArrayList<>(this.memberList);
        friendsInGroup.retainAll(usr.getFriendsList());
        return (friendsInGroup.size() > 0);
    }
   
    
    @Override
    void addPost(Post post) {
        if(this.isMember(post.getPostUser()) || this.checkFriends(post.getPostUser())){
            this.wall.add(post);
        }else System.out.println("User " + post.getPostUser() + " cannot post on Open Group" + this.name);
    }

    @Override
    void addReplyToPost(Post original, Post reply) {
        if(this.isMember(reply.getPostUser()) || this.checkFriends(reply.getPostUser())){
           original.addReply(reply);
           
        }
    }

    

    
}
