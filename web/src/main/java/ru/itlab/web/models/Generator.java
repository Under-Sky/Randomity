package ru.itlab.web.models;

public class Generator {
    public int id;
    public String nameOfGenerator;

    public Generator() {
    }

    public String toJSON() {
        return "{\"id\":" + id + ", \"name\":\"" + nameOfGenerator + "\"}";
    }
}
