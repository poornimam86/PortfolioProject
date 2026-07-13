package portfolioproject.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import portfolioproject.model.Portfolio;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Save Portfolio to JSON
    public static void savePortfolio(Portfolio portfolio, String fileName) {

        try {

            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File(fileName), portfolio);

            System.out.println("\nPortfolio saved successfully to " + fileName);

        } catch (IOException e) {

            System.out.println("Error while saving portfolio.");
            e.printStackTrace();
        }
    }

    // Load Portfolio from JSON
    public static Portfolio loadPortfolio(String fileName) {

        try {

            return mapper.readValue(new File(fileName), Portfolio.class);

        } catch (IOException e) {

            System.out.println("Error while loading portfolio.");
            e.printStackTrace();

            return null;
        }
    }
}