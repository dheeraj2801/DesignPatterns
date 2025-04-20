package SOLIDPrinciples.InterfaceSegregationPrinciple;

public class WithoutISP {
//    ❌ This violates ISP because not all printers have scan and fax capabilities.

    interface MultiFunctionPrinter {
        void print();
        void scan();
        void fax();
    }

    // Basic printer only supports printing but is forced to implement unused methods.
    class BasicPrinter implements MultiFunctionPrinter {
        @Override
        public void print() {
            System.out.println("Printing document...");
        }

        @Override
        public void scan() {
            throw new UnsupportedOperationException("Scan not supported!");
        }

        @Override
        public void fax() {
            throw new UnsupportedOperationException("Fax not supported!");
        }
    }
}
