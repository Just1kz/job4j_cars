package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "typeBody")
public class TypeBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "name")
    private String name;

//    @OneToMany(mappedBy = "typeBody")
//    private List<Item> items = new ArrayList<>();

    public static TypeBody of(String name) {
        TypeBody typeBody = new TypeBody();
        typeBody.name = name;
        return typeBody;
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

//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TypeBody typeBody = (TypeBody) o;
        return id == typeBody.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TypeBody{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + '}';
    }
}
