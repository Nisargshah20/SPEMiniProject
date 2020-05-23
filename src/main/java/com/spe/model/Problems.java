package com.spe.model;

import javax.persistence.*;

@Entity
@Table(name="problems")
public class Problems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pid",nullable=false,updatable=false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="difficulty")
    private String difficulty;

    @Column(name="topic")
    private String topic;

    @Column(name="attempted")
    private Long attempted;

    @Column(name="solved")
    private Long solved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getAttempted() {
        return attempted;
    }

    public void setAttempted(Long attempted) {
        this.attempted = attempted;
    }

    public Long getSolved() {
        return solved;
    }

    public void setSolved(Long solved) {
        this.solved = solved;
    }

}
