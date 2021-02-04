package app;

public class FlipDoors {

    public Boolean[] doors;

    public FlipDoors() {
        doors = new Boolean[100];
        for (int i = 0; i < 100; i++) {
            doors[i] = false;
        }
        System.out.println("All " + doors.length + " doors closed");
    }

    public void flipAllDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = !doors[i];
        }
    }

    public void flipEveryOtherDoor() {
        for (int i = 1; i < doors.length; i += 2) {
            doors[i] = !doors[i];
        }
    }

    public void flipEveryThirdDoor() {
        for (int i = 2; i < doors.length; i += 3) {
            doors[i] = !doors[i];
        }
    }
}
