package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import lombok.Data;

@Data
public class ExcuseCreativeVoteRequest {
    private Long excuseCreativeId;
    private Long votant;
}
