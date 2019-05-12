package edu.java.hibernate.mapping.manytoone;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SQL
 *
 create table post(
 id bigint not null primary key auto_increment,
 posted tinyint(1) default 0,
 title varchar(255),
 contents varchar(1024)
 ) auto_increment=1;
 */


@Entity
@Table(name="post")
@Access(javax.persistence.AccessType.PROPERTY)
public class Post
{
    private Long id;
    private Boolean posted;
    private String title;
    private String contents;
    private List<PostComment> comments = new ArrayList<PostComment>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return id;
    }

    @Column(name="posted")
    public Boolean getPosted()
    {
        return posted;
    }

    public void setPosted(Boolean posted)
    {
        this.posted = posted;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Column(name="contents")
    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    @OneToMany (mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    public List<PostComment> getComments()
    {
        return comments;
    }

    public void setComments(List<PostComment> comments)
    {
        this.comments = comments;
    }

    public void addComment(PostComment comment)
    {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment comment)
    {
        comments.remove(comment);
        comment.setPost(null);
    }

    //private User   author;


}
