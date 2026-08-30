package dev.dsegorov.kanban.model;

import dev.dsegorov.kanban.model.ids.SubTaskId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Эпик - составная задача, объединяющая подзадачи.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder(toBuilder = true)
public class Epic extends BaseEntity{
    //region Fields

    /**
     * Название эпика.
     */
    private final String name;

    /**
     * Описание эпика.
     */
    private final String description;

    /**
     * Статус, вычесленный по статусам подзадач.
     */
    private final Status status;

    /**
     * Время начала - самое раннее среди подзадач.
     */
    private final LocalDateTime startTime;

    /**
     * Суммарная длительность подзадач.
     */
    private final Duration duration;

    /**
     * Время окончания - самое позднее среди подзадач.
     */
    private final LocalDateTime endTime;

    /**
     * Ссылки на подзадачи эпика.
     */
    @Builder.Default
    private final List<SubTaskId> subTaskIds = new ArrayList<>();

    //endregion
    //region Public

    /**
     * Возвращает тип задачи.
     *
     * @return Тип задачи.
     */
    public TaskType getType() {

        return TaskType.EPIC;
    }

    //endregion
}
