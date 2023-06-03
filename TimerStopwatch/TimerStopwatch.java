import java.util.Scanner;

public class TimerStopwatch {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int MILLISECONDS_IN_SECOND = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Timer");
        System.out.println("2. Stopwatch");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the duration in minutes: ");
                int minutes = scanner.nextInt();
                startTimer(minutes);
                break;
            case 2:
                startStopwatch();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }

    public static void startTimer(int minutes) {
        long durationInMillis = minutes * SECONDS_IN_MINUTE * MILLISECONDS_IN_SECOND;

        try {
            Thread.sleep(durationInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Timer has finished!");
    }

    public static void startStopwatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stopwatch started. Press enter to stop.");

        long startTime = System.currentTimeMillis();
        scanner.nextLine(); 
        long endTime = System.currentTimeMillis();

        long elapsedMillis = endTime - startTime;
        int hours = (int) (elapsedMillis / (MILLISECONDS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR));
        int minutes = (int) ((elapsedMillis / (MILLISECONDS_IN_SECOND * SECONDS_IN_MINUTE)) % MINUTES_IN_HOUR);
        int seconds = (int) ((elapsedMillis / MILLISECONDS_IN_SECOND) % SECONDS_IN_MINUTE);
        int milliseconds = (int) (elapsedMillis % MILLISECONDS_IN_SECOND);

        System.out.printf("Elapsed Time: %02d:%02d:%02d.%03d\n", hours, minutes, seconds, milliseconds);
        scanner.close();
    }
}
