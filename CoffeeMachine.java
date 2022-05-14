
import java.util.*;

class CoffeeMaker {
	static int WATER = 400;
	static int MILK = 540;
	static int BEANS = 120;
	static int CUP = 9;
	static int MONEY = 550;
	static Scanner SCANNER = new Scanner(System.in);
	
	
}

class CoffeeMachine {
	
    static int water = CoffeeMaker.WATER;
    static int milk = CoffeeMaker.MILK;
    static int beans = CoffeeMaker.BEANS;
    static int dCups = CoffeeMaker.CUP;
    static int money = CoffeeMaker.MONEY;
    static Scanner scanner = CoffeeMaker.SCANNER;
    
    public static void main(String[] args) {
        
        menu();
    }
    
    static void menu() {
        
        while (true) {
            
            
        
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String menu = scanner.next(); 
            
            System.out.println();
            switch (menu) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    ingrediant();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
            System.out.println();
        
        }
        
    }
    
    static void take() {
        System.out.printf("I gave you $%d%n", money);
        
        money = 0;
        System.out.println();
    }
    
    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int w = scanner.nextInt();
        
        System.out.println("Write how many ml of milk you want to add:");
        int m = scanner.nextInt();
        
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int b = scanner.nextInt();
        
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int c = scanner.nextInt();
        
        water += w;
        milk += m;
        beans += b;
        dCups += c;
        
        System.out.println();
        
    }
    
    static void buy () {
        
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = scanner.next();
        
        switch (buy) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
            default:
                break;
        }
        
        
        
    }
    
    static void espresso() {
        int wate = water - 250;
        int bean = beans - 16;
        int dCup = dCups - 1;
        
        if (wate > 0 && bean > 0 && dCup >= 0) {
            water = wate;
            beans = bean;
            dCups = dCup;
            money = money + 4;
            
            System.out.println("I have enough resources, making you a coffee!");
        } else if (wate < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (bean < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (dCup < 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    
    static void latte() {
        int wate = water - 350;
        int mil = milk - 75;
        int bean = beans - 20;
        int dCup = dCups - 1;
        
        if (wate > 0 && bean > 0 && dCup > 0 && mil > 0) {
        	water = wate;
            beans = bean;
            dCups = dCup;
            money = money + 7;
            milk = mil;
            
            System.out.println("I have enough resources, making you a coffee!");
        } else if (wate < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (bean < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (dCup < 0) {
            System.out.println("Sorry, not enough cups!");
        } else if (mil < 0) {
            System.out.println("Sorry, not enough milk!");
        }
        
    }
    
    static void cappuccino() {
        int wate = water - 200;
        int mil = milk - 100;
        int bean = beans - 12;
        int dCup = dCups - 1;
        
        if (wate > 0 && bean > 0 && dCup > 0 && mil > 0) {
        	water = wate;
            beans = bean;
            dCups = dCup;
            money = money + 6;
            milk = mil;
            
            System.out.println("I have enough resources, making you a coffee!");
        } else if (wate < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (bean < 0) {
            System.out.println("Sorry, not enough coffee beans");
        } else if (dCup < 0) {
            System.out.println("Sorry, not enough disposable cups");
        } else if (mil < 0) {
            System.out.println("Sorry, not enough milk");
        }
        
    }
    
    void servings () {
        
        numberOfServings();
        
        System.out.println("Write how many cups of coffee you will need:");
        int cup = scanner.nextInt(); 
        
        int[] arr = new int[3];
        
        int w = water(cup);
        int m = milk(cup);
        int b = beans(cup);
        
        String result = " ";
        String yes = ", I can make that amount of coffee ";
        
        int x = water - w;
        int y = milk - m;
        int z = beans - b;
        int a = 0;
        
        if (x >= 0 && y >= 0 && z >= 0) {
            
            arr[0] = x / 200;
            arr[1] = y / 50;
            arr[2] = z / 15;
            
            a = getSmallest(arr,3);
            
            if (a == 0) {
                result = "Yes" + yes;
            } else {
                result = "Yes" + yes + "(and even " + a + " more than that)";
            }
            
        } else {
            
            arr[0] = Math.abs(water / 200);
            arr[1] = Math.abs(milk / 50);
            arr[2] = Math.abs(beans / 15);
            
            a = getSmallest(arr,3);
            result = "No, I can make only " + a + " cup(s) of coffee";
        }
        
        System.out.println(result);
    }
    
    public int getSmallest(int[] a, int total){  
        int temp;  
        for (int i = 0; i < total; i++) {  
            for (int j = i + 1; j < total; j++) {  
                if (a[i] > a[j]) {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
       return a[0];  
    }  
    
    static void numberOfServings() {
        
        System.out.println("Write how many ml of water the coffee machine has: ");
        water = scanner.nextInt();
        
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milk = scanner.nextInt();
        
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        beans = scanner.nextInt();
        
    }
    
    static int water(int cup) {return cup * 200;}
    static int milk(int cup) {return cup * 50;}
    static int beans(int cup) {return cup * 15;}
    
    
    static void ingrediant () {
        
        /*Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write how many cups of coffee you will need:");
        int cup = scanner.nextInt();
        
        int wate = water(cup);
        int mil = milk(cup);
        int bean = beans(cup);*/
        
        System.out.printf("The coffee machine has:%n");
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", beans);
        System.out.printf("%d disposable cups%n", dCups);
        System.out.printf("$%d of money%n", money);
    }
    
    static void steps () {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        
    }

}
