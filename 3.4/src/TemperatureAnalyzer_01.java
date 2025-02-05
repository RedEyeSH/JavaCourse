import java.io.*;
import java.net.*;

public class TemperatureAnalyzer_01 {
    private static final String FILE = "https://users.metropolia.fi/~jarkkov/temploki.csv";

    public static void main(String[] args) {
        double totalTemperature = 0;
        int count = 0;
        String targetDate = "01.01.2023";

        try {
            URL url = new URL(FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            String[] headers = reader.readLine().split(";");
            int tempColumnIndex = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase("UlkoTalo")) {
                    tempColumnIndex = i;
                    break;
                }
            }

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > tempColumnIndex) {
                    String dateTime = data[0];
                    if (dateTime.startsWith(targetDate)) {
                        try {
                            double temp = Double.parseDouble(data[tempColumnIndex].replace(",", "."));
                            totalTemperature += temp;
                            count++;
                        } catch (NumberFormatException e) {
                            System.out.println("Skipping invalid temperature value: " + data[tempColumnIndex]);
                        }
                    }
                }
            }

            reader.close();

            if (count > 0) {
                double avgTemp = totalTemperature / count;
                System.out.printf("Average temperature on January 1, 2023: %.2f°C%n", avgTemp);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
