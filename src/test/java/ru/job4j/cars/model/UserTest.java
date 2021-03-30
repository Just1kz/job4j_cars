package ru.job4j.cars.model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {
    String name = "Anton";
    String phone = "123";
    String email = "123";
    String password = "123";
    User user = User.of(name, phone, email, password);
    User user2 = User.of(name, phone, email, password);

    @Test
    public void of() {
        String name = "Anton";
        String phone = "123";
        String email = "123";
        String password = "123";
        assertThat(User.of(name, phone, email, password), is(user));
    }

    @Test
    public void getId() {
        assertThat(user.getId(), is(0));
    }

    @Test
    public void setId() {
        user.setId(1);
        assertThat(user.getId(), is(1));
    }

    @Test
    public void getName() {
        assertThat(user.getName(), is("Anton"));
    }

    @Test
    public void setName() {
        user.setName("Petr");
        assertThat(user.getName(), is("Petr"));
    }

    @Test
    public void getPhone() {
        assertThat(user.getPhone(), is("123"));
    }

    @Test
    public void setPhone() {
        user.setPhone("+79529008838");
        assertThat(user.getPhone(), is("+79529008838"));
    }

    @Test
    public void getEmail() {
        assertThat(user.getEmail(), is("123"));
    }

    @Test
    public void setEmail() {
        user.setEmail("exelent.pride@rambler.ru");
        assertThat(user.getEmail(), is("exelent.pride@rambler.ru"));
    }

    @Test
    public void getPassword() {
        assertThat(user.getPassword(), is("123"));
    }

    @Test
    public void setPassword() {
        user.setPassword("1234");
        assertThat(user.getPassword(), is("1234"));
    }

    @Test
    public void equalsTest() {
        assertThat(user.equals(user2), is(Boolean.TRUE));
    }

    @Test
    public void hashCodeTest() {
        assertThat(user.hashCode(), is(1587871));
    }

    @Test
    public void toStringTest() {
        assertThat(user.toString(),
                is("User{id=0, name='Anton', phone='123', email='123', password='123'}"));
    }
}