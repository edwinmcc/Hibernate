package com.ordermate.dao;

import edu.java.hibernate.mapping.manytoone.Post;
import edu.java.hibernate.mapping.manytoone.PostComment;
import edu.java.hibernate.model.Computer;
import edu.java.hibernate.model.IPAddress;
import java.util.List;
import org.junit.Test;

public class TestPostComment extends AbstractTest
{
    protected void printPostComment(PostComment pc)
    {
        StringBuilder sb= new StringBuilder();
        addToPrint("Comment",pc.getComment(),sb);
        addToPrint("PostID",pc.getPost().getId().toString(), sb);
        logger.info(sb.toString());
    }

    @Test
    public void testPostComment()
    {
        /*
        beginTransaction();
        Post post=(Post)session.get(Post.class, 1L);
        PostComment postComment = new PostComment();
        postComment.setComment("This is good");
        postComment.setPost(post);
        save(postComment);
        printPostComment(postComment);
        */

        /*
        beginTransaction();
        Post p1 = new Post();
        p1.setTitle("Animal Farm");
        p1.setContents("Animal Farm testing");
        PostComment postComment1 = new PostComment();
        postComment1.setComment("Test Posting Comment");
        postComment1.setPost(p1);
        save(postComment1);
        */

        //beginTransaction();
        Post p1 = (Post)session.get(Post.class,1L);
        List<PostComment> comments = p1.getComments();
        for(PostComment pc : comments)
        {
            printPostComment(pc);
        }

        beginTransaction();
        PostComment pc1 = new PostComment();
        pc1.setComment("New Comment");
        p1.addComment(pc1);
        save(pc1);


        Computer c = new Computer();
        c.setName("Testing");
        c.setIpAddress(new IPAddress("10.1.1.127"));

        save(c);

        Computer  c1 = (Computer)session.get(Computer.class, c.getId());
        printDetails(c1);

    }

    public void printDetails(Computer c)
    {
        System.out.println("Name "+c.getName());
        System.out.println("IPAddres "+c.getIpAddress().getAddress());
    }
}
