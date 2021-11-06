package ua.goit.projectmanager.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Command {
    EXIT("exit", "stop the app"),
    HELP("help","list of commands"),

    CREATECOMPANY("create_company","create new company in DB"),
    GETCOMPANYBYID("get_company_by_id", "returns company from DB by ID"),
    GETALLCOMPANIES("get_all_companies","returns all companies from DB"),
    DELETECOMPANY("delete_company","deletes company from DB by ID"),

    CREATEPROJECT("create_project","create new project in DB"),
    GETPROJECTBYID("get_project_by_id", "returns project from DB by ID"),
    GETALLPROJECTS("get_all_projects","returns all projects from DB"),
    DELETEPROJECT("delete_project","deletes project from DB by ID"),

    CREATECUSTOMER("create_customer","create new customer in DB"),
    GETCUSTOMERBYID("get_customer_by_id", "returns customer from DB by ID"),
    GETALLCUSTOMERS("get_all_customers","returns all customers from DB"),
    DELETECUSTOMER("delete_customer","deletes customer from DB by ID"),

    CREATEDEVELOPER("create_developer","create new developer in DB"),
    GETDEVELOPERBYID("get_developer_by_id", "returns developer from DB by ID"),
    GETALLDEVELOPERS("get_all_developers","returns all developers from DB"),
    DELETEDEVELOPER("delete_developer","deletes developer from DB by ID");

    private String commandName;
    private String description;
    public static final Map<String, String> commandsWithDescription = Arrays.stream(Command.values())
            .collect(Collectors.toMap(Command::getCommandName, Command::getDescription));
}
