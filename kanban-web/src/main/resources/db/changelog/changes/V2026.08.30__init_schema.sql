--liquibase formatted sql

--changeset David Egorov:2026.08.30.00.00__init_schema

CREATE TABLE epic
(
    id              UUID                        NOT NULL DEFAULT gen_random_uuid(),
    name            TEXT                        NOT NULL,
    description     TEXT,
    status          TEXT                        NOT NULL,
    start_date      TIMESTAMP,
    duration        BIGINT,
    end_time        TIMESTAMP,
    created_date    TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT NOW(),
    modified_date   TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT NOW(),
    version         BIGINT                      NOT NULL DEFAULT 1,

    CONSTRAINT pk_epic PRIMARY KEY (id)
);

COMMENT ON TABLE epic                   IS 'Эпик - составная задача из подзадач';
COMMENT ON COLUMN epic.id               IS 'Идентификатор эпика';
COMMENT ON COLUMN epic.name             IS 'Название';
COMMENT ON COLUMN epic.description      IS 'Описание';
COMMENT ON COLUMN epic.status           IS 'Статус, вычисленный по подзадачам';
COMMENT ON COLUMN epic.start_date       IS 'Время начала (самое равннее среди подзадач)';
COMMENT ON COLUMN epic.duration         IS 'Суммарная длительность подзадач';
COMMENT ON COLUMN epic.end_time         IS 'Время окончания (самое позднее среди подзадач)';
COMMENT ON COLUMN epic.created_date     IS 'Дата создания записи';
COMMENT ON COLUMN epic.modified_date    IS 'Дата последнего изменения записи';
COMMENT ON COLUMN epic.version          IS 'Версия';

CREATE TABLE task
(
    id              UUID                        NOT NULL DEFAULT gen_random_uuid(),
    name            TEXT                        NOT NULL,
    description     TEXT,
    status          TEXT                        NOT NULL,
    start_date      TIMESTAMP,
    duration        BIGINT,
    created_date    TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT NOW(),
    modified_date   TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT NOW(),
    version         BIGINT                      NOT NULL DEFAULT 1,

    CONSTRAINT pk_task PRIMARY KEY (id)
);

COMMENT ON TABLE task                   IS 'Задача - самостоятельная единица работы';
COMMENT ON COLUMN task.id               IS 'Идентификатор задачи';
COMMENT ON COLUMN task.name             IS 'Название';
COMMENT ON COLUMN task.description      IS 'Описание';
COMMENT ON COLUMN task.status           IS 'Статус выполнения';
COMMENT ON COLUMN task.start_date       IS 'Время начала';
COMMENT ON COLUMN task.duration         IS 'Плановая длительность';
COMMENT ON COLUMN task.created_date     IS 'Дата создания записи';
COMMENT ON COLUMN task.modified_date    IS 'Дата последнего изменения записи';
COMMENT ON COLUMN task.version          IS 'Версия';

CREATE TABLE sub_task
(
    id              UUID                        NOT NULL DEFAULT gen_random_uuid(),
    name            TEXT                        NOT NULL,
    description     TEXT,
    status          TEXT                        NOT NULL,
    start_date      TIMESTAMP,
    duration        BIGINT,
    epic_id         UUID                        NOT NULL,
    created_date    TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT NOW(),
    modified_date   TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT NOW(),
    version         BIGINT                      NOT NULL DEFAULT 1,

    CONSTRAINT pk_sub_task PRIMARY KEY (id),
    CONSTRAINT fk_sub_task__epic_id___epic__id FOREIGN KEY (epic_id) REFERENCES epic (id)
);

COMMENT ON TABLE sub_task                   IS 'Подзадача - часть эпика';
COMMENT ON COLUMN sub_task.id               IS 'Идентификатор подзадачи';
COMMENT ON COLUMN sub_task.name             IS 'Название';
COMMENT ON COLUMN sub_task.description      IS 'Описание';
COMMENT ON COLUMN sub_task.status           IS 'Статус выполнения';
COMMENT ON COLUMN sub_task.start_date       IS 'Время начала';
COMMENT ON COLUMN sub_task.duration         IS 'Плановая длительность';
COMMENT ON COLUMN sub_task.epic_id          IS 'Ссылка на родительский эпик';
COMMENT ON COLUMN sub_task.created_date     IS 'Дата создания записи';
COMMENT ON COLUMN sub_task.modified_date    IS 'Дата последнего изменения записи';
COMMENT ON COLUMN sub_task.version          IS 'Версия';

CREATE INDEX idx_sub_task__epic_id ON sub_task (epic_id);