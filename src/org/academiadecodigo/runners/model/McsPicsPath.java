package org.academiadecodigo.runners.model;

public enum McsPicsPath {

    GUSTAVO("src/resources/guga.png", "Gustavo"),
    SARA("src/resources/sara.png", "Sara"),
    MARIANA("src/resources/mariana.png", "Mariana"),

    BALJEET( "src/resources/baljeet.png", "Baljeet"),

    CAROL("src/resources/carol.png", "Carol");

    private final String path;
    private final String name;

    McsPicsPath(String path, String name){
        this.path = path;
        this.name = name;
    }

    public String getPath(){
        return this.path;
    }

    public String getName(){
        return this.name;
    }
}
