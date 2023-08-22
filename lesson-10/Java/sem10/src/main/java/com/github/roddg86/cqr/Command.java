package com.github.roddg86.cqr;

/**
 * Интерфейс "Command".
 * Представляет команду — действие, которое изменяет состояние системы.
 * Например, добавление, обновление или удаление записи в базе данных.
 */
public interface Command {
    void execute();
}