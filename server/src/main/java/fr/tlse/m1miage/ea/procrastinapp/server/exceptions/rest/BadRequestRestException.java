package fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest;

public class BadRequestRestException extends RuntimeException {
    public BadRequestRestException(String message) {
        super(message);
    }
}
