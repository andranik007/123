package com.example.gg.Entity;

public enum Role {
    USER("Пользователь"),
    ADMIN("Администрато");

    private final String login;

    Role(String login) {this.login = login;}
}
