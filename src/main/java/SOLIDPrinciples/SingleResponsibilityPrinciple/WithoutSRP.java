package SOLIDPrinciples.SingleResponsibilityPrinciple;

public class WithoutSRP {
//    ❌ Violating SRP
    class ATM {
        public void withdrawCash(int amount) {
            System.out.println("Withdrawing " + amount);
        }

        public void checkBalance() {
            System.out.println("Checking balance...");
        }

        public void printReceipt() {
            System.out.println("Printing receipt...");
        }
    }
}
