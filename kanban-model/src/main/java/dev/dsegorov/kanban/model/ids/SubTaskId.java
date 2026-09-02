package dev.dsegorov.kanban.model.ids;

import java.util.UUID;

/**
 * Типизированный ID поздачи.
 *
 * @param value ID подзадачи.
 */
public record SubTaskId(UUID value) {

    /**
     * Создаёт ID задачи из значения.
     *
     * @param value ID задачи.
     *
     * @return ID задачи.
     */
    public static SubTaskId of(UUID value) {

        return new SubTaskId(value);
    }

}
