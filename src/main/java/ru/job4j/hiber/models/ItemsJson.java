package ru.job4j.hiber.models;

import java.util.List;

/**
 * Класс, который используется в ShowServlet,
 * содержит список элементов, которые необходимо вернуть в ответе.
 * @author Evgeniya Tsiurupa
 * @version 1.0
 * @since 28/08/2019
 */
public class ItemsJson {
    private List items;

    public ItemsJson(List items) {
        this.items = items;
    }

    public ItemsJson() {
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
