package org.example.Lesson4;

public class Triangle {

    public Double square(int a, int b, int c){
        Double sq = null;
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            Double p = ((Double.valueOf(a + b + c) / 2));
            sq = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            System.out.println("Это не треугольник. Одна из сторон больше суммы двух других");

        }
        return sq;
    }
}
