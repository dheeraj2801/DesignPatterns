package SOLIDPrinciples.SingleResponsibilityPrinciple;

//-A class should have only one reason to change, meaning it should have only a single responsibility.

//    ✅ Applying SRP

// Class responsible for withdrawing money
class CashDispenser {
    public void withdrawCash(int amount) {
        System.out.println("Withdrawing " + amount);
    }
}

// Class responsible for balance checking
class BalanceChecker {
    public void checkBalance() {
        System.out.println("Checking balance...");
    }
}

// Class responsible for printing receipts
class ReceiptPrinter {
    public void printReceipt() {
        System.out.println("Printing receipt...");
    }
}

// ATM uses all these functionalities but they are separate
class ATM {
    private final CashDispenser cashDispenser;
    private final BalanceChecker balanceChecker;
    private final ReceiptPrinter receiptPrinter;

    public ATM() {
        this.cashDispenser = new CashDispenser();
        this.balanceChecker = new BalanceChecker();
        this.receiptPrinter = new ReceiptPrinter();
    }

    public void withdraw(int amount) {
        cashDispenser.withdrawCash(amount);
        receiptPrinter.printReceipt();
    }

    public void checkBalance() {
        balanceChecker.checkBalance();
    }
}

public class WithSRP {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw(1000);
        atm.checkBalance();
    }
}
