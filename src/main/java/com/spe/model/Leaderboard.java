package com.spe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaderboard")
public class Leaderboard {
    @Id
    @Column(name="username",nullable=false,updatable=false)
    private String username;

    @Column(name="points")
    private Long points;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getEasy() {
        return easy;
    }

    public void setEasy(Long easy) {
        this.easy = easy;
    }

    public Long getMedium() {
        return medium;
    }

    public void setMedium(Long medium) {
        this.medium = medium;
    }

    public Long getHard() {
        return hard;
    }

    public void setHard(Long hard) {
        this.hard = hard;
    }

    @Column(name="easy")
    private Long easy;

    @Column(name="medium")
    private Long medium;

    @Column(name="hard")
    private Long hard;


}
