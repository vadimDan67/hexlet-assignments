package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    public Segment(Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }
    public Point getMidPoint() {
        var x = (beginPoint.getX() + endPoint.getX()) / 2;
        var y = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(x, y);
    }
    public Point getBeginPoint() {
        return this.beginPoint;
    }
    public Point getEndPoint() {
        return this.endPoint;
    }
}
// END
