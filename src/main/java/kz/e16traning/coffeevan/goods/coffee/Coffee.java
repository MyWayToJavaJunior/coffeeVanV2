package kz.e16traning.coffeevan.goods.coffee;

import kz.e16traning.coffeevan.goods.IGoods;


/**
 * Описание кофе.
 *
 */
public class Coffee implements IGoods {
    private int totalVolume;
    private int volumeOfCoffee;
    private double cost;
    private CoffeeType coffeeType;
    private CoffeeCondition coffeeCondition;
    private CoffeeWrap coffeeWrap;

    public Coffee(CoffeeType coffeeType,
                  CoffeeCondition coffeeCondition,
                  CoffeeWrap coffeeWrap) {
        this.coffeeType = coffeeType;
        this.coffeeCondition = coffeeCondition;
        this.coffeeWrap = coffeeWrap;
        this.totalVolume = coffeeWrap.getVolume()
                + coffeeWrap.getVolumeOfWrap();
        this.volumeOfCoffee = coffeeWrap.getVolume();
        this.cost = PriceOfCoffee.getPrice().get(coffeeType)
                * coffeeWrap.getVolume();
    }

    @Override
    public int getVolume() {
        return totalVolume;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("( %8s, %7s, %7s: %4s %4s %6s )",
                this.coffeeType, this.coffeeCondition,
                this.coffeeWrap, this.volumeOfCoffee,
                this.totalVolume, this.cost);
    }
}
