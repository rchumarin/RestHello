package net.proselyte.resthello.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Simple JavaBEan domain object that represents Contact.
 *
 * @author Eugene Suleimanov
 * */

@Entity
@Table(name = "contacts")
public class Contact implements  Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Basic
    private String name;

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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
