package org.academiadecodigo.runners.model;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private Picture pic;
    private double limit;
    private ObstaclesPicsPath path;
    private int col;
    private int row;
    private Player player;

    private int speed = 55;



    public Obstacle(ObstaclesPicsPath path, int col, int row, Player player) {
        this.path = path;
        this.col = col;
        this.row = row;
        this.limit = 12;
        this.player = player;

    }

    public boolean move() {
        this.pic = new Picture(col, row, path.getPath());
        this.pic.draw();
        int i = 0;

        while(i <= limit) {


            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pic.translate(0, 40);

            //System.out.println(pic.getX() + " this is object");
            //System.out.println(pic.getY() + " this is object");

            //System.out.println(player.getPic().getX());
            //System.out.println(player.getPic().getY());
            if (checkCollision()) {
                if(path.getType().equals("GOOD")) {
                    this.pic.delete();
                    player.setScore(player.getScore() + 1);


                    player.getScoretxt().setText("Score :" + player.getScore());
                    //SoundHandler.RunMusic("src/resources/pling.wav");

                } else {
                    this.pic.delete();
                    player.setLives(player.getLives() - 1);

                   if (player.getLives() == 5) {
                        player.getHeart3().delete();
                        //SoundHandler.RunMusic("src/resources/plok.wav");
                    } else if (player.getLives() == 4) {
                        player.getHalf3().delete();
                        //SoundHandler.RunMusic("src/resources/plok.wav");
                    } else if (player.getLives() == 3) {
                        player.getHeart2().delete();
                        //SoundHandler.RunMusic("src/resources/plok.wav");
                    } else if (player.getLives() == 2) {
                        player.getHalf2().delete();
                        //SoundHandler.RunMusic("src/resources/plok.wav");
                    } else if (player.getLives() == 1) {
                        player.getHeart().delete();
                        //SoundHandler.RunMusic("src/resources/plok.wav");
                    } else{
                        player.getHalf().delete();
                        //SoundHandler.RunMusic("src/resources/plok.wav");
                    }

                    if(player.getLives() < 1) {
                        return false;
                    }
                }
            }
            i++;
            if(path.getType().equals("GOOD") && (pic.getX() != (player.getPic().getX()+25)) && (pic.getY() == (player.getPic().getY()))){
                player.setLives(player.getLives() -1);
                if (player.getLives() == 5) {
                    player.getHeart3().delete();
                    //SoundHandler.RunMusic("src/resources/plok.wav");
                } else if (player.getLives() == 4) {
                    player.getHalf3().delete();
                    //SoundHandler.RunMusic("src/resources/plok.wav");
                } else if (player.getLives() == 3) {
                    player.getHeart2().delete();
                    //SoundHandler.RunMusic("src/resources/plok.wav");
                } else if (player.getLives() == 2) {
                    player.getHalf2().delete();
                    //SoundHandler.RunMusic("src/resources/plok.wav");
                } else if (player.getLives() == 1) {
                    player.getHeart().delete();
                    //SoundHandler.RunMusic("src/resources/plok.wav");
                } else{
                    player.getHalf().delete();
                    //SoundHandler.RunMusic("src/resources/plok.wav");
                }

            }

        }
        this.pic.delete();
        return true;
        }

    public boolean checkCollision() {
        if ((pic.getY()  == player.getPic().getY()) && (pic.getX() == (player.getPic().getX() + 25))){
            return true;
        }
        return false;


    }


}
