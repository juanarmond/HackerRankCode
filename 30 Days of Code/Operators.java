
// Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.
// Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result!

// Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip = meal_cost*((double)tip_percent /100);
        double tax = meal_cost * ((double)tax_percent /100);
        double total = ((double)meal_cost + tip + tax);
        // System.out.printf("%.2f \n", tip);
        // System.out.printf("%.2f \n", tax);
        System.out.println(Math.round(total));
    }