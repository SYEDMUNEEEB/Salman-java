import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, String> POLYGON_SHAPES = new HashMap<>();

    // Initialize polygon shapes
    static {
        POLYGON_SHAPES.put(3, "Triangle");
        POLYGON_SHAPES.put(4, "Square");
        POLYGON_SHAPES.put(5, "Pentagon");
        POLYGON_SHAPES.put(6, "Hexagon");
        POLYGON_SHAPES.put(7, "Heptagon");
        // Add more shapes as needed
    }

    // Method to find the name of a polygon based on the number of sides
    public static String findPolygonShape(int sides) {
        String shape = POLYGON_SHAPES.get(sides);
        return shape != null ? shape : "Unknown";
    }

    // Method to check if a polygon with a given number of sides is valid
    public static boolean isPolygonValid(int sides) {
        return POLYGON_SHAPES.containsKey(sides);
    }

    // Method to calculate the perimeter of a polygon
    public static double calculatePerimeter(int sides, double sideLength) {
        if (sides < 3 || sideLength <= 0) {
            throw new IllegalArgumentException("Invalid input. Polygon must have at least 3 sides, and side length must be positive.");
        }
        return sides * sideLength;
    }

    // Method to calculate the area of a polygon
    public static double calculateArea(int sides, double sideLength) {
        if (sides < 3 || sideLength <= 0) {
            throw new IllegalArgumentException("Invalid input. Polygon must have at least 3 sides, and side length must be positive.");
        }
        return (sides * sideLength * sideLength) / (4 * Math.tan(Math.PI / sides));
    }

    // Method to compare the calculated area with a predefined area
    public static String compareArea(double calculatedArea, double predefinedArea) {
        if (calculatedArea > predefinedArea) {
            return "Calculated area is larger than predefined area";
        } else if (calculatedArea < predefinedArea) {
            return "Calculated area is smaller than predefined area";
        } else {
            return "Calculated area matches predefined area";
        }
    }

    // Method to display a simple text-based representation of a polygon
    public static void displayPolygon(int sides) {
        // Implement text-based polygon representation here
        String polygonShape = findPolygonShape(sides);
        System.out.println("Shape: " + polygonShape);
        if ("Triangle".equals(polygonShape)) {
            System.out.println("   /\\");
            System.out.println("  /  \\");
            System.out.println(" /____\\");
        } else if ("Square".equals(polygonShape)) {
            System.out.println(" ______");
            System.out.println("|      |");
            System.out.println("|      |");
            System.out.println("|______|");
        } else if ("Pentagon".equals(polygonShape)) {
            System.out.println("   /\\");
            System.out.println("  /  \\");
            System.out.println(" /    \\");
            System.out.println(" \\    /");
            System.out.println("  \\__/");
        } else if ("Heptagon".equals(polygonShape)) {
            System.out.println("  _____");
            System.out.println(" /     \\");
            System.out.println("/       \\");
            System.out.println("\\       /");
            System.out.println(" \\_____/");
        } else if ("Hexagon".equals(polygonShape)) {
            System.out.println("   ______");
            System.out.println("  /      \\");
            System.out.println(" /        \\");
            System.out.println("/          \\");
            System.out.println("\\          /");
            System.out.println(" \\        /");
            System.out.println("  \\______/");
        } else {
            System.out.println("No representation available for this polygon");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sides for the polygon: ");
        int sides = scanner.nextInt();

        if (!isPolygonValid(sides)) {
            System.out.println("Invalid number of sides");
        } else {
            System.out.print("Enter the side length: ");
            double sideLength = scanner.nextDouble();

            String polygonShape = findPolygonShape(sides);
            System.out.println("Shape of the polygon with " + sides + " sides: " + polygonShape);

            double perimeter = calculatePerimeter(sides, sideLength);
            double calculatedArea = calculateArea(sides, sideLength);
            double predefinedArea = sideLength * sideLength; // Assuming predefined area for a square

            System.out.println("Perimeter: " + perimeter);
            System.out.println("Calculated Area: " + calculatedArea);
            System.out.println(compareArea(calculatedArea, predefinedArea));

            displayPolygon(sides); // Display the text-based representation of the polygon
        }

        scanner.close(); // Close the scanner when done
    }
}
