package aula09.plane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return planes.values().stream()
            .filter(plane -> plane.getPlaneType().equals("Commercial"))
            .collect(Collectors.toList());
    }

    public List<Plane> getMilitaryPlanes() {
        return planes.values().stream()
            .filter(plane -> plane.getPlaneType().equals("Military"))
            .collect(Collectors.toList());
    }

    public void printAllPlanes() {
        planes.values().forEach(System.out::println);
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
