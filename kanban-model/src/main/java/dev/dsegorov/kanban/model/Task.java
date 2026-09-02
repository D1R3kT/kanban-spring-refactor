package dev.dsegorov.kanban.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Задача - базовая единица работы в канбане.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder(toBuilder = true)
public class Task extends BaseEntity {
    //region Fields

    /**
     * Название задачи.
     */
    private final String name;

    /**
     * Описание задачи.
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

        return TaskType.TASK;
    }

    //endregion
}
