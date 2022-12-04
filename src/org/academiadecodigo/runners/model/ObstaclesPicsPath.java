package org.academiadecodigo.runners.model;

public enum ObstaclesPicsPath {

    SUPER_BOCK("src/resources/beer.png", "GOOD"),
    JAVASCRIPT("src/resources/javascript.png", "BAD"),
    WEED("src/resources/weed.png", "GOOD"),
    JAVA("src/resources/java_new.png", "BAD"),
    CMAIS("src/resources/c++.png", "BAD");



    private final String path;
    private final String type;

    ObstaclesPicsPath(String path, String type){
        this.path = path;
        this.type = type;
    }

    public String getPath(){
        return this.path;
    }

    public String getType(){
        return this.type;
    }
}
