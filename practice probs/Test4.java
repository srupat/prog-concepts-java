import java.util.*;

abstract class Account implements Comparable<Account> {
    String acc_no;
    double balance;

    public Account(String no, double bal) {
        acc_no = no;
        balance = bal;
    }

    // Override "compareTo" method here
    public int compareTo(Account a) {
        if (this.balance > a.balance) {
            return -1;
        } else if (this.balance < a.balance) {
            return 1;
        } else
            return 0;
    }

    // Override "equals" method here
    public boolean equals(Account a) {
        if (this.acc_no == a.acc_no)
            return true;
        return false;
    }

    // Override "hashCode" method here
    public int hashCode() {
        return this.acc_no.hashCode();
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String acc_no, double bal) {
        // Complete the definition
        super(acc_no, bal);
    }

    // Override the toString() method
    public String toString() {
        return "Savings Account:" + this.acc_no + " , " + "Balance:" + this.balance;
    }
}

class CurrentAccount extends Account {
    double overdraft_limit;

    public CurrentAccount(String acc_no, double bal, double odl) {
        // Complete the constructor definition}}
        super(acc_no, bal);
        this.overdraft_limit = odl;
    }

    // Override the toString() method}}
    public String toString() {
        return "Current Account:" + this.acc_no + " , " + "Balance:" + this.balance;
    }
}

public class Test4 {
    // Define the `accountProcessor' method here
    // define the treeset here, which will use the overriden compareTo method
    public static void accountProcessor(ArrayList<Account> acc) {
        LinkedHashSet<Account> lhs = new LinkedHashSet<Account>(acc);
        Set<Account> ts = new TreeSet<Account>(lhs);
        for (Account a : ts) {
            System.out.println(a);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<Account> acc = new ArrayList<Account>();

        // reading the number of savings accounts
        int s_acc_count = s.nextInt();
        for (int i = 1; i <= s_acc_count; i++) {
            // reading acc no
            String no = s.next();
            // reading balance
            double bal = s.nextDouble();
            acc.add(new SavingsAccount(no, bal));
        }

        // reading the number of current accounts
        int c_acc_count = s.nextInt();
        for (int i = 1; i <= c_acc_count; i++) {
            // reading acc no
            String no = s.next();
            // reading balance
            double bal = s.nextDouble();
            // reading overdraft limit
            double lim = s.nextDouble();
            acc.add(new CurrentAccount(no, bal, lim));
        }

        accountProcessor(acc);
        s.close();
    }
}