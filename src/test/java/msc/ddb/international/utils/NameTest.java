package msc.ddb.international.utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class NameTest {

    
    @Test
	public void testgetUnknownName() {
		Name name = new Name("");
        assertEquals("Unknown", name.getName());
	}

    @Test
	public void testgetKnownName() {
		Name name = new Name("Known");
        assertEquals("Known", name.getName());
	}

    @Test
	public void testimplementsNameable() {
		Name name = new Name("");
        assertTrue(name instanceof Nameable);
	}
}
