/*
 * ΓΕ5 2018-2019
 * Άσκηση 2 
 */
package mouriBook;

/**
 *
 * @author Έλενα
 */
public class MouriBook_ex2 {
   public static void main(String[] args) {
		User u1 = new User("Teo", "teo@eap.gr");
		User u2 = new User("Makis", "makis@eap.gr");
		User u3 = new User("Petros", "petros@eap.gr");
		User u4 = new User("Stefania", "stefania@eap.gr");
		User u5 = new User("Nikoleta", "nikoleta@eap.gr");
		User u6 = new User("Marina", "marina@eap.gr");
//		Group g1 = new OpenGroup("CS Students", "Geek Group!");
//		Group g2 = new PrivateGroup("Math Studs", "Sharp minds");
		u1.addFriend(u2);
		u1.addFriend(u3);
		u1.addFriend(u4);
		u6.addFriend(u1);
		u6.addFriend(u2);
		u6.addFriend(u3);
		u6.addFriend(u5);
		u2.addFriend(u3);
		u1.printCommonFriends(u6);
//		g1.addMember(u1);
//		g1.addMember(u2);
//		Post p1 = u1.createPost("My first post in this group!");
//		Post p2 = u1.createPost("Hope you don't get bored with me!");
//		Post p3 = u6.createPost("This is user 6, hello dudes!");
//		g1.addPost(p1);
//		g1.addPost(p2);
//		g1.addPost(p3);
//		Post p1reply = u2.createPost("Hello to you too! Enjoy our group!");
//		g1.addReplyToPost(p1, p1reply);
//		Post p1Reply2 = u3.createPost("Hello Makis!");
//		g1.addReplyToPost(p1reply, p1Reply2);
//		g1.printWall();
//		System.out.println("++++++++++++++++++++++++++++++++++++++++");
//		g2.addMember(u3);
//		g2.addMember(u4);
//		Post pp1 = u3.createPost("I am glad to be in this group!");
//		g2.addPost(pp1);
//		Post pp1Reply = u4.createPost("Hello Petro!");
//		g2.addReplyToPost(pp1, pp1Reply);
//		Post pp1Reply2 = u5.createPost("Ha Ha Ha Ha");
//		g2.addReplyToPost(pp1Reply, pp1Reply2 );
//		g2.printWall();
//		System.out.println("++++++++++++++++++++++++++++++++++++++++");
//		System.out.println("Latest Post of Group 1");
//		System.out.println(g1.getLatestPost());
//	System.out.println("Latest Post of Group 2");
//		System.out.println(g2.getLatestPost());
	}
 
}
