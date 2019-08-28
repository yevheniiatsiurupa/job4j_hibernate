package ru.job4j.hiber.models;

/**
 * Класс, который используется в ShowServlet,
 * определяет какие элементы необходимо вернуть в ответе (все или
 * отфильтрованные).
 * @author Evgeniya Tsiurupa
 * @version 1.0
 * @since 28/08/2019
 */
public class FilterJson {
    private boolean showAll;

    public FilterJson(boolean showAll) {
        this.showAll = showAll;
    }

    public FilterJson() {
    }

    public boolean isShowAll() {
        return showAll;
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }
}
