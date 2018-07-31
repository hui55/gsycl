package com.qianmi.yqqlm.stream;

import java.math.BigDecimal;

/**
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/30
 */
public class Apple {


    public Apple(BigDecimal weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    private BigDecimal weight;
    private String color;

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Apple apple = (Apple) o;

        if (getWeight() != null ? !getWeight().equals(apple.getWeight()) : apple.getWeight() != null) {
            return false;
        }
        return getColor() != null ? getColor().equals(apple.getColor()) : apple.getColor() == null;
    }

    @Override
    public int hashCode() {
        int result = getWeight() != null ? getWeight().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        return result;
    }
}
