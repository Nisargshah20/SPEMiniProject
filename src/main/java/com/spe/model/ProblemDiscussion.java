package com.spe.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="problemdiscussion")
public class ProblemDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false,updatable=false)
    private Long id;

    @Column(name="pid")
    private Long pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Column(name = "username")
    private String username;

    @Column(name = "comment")
    private String comment;

    @Temporal(value= TemporalType.TIMESTAMP)
    @Column(name = "doj")
    private Date doj;
}
