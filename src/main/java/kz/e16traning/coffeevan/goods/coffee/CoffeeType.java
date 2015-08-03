package kz.e16traning.coffeevan.goods.coffee;

/**
 * Тип кофе.
 *
 */
public enum CoffeeType {
    ARABICA,
    ROBUSTA,
    LIBERICA;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
}
