import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
    private static final Map<Integer, String> POLYGON_SHAPES = new HashMap<>();

    static {
        POLYGON_SHAPES.put(3, "Triangle");
        POLYGON_SHAPES.put(4, "Square");
        POLYGON_SHAPES.put(5, "Pentagon");
        POLYGON_SHAPES.put(6, "Hexagon");
        POLYGON_SHAPES.put(7, "Heptagon");
    }

    public static String findPolygonShape(int sides) {
        String shape = POLYGON_SHAPES.get(sides);
        return shape != null ? shape : "Unknown";
    }

    public static boolean isPolygonValid(int sides) {
        return POLYGON_SHAPES.containsKey(sides);
    }

    public static double calculatePerimeter(int sides, double sideLength) {
        if (sides < 3 || sideLength <= 0) {
            System.err.println("Invalid input. Polygon must have at least 3 sides, and side length must be positive.");
            return -1.0;
        }
        return sides * sideLength;
    }

    public static double calculateArea(int sides, double sideLength) {
        if (sides < 3 || sideLength <= 0) {
            System.err.println("Invalid input. Polygon must have at least 3 sides, and side length must be positive.");
            return -1.0;
        }
        return (sides * sideLength * sideLength) / (4 * Math.tan(Math.PI / sides));
    }

    public static String compareArea(double calculatedArea, double predefinedArea) {
        if (calculatedArea > predefinedArea) {
            return "Calculated area is larger than predefined area";
        } else if (calculatedArea < predefinedArea) {
            return "Calculated area is smaller than predefined area";
        } else {
            return "Calculated area matches predefined area";
        }
    }

    public static void displayPolygon(int sides) {
        String polygonShape = findPolygonShape(sides);
        System.out.println("Shape: " + polygonShape);
    }

    public static boolean askUserToViewImage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to view an image of the polygon? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes");
    }

    public static void displayImage(String polygonShape) {
        try {
            String imagePath = "ISEimages/" + polygonShape + ".png"; 
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                System.out.println("Displaying the polygon image...");
                java.awt.Desktop.getDesktop().open(imageFile);
            } else {
                System.err.println("Image file not found for " + polygonShape);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while displaying the image.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of sides for the polygon: ");
        int sides = scanner.nextInt();
        if (!isPolygonValid(sides)) {
            System.err.println("Invalid number of sides");
            scanner.close();
            return;
        }

        System.out.print("Enter the side length (in centimeters): ");
        double sideLength = scanner.nextDouble();
        if (sideLength < 1 || sideLength > 20) {
            System.err.println("Invalid side length. Length should be between 1 and 20 centimeters.");
            scanner.close();
            return;
        }

        String polygonShape = findPolygonShape(sides);
        System.out.println("Shape of the polygon with " + sides + " sides: " + polygonShape);

        double perimeter = calculatePerimeter(sides, sideLength);
        double calculatedArea = calculateArea(sides, sideLength);
        double predefinedArea = sideLength * sideLength;

        if (perimeter >= 0.0) {
            System.out.println("Perimeter: " + perimeter + " cm");
        }

        if (calculatedArea >= 0.0) {
            System.out.println("Calculated Area: " + calculatedArea + " sq. cm");
            System.out.println(compareArea(calculatedArea, predefinedArea));
        }

        boolean viewImage = askUserToViewImage();
        if (viewImage) {
            displayImage(polygonShape);
        }

        displayPolygon(sides);

        scanner.close();
    }
}
