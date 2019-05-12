package com.ordermate.dao;

import edu.java.hibernate.mapping.manytoone.Post;
import edu.java.hibernate.mapping.manytoone.PostComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestPost extends AbstractTest
{

    protected void printPost(Post p)
    {
        StringBuilder sb=new StringBuilder();
        addToPrint("Posted",p.getPosted().toString(),sb);
        addToPrint("Title",p.getTitle(),sb);
        addToPrint("Contents",p.getContents(),sb);
        logger.info(sb.toString());
    }

    @Test
    public void addPosts()
    {
        beginTransaction();
        Post p1 = new Post();
        p1.setPosted(true);
        p1.setTitle("Bible");
        p1.setContents("In the Beginning God created the heaven and the earth");

        PostComment pc1 = new PostComment();
        pc1.setComment("I am testing");

        PostComment pc2 = new PostComment();
        pc2.setComment("I am testing again");

        p1.addComment(pc1);
        p1.addComment(pc2);

        save(p1);

        p1=(Post)session.get(Post.class, p1.getId());
        printPost(p1);
    }
}
