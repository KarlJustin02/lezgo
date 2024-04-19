import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Date;

public class PizzaParlor {

    public static DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public static void input() {
        double total = 0;

        String AllFlavors[][] = {
                {"Hawaiian", "Pepperoni", "All-Meat", "4-Cheese"},
                {"Solo", "Barkada", "Family", "Party"}
        };

        int price[][] = {
                {167, 376, 657, 876},
                {178, 405, 690, 907},
                {204, 450, 768, 978},
                {234, 489, 808, 1018}
        };

        int x = 0;
        do {
                
            String userdev = JOptionPane.showInputDialog("Choose your Flavor: \n\n[1] Hawaiian,\n[2] Pepperoni,\n[3] All Meat,\n[4] 4-Cheese");
            int flavor = Integer.parseInt(userdev);

            if (flavor > 0 && flavor <= 4) 
            {
                userdev = JOptionPane.showInputDialog("Choose your Size: \n\n[1] Solo: " + price[flavor - 1][0] + "\n[2] Barkada: " + price[flavor - 1][1] + "\n[3] Family: " + price[flavor - 1][2] + "\n[4] Party: " + price[flavor - 1][3]);
                int size = Integer.parseInt(userdev);

                if (size > 0 && size <= 4) 
                {
                    userdev = JOptionPane.showInputDialog("Order: " + AllFlavors[0][flavor - 1] + " - " + AllFlavors[1][size - 1] + "\n\nHow many " + AllFlavors[0][flavor - 1] + " - " + AllFlavors[1][size - 1] + "  should we prepare for You?");
                    int quantity = Integer.parseInt(userdev);

                    if (quantity > 0) 
                    {
                        String flavorchoice = AllFlavors[0][flavor - 1];
                        String flavorsize = AllFlavors[1][size - 1];
                        double sizeprice = price[flavor - 1][size - 1];
                        int quantitypizza = quantity;

                        do 
                        {
                            userdev = JOptionPane.showInputDialog(null, "\nDo you want to buy more? [y/n]: ");
                            if (userdev.equalsIgnoreCase("y")) 
                            {
                                x = 1;
                                double quantitysize = sizeprice * quantitypizza;
                                total = total + (sizeprice * quantitypizza);
                                
                                if(size == 2)
                                {
                                    System.out.printf("%-19s | %-6s | %s Php%n", quantity + "x  " + flavorchoice, flavorsize, decimalFormat.format(quantitysize));
                                }
                                else
                                {
                                    System.out.printf("%-19s | %-7s | %s Php%n", quantity + "x  " + flavorchoice, flavorsize, decimalFormat.format(quantitysize));
                                }

                                JOptionPane.showMessageDialog(null, "Adding More Order");
                            } 
                            else if (userdev.equalsIgnoreCase("n")) 
                            {
                                x = 2;
                                double quantitysize = sizeprice * quantitypizza;
                                total = total + quantitysize;

                                if(size == 2)
                                {
                                    System.out.printf("%-19s | %-6s | %s Php%n", quantity + "x  " + flavorchoice, flavorsize, decimalFormat.format(quantitysize));
                                }
                                else
                                {
                                    System.out.printf("%-19s | %-7s | %s Php%n", quantity + "x  " + flavorchoice, flavorsize, decimalFormat.format(quantitysize));
                                }

                                calculation(total);
                            } 
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Invalid, Please Enter Again");
                            }
                        } while (x < 1);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Invalid quantity, Please Enter Again");
                    }
                } 
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid size. Please enter again.");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Invalid flavor. Please enter again.");
            }
        } while (x < 2);
    }
    hello
    public static void calculation(double total) {
        int x = 0;
        do {
            Date currentDate = new Date();

            String userdev = JOptionPane.showInputDialog("Your total ordered is: " + decimalFormat.format(total)+ " Php" + " \n\n Enter Payment: ");
            double payment = Double.parseDouble(userdev);
            double change = payment - total;

            if (payment >= total) 
            {
                System.out.println("\nTotal Amount:\t\t\t" + decimalFormat.format(total)+ " Php");
                System.out.println("Payment:\t\t\t" + decimalFormat.format(payment)+ " Php");
                System.out.println("Change:\t\t\t\t" + decimalFormat.format(change) +  " Php" + "\n");
                System.out.println("---------------------------------------------------");
                System.out.println("\t     Thank you, Come Again!");
                System.out.println("     Visit us again at Neust Cict Building");
                System.out.println("---------------------------------------------------");
                JOptionPane.showMessageDialog(null, "Thank you, Come Again!");
               
                x++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not enough payment. Please enter again.");
            }
        } while (x == 0);
    }

    public static void main(String[] args) 
    {
        Date currentDate = new Date();
        
        System.out.println("--------------------------------------------------");
        System.out.println("\t\t   Pizza_Parlor");
        System.out.println("\t       Neust Cict Building");
        System.out.println("--------------------------------------------------");
        System.out.println("Date & Time: \n\t" + currentDate);
        System.out.println("---------------------Receipt----------------------\n");
        System.out.println("Quantity & Flavor   |  Size   | Price \n");

        input();
    }
}