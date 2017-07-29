package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
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
    public int heigth;

    public Rectangle(int topLeftX, int topLeftY, int width, int heigth) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.heigth = heigth;
    }

    public Rectangle(int topLeftX, int topLeftY) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = 4;
        this.heigth = 2;
    }

    public Rectangle(int topLeftX, int topLeftY, int width) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.heigth = width;
    }

    public Rectangle(Rectangle anotherRectangle) {
        this.topLeftX = anotherRectangle.topLeftX;
        this.topLeftY = anotherRectangle.topLeftY;
        this.width = anotherRectangle.width;
        this.heigth = anotherRectangle.heigth;
    }

}
