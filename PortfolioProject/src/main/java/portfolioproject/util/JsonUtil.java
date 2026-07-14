package portfolioproject.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import portfolioproject.model.Portfolio;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Save Portfolio to JSON
    public static void savePortfolio(Portfolio portfolio, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName)) {

            mapper.writerWithDefaultPrettyPrinter().writeValue(fos, portfolio);

            System.out.println("\nPortfolio saved successfully to " + fileName);

        } catch (IOException e) {

            System.out.println("Error while saving portfolio.");
            e.printStackTrace();
        }
    }

    // Load Portfolio from JSON
    public static Portfolio loadPortfolio(String fileName) {

        try (FileInputStream fis = new FileInputStream(fileName)) {

            return mapper.readValue(fis, Portfolio.class);

        } catch (IOException e) {

            System.out.println("Error while loading portfolio.");
            e.printStackTrace();

            return null;
        }
    }
}