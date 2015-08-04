package kz.e16traning.coffeevan;

import kz.e16traning.coffeevan.exceptions.ProjectMainException;
import kz.e16traning.coffeevan.goods.GenerateGoods;
import kz.e16traning.coffeevan.goods.coffee.PriceOfCoffee;
import kz.e16traning.coffeevan.loader.Loader;
import kz.e16traning.coffeevan.storage.IStorage;
import kz.e16traning.coffeevan.storage.Storage;


/**
 * @author DK
 * @version 1.0.0
 */
public class Run {
	public static void main(String[] args) {
		try {
			GenerateGoods generateGoods = new GenerateGoods();
			PriceOfCoffee priceOfCoffee = new PriceOfCoffee();
			IStorage van = new Storage(500);
			Loader loader = new Loader(700, van);
			loader.load();
			System.out.println(van);
			System.out.println(loader);
		} catch (ProjectMainException e) {
			System.out.println(e.getMessage());
		}
	}
}