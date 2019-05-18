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
class Post {
    private Date dateAdded;
    private String postContent;
    private User postUser;
    private ArrayList<Post> postRepl = new ArrayList<>();
    
    public Post(String content, User usr){
        this.dateAdded = new Date();
        this.postContent = content;
        this.postUser = usr;
    }
    
    public ArrayList<Post> getPostReplies(){
        return this.postRepl;
    }
    public User getPostUser(){
        return this.postUser;
    }
    
    public void addReply(Post post){
        this.postRepl.add(post);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("| " + this.dateAdded.toString() + " | "+ this.postUser.toString() + " : " + this.postContent );
        if(!this.postRepl.isEmpty()){
            for(Post post : this.postRepl){
                str.append("\n -> " + post);
            }
        }       
        return str.toString();
    }
}
