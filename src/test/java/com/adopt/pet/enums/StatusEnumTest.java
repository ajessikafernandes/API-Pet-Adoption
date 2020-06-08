package com.adopt.pet.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class StatusEnumTest {

    @Test
    public void testWithValueInvalid() {
        assertNull(StatusEnum.byValue("INVALID"));
    }

    @Test
    public void testWithValueValid() {
        assertEquals(StatusEnum.valueOf("AVAILABLE"), StatusEnum.AVAILABLE);
    }

    @Test
    public void testWithValueNull() {
        assertTrue(StatusEnum.optionIsNull(null));
    }

    @Test
    public void testIgnoreCase(){
        assertEquals(StatusEnum.byValue("available"), StatusEnum.AVAILABLE);
    }

    @Test
    public void testIgnoreDifferentCase(){
        assertEquals(StatusEnum.byValue("Available"), StatusEnum.AVAILABLE);
    }

}