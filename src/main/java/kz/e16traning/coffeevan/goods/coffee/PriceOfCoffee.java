package kz.e16traning.coffeevan.goods.coffee;

import kz.e16traning.coffeevan.exceptions.LoadPriceFromFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Загрузка цен на кофе
 * из файла.
 *
 */
public class PriceOfCoffee {
    private final static String SOURCE_PATH = "price.txt";
    private static Map<CoffeeType, Double> priceFromFile = new HashMap<>();

    private void loadPrice() throws LoadPriceFromFileException {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(SOURCE_PATH);
            properties.load(fis);
            for (int i = 0; i < CoffeeType.values().length; i++) {
                priceFromFile.put(CoffeeType.values()[i],
                        Double.valueOf(properties.getProperty(
                                CoffeeType.values()[i].name())));
            }
        } catch (IOException e) {
            throw new LoadPriceFromFileException("Cant load price from file");
        }
    }

    public PriceOfCoffee() throws LoadPriceFromFileException {
        loadPrice();
    }

    public static Map<CoffeeType, Double> getPrice() {
        return priceFromFile;
    }
}
