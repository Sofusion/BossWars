package ru.BossWars.tp;

public class Pos {
    public String worldName;
    public double x, y, z;
 
    public Pos(String name, double x, double y, double z) {
        worldName = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}