package dev.dsegorov.kanban.model.ids;

import java.util.UUID;

/**
 * Типизированный ID эипика.
 *
 * @param value ID эпика.
 */
public record EpicId(UUID value) {

    /**
     * Создаёт идентификатор эпика из значения.
     *
     * @param value ID эпика.
     *
     * @return ID эпика.
     */
    public static EpicId of(UUID value) {

        return new EpicId(value);
    }
}
