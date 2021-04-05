package send;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FBFeed {

    private List<FBPost> posts;


    //construtores
    public FBFeed() {
        this.posts = new ArrayList<FBPost>();
    }

    public FBFeed(List<FBPost> posts1) {
        List <FBPost> aux = new ArrayList<>();
        for (FBPost c : posts1){
            aux.add(c);
        }
        this.posts = aux;
    }

    public FBFeed(FBFeed f) {
        this.posts = f.getPosts();
    }


    //get
    public List<FBPost> getPosts() {
        return this.posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }


    //set
    public void setPosts(List<FBPost> posts1) {
        this.posts = new ArrayList<FBPost>();
        for (FBPost c : posts1){
            this.posts.add(c.clone());
        }
    }
    
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FBFeed)) {
            return false;
        }
        FBFeed feed = (FBFeed) o;
        
        return feed.getPosts().equals(this.getPosts());
    }


    public String toString() {
        String out ="";
        
        for (FBPost post : this.posts ){
            out = out + post.toString() + "\n";
        }
        
        return "{" +
            " posts=\n'" + out + "'" +
            "}";
    }


    public FBFeed clone(){
        return new FBFeed(this);
    }


    //i determinar numero de posts
    public int nrPosts(String user){
        return (int) this.posts.stream().filter(n->n.getNome().equals(user)).count();
    }

    //ii
    public List<FBPost> postsOf(String user){
        List <FBPost> aux = new ArrayList<FBPost>();
        Iterator<FBPost> it = this.posts.iterator();
        FBPost posty;

        while(it.hasNext()){
            posty = it.next();
            if(posty.getNome() == user){
                aux.add(posty.clone());
            }
        }   
        return aux;
    }

    //iii
    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        List <FBPost> aux = new ArrayList<FBPost>();
        
        for (FBPost p : this.posts){
            if (user.equals(p.getNome()) && (inicio.isEqual(p.getTime()) || 
            p.getTime().isAfter(inicio)) && (p.getTime().isEqual(fim) || 
            p.getTime().isBefore(fim))){
                aux.add(p);
            }
        }

        return aux;
    }


    //iv
    public FBPost getPost(int id){

        for (FBPost p : this.posts){
            if (p.getIdentificador() == id){
                return p;
            }
        }

        return null;
    }


    //v
    public void comment(FBPost post, String comentario){
        List<String> aux = post.getComments();
        aux.add(comentario);
        
        int id = post.getIdentificador();
        for (FBPost p : this.posts){
            if (p.getIdentificador() == id){
                p.setComents(aux);
            }
        }
    }

    public void comment1 (FBPost post, String comentario){
        
        Iterator <FBPost> it = this.posts.iterator();
        boolean found = false;

        while ( it.hasNext() && !found ){
            FBPost p = it.next();

            if(p.equals(post)){
                found = true;
                p.addComment (comentario);
            }
        }
    }



    //vi

    public void comment(int postid, String comentario){
        List<String> aux = getPost(postid).getComments();
        aux.add(comentario);
        
        for (FBPost p : this.posts){
            if (p.getIdentificador() == postid){
                p.setComents(aux);
            }
        }
    }


    
    public void comment1 (int postid, String comentario){
        
        Iterator <FBPost> it = this.posts.iterator();
        boolean found = false;

        while ( it.hasNext() && !found ){
            FBPost p = it.next();

            if(p.getIdentificador() == postid){
                found = true;
                p.addComment (comentario);
            }
        }
    }


    //vii

    public void like(FBPost post){
        int id = post.getIdentificador();
        
        //ou comparar com equals
        for (FBPost p : this.posts){
            if (p.getIdentificador() == id){
                //p.setLikes(p.getLikes()+1);
                p.addLike();
            }
        }
    }


    //viii

    public void like(int postid){
        
        for (FBPost p : this.posts){
            if (p.getIdentificador() == postid){
                p.setLikes(p.getLikes()+1);
            }
        }
        
    }


    //ix

    public List<Integer> top5Comments(){
        return top5CommentsExterno_v1();
    }



    private List<Integer> top5CommentsInterno_v1() {
        List<Integer> aux = new ArrayList<Integer>();
        this.posts.stream().sorted().mapToInt(FBPost::getIdentificador).forEach(a->aux.add(a));
        Collections.reverse(aux);
        return aux.subList(0, 5);
    }



    private List<Integer> top5CommentsExterno_v1(){
        TreeSet<FBPost> postset = new TreeSet<FBPost>();
        for (FBPost f : this.posts) postset.add(f);
        
        Iterator<FBPost> it = postset.descendingIterator();
        int i = 0;
        FBPost now;
        List<Integer> ret = new ArrayList<Integer>();


        while ( i < 5 && it.hasNext()){
            now = it.next();
            ret.add(now.getIdentificador());
            i++;
        }

        return ret;
    }


    private List<Integer> top5CommentsExterno_v2(){
        TreeSet<FBPost> postset = new TreeSet<FBPost>();
        for (FBPost f : this.posts) postset.add(f);

        Iterator<FBPost> it = postset.iterator();
        List<Integer> ret = new ArrayList<Integer>();
        FBPost now;

        while (it.hasNext()){
            now = it.next();
            ret.add(now.getIdentificador());
        }

        ret = ret.subList(ret.size()-5,ret.size());
        Collections.reverse(ret);
        return ret;

    }



}