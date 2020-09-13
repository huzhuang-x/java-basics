package com.hz.creational.abstractFactory;

import com.hz.creational.abstractFactory.color.Color;
import com.hz.creational.abstractFactory.shape.Circle;
import com.hz.creational.abstractFactory.shape.Rectangle;
import com.hz.creational.abstractFactory.shape.Shape;
import com.hz.creational.abstractFactory.shape.Square;

/**
 * @author HuZhuang
 * @description:
 * @date 2020/9/13
 **/
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
