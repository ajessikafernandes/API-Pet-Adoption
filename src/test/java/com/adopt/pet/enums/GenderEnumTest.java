package com.adopt.pet.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class GenderEnumTest {

    @Test
    public void testWithValueInvalid() {
        assertNull(GenderEnum.byValue("INVALID"));
    }

    @Test
    public void testWithValueValid() {
        assertEquals(GenderEnum.valueOf("FEMALE"), GenderEnum.FEMALE);
    }

    @Test
    public void testWithValueNull() {
        assertTrue(GenderEnum.optionIsNull(null));
    }

    @Test
    public void testIgnoreCase(){
        assertEquals(GenderEnum.byValue("female"), GenderEnum.FEMALE);
    }

    @Test
    public void testIgnoreDifferentCase(){
        assertEquals(GenderEnum.byValue("Female"), GenderEnum.FEMALE);
    }

}