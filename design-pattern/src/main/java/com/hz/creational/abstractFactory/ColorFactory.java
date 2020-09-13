package com.hz.creational.abstractFactory;

import com.hz.creational.abstractFactory.color.Blue;
import com.hz.creational.abstractFactory.color.Color;
import com.hz.creational.abstractFactory.color.Green;
import com.hz.creational.abstractFactory.color.Red;
import com.hz.creational.abstractFactory.shape.Shape;

/**
 * @author HuZhuang
 * @description:
 * @date 2020/9/13
 **/
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
