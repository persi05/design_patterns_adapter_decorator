package vectorsSolve;

class Polar2DAdapter implements IVector, IPolar2D {
    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }

    @Override
    public double abs() {
        return srcVector.abs();
    }

    @Override
    public double cdot(IVector param) {
        return srcVector.cdot(param);
    }

    @Override
    public double[] getComponents() {
        return srcVector.getComponents();
    }

    @Override
    public double getAngle() {
        return Math.atan2(srcVector.getY(), srcVector.getX());
    }
}