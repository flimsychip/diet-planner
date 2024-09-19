/*************************************************
 File: FoodType
 By: Allie Young
 Date: 7/17/24
 Description: class to instantiate the food items the user will be adding. has
 getters for access to object data + toString to print out that data
 *************************************************/

package project1;

public class FoodType {
    private String name;
    private double calories, protein, fiber;

    public FoodType(String name, double cal, double pro, double fiber) {
        this.name = name;
        this.calories = cal;
        this.protein = pro;
        this.fiber = fiber;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return this.calories;
    }

    public double getProtein() {
        return this.protein;
    }

    public double getFiber() {
        return this.fiber;
    }

    // don't need setters for this project

    public String toString() {
        return this.name + " | cal: " + this.calories + " protein: " + this.protein + " fiber: " + this.fiber;
    }
}
