import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
class Guesser1 {
  int guess() {
    Random r = new Random();
    int n = r.nextInt(10);
    return n;
  }
}

class Player1 {
  int n;
  String username = "";
  String password = "";
  int playerGuess(Player1[] p1, int i) {

    System.out.println("enter the number " + " " + p1[i].username + ":");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println();
    System.out.println("the number" + " " + p1[i].username + " " + "entered is :" + " " + n);
    System.out.println();
    return n;
  }
  void signup() {
    System.out.println();
    System.out.println("Welcome to the signup page");
    System.out.println();
    Scanner sc = new Scanner(System.in);
    System.out.println("enter Your UserName:");
    username = sc.nextLine();
    System.out.println("Enter Your Password:");
    password = sc.nextLine();
    System.out.println("Signup succeded");
    System.out.println();
  }
}
class Admin {

  int count = 0;
  void login(Player1[] p1) {

    System.out.println("Welcome to the login page");
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("Enter the username:");
    String user = sc.nextLine();
    System.out.println("Enter the password:");
    String pass = sc.nextLine();
    int count = 0;
    int count1 = 0;
    for (Player1 p: p1) {
      if (user.equalsIgnoreCase(p.username) & pass.equalsIgnoreCase(p.password)) {
        System.out.println("Welcome" + " " + user);
        System.out.println();
        count++;
        return;
      }
    }
    if (count == 0) {
      count1++;
      if (count1 < 3) {
        System.out.println("Try again");
        login(p1);
      } else {
        System.out.println("Try again after sometime! Bye");
        System.exit(0);
      }
    }
  }

}
class Umpire1 {

  
  int count = 0;
  void compare(Player1[] p1, int n) {
	String[] arr = new String[p1.length] ;
	Arrays.fill(arr, "0");
    for (int i = 0; i < p1.length; i++) {
      if (p1[i].playerGuess(p1, i) == n) {
        arr[i] = p1[i].username;
        count++;
      }
    }

    if (count == p1.length) {
      for (Player1 p: p1) {
        System.out.print(p.username + ",");
      }
      System.out.println(" " + "won the game");
      System.exit(0);

    }

    for (String s: arr) {
      if (!s.equals("0"))
        System.out.println(s + " " + "won the game");
    }

    if (count == 0) {
      System.out.println("All players lost the Game!");
      System.out.println("Number is " + n);
    }
  }
}

public class Game1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = "";
    int count1 = 0;
    int count2 = 0;
    int count = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of players");
    int size = sc.nextInt();
    Player1[] p1 = new Player1[size];
    Admin a = new Admin();
    Guesser1 g = new Guesser1();
    Umpire1 u = new Umpire1();
    System.out.println("Welcome to the Guessergame");
    for (int k = 0;; k++) {
      System.out.println("1.Signup 2.Login 3.Game 4.exit");
      System.out.println("Enter your option");
      int choice = sc.nextInt();
      switch (choice) {
      case 1: {
        if (count1 == 0) {
          for (int i = 0; i < p1.length; i++) {
            p1[i] = new Player1();
            p1[i].signup();
          }
          count1++;
          System.out.println("Signup completed for all the players");
          System.out.println();
          break;
        } else {
          System.out.println("Already signed up!Go to Login page");
          break;
        }
      }
      case 2: {
        if(count1>=1) {
    	  for (int i = 0; i < p1.length; i++) {
          a.login(p1);
        }
        count++;
        }
        else {
        	System.out.println("Signup first!");
        	break;
        }
        System.out.println("Login completed for all the players");
        System.out.println();
        break;
      }
      case 3: {

        if (count >= 1 & count1 >= 1) {
          u.compare(p1, g.guess());
          break;
        }
        if (count2 == 2) {
          System.out.println("Try again after some time! Bye");
          System.exit(0);
          break;
        }
        if (k < 3) {
          System.out.println("You have to complete signup and login");
          System.out.println();
          count2++;

        }
        break;

      }
      case 4: {
        System.out.println("Have a nice day ! Bye");
        System.exit(0);
      }
      default:
      { System.out.println("Invalid input!");
    	  break;
      }

      }
    }

  }
}
