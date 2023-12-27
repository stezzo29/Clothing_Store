import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        ClothingStore cs = new ClothingStore("Simmi's Shop"); // store name
        System.out.println("\n*** Welcome to " + cs.getStoreName() + " ***");
        System.out.println();
        System.out.println("\t1. Make a Purchase");
        System.out.println("\t2. Join our Rewards Program");
        System.out.println("\t3. View our Full Inventory");
        System.out.println("\t4. View Member Profile");
        System.out.println("\t5. Exit Shop");
        System.out.println();

        while (true) {

            int menuChoice = scnr.nextInt();

            switch (menuChoice) {
                case 0:
                    break;
                case 1:
                    System.out.println("---------------------------");
                    purchase(cs, scnr, new ArrayList<Clothing>());
                    boolean continueShopping = false;
                    if (!continueShopping) {
                        return;
                    }
                    break;
                case 2:
                    System.out.println("---------------------------");
                    rewards(cs, scnr);
                    break;
                case 3:
                    System.out.println("---------------------------");
                    viewInventory(cs, scnr);
                    break;
                case 4:
                    System.out.println("---------------------------");

                    break;
                case 5:
                    System.out.println("Thank you for visiting!");

                    break;
                default:
                    System.out.println("Invalid Choice, try again.");
            }
        }
    }

    private static void main(ClothingStore cs, Scanner scnr) {
    }

    public static void rewards(ClothingStore clothingStore, Scanner scnr) {
        System.out.println("\nRegistration");
        System.out.println("--------------");

        scnr.nextLine();
        System.out.println("\nEnter Your Name: ");
        String name = scnr.nextLine();

        scnr.nextLine();
        System.out.println("\nEnter Your Email:");
        String email = scnr.nextLine();
        scnr.nextLine();

        System.out.println("\nEnter Phone Number:");
        String phone = scnr.nextLine();

        System.out.println("\nThank you for registering, " + name + "!");
        clothingStore.addNewMember(name, email, phone);

    }

    public static void viewInventory(ClothingStore clothingStore, Scanner scnr) {
        System.out.println("\nFULL INVENTORY");

        int dressTotal = 0;
        int pantTotal = 0;
        int topTotal = 0;

        for (Dress clothing : clothingStore.getAvailableDresses()) {
            dressTotal += clothing.getNumInStock();
        }

        for (Pant clothing : clothingStore.getAvailablePants()) {
            pantTotal += clothing.getNumInStock();
        }

        for (Top clothing : clothingStore.getAvailableTops()) {
            topTotal += clothing.getNumInStock();
        }

        double dressPrice = 0;
        double pantPrice = 0;
        double topPrice = 0;

        for (Dress clothing : clothingStore.getAvailableDresses()) {
            dressPrice += clothing.getPrice();
        }

        for (Pant clothing : clothingStore.getAvailablePants()) {
            pantPrice += clothing.getPrice();
        }

        for (Top clothing : clothingStore.getAvailableTops()) {
            topPrice += clothing.getPrice();
        }

        System.out.println("\nType\t      Amount\tTotal Price");
        System.out.println("-----------------------------------");
        System.out.println("Dresses:\t" + dressTotal + "\t  $" + dressPrice);
        System.out.println("Pants:  \t" + pantTotal + "\t  $" + pantPrice);
        System.out.println("Tops:   \t" + topTotal + "\t  $" + topPrice);

    }

    public static void purchase(ClothingStore clothingStore, Scanner scnr, ArrayList<Clothing> cart) {
        System.out.println("\nWhat would you like to purchase?");
        System.out.println("\t1. Dresses");
        System.out.println("\t2. Pants");
        System.out.println("\t3. Tops");

        int clothingTypeChoice = scnr.nextInt();

        // display clothing inventory

        // int itemNum = 1;

        // user selects dresses
        if (clothingTypeChoice == 1) {
            int itemNum = 1;
            ArrayList<Dress> inventory = clothingStore.getAvailableDresses();
            if (!inventory.isEmpty()) {
                System.out.println("-----------------------------");
                System.out.println("\nWhich of the following dresses would you like to purchase?\n");

                for (Dress clothing : inventory) {
                    System.out.println(itemNum + " - " + clothing.getColor() + " " + clothing.getStyle() + " "
                            + clothing.getLength() + " Dress"
                            + "\n\tSize: " + clothing.getSize()
                            + "\n\tPrice: $" + clothing.getPrice());
                    System.out.println();
                    itemNum++;
                }

                // get user selection to add product to cart
                int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));
                    // update inventory for this item
                    clothingStore.removeClothing("dresses", choice - 1);
                    // cart
                    System.out.println("\nYou have " + cart.size() + " item(s) in your cart. Are you done shopping?");
                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");

                    int doneShopping = scnr.nextInt();
                    if (doneShopping == 1) {
                        System.out.println("--------");
                        System.out.println("CHECKOUT\n");
                        checkout(clothingStore, scnr, cart);
                    } else if (doneShopping == 2) {
                        purchase(clothingStore, scnr, cart);
                    } else {
                        System.out.println("Invalid");
                    }

                } else {
                    System.out.println("Invalid product number.");
                    purchase(clothingStore, scnr, cart);
                }
            } else {
                System.out.println("Sorry! We are currently sold out of dresses.");
                System.out.println("\nYou have " + cart.size() + " item(s) in your cart. Are you done shopping?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");

                int doneShopping = scnr.nextInt();
                if (doneShopping == 1) {
                    System.out.println("--------");
                    System.out.println("CHECKOUT\n");
                    checkout(clothingStore, scnr, cart);
                } else if (doneShopping == 2) {
                    purchase(clothingStore, scnr, cart);
                } else {
                    System.out.println("Invalid");
                }
            }
        }
        // user selects pants
        if (clothingTypeChoice == 2) {
            int itemNum = 1;
            ArrayList<Pant> inventory = clothingStore.getAvailablePants();
            if (!inventory.isEmpty()) {
                System.out.println("-----------------------------");
                System.out.println("\nWhich of the following pants would you like to purchase?\n");

                for (Pant clothing : inventory) {
                    System.out.println(itemNum + " - " + clothing.getColor() + " " + clothing.getStyle() + " "
                            + "\n\tSize: " + clothing.getSize() + "\tInseam: " + clothing.getInseam()
                            + "\n\tPrice: $" + clothing.getPrice());
                    System.out.println();
                    itemNum++;
                }

                // get user selection to add product to cart
                int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));
                    // update inventory for this item
                    clothingStore.removeClothing("pants", choice - 1);
                    // cart
                    System.out.println("\nYou have " + cart.size() + " item(s) in your cart. Are you done shopping?");
                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");

                    int doneShopping = scnr.nextInt();
                    if (doneShopping == 1) {
                        System.out.println("--------");
                        System.out.println("CHECKOUT\n");
                        checkout(clothingStore, scnr, cart);
                    } else if (doneShopping == 2) {
                        purchase(clothingStore, scnr, cart);
                    } else {
                        System.out.println("Invalid");
                    }

                } else {
                    System.out.println("Invalid product number.");
                    purchase(clothingStore, scnr, cart);
                }
            } else {
                System.out.println("Sorry! We are currently sold out of pants.");
                System.out.println("\nYou have " + cart.size() + " item(s) in your cart. Are you done shopping?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");

                int doneShopping = scnr.nextInt();
                if (doneShopping == 1) {
                    System.out.println("--------");
                    System.out.println("CHECKOUT\n");
                    checkout(clothingStore, scnr, cart);
                } else if (doneShopping == 2) {
                    purchase(clothingStore, scnr, cart);
                } else {
                    System.out.println("Invalid");
                }
            }
        }
        // user selects tops
        if (clothingTypeChoice == 3) {
            int itemNum = 1;
            ArrayList<Top> inventory = clothingStore.getAvailableTops();
            if (!inventory.isEmpty()) {
                System.out.println("-----------------------------");
                System.out.println("\nWhich of the following tops would you like to purchase?\n");

                for (Top clothing : inventory) {
                    System.out.println(itemNum + " - " + clothing.getColor() + " " + clothing.getSleeveLength() + " "
                            + clothing.getStyle() + " "
                            + "\n\tSize: " + clothing.getSize()
                            + "\n\tPrice: $" + clothing.getPrice());
                    System.out.println();
                    itemNum++;
                }

                // get user selection to add product to cart
                int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));
                    // update inventory for this item
                    clothingStore.removeClothing("tops", choice - 1);
                    // cart
                    System.out.println("\nYou have " + cart.size() + " item(s) in your cart. Are you done shopping?");
                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");

                    int doneShopping = scnr.nextInt();
                    if (doneShopping == 1) {
                        System.out.println("--------");
                        System.out.println("CHECKOUT\n");
                        checkout(clothingStore, scnr, cart);
                    } else if (doneShopping == 2) {
                        purchase(clothingStore, scnr, cart);
                    } else {
                        System.out.println("Invalid");
                    }

                } else {
                    System.out.println("Invalid product number.");
                    purchase(clothingStore, scnr, cart);
                }
            } else {
                System.out.println("Sorry! We are currently sold out of tops.");
                System.out.println("\nYou have " + cart.size() + " item(s) in your cart. Are you done shopping?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");

                int doneShopping = scnr.nextInt();
                if (doneShopping == 1) {
                    System.out.println("--------");
                    System.out.println("CHECKOUT\n");
                    checkout(clothingStore, scnr, cart);
                } else if (doneShopping == 2) {
                    purchase(clothingStore, scnr, cart);
                } else {
                    System.out.println("Invalid");
                }

            }
        }

    }

    // chechout
    private static boolean checkout(ClothingStore clothingStore, Scanner scnr, ArrayList<Clothing> cart) {
        while (true) {

            double total = 0;
            for (Clothing clothing : cart) {
                total += clothing.getPrice();
            }
            System.out.println("Your total is $" + total);
            System.out.println("\nTo add purchase to your account, please select your name:\n");

            int num = 1;

            for (Member member : clothingStore.getMemberList()) {
                System.out.println(num + ". " + member.getName() + " - #" + clothingStore.getNextMemberID());
                num++;

            }
            System.out.println(num + ". Register a new member.");

            int numChoice = scnr.nextInt();

            if (numChoice == clothingStore.getMemberList().size() - 1) {
                for (Member member : clothingStore.getMemberList()) {
                    System.out.println("\nThank you for your purchase, " + member.getName() + " please shop again!");
                    return false;
                }
            } else if (numChoice == clothingStore.getMemberList().size() + 1) {
                rewards(clothingStore, scnr);
                return false;
            } else if (numChoice == 0) {
                return false;
            } else {
                System.out.println("Invalid choice. Please try again.");
                return true;
            }

        }

    }
}
