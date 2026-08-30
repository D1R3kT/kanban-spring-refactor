package dev.dsegorov.kanban.model.ids;

import java.util.UUID;

/**
 * Типизированный ID задачи.
 *
 * @param value ID задачи.
 */
public record TaskId(UUID value) {

    /**
     * Создаёт ID задачи из значения.
     *
     * @param value ID задачи.
     *
     * @return ID задачи.
     */
    public static TaskId of(UUID value) {

        return new TaskId(value);
    }
}
