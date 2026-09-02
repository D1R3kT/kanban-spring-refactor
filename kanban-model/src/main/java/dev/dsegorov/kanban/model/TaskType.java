package dev.dsegorov.kanban.model;

/**
 * Тип задачи.
 */
public enum TaskType {

    /**
     * Обычная самостоятельная задача.
     */
    TASK,

    /**
     * Подзадача - чать эпика.
     */
    SUBTASK,

    /**
     * Эпик - составная задача, объединяющая подзадачи.
     */
    EPIC

}
