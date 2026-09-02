package dev.dsegorov.kanban.model;

/**
 * Статус выполнения задачи.
 */
public enum Status {

    /**
     * Создана, ещё не в работе.
     */
    NEW,

    /**
     * В работе.
     */
    IN_PROGRESS,

    /**
     * Выполнена.
     */
    DONE
}
