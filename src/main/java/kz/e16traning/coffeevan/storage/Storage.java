package kz.e16traning.coffeevan.storage;

import kz.e16traning.coffeevan.exceptions.SetVolumeStorageException;
import kz.e16traning.coffeevan.goods.IGoods;


/**
 * Реализация хранилища, на основе
 * изменяющего размер массива
 *
 */
public class Storage implements IStorage {
    private static final int DEFAULT_CAPACITY = 10;
    private IGoods[] goods;
    private int size;
    private int volume;
    private final int totalVolume;

    private IGoods get(int index) {
        return goods[index];
    }

    private boolean checkVolume(int volume) {
        return this.volume + volume < totalVolume;
    }

    private void checkCapacity(int index) {
        if (index > goods.length) changeDataCapacity();
    }

    private void changeDataCapacity() {
        int newCapacity = (goods.length * 3) / 2 + 1;
        IGoods[] oldGoods = goods;
        goods = new IGoods[newCapacity];
        System.arraycopy(oldGoods, 0, goods, 0, size);
    }

    public String toString() {
        String result = String.format("%10s %9s %7s %5s %5s %5s\n",
                "name", "condition", "wrap", "vol", "tVol", "cost");
        for (int i = 0; i < size; i++) {
            result += get(i).toString() + "\n";
        }
        result += "\n Total loaded: " + volume
                + " / of " + totalVolume + "\n";
        return result;
    }

    public Storage(int totalVolume)
            throws SetVolumeStorageException {
        if (totalVolume < 0) {
            throw new SetVolumeStorageException(
                    "Volume can't be negative");
        } else {
            this.goods = new IGoods[DEFAULT_CAPACITY];
            this.totalVolume = totalVolume;
        }
    }

    public boolean add(final IGoods goods) {
        if (!checkVolume(goods.getVolume())) return false;
        checkCapacity(size + 1);
        this.goods[size++] = goods;
        volume += goods.getVolume();
        return true;
    }

}
