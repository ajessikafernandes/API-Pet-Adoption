package com.adopt.pet.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class SelectOptionEnumTest {

    @Test
    public void testWithValueInvalid() {
        assertNull(SelectOptionEnum.byValue("INVALID"));
    }

    @Test
    public void testWithValueValid() {
        assertEquals(SelectOptionEnum.valueOf("YES"), SelectOptionEnum.YES);
    }

    @Test
    public void testWithValueNull() {
        assertTrue(SelectOptionEnum.optionIsNull(null));
    }

    @Test
    public void testIgnoreCase(){
        assertEquals(SelectOptionEnum.byValue("yes"), SelectOptionEnum.YES);
    }

    @Test
    public void testIgnoreCase2(){
        assertEquals(SelectOptionEnum.byValue("Yes"), SelectOptionEnum.YES);
    }
}