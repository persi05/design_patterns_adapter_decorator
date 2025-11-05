package vectorsSolve;

public class Vector3DDecorator implements IVector {
    private IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector srcVector) {
        this(srcVector, 0.0);
    }

    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }

    @Override
    public double abs() {
        double[] comp = srcVector.getComponents();
        return Math.sqrt(comp[0] * comp[0] + comp[1] * comp[1] + z * z);
    }

    @Override
    public double cdot(IVector param) {
        double[] comp1 = srcVector.getComponents();
        double[] comp2 = param.getComponents();
        double result = comp1[0] * comp2[0] + comp1[1] * comp2[1];
        if (comp2.length >= 3) {
            result += z * comp2[2];
        }
        return result;
    }

    @Override
    public double[] getComponents() {
        double[] comp = srcVector.getComponents();
        return new double[]{comp[0], comp[1], z};
    }

    public Vector3D cross(IVector param) {
        double[] comp1 = this.getComponents();
        double[] comp2 = param.getComponents();

        // [i, j, k]
        // [x1, y1, z1]
        // [x2, y2, z2]

        double z2 = (comp2.length >= 3) ? comp2[2] : 0.0;

        double rx = comp1[1] * z2 - comp1[2] * comp2[1];
        double ry = comp1[2] * comp2[0] - comp1[0] * z2;
        double rz = comp1[0] * comp2[1] - comp1[1] * comp2[0];

        return new Vector3D(rx, ry, rz);
    }

    public IVector getSrcV() {
        return srcVector;
    }
}