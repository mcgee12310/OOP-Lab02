package Lab01;

import java.util.Scanner;

public class DaysOfMonths {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        String monthInput;
        int yearInput;

        while (true) {
           
            System.out.print("Enter a month (January, Jan., Jan or 1): ");
            monthInput = scanner.nextLine().trim();
            int month = convertMonthToNumber(monthInput);
            if (month == -1) {
                
                continue;
            }

            System.out.print("Enter a year > 0: ");
            yearInput = scanner.nextInt();
            scanner.nextLine();
            if (yearInput <= 0) {
                System.out.println("Enter a year > 0: ");
                continue;
            }

            int days = getDaysInMonth(month, yearInput);
            System.out.println("Number of days in " + monthInput + "/" + yearInput + " is: " + days);
            break;
        }

        scanner.close();
    }

    public static boolean isLeapYear(int yearInput) {
        if (yearInput % 4 == 0) {
            if (yearInput % 100 == 0) {
                return yearInput % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    public static int convertMonthToNumber(String month) {
        month = month.toLowerCase();
        switch (month) {
            case "january": case "jan.": case "jan": case "1":
                return 1;
            case "february": case "feb.": case "feb": case "2":
                return 2;
            case "march": case "mar.": case "mar": case "3":
                return 3;
            case "april": case "apr.": case "apr": case "4":
                return 4;
            case "may": case "5":
                return 5;
            case "june": case "jun.": case "jun": case "6":
                return 6;
            case "july": case "jul.": case "jul": case "7":
                return 7;
            case "august": case "aug.": case "aug": case "8":
                return 8;
            case "september": case "sep.": case "sep": case "9":
                return 9;
            case "october": case "oct.": case "oct": case "10":
                return 10;
            case "november": case "nov.": case "nov": case "11":
                return 11;
            case "december": case "dec.": case "dec": case "12":
                return 12;
            default:
                return -1;
        }
    }
}
