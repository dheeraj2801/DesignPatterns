package SOLIDPrinciples.LiskovSubstitutionPrinciple;

//-Subtypes should be substitutable for their base types.
//If a subclass cannot be used in place of its superclass, then it violates LSP.
interface Bird { }

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich implements Bird {
    public void run() {
        System.out.println("Ostrich is running");
    }
}

public class WithLSP {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Ostrich ostrich = new Ostrich();
        sparrow.fly();
        ostrich.run();
    }
}
