package com.pluralsight.application;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;

public class DealershipApplication
{
    Dealership dealership;

    public DealershipApplication(Dealership dealership)
    {
        this.dealership = dealership;
    }

    public void run()
    {
        while(true)
        {
            int choice = UserInterface.getHomeScreenSelection(dealership);

            switch (choice)
            {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    searchByPrice();
                    break;
                case 3:
                    searchByYear();
                    break;
                case 4:
                    searchByColor();
                    break;
                case 5:
                    searchByMileage();
                    break;
                case 6:
                    searchByVehicleType();
                    break;
                case 7:
                    addVehicle();
                    break;
                case 0:
                    UserInterface.endApplication();
                    System.exit(0);
            }
        }
    }

    private void displayAllVehicles()
    {
        UserInterface.displayMessage("\nShow All Vehicles");
        UserInterface.displayMessage("------------------------------------");
        UserInterface.displayVehicles(dealership.getAllVehicles());
    }

    private void searchByPrice()
    {
        UserInterface.displayMessage("\nSearch by Price");
        UserInterface.displayMessage("------------------------------------");
        double min = UserInterface.getUserInputDouble("Minimum Price: ");
        double max = UserInterface.getUserInputDouble("Maximum Price: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        UserInterface.displayMessage("------------------------------------");
        UserInterface.displayVehicles(vehicles);

    }

    private void searchByYear()
    {
        // get min and max year from user
        UserInterface.displayMessage("\nSearch by year");
        UserInterface.displayMessage("--------------------------");
        int minYear = UserInterface.getUserInputInt("Minimum Year: ");
        int maxYear = UserInterface.getUserInputInt("Maximum Year: ");

        // search for vehicle by year
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);

        // display the vehicles
        UserInterface.displayVehicles(vehicles);
    }

    private void searchByColor()
    {
        UserInterface.displayMessage("search by color");
    }

    private void searchByMileage()
    {
        UserInterface.displayMessage("search by mileage");
    }

    private void searchByVehicleType()
    {
        UserInterface.displayMessage("search by vehicle type");
    }

    private void addVehicle()
    {
//        1) Collect the Vehicle info from the user
        UserInterface.displayMessage("========== Please input vehicle info ===========");

//        2) Parse the information provided into variables and pass the values into our Constructor
        int vin =  Integer.parseInt(UserInterface.getUserInput("Please input the vin number: "));
        int year = Integer.parseInt(UserInterface.getUserInput("Please enter the year: "));
        String make = UserInterface.getUserInput("Please enter the make: ");
        String model = UserInterface.getUserInput("Please enter the model: ");
        String vehicleType = UserInterface.getUserInput("Please enter the vehicle type: ");
        String color = UserInterface.getUserInput("Please enter the color: ");
        int odometer = Integer.parseInt(UserInterface.getUserInput("Please enter the odometer number (int): "));
        double price = Double.parseDouble(UserInterface.getUserInput("Please enter the price: "));
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

//        3) Pass the newly created vehicle to the dealership and save
        dealership.addVehicleToDealership(vehicle);
        dealership.saveDealership();
    }
}
