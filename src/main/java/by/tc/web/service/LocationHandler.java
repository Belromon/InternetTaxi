package by.tc.web.service;

import by.tc.web.entity.Point;

import java.util.Random;

public class LocationHandler {

    public static double getRandomCoordinate(){
        double rangeMin = 0;
        double rangeMax = 50;
        Random random = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        return  randomValue;
    }

    public static double getDistance(Point begin, Point end){

      return   Math.sqrt(Math.pow((end.getX() - begin.getX()), 2) + Math.pow((end.getY() - begin.getY()), 2));
    }

}
