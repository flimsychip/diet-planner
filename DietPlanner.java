/*************************************************
 File: DietPlanner
 By: Allie Young
 Date: 7/18/24
 Description: main file in project. user is prompted to add to/remove from a list of
 food items. at the end, program displays their diet and its total calories, protein,
 and fiber
 *************************************************/

package project1;
import java.util.Scanner;

public class DietPlanner {
    // initializing
    static Scanner in = new Scanner(System.in);
    static int input;
    static double totalCal = 0, totalProtein = 0, totalFiber = 0;
    static FoodType chicken = new FoodType("chicken", 423, 37, 0);
    static FoodType spinach = new FoodType("spinach", 41, 5, 4.3);
    static FoodType sweetPotato = new FoodType("sweet potato", 180, 4, 6.6);
    static ArrayBag<FoodType> diet = new ArrayBag<>();

    public static void main(String[] args) {
        addFood();
        printDiet();
        removeFood();
        printDiet();
    }

    static void addFood() {
        while(true) {
            FoodType foodAdded = null;
            System.out.print("what food item would you like to add?\n(1) chicken (2) spinach (3) sweet potato (other) exit: ");
            input = in.nextInt();

            // checks if user wants to exit
            if (input < 1 || input > 3) {
                return;
            }

            // calculations (adding to bag, totals)
            switch (input) {
                case 1: foodAdded = chicken; break;
                case 2: foodAdded = spinach; break;
                case 3: foodAdded = sweetPotato;
            }
            diet.add(foodAdded);
            totalCal += foodAdded.getCalories();
            totalProtein += foodAdded.getProtein();
            totalFiber += foodAdded.getFiber();

            System.out.println("current food items:");
            displayCurrent();
        }
    }

    static void removeFood() {
        while(true) {
            FoodType foodRemoved = null;
            System.out.print("what food item would you like to remove?\n(1) chicken (2) spinach (3) sweet potato (other) exit: ");
            input = in.nextInt();

            // checks if user wants to exit
            if (input < 1 || input > 3) {
                return;
            }

            switch (input) {
                case 1: foodRemoved = chicken; break;
                case 2: foodRemoved = spinach; break;
                case 3: foodRemoved = sweetPotato;
            }

            // error prevention -- checks if there is a serving to be removed
            if(!diet.contains(foodRemoved)) {
                System.out.println("\n[ WARNING ] you don't have any servings of " + foodRemoved.getName() + " in your diet! please enter another option.");
                continue;
            }

            // calculations (subtracting from bag, totals)
            diet.remove(foodRemoved);
            totalCal -= foodRemoved.getCalories();
            totalProtein -= foodRemoved.getProtein();
            totalFiber -= foodRemoved.getFiber();

            System.out.println("current food items:");
            displayCurrent();
        }
    }

    static void displayCurrent() {
        Object[] display = diet.toArray();
        for (int i = 0; i < display.length; i++) {
            System.out.println(display[i]);
        }
        System.out.println();
    }

    static void printDiet() {
        // prints serving, not servings, if only 1
        String c = " servings"; String s = " servings"; String sp = " servings";
        if(diet.getFrequencyOf(chicken) == 1) { c = " serving"; }
        if(diet.getFrequencyOf(spinach) == 1) { s = " serving"; }
        if(diet.getFrequencyOf(sweetPotato) == 1) { sp = " serving"; }

        System.out.println("your diet:");
        System.out.println(diet.getFrequencyOf(chicken) + c + " of chicken");
        System.out.println(diet.getFrequencyOf(spinach) + s + " of spinach");
        System.out.println(diet.getFrequencyOf(sweetPotato) + sp + " of sweet potato");
        System.out.printf("calories: %.1f protein: %.1fg fiber: %.1fg\n\n", totalCal, totalProtein, totalFiber);
    }
}