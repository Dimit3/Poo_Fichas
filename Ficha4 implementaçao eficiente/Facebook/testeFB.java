package send;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class testeFB {
    
    public static void main (String [] args){
        

        //criar posts

        List<String> comments1 = new ArrayList<String>();
        comments1.add("me too");

        List<String> comments2 = new ArrayList<String>();
        comments2.add(":P");
        comments2.add(":P");
        comments2.add(":D");
        comments2.add(":(");

        FBPost post1 = new FBPost(1, "Daniel", LocalDateTime.MIN, "Felling good", 10, comments1);
        comments1.add("like");
        comments1.add("sameee");
        comments1.add("sameee");
        FBPost post2 = new FBPost(2, "Daniel", LocalDateTime.MAX, "It's a nice day", 15, comments1);
        FBPost post3 = new FBPost(post2);
        post3.setIdentificador(3);
        FBPost post4 = new FBPost(4, "joaozinho", LocalDateTime.now(), ":)", 5, comments2);
        comments2.add(":D");
        comments2.add(":D");
        comments2.add(":D");
        comments2.add(":D");
        FBPost post5 = new FBPost(5, "joaozinho", LocalDateTime.now(), ":)", 10, comments2);
        comments1.add("relatable");
        comments1.add("sameee");
        comments1.add("bored");
        FBPost post6 = new FBPost(6, "maria", LocalDateTime.now(), "Tired of this quarentine", 7, comments1);
        comments2.add(":P");
        comments2.add(":P");
        comments2.add(":D");
        FBPost post7 = new FBPost(7, "maria", LocalDateTime.now(), "Hey", 87, comments2);

        

        List<FBPost> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
        posts.add(post7);

        FBFeed feed1 = new FBFeed(posts);

        //System.out.println(feed1);

        System.out.println(feed1.top5Comments());

    }

}