package dev.dsegorov.kanban.model;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

/**
 * Базовый класс сущностей.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public abstract class BaseEntity {
    //region Fields

    /**
     * ID сущности.
     */
    @Id
    @Builder.Default
    @EqualsAndHashCode.Include
    protected UUID id = UUID.randomUUID();

    /**
     * Дата создания.
     */
    @WhenCreated
    protected Instant createdDate;

    /**
     * Дата последнего изменения.
     */
    @WhenModified
    protected Instant modifiedDate;

    /**
     * Версия.
     */
    @Version
    protected Long version;

    //endregion
}
