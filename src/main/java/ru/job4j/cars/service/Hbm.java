package ru.job4j.cars.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.cars.model.Item;
import ru.job4j.cars.model.Mark;

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
                "select distinct c from Item c join fetch c.model, c.mark, c.user, c.photo, c.typeBody "
                        + "where c.created >= current_date - 1 "
                        + "order by c.id").list());
    }

    @Override
    public Collection<Item> withPhoto() {
        return this.tx(session -> session.createQuery(
                "select distinct c from Item c join fetch c.model, c.mark, c.user, c.photo, c.typeBody "
                        + "where c.photo is not null "
                        + "order by c.id").list());
    }

    @Override
    public Collection<Item> mark(Mark mark) {
        return this.tx(session -> session.createQuery(
                "select distinct c from Item c join fetch c.model, c.mark, c.user, c.photo, c.typeBody "
                        + "where c.mark.name = :MarkName  "
                        + "order by c.id")
                .setParameter("MarkName", mark.getName())
                .list());
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
