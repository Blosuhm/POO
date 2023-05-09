package aula09.plane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaneManager {

    Map<String, Plane> planes = new HashMap<>();

    public void addPlane(Plane plane) {
        planes.put(plane.getId(), plane);
    }

    public void removePlane(String id) {
        planes.remove(id);
    }

    public Plane searchPlane(String id) {
        return planes.get(id);
    }

    public List<Plane> getCommercialPlanes() {
        List<Plane> commercialPlanes = new ArrayList<>();
        for (Plane plane : this.planes.values()) {
            if (plane.getPlaneType().equals("Commercial")) {
                commercialPlanes.add(plane);
            }
        }
        return commercialPlanes;
    }

    public List<Plane> getMilitaryPlanes() {
        List<Plane> militaryPlanes = new ArrayList<>();
        for (Plane plane : this.planes.values()) {
            if (plane.getPlaneType().equals("Military")) {
                militaryPlanes.add(plane);
            }
        }
        return militaryPlanes;
    }

    public void printAllPlanes() {
        for (Plane plane : this.planes.values()) {
            System.out.println(plane);
        }
    }

    public Plane getFastestPlane() {
        Plane fastestPlane = null;
        for (Plane plane : planes.values()) {
            if (fastestPlane == null || fastestPlane.getMaxSpeed() < plane.getMaxSpeed()) {
                fastestPlane = plane;
            }
        }
        return fastestPlane;
    }
}
