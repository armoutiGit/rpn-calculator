import java.util.Scanner;

/**
 * A program for an RPN calculator that uses a stack.
 */
public final class Calc {
  private static int stackSize;
  private static LinkedStack<Integer> rpnStack = new LinkedStack<Integer>();
  private static Scanner scnr = new Scanner(System.in);

  /**
   * The main function.
   *
   * @param args Not used.
   */
  public static void main(String[] args) {
    String e = scnr.next();
    stackSize = 0;
    // accept user input as long as ! not inputted
    while (!"!".equals(e)) {
      if ("?".equals(e) || ".".equals(e)) {
        specialCommand(e.charAt(0));
      } else if ("*".equals(e) || "/".equals(e) || "%".equals(e)) {
        evaluate(e.charAt(0));
      } else if ("+".equals(e) || "-".equals(e)) {
        evaluate(e.charAt(0));
      } else {
        // e should be integer. if parseInt throws exception, catch, print error
        validateInt(e);
      }
      // get next input
      e = scnr.next();
    }
  }

  // helper method to print either . or ? result
  private static void specialCommand(char c) {
    if (c == '.') {
      if (stackSize == 0) {
        System.err.println("ERROR: Empty stack");
        return;
      }
      System.out.println(rpnStack.top());
    } else {
      System.out.println(rpnStack.toString());
    }
  }

  // helper method to perform operation
  private static void evaluate(char operator) {

    if (stackSize < 2) {
      System.err.println("ERROR: Not enough arguments.");
      return;
    }

    //division by zero or modulo zero
    if ((rpnStack.top() == 0) && (operator == '/' || operator == '%')) {
      System.err.println("ERROR: division by zero");
      return;
    }

    // get integers to be evaluated
    int first = rpnStack.top();
    rpnStack.pop();
    int second = rpnStack.top();
    rpnStack.pop();
    //now perform the operation and update stack size
    mySwitch(operator, first, second);
    stackSize -= 1;
  }

  // perform operation by traversing through switch
  private static void mySwitch(char operator, int first, int second) {
    switch (operator) {
      case '*':
        rpnStack.push(second * first);
        break;
      case '/':
        rpnStack.push(second / first);
        break;
      case '+':
        rpnStack.push(second + first);
        break;
      case '-':
        rpnStack.push(second - first);
        break;
      default:
        rpnStack.push(second % first);
        break;
    }
  }

  // helper method to check user input is integer
  private static void validateInt(String e) {
    try {
      rpnStack.push(Integer.parseInt(e));
      stackSize += 1;
    } catch (NumberFormatException num) {
      System.err.println("ERROR: bad token");
    }
  }

}
