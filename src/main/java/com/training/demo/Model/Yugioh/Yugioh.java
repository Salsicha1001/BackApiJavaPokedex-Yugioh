package com.training.demo.Model.Yugioh;

import com.training.demo.Model.User;

import java.util.Objects;

public class Yugioh {
    private User user;
    private int id;
    private String name;
    private String type;
    private String desc;
    private int atk;
    private int def;
    private String level;
    private String race;
    private String attribute;
    private String archetype;
    private String scale;
    private String linkval;
    private String linkmarkers;


    public Yugioh() {
    }

    public Yugioh(User user, int id, String name, String type, String desc, int atk, int def, String level, String race, String attribute, String archetype, String scale, String linkval, String linkmarkers) {
        this.user = user;
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.atk = atk;
        this.def = def;
        this.level = level;
        this.race = race;
        this.attribute = attribute;
        this.archetype = archetype;
        this.scale = scale;
        this.linkval = linkval;
        this.linkmarkers = linkmarkers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLinkval() {
        return linkval;
    }

    public void setLinkval(String linkval) {
        this.linkval = linkval;
    }

    public String getLinkmarkers() {
        return linkmarkers;
    }

    public void setLinkmarkers(String linkmarkers) {
        this.linkmarkers = linkmarkers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yugioh yugioh = (Yugioh) o;
        return id == yugioh.id &&
                atk == yugioh.atk &&
                def == yugioh.def &&
                Objects.equals(user, yugioh.user) &&
                Objects.equals(name, yugioh.name) &&
                Objects.equals(type, yugioh.type) &&
                Objects.equals(desc, yugioh.desc) &&
                Objects.equals(level, yugioh.level) &&
                Objects.equals(race, yugioh.race) &&
                Objects.equals(attribute, yugioh.attribute) &&
                Objects.equals(archetype, yugioh.archetype) &&
                Objects.equals(scale, yugioh.scale) &&
                Objects.equals(linkval, yugioh.linkval) &&
                Objects.equals(linkmarkers, yugioh.linkmarkers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, id, name, type, desc, atk, def, level, race, attribute, archetype, scale, linkval, linkmarkers);
    }

    @Override
    public String toString() {
        return "Yugioh{" +
                "user=" + user +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", atk=" + atk +
                ", def=" + def +
                ", level='" + level + '\'' +
                ", race='" + race + '\'' +
                ", attribute='" + attribute + '\'' +
                ", archetype='" + archetype + '\'' +
                ", scale='" + scale + '\'' +
                ", linkval='" + linkval + '\'' +
                ", linkmarkers='" + linkmarkers + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
