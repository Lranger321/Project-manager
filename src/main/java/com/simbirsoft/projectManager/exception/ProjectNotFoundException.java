package com.simbirsoft.projectManager.exception;

public class ProjectNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return super.toString() +
                "Project not found";
    }
}
