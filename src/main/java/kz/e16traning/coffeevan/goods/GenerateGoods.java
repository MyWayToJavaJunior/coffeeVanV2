package kz.e16traning.coffeevan.goods;

import kz.e16traning.coffeevan.goods.coffee.Coffee;
import kz.e16traning.coffeevan.goods.coffee.CoffeeCondition;
import kz.e16traning.coffeevan.goods.coffee.CoffeeType;
import kz.e16traning.coffeevan.goods.coffee.CoffeeWrap;

import java.util.Random;

/**
 * Генератор товаров.
 *
 */
public class GenerateGoods {
    public static IGoods getCoffee() {
        return new Coffee(Enums.random(CoffeeType.class),
                Enums.random(CoffeeCondition.class),
                Enums.random(CoffeeWrap.class));
    }

    public static class Enums {
        private static Random random = new Random(47);
        public static <T extends Enum<T>> T random(Class<T> ec) {
            return random(ec.getEnumConstants());
        }
        public static <T> T random(T[] values) {
            return values[random.nextInt(values.length)];
        }
    }
}
