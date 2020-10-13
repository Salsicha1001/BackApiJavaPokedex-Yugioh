package com.training.demo.Model;

import java.util.List;
import java.util.Objects;

public class Pokemon {
    private User user;
    private String id;
    private String name;
    private List type;
    private String img;
    private String anitEvolution;
    private String nextEvolution;
    private List weaknesses;



    public Pokemon(User user, String id, String name, List type, String img,String anitEvolution, String nextEvolution ,List weaknesses) {
        this.user = user;
        this.id = id;
        this.name = name;
        this.type = type;
        this.img = img;
        this.anitEvolution = anitEvolution;
        this.nextEvolution = nextEvolution;
        this.weaknesses = weaknesses;
    }

    public Pokemon() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getType() {
        return type;
    }

    public void setType(List type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getAnitEvolution() {
        return anitEvolution;
    }

    public void setAnitEvolution(String anitEvolution) {
        this.anitEvolution = anitEvolution;
    }

    public String getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(String nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(user, pokemon.user) &&
                Objects.equals(id, pokemon.id) &&
                Objects.equals(name, pokemon.name) &&
                Objects.equals(type, pokemon.type) &&
                Objects.equals(img, pokemon.img) &&
                Objects.equals(anitEvolution, pokemon.anitEvolution) &&
                Objects.equals(nextEvolution, pokemon.nextEvolution) &&
                Objects.equals(weaknesses, pokemon.weaknesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, id, name, type, img, anitEvolution, nextEvolution, weaknesses);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "user=" + user +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", img='" + img + '\'' +
                ", anitEvolution='" + anitEvolution + '\'' +
                ", nextEvolution='" + nextEvolution + '\'' +
                ", weaknesses=" + weaknesses +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
