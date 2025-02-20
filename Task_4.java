import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Question {
    String questionText;
    List<String> options;
    int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

class User {

    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Task_4 {
    static List<Question> questions = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static User loggedInUser;
    static boolean sessionOpen = false;

    public static void main(String args[]) {

        startQuestions();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Exit");
            System.out.println("\nEnter your choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    register(sc);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select valid option.");
                    break;
            }
        }
    }

    public static void startQuestions() {
        List<String> options1 = new ArrayList<>();
        options1.add("0");
        options1.add("null");
        options1.add("Not Assigned");
        options1.add("1");

        List<String> options2 = new ArrayList<>();
        options2.add("Java supports multiple inheritance using classes");
        options2.add("Java is a platform-independent programming language");
        options2.add("Java is a purely procedural language");
        options2.add("Java does not support multithreading");

        List<String> options3 = new ArrayList<>();
        options3.add("4 bytes");
        options3.add("8 bytes");
        options3.add("16 bytes");
        options3.add("2 bytes");

        List<String> options4 = new ArrayList<>();
        options4.add("static");
        options4.add("private");
        options4.add("unsigned");
        options4.add("synchronized");

        List<String> options5 = new ArrayList<>();
        options5.add("11");
        options5.add("12");
        options5.add("13");
        options5.add("14");

        List<String> options6 = new ArrayList<>();
        options6.add("A) String");
        options6.add("B) Object");
        options6.add("C) Class");
        options6.add("D) System");

        List<String> options7 = new ArrayList<>();
        options7.add("true");
        options7.add("false");
        options7.add("Compilation error");
        options7.add("Runtime error");

        List<String> options8 = new ArrayList<>();
        options8.add("Defining multiple methods with the same name but different parameter lists");
        options8.add("Defining multiple methods with the same name and same parameters");
        options8.add("Redefining a method in a subclass");
        options8.add("Using the final keyword with a method");

        List<String> options9 = new ArrayList<>();
        options9.add("An abstract class cannot have a constructor");
        options9.add("An abstract class can have both abstract and non-abstract methods");
        options9.add("An abstract class must be declared as final");
        options9.add("An abstract class cannot have instance variables");

        List<String> options10 = new ArrayList<>();
        options10.add("NullPointerException");
        options10.add("ArrayIndexOutOfBoundsException");
        options10.add("NumberFormatException");
        options10.add("IllegalArgumentException");

        Question question1 = new Question(" What is the default value of an instance variable of type `int` in Java?",
                options1, 0);
        Question question2 = new Question(" Which of the following is true about Java?", options2, 1);
        Question question3 = new Question(" What is the size of the long data type in Java?", options3, 1);
        Question question4 = new Question(" Which of the following is not a valid Java keyword?", options4, 2);
        Question question5 = new Question(
                " What will be the output of the following code?\nCode:\nint x = 5;\nSystem.out.println(x++ + ++x);",
                options5, 2);
        Question question6 = new Question(" Which class in Java is the parent class of all classes?", options6, 1);
        Question question7 = new Question(
                " What is the output of the following code?\nCode:\nString s1 = \"Java\";\r\n" + //
                        "String s2 = new String(\"Java\");\r\n" + //
                        "System.out.println(s1 == s2);\r" + //
                        "",
                options7, 1);
        Question question8 = new Question(" What is method overloading in Java?", options8, 0);
        Question question9 = new Question(" Which of the following is true about an abstract class in Java?",
                options9, 1);
        Question question10 = new Question(
                " Which exception is thrown when an array is accessed with an invalid index in Java?", options10, 1);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);
    }

    public static void register(Scanner sc) {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter a password:");
        String password = sc.nextLine();

        for (User user : users) {

            if (user.username.equals(username)) {
                System.out.println("Username already exists. Please choose another one.");
                return;
            }
        }

        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful! You can now log in now.");
    }

    public static void login(Scanner sc) {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter a password:");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                loggedInUser = user;
                sessionOpen = true;
                startExam(sc);
                return;
            }
        }
        System.out.println("Invalid username or password. Please try again..");
    }

    public static void startExam(Scanner sc) {
        System.out.println("\n**  Welcome," + loggedInUser.username + "! **");
        System.out.println("-------------------------------------------------\n");
        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ":" + q.questionText);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + "." + q.options.get(j));
            }

            System.out.println("Select your answer (1-" + q.options.size() + "): ");
            int userChoice = sc.nextInt();
            if (userChoice == q.correctOption + 1) {
                System.out.println("Correct!");
                System.out.println("---------------------------------------------------------\n");
            } else {
                System.out.println("Incorrect!");
                System.out.println("---------------------------------------------------------\n");
            }
        }
        System.out.println("Exam completed!");
        sessionOpen = false;
    }
}
