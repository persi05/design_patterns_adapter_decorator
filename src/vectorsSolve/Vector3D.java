package vectorsSolve;

public class Vector3D implements IVector {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double abs() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double cdot(IVector param) {
        double[] components = param.getComponents();
        double result = x * components[0] + y * components[1];
        if (components.length >= 3) {
            result += z * components[2];
        }
        return result;
    }

    @Override
    public double[] getComponents() {
        return new double[]{x, y, z};
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
}
