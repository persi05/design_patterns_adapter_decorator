package vectorsSolve;

public class Vector3DInheritance extends Vector2D {
    private double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    @Override
    public double cdot(IVector param) {
        double[] comp = param.getComponents();
        double result = getX() * comp[0] + getY() * comp[1];
        if (comp.length >= 3) {
            result += z * comp[2];
        }
        return result;
    }

    @Override
    public double[] getComponents() {
        return new double[]{getX(), getY(), z};
    }

    public Vector3D cross(IVector param) {
        double[] comp1 = this.getComponents();
        double[] comp2 = param.getComponents();

        double z2 = (comp2.length >= 3) ? comp2[2] : 0.0;

        double rx = comp1[1] * z2 - comp1[2] * comp2[1];
        double ry = comp1[2] * comp2[0] - comp1[0] * z2;
        double rz = comp1[0] * comp2[1] - comp1[1] * comp2[0];

        return new Vector3D(rx, ry, rz);
    }



    public IVector getSrcV() {
        return new Vector3DInheritance(getX(), getY(), z);
    }

    public double getZ() { return z; }
}