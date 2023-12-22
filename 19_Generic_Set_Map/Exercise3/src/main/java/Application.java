import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        final String csvPath = sc.next();

        try (BufferedReader bf = new BufferedReader(new FileReader(csvPath))) {
            final HashMap<String, Integer> votesMap = new HashMap<>();

            String line = bf.readLine();
            while (line != null) {
                final String[] parts = line.split(",");

                // Check if already exists.
                final int voteCount = Integer.parseInt(parts[1]);
                if (votesMap.containsKey(parts[0])) {
                    int currentVotes = votesMap.get(parts[0]);
                    votesMap.put(parts[0], currentVotes+voteCount);
                } else {
                    votesMap.put(parts[0], voteCount);
                }

                line = bf.readLine();
            }

            // Output.
            for (String key : votesMap.keySet()) {
                System.out.println(key + ": " + votesMap.get(key));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
