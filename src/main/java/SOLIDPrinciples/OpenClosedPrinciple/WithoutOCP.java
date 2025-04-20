package SOLIDPrinciples.OpenClosedPrinciple;

public class WithoutOCP {
//    ❌ Violates OCP - Need to modify this class whenever a new shape is added

    class AreaCalculator {
        public double calculateArea(Object shape) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                return Math.PI * c.radius * c.radius;
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                return r.length * r.breadth;
            }
            return 0;
        }
    }
}
