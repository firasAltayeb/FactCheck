package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import app.*;

public class FlipDoors_test {

	public FlipDoors flipper;

	@Before
	public void setUp() {
		flipper = new FlipDoors();
		System.out.println("setup done");
	}

	@Test
	public void flipAllDoorsTest() {
		flipper.flipAllDoors();
		checkDoors();

		int numberOfOpen = countOpenDoors();
		assertEquals(100, numberOfOpen);
	}

	@Test
	public void flipEveryOtherDoorTest() {
		flipper.flipEveryOtherDoor();
		checkDoors();

		int numberOfOpen = countOpenDoors();
		assertEquals(50, numberOfOpen);
	}

	@Test
	public void flipEveryThirdDoor() {
		flipper.flipEveryThirdDoor();
		checkDoors();

		int numberOfOpen = countOpenDoors();
		assertEquals(33, numberOfOpen);
	}

	@Test
	public void flipInOrder() {
		flipper.flipAllDoors();
		flipper.flipEveryOtherDoor();
		flipper.flipEveryThirdDoor();

		int numberOfOpen = countOpenDoors();
		int numberOfClosed = countClosedDoors();

		checkDoors();
		assertEquals(49, numberOfOpen);
		assertEquals(51, numberOfClosed);
	}

	public void checkDoors() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Door number " + (i + 1) + " is " + flipper.doors[i]);
		}
	}

	public int countOpenDoors() {
		int numberOfOpen = 0;
		for (Boolean door : flipper.doors)
			if (door) {
				numberOfOpen += 1;
			}
		return numberOfOpen;
	}

	public int countClosedDoors() {
		int numberOfClosed = 0;
		for (Boolean door : flipper.doors) {
			if (!door) {
				numberOfClosed += 1;
			}
		}
		return numberOfClosed;
	}

}