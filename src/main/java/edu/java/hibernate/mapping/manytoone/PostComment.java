package edu.java.hibernate.mapping.manytoone;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 create table post_comment
 (
 id bigint not null primary key auto_increment,
 comment varchar(256),
 post_id bigint,
 foreign key(post_id) references post(id) on delete cascade
 ) auto_increment=1;
 */

@Entity
@Table(name="post_comment")
@Access(AccessType.PROPERTY)
public class PostComment
{

    private Long id;
    private String comment;
    private Post   post;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name="comment")
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name="post_id")
    public Post getPost()
    {
        return post;
    }

    public void setPost(Post post)
    {
        this.post = post;
    }
}
