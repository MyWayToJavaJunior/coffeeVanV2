package kz.e16traning.coffeevan.storage;


import kz.e16traning.coffeevan.goods.IGoods;

/**
 * Общий итерфейс для хранилищ.
 *
 */
public interface IStorage {
    boolean add(IGoods goods);
}
