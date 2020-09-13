package com.hz.creational.abstractFactory;

import com.hz.creational.abstractFactory.color.Color;
import com.hz.creational.abstractFactory.shape.Shape;

/**
 * @author HuZhuang
 * @description:
 * @date 2020/9/13
 **/
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shapeType) ;
}
