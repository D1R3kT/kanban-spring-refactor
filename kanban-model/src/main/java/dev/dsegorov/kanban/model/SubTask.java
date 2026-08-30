package dev.dsegorov.kanban.model;

import dev.dsegorov.kanban.model.ids.EpicId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Подзадача - часть эпика.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder(toBuilder = true)
public class SubTask extends BaseEntity {
    //region fields

    /**
     * Название подзадачи.
     */
    private final String name;

    /**
     * Описание подзадачи.
     */
    private final String description;

    /**
     * Статус выполнения.
     */
    private final Status status;

    /**
     * Время начала.
     */
    private final LocalDateTime startTime;

    /**
     * Плановая длительность.
     */
    private final Duration duration;

    /**
     * Ссылка на родительский эпик.
     */
    private final EpicId epicId;

    //endregion
    //region Public

    /**
     * Возвращает время окончания как {@code startTime + duration}.
     *
     * @return Время окончания задачи или {@code null}, если начало или длительность не заданы.
     */
    public LocalDateTime getEndTime() {

        return (startTime == null || duration == null) ? null : startTime.plus(duration);
    }

    /**
     * Возвращает тип задачи.
     *
     * @return Тип задачи.
     */
    public TaskType getType() {

        return TaskType.SUBTASK;
    }

    //endregion
}
