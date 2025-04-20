package SOLIDPrinciples.LiskovSubstitutionPrinciple;

public class WithoutLSP {
//    ❌ Violates LSP
    class Bird {
        public void fly() {
            System.out.println("Bird is flying");
        }
    }

    class Ostrich extends Bird {
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Ostriches can't fly!");
        }
    }
}
