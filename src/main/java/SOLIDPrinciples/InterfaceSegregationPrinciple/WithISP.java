package SOLIDPrinciples.InterfaceSegregationPrinciple;
//- Clients should not be forced to depend on interfaces they do not use.
//Large interfaces should be split into smaller, more specific interfaces.

// Separate interfaces for each functionality
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

// Basic Printer only implements what it supports
class BasicPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing Document...");
    }
}

// Advanced Printer supports printing and scanning
class AdvancedPrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Printing Document...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning Document...");
    }
}

// Multi-Function Printer supports print, scan, and fax
class MultiFunctionMachine implements Printer, Scanner, Fax {
    @Override
    public void print() {
        System.out.println("Printing Document...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning Document...");
    }

    @Override
    public void fax() {
        System.out.println("Faxing Document...");
    }
}

public class WithISP {
    public static void main(String[] args) {
        MultiFunctionMachine multiFunctionMachine = new MultiFunctionMachine();
        multiFunctionMachine.print();
        multiFunctionMachine.scan();
        multiFunctionMachine.fax();
    }
}
