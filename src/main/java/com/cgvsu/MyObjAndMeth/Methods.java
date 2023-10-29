package com.cgvsu.MyObjAndMeth;

import java.util.List;

public class Methods {

    //если векторы сонаправлены возвращает true
    public static boolean getVectorsOrient(List<Point> points, Point center){
        Vector[] vectors = new Vector[2];
        Vector v1 = new Vector(center, points.get(0));
        Vector v2 = new Vector(center, points.get(1));
        Vector v3 = new Vector(center, points.get(2));
        vectors[0] = multiplyVectors(v1, v3);
        vectors[1] = multiplyVectors(v3, v2);
        return vectors[0].getZ()*vectors[1].getZ() > 0 && vectors[0].getZ() > 0;
    }

    //делает произведение 2-х векторов
    private static Vector multiplyVectors(Vector v1, Vector v2){
        Vector v = new Vector(new Point(0, 0, 0), new Point(1, 1, 1));
        v.setX(v1.getY()*v2.getZ() - v1.getZ()*v2.getY());
        v.setY(v1.getZ()*v2.getX() - v1.getX()*v2.getZ());
        v.setZ(v1.getX()*v2.getY() - v1.getY()*v2.getX());
        return v;
    }

}

/*
//если же точки подаются сразу упорядоченно, чтобы понять угол?? - тогда след. методы ненужные
    //в данный метод подаётся массив из трёх точек
    //и метод переставляет их в том порядке, в котором они расположены против часовой стрелки
    //после перестановки по порядку каждая т-ка соединяется с серединой круга и получается 3 вектора
    public static Point[] orderPoints(List<Point> points, Point center, int radius){
        Point[] resPoints = new Point[3];

        //во-первых найти точку, которая лежит внути круга и которую потому будем проверять
        //удалить её, чтобы не мешала на след. действиях
        for (int i = 0; i < 3; i++){
            if (Math.pow((points.get(i).getX() - center.getX()), 2) + Math.pow((points.get(i).getY() - center.getY()), 2) < Math.pow(radius, 2)){
                resPoints[1] = points.get(i);
                points.remove(i);
                break;
            }
        }

        //после нахождения средней точки нужно найти положение двух остальных
        //для этого - метод findQuarter, который покажет, в каких четвертях расположены точки
        //если точки в разных четвертях - то можно определить, какая из них "первая", а вторя будет второй методом искл.
        //если точки в одной и той же чтв - требуется доп. проверка
        //для случая, когда четверти не совпадают - метод easyOrder
        //когда совпадают - complicatedOrder
        int quart1 = findQuarter(points.get(0), center), quart2 = findQuarter(points.get(1), center);


        return resPoints;
    }


    //на вход даётся точка и "центр координат"
    //от него идут локальные Ох и Оу
    //отталкиваясь от них находится, в какой четверти расположена точка
private static int findQuarter(Point point, Point center){
    int quarter = 0;
    //1 или 3 чтв
    if (point.getX() <= center.getX()) {
        if (point.getY() <= center.getY()){
            quarter = 2;
        } else {
            quarter = 3;
        }
    }
    //2 или 4 чтв
    else {
        if (point.getY() <= center.getY()) {
            quarter = 1;
        } else {
            quarter = 4;
        }
    }
    return quarter;
}

    //если у точек разные четверти
    //важен ли угол?
    private static List<Point> easyOrder(List<Point> points, int quart1, int quart2){
        List<Point> finalPoints = new ArrayList<>();
        switch(quart1){
            case(1):
                finalPoints.add(0, points.get(1));
                finalPoints.add(1, points.get(0));
                break;
            case(2):
                finalPoints.add(0, points.get(0));
                finalPoints.add(1, points.get(1));
                break;
            case(3):
                switch (quart2){
                    case(2):
                        finalPoints.add(0, points.get(1));
                        finalPoints.add(1, points.get(0));
                        break;
                    case(1):
                    case(4):
                        finalPoints.add(0, points.get(0));
                        finalPoints.add(1, points.get(1));
                        break;
                }
                break;
            case(4):
                switch (quart2){
                    case(1):
                        finalPoints.add(0, points.get(0));
                        finalPoints.add(1, points.get(1));
                        break;
                    case(2):
                    case(3):
                        finalPoints.add(0, points.get(1));
                        finalPoints.add(1, points.get(0));
                        break;
                }
                break;
        }
        return finalPoints;
    }*/