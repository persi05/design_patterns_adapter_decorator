package vectorsSolve;

class PolarInheritance2D extends Vector2D implements IPolar2D {
    public PolarInheritance2D(double x, double y) {
        super(x, y);
    }

    @Override
    public double getAngle() {
        return Math.atan2(getY(), getX());
    }
}
