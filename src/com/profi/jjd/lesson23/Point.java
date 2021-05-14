package com.profi.jjd.lesson23;

import com.profi.jjd.lesson23.annotations.Component;
import com.profi.jjd.lesson23.annotations.Required;
import com.profi.jjd.lesson24.validation.Min;

@Component(fileName = "point.properties", version = 2)
public class Point {
    @Required
    @Min(value = 2, errorMessage = "Min")
    private int x;
    @Required
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
