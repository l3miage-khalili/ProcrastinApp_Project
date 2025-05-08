package fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest;

public class ForbiddenRestException extends RuntimeException {
    public ForbiddenRestException(String message) {
        super(message);
    }
}
