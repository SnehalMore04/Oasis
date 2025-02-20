import java.util.Scanner;

class BankAccount {
    String fname;
    String lname;
    String name = fname + lname;
    String userName;
    String password;
    String accountNumber;
    float intialBalance = 10000f;
    int ntransactions = 0;
    String transactionHistory = " ";

    // to return all details
    public void register() {
        System.out.println("\n<---Registration Form--->");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your First Name:");
        this.fname = sc.nextLine();
        System.out.println("----------------------");
        System.out.println("Enter your Last Name:");
        this.lname = sc.nextLine();
        System.out.println("----------------------");
        System.out.println("Enter your Username:");
        this.userName = sc.nextLine();
        System.out.println("---------------------");
        System.out.println("Enter your Password:");
        this.password = sc.nextLine();
        System.out.println("---------------------");
        System.out.println("Enter your Account Number:");
        this.accountNumber = sc.nextLine();
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("** Registered Successfully!! **");
        System.out.println("-------------------------------\n");
        System.out.println("Kindly Login into your Bank Account-->>");
    }

    public boolean login() {
        boolean logedin = false;
        Scanner sc = new Scanner(System.in);
        while (!logedin) {
            System.out.println();
            System.out.println("-->> Login Page <<--");
            System.out.println("Enter your Username: ");
            String username = sc.nextLine();
            if (username.equals(userName)) {
                while (!logedin) {
                    System.out.println("--------------------");
                    System.out.println("Enter your Password:");
                    String pass = sc.nextLine();
                    if (pass.equals(password)) {
                        System.out.println();
                        System.out.println("------------------------------");
                        System.out.println("**Logged in Successfully!!!**");
                        System.out.println("------------------------------");
                        System.out.println();
                        logedin = true;
                    } else {
                        System.out.println("ERROR: Incorrect Password..Please try again..");
                    }
                }
            } else {
                System.out.println("ERROR: User does not exist");
            }
        }
        return logedin;
    }

    public void withdraw() {
        System.out.println("Enter your withdrawal ammount:");
        Scanner sc = new Scanner(System.in);
        float ammount = sc.nextFloat();
        try {
            if (intialBalance >= ammount) {
                ntransactions++;
                intialBalance = intialBalance - ammount;
                System.out.println("\n---------------------------------------------");
                System.out.println("|    Rs. " + ammount + " withdraw successfully!!     |");
                System.out.println("---------------------------------------------");
                String str = "Withdrawn: Rs. " + ammount + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Insufficient balance. Please check the amount.");
            }
        } catch (Exception e) {

        }
    }

    public void deposite() {
        System.out.println("Enter your deposite ammount:");
        Scanner sc = new Scanner(System.in);
        float ammount = sc.nextFloat();
        try {
            if (10000f >= ammount) {
                ntransactions++;
                intialBalance = intialBalance + ammount;
                System.out.println("---------------------------------------------");
                System.out.println("|     Rs." + ammount + " deposited successfully!!    |");
                System.out.println("---------------------------------------------");
                String str = "Deposited: Rs. " + ammount + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Please check your amount. The limit is 10000");
            }
        } catch (Exception e) {

        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter recepient's name:");
        String resName = sc.nextLine();
        System.out.println("Enter amount to transfer:");
        float amount = sc.nextFloat();
        try {
            if (intialBalance >= amount) {
                if (amount <= 50000f) {
                    ntransactions++;
                    intialBalance = intialBalance - amount;
                    System.out.println("\n----------------------------------------------------------------");
                    System.out.println(
                            "|            Rs." + amount + " transfered successfully to " + resName + "            |");
                    System.out.println("----------------------------------------------------------------");
                    String str = "Rs. " + amount + " transferd to " + resName + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry!! The limit is Rs.50,000");
                }
            } else {
                System.out.println("\nInsufficient balance");
            }
        } catch (Exception e) {

        }
    }

    public void checkBalance() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                  Your Account Balance: Rs." + intialBalance + "                  |");
        System.out.println("--------------------------------------------------------------------------------\n");
    }

    public void transactionHis() {
        if (ntransactions == 0) {
            System.out.println("======= TRANSACTION HISTORY =======");
            System.out.println("-----------------------------------");
            System.out.println("|         No transactions         |");
            System.out.println("-----------------------------------");
        } else {
            System.out.println("====== TRANSACTION HISTORY ======");
            System.out.println("---------------------------------");
            System.out.println(transactionHistory);
            System.out.println("---------------------------------");
        }
    }
}

// ATM Interface
class Task3 {
    public static int takeLimit(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose number between 1 and " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter correct input values.");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String args[]) {
        System.out.println("<<--WELCOME TO THANE BANK-->>");
        System.out.println("-----------------------------");
        System.out.println("Guidelines:\nPress 1 for Register \nPress 2 for Quit");
        System.out.println("\nEnter your choice:");
        int choice = takeLimit(2);

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("Guidelines:\nPress 1 for Login \nPress 2 for Quit\n");
                System.out.println("Enter your choice:");
                int ch = takeLimit(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("<<---WELCOME BACK " + b.userName + " --->>");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\nGuidelines: \nPress 1 for Withdraw \nPress 2 for Deposite \nPress 3 for Transfer \nPress 4 for Check balance \nPress 5 for Transacation History \nPress 6 for Exit");
                            System.out.println("\n---------------------------------");
                            System.out.print("Enter your choice:");
                            System.out.println();
                            int c = takeLimit(6);
                            System.out.println();
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposite();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transactionHis();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
