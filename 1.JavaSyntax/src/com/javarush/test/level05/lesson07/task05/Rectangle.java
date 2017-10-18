package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    public int topLeftX;
    public int topLeftY;
    public int width;
    public int height;

    public void initialize(int topLeftX, int topLeftY, int width, int height) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.height = height;
    }

    public void initialize(int topLeftX, int topLeftY) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = 4;
        this.height = 2;
    }

    public void initialize(int topLeftX, int topLeftY, int width) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.height = width;
    }

    public void initialize(Rectangle anotherRectangle) {
        this.topLeftX = anotherRectangle.topLeftX;
        this.topLeftY = anotherRectangle.topLeftY;
        this.width = anotherRectangle.width;
        this.height = anotherRectangle.height;
    }


}
