package com.training.demo.Model.Yugioh;

import java.util.Objects;

public class TypeCardMonsterModel {
    private String value;
    private String name;

    public TypeCardMonsterModel() {
    }

    public TypeCardMonsterModel(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeCardMonsterModel that = (TypeCardMonsterModel) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name);
    }

    @Override
    public String toString() {
        return "TypeCardMonsterModel{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
