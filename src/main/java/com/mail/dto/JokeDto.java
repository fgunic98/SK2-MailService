package com.mail.dto;


public class JokeDto {

    private String id;
    private String joke;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtcDate() {
        return joke;
    }

    public void setUtcDate(String joke) {
        this.joke = joke;
    }
    @Override
    public String toString() {
        return "MatchDto{" +
                "id = " + id +
                ", sala = " + joke +
                '}';
    }
}

