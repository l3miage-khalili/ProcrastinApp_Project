package fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical;

import lombok.Getter;

@Getter
public class EntiteNotFoundException extends Exception {

    public EntiteNotFoundException(String message) {
        super(message);
    }
}
