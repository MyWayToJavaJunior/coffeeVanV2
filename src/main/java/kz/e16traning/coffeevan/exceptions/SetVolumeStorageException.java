package kz.e16traning.coffeevan.exceptions;

/**
 * Ошибка установки отрицательного значения
 * для обьема загрузки.
 */
public class SetVolumeStorageException
        extends ProjectMainException {
    public SetVolumeStorageException(String message) {
        super(message);
    }
}
