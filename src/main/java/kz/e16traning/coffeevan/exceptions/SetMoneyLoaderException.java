package kz.e16traning.coffeevan.exceptions;

/**
 * Ошибка установки отрицательного значения
 * для суммы на которую осуществляется загрузка.
 *
 */
public class SetMoneyLoaderException
        extends ProjectMainException {
    public SetMoneyLoaderException(String message) {
        super(message);
    }
}
