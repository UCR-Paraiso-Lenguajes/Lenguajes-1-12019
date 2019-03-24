package task1lenguajes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

// All methods are Example of Block and Identing (Chapter 3 P.35)
public class ClearCodeExamples {

    //Example of Avoid misinformation (Chapter 2 P.19)
    public String degreesCentigradeIntoFahrenheit(int degreesCentigrade) {
        int degreesFahrenheit;
        degreesFahrenheit = 32 + (9 * degreesCentigrade / 5);

        return "The result of convert degrees centigrade into fahrenheit is: " + degreesFahrenheit + " fahrenheit";
    }

    // Example of Use Intention-Revealing Names (Chapter 2 P.18)
    public String isPrimeNumber(int number) {
        boolean isPrime = true;
        for (int i = 2; i < number && isPrime == true; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }
        if (isPrime) {
            return "The number es prime";
        } else {
            return "The number isn't prime";
        }
    }

    //Example of Method names (Chapter 2 P.25)
    public String determineImpairOrPair(int number) {

        if (number % 2 == 0) {
            return "the number " + number + " is pair";
        } else {
            return "the number " + number + " is impair";
        }

    }

    //Example of Small Method (Chapter 3 P.34) 
    public boolean hasACapitalLetter(String word) {
        boolean isCapitalLetter = false;
        for (int i = 0; i < word.length() && isCapitalLetter == false; i++) {
            Character charAtThisPosition = word.charAt(i);
            if (charAtThisPosition >= 65 && charAtThisPosition <= 90) {
                isCapitalLetter = true;
            }
        }
        return isCapitalLetter;
    }

    // Example of Verbs and Keywords (Chapter 3 P.43)
    public int triangleAreaBaseHeight(int base, int height) {
        int triangleArea = 0;
        triangleArea = base * height / 2;
        return triangleArea;
    }

    //Example of Argument Object
    //It is not necesary to add other features about the car
    public String createCar(String brand, String licensePlate) {
        String carDescription = "The car with brand '" + brand + "' with license plate '" + licensePlate + "' is registered";
        return carDescription;
    }

    //Example of Do One Thing (Chapter 3 P.35)
    public String calculateYourAge(int birthYear) {
        Calendar cal = Calendar.getInstance();
        int actualYear = cal.get(Calendar.YEAR);
        int age = actualYear - birthYear;

        return "Your age is: " + age;
    }

}
