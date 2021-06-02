package com.example.a4t;



public class ModelClass {
    String strDrink;
    String strDrinkThumb;
    String strInstructions;

    public ModelClass(String strDrink, String strDrinkThumb, String strInstructions){
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.strInstructions = strInstructions;
    }

    public ModelClass() { }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }
}


