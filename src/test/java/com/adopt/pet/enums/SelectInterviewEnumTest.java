package com.adopt.pet.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class SelectInterviewEnumTest {

    @Test
    public void testWithValueInvalid() {
        assertNull(SelectInterviewEnum.byValue("INVALID"));
    }

    @Test
    public void testWithValueValid() {
        assertEquals(SelectInterviewEnum.valueOf("YES"), SelectInterviewEnum.YES);
    }

    @Test
    public void testWithValueNull() {
        assertTrue(SelectInterviewEnum.optionIsNull(null));
    }

    @Test
    public void testIgnoreCase(){
        assertEquals(SelectInterviewEnum.byValue("yes"), SelectInterviewEnum.YES);
    }

    @Test
    public void testIgnoreDifferentCase(){
        assertEquals(SelectInterviewEnum.byValue("Yes"), SelectInterviewEnum.YES);
    }

}