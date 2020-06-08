package com.adopt.pet.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class SizeEnumTest {

    @Test
    public void testWithValueInvalid() {
        assertNull(SizeEnum.byValue("INVALID"));
    }

    @Test
    public void testWithValueValid() {
        assertEquals(SizeEnum.byValue("PEQUENO_PORTE"), SizeEnum.PEQUENO_PORTE);
    }

    @Test
    public void testValueWithSpace(){
        //TODO: Implementar metodo para testar o replace (" ", "_")
    }

    @Test
    public void testWithValueNull() {
        assertTrue(SizeEnum.optionIsNull(null));
    }

    @Test
    public void testIgnoreCase(){
        assertEquals(SizeEnum.byValue("pequeno_porte"), SizeEnum.PEQUENO_PORTE);
    }

    @Test
    public void testIgnoreDifferentCase(){
        assertEquals(SizeEnum.byValue("Pequeno_porte"), SizeEnum.PEQUENO_PORTE);
    }

}