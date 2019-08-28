package ru.job4j.hiber.validation;

import ru.job4j.hiber.models.Item;
import ru.job4j.hiber.persistence.DbStore;

import java.util.List;

/**
 * Класс для валидации данных.
 * @author Evgeniya Tsiurupa
 * @version 1.0
 * @since 28/08/2019
 */
public class ValidateService {
    /**
     * Ссылка на объект MemoryStore, в котором находится хранилище пользователей.
     */
    private final DbStore logic = DbStore.getInstance();

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final ValidateService INSTANCE = new ValidateService();
    }

    public void addOrUpdateItem(Item item) throws Exception {
        this.logic.addOrUpdateItem(item);
    }

    public List findAll() throws Exception {
        return this.logic.findAll();
    }

    public List findFiltered() throws Exception {
        return this.logic.findFiltered();
    }
}
