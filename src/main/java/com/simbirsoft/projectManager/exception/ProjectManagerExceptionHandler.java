package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProjectManagerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Something goes wrong :(";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = ProjectNotFoundException.class)
    protected ResponseEntity<Object> handleProjectNotFound(
            RuntimeException ex, WebRequest request, ProjectNotFoundException e) {
        String bodyOfResponse = e.toString();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFound(
            RuntimeException ex, WebRequest request, UserNotFoundException e) {
        String bodyOfResponse = e.toString();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = TaskNotFoundException.class)
    protected ResponseEntity<Object> handleTaskNotFound(
            RuntimeException ex, WebRequest request, TaskNotFoundException e) {
        String bodyOfResponse = e.toString();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(value = ReleaseNotFoundException.class)
    protected ResponseEntity<Object> handleReleaseNotFound(
            RuntimeException ex, WebRequest request, ReleaseNotFoundException e) {
        String bodyOfResponse = e.toString();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
