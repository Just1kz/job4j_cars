package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @JoinColumn(name = "transmission")
    private String transmission;

    @JoinColumn(name = "drive")
    private String drive;

    @ManyToOne
    @JoinColumn(name = "typeBody_id")
    private TypeBody typeBody;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @JoinColumn(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @JoinColumn(name = "sold")
    private boolean sold = false;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public TypeBody getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(TypeBody typeBody) {
        this.typeBody = typeBody;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && sold == item.sold
                && Objects.equals(mark, item.mark)
                && Objects.equals(model, item.model)
                && Objects.equals(typeBody, item.typeBody)
                && Objects.equals(photo, item.photo)
                && Objects.equals(user, item.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, typeBody, photo, user, sold);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id="
                + id
                + ", mark="
                + mark
                + ", model="
                + model
                + ", transmission='"
                + transmission
                + '\''
                + ", drive='"
                + drive
                + '\''
                + ", typeBody="
                + typeBody
                + ", photo="
                + photo
                + ", description='"
                + description
                + '\''
                + ", user="
                + user
                + ", sold="
                + sold
                + ", created="
                + created
                + '}';
    }
}
