package com.simbirsoft.projectManager.entity;

/**
 * Сосотояния проекта
 * {@link #NOT_STARTED}
 * {@link #IN_PROGRESS}
 * {@link #DONE}
 */
public enum ProjectStatus {
    /**
     * Не начат
     */
    NOT_STARTED("Не начат"),
    /**
     * В разработке
     */
    IN_PROGRESS("В разработке"),
    /**
     * Завершён
     */
    DONE("Завершён");

    private final String name;

    ProjectStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
