package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import app.*;

public class Concatenate_test {

	public Concatenate myClass;

	@Before  
	public void setUp() {
		myClass = new Concatenate();

		System.out.println("setup done");
	}

	@Test
	public void stringTest() {
		String result = myClass.concatenate("foo", "bar");
		assertEquals("foobar", result);
	}

	@Test
	public void intTest() {
		int result = myClass.addNumbers(10, 5);
		assertEquals(15, result);
	}

	@Test
	public void multiplyTest() {
		int result = myClass.multiplyNumbers(7, 5);
		assertEquals(35, result);
	}

	@Test
	public void arrayEqual() {
		assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
	}

	@Test
	public void exceptionThrown() {
		Throwable e = null;
		try {
			myClass.stringList.get(3);
		} catch (Throwable ex) {
			e = ex;
		}

		assertTrue(e instanceof IndexOutOfBoundsException);
	}


	@Test
	public void arrayListTest() {
		myClass.stringList.add("James");
		assertEquals("James", myClass.stringList.get(0));
	}


}
