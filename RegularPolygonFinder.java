import java.util.Scanner;

public class RegularPolygonFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Regular Polygon Finder!");
        
        int sides;
        
        do {
            System.out.print("Enter the number of sides (3, 4, 5, or 6): ");
            sides = input.nextInt();
        } while (sides < 3 || sides > 6);
        
        String polygonShape = findPolygonShape(sides);
        
        if (polygonShape != null) {
            System.out.println("The shape of the polygon with " + sides + " sides is: " + polygonShape);
        } else {
            System.out.println("Invalid number of sides.");
        }
        
        input.close();
    }
    
    public static String findPolygonShape(int sides) {
        switch (sides) {
            case 3:
                return "Triangle";
            case 4:
                return "Square or Rectangle";
            case 5:
                return "Pentagon";
            case 6:
                return "Hexagon";
            default:
                return null;
        }
    }
}
