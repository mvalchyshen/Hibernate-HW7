package ua.goit.projectmanager.controller;


import ua.goit.projectmanager.service.handler.CommandHandler;
import ua.goit.projectmanager.view.Command;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class ControllerImpl implements Controller {

    private View view;
    private CommandHandler commands;
    private Map<String, String> commandsWithDescription;


    public ControllerImpl(View view) {
        this.view = view;
        this.commands = CommandHandler.of();


    }


    @Override
    public void run() {
        view.write("Welcome");
        while (true) {
            view.write("Write help for list of commands");
            commands.handle(view.read(),view);
        }
    }
}

