package vectorsSolve;

public class Main {

    public static void printCartesian(IVector vec) {
        double[] comp = vec.getComponents();
        for (int i = 0; i < comp.length; i++) {
            System.out.print(comp[i]);
            if (i < comp.length - 1) System.out.print(", ");
        }
    }

    public static void printPolar(IPolar2D vec) {
        double r = vec.abs();
        double angle = vec.getAngle();
        // double angleDeg = angle * 180.0 / Math.PI;
        // System.out.printf("r = %.2f, fi = %.4f rad (%.2f°)", r, angle, angleDeg);
        System.out.printf("r = %.2f, fi = %.4f rad", r, angle);
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3.0, 4.0);
        Vector2D v2 = new Vector2D(2.0, 7.0);
        Vector2D v3 = new Vector2D(-2.0, 1.0);
        Vector3DInheritance v4 = new Vector3DInheritance(-1.0, -2.0, -3.0);

        Vector2D[] vectors = {v1, v2, v3};
        String[] names = {"v1", "v2", "v3"};

        System.out.println("1. WSPOLRZEDNE WEKTOROW");

        for (int i = 0; i < 3; i++) {
            Polar2DAdapter adapter = new Polar2DAdapter(vectors[i]);
            System.out.println(names[i] + ":");
            System.out.print("  Kartezjanski: ");
            printCartesian(vectors[i]);
            System.out.println();
            System.out.print("  Biegunowy:    ");
            printPolar(adapter);
            System.out.println("\n");
        }

        System.out.println("ILOCZYNY SKALARNE");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double dotProduct = vectors[i].cdot(vectors[j]);
                System.out.printf("%s * %s = %.2f\n", names[i], names[j], dotProduct);
            }
        }
        System.out.println();

        System.out.println("ILOCZYNY WEKTOROWE");

        Vector3DDecorator dec1 = new Vector3DDecorator(v1);
        Vector3DDecorator dec2 = new Vector3DDecorator(v2);
        Vector3DDecorator dec3 = new Vector3DDecorator(v3);

        Vector3DDecorator[] decorators = {dec1, dec2, dec3};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Vector3D crossProduct = decorators[i].cross(decorators[j]);
                System.out.printf("%s x %s = ", names[i], names[j]);
                printCartesian(crossProduct);
                System.out.println();
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();


        System.out.print("v4  ");
        printCartesian(v4);
        System.out.printf("\n|v4| = %.2f\n", v4.abs());

        for (int j = 0; j < 3; j++) {
            double dotProduct = v4.cdot(vectors[j]);
            System.out.printf("v4 * %s = %.2f\n", names[j], dotProduct);
        }

        double dotProduct = v4.cdot(v4);
        System.out.printf("v4 * v4 = %.2f\n", dotProduct);
        System.out.println();

        for (int j = 0; j < 3; j++) {
            Vector3D cross_v4 = v4.cross(decorators[j]);
            System.out.printf("v4 x %s = ", names[j]);
            printCartesian(cross_v4);
            System.out.println();
        }

        Vector3D cross_v4 = v4.cross(v4);
        System.out.print("v4 x v4 = ");
        printCartesian(cross_v4);
        System.out.println();

        Vector3DDecorator dec4 = new Vector3DDecorator(v4);
        for (int j = 0; j < 3; j++) {
            Vector3D cross_v_v4 = decorators[j].cross(dec4);
            System.out.printf("%s x v4 = ", names[j]);
            printCartesian(cross_v_v4);
            System.out.println();
        }
    }
}