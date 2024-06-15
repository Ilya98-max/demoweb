package com.example.demo.command;


import com.example.demo.command.impl.*;

import java.util.Locale;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    BACK(new BackCommand()),
    PLACE_ORDER(new PlaceOrderCommand()),
    UPLOAD_PHOTO(new UploadPhotoCommand()),
    PLACE_ORDER_RU(new PlaceOrderRuCommand()),

    DELETE_ACCOUNT(new DeleteAccountCommand()),

    CHANGE_PASSWORD(new ChangePasswordCommand()),
    DEFAULT (new DefaultCommand());



    Command command ;
    CommandType(Command command) {
        this.command = command;
    }
    public static Command define(String commandStr, Locale locale) {
        if (locale.getLanguage().equals("ru") && commandStr.equals("PLACE_ORDER")) {
            return CommandType.PLACE_ORDER_RU.command;
        } else {
            CommandType type = CommandType.valueOf(commandStr.toUpperCase());
            return type.command;
        }
    }
}
