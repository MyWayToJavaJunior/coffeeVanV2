package kz.e16traning.coffeevan.exceptions;

/**
 * Ошибка загрузки цен из файла.
 *
 */
public class LoadPriceFromFileException
        extends ProjectMainException {
    public LoadPriceFromFileException(String message) {
        super(message);
    }
}
