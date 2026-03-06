public class UseCase11PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     */
    public static void main(String[] args) {

        String input = "racecar";

        PalindromeService service = new PalindromeService();
        boolean result = service.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    public boolean checkPalindrome(String input) {

        // Initialize pointers
        int start = 0;
        int end = input.length() - 1;

        // Compare characters moving inward
        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}