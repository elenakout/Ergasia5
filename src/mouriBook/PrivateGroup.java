/*
 * ΓΕ5 2018-2019
 * Άσκηση 2 
 */
package mouriBook;

/**
 *
 * @author Έλενα
 */
public class PrivateGroup extends Group{
    
    public PrivateGroup(String name, String desc){
        super(name, desc);
    }

    
    @Override
    void addPost(Post post) {
        if(this.isMember(post.getPostUser())){
            this.wall.add(post);
        }else System.out.println("User " + post.getPostUser() + " cannot post on Open Private" + this.name);
    }

    @Override
    void addReplyToPost(Post original, Post reply) {
        if(this.isMember(reply.getPostUser())){
           original.addReply(reply);
        }else System.out.println("User " + reply.getPostUser() + " cannot post on Private Group " + this.name);
    }

    
}
