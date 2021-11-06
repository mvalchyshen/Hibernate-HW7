package ua.goit.projectmanager.model;

public enum Level {
    Junior("Junior"),
    Middle("Middle"),
    Senior("Senior");

    private String name;
    private Level(String name) {
        this.name = name;
    }
}
