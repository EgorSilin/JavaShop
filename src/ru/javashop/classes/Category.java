package ru.javashop.classes;

/**
 * Created by Admin on 08.06.2016.
 */
public class Category {
    private String name;
    private long id;

    public Category() {}
    public Category(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
