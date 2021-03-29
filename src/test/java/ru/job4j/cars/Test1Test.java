package ru.job4j.cars;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Test1Test {

    @Test
    public void LGD() {
        assertThat(Test1.LGD(), is(Boolean.TRUE));
    }
}