package kz.e16traning.coffeevan.loader;

import kz.e16traning.coffeevan.exceptions.SetMoneyLoaderException;
import kz.e16traning.coffeevan.goods.GenerateGoods;
import kz.e16traning.coffeevan.goods.IGoods;
import kz.e16traning.coffeevan.storage.IStorage;

/**
 * Загрузчик хранилища.
 *
 */
public class Loader {
    private double totalMoney;
    private double money;
    private IStorage storage;

    public Loader(double totalMoney, IStorage storage) throws SetMoneyLoaderException {
        if (totalMoney < 0) {
            throw new SetMoneyLoaderException("Money can't be negative");
        } else {
            this.totalMoney = totalMoney;
            this.storage = storage;
        }
    }

    public void load() {
        while (true) {
            IGoods goods = GenerateGoods.getCoffee();
            if (!load(goods)) {
                break;
            }
            money += goods.getCost();
        }
    }

    private boolean load(IGoods goods) {
        if (!checkMoney(goods) || !storage.add(goods)) return false;
        return true;
    }

    private boolean checkMoney(IGoods goods) {
        return money + goods.getCost() < totalMoney;
    }

    @Override
    public String toString() {
        return " Money used: " + money + " / of " + totalMoney + "\n";
    }
}
