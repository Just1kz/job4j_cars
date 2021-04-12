package ru.job4j.cars.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.cars.model.*;

import java.util.Collection;
import java.util.function.Function;

public class Hbm implements Repository, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private final Logger logger = LoggerFactory.getLogger(Hbm.class.getName());

    private static final Hbm INST = new Hbm();

    public static Hbm instOf() {
        return INST;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            logger.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Item> lastDay() {
        return this.tx(session -> session.createQuery(
                "from Item "
                        + "where created >= current_date - 1 "
                        + "order by id").list());
    }

    @Override
    public Collection<Item> withPhoto() {
        return this.tx(session -> session.createQuery(
                "from Item  "
                        + "where photo is not null and photo.id != 1 "
                        + "order by id").list());
    }

    @Override
    public Collection<Item> mark(Mark mark) {
        return this.tx(session -> session.createQuery(
                "from Item where mark.name = :MarkName "
                        + "order by id")
                .setParameter("MarkName", mark.getName())
                .list());
    }

    @Override
    public Collection<Mark> allMark() {
        return this.tx(session -> session.createQuery("from Mark ORDER BY id").list());
    }

    @Override
    public Collection<Model> allModel() {
        return this.tx(session -> session.createQuery("from Model ORDER BY id").list());
    }

    @Override
    public Collection<TypeBody> allTypeBody() {
        return this.tx(session -> session.createQuery("from TypeBody ORDER BY id").list());
    }

    @Override
    public Collection<Item> allItem() {
        return this.tx(session -> session.createQuery("from Item ORDER BY id").list());
    }

    @Override
    public Collection<Item> myItem(User user) {
        return this.tx(session -> session.createQuery(
                "from Item "
                        + "where user.name = :UserName  "
                        + "order by id")
                .setParameter("UserName", user.getName())
                .list());
    }

    @Override
    public Collection<Item> noSoldItem() {
        return this.tx(session -> session.createQuery(
                "from Item "
                        + "where sold = :Sold  "
                        + "order by id")
                .setParameter("Sold", false)
                .list());
    }

    @Override
    public void soldItem(int id) {
        this.tx(session -> session.createQuery("UPDATE Item SET sold = true where id = :id")
                .setParameter("id", id)
                .executeUpdate());
    }

    @Override
    public void createUser(User user) {
        this.tx(session -> session.save(user));
    }

    @Override
    public User findByEmailAndPhoneUser(String email, String phone) {
        return (User) this.tx(session -> session.createQuery("FROM User where "
                + "email = :email and "
                + "phone = :phone")
                .setParameter("email", email)
                .setParameter("phone", phone)
                .uniqueResult());
    }

    @Override
    public User findByEmailAndPasswordUser(String email, String password) {
        return (User) this.tx(session -> session.createQuery("FROM User where "
                + "email = :email and "
                + "password = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult());
    }

    @Override
    public Photo createPhoto(Photo photo) {
        this.tx(session -> session.save(photo));
        return photo;
    }

    @Override
    public Mark findByNameMark(String name) {
        return (Mark) this.tx(session -> session.createQuery("FROM Mark where "
                + "name = :name")
                .setParameter("name", name)
                .uniqueResult());
    }

    @Override
    public Model findByNameModel(String name) {
        return  (Model) this.tx(session -> session.createQuery("FROM Model where "
                + "name = :name")
                .setParameter("name", name)
                .uniqueResult());
    }

    @Override
    public TypeBody findByNameTypeBody(String name) {
        return  (TypeBody) this.tx(session -> session.createQuery("FROM TypeBody where "
                + "name = :name")
                .setParameter("name", name)
                .uniqueResult());
    }

    @Override
    public Photo findByNamePhoto(String name) {
        return  (Photo) this.tx(session -> session.createQuery("FROM Photo where "
                + "title = :name")
                .setParameter("name", name)
                .uniqueResult());
    }

    @Override
    public void addItem(Item item) {
        this.tx(session -> session.save(item));
    }

    @Override
    public Item findByIdItem(int id) {
        return (Item) this.tx(session -> session.createQuery("FROM Item where "
                + "id = :id")
                .setParameter("id", id)
                .uniqueResult());
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
