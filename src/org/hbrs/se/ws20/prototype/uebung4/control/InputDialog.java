package org.hbrs.se.ws20.prototype.uebung4.control;

import org.hbrs.se.ws20.prototype.uebung4.model.*;
import org.hbrs.se.ws20.prototype.uebung4.view.OutputDialog;

import java.io.IOException;
import java.util.Scanner;

public class InputDialog {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    private Container container = null;

    public InputDialog() {
        this.container = Container.getInstance();
    }

    public void startEingabe() throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        Console console = Console.getInstance();
        String strInput = null;

        Scanner scanner = new Scanner( System.in );

        System.out.println(TEXT_RED + "Prio-Tool V1.5" + TEXT_CYAN);

        while ( true ) {
            System.out.print( TEXT_RED + "> " + TEXT_CYAN);
            strInput = scanner.nextLine();
            String[] strings = strInput.split(" ");
            switch(strings[0]) {

                case "enter":
                    int id = console.readLineInt("UserStory ID: ");
                    String title = console.readLine("Title: ");
                    int addedValue = console.readLineInt("Added value (1-5): ");
                    int penalty = console.readLineInt("Penalty (1-5): ");
                    int effort = console.readLineInt("Effort: ");
                    int risk = console.readLineInt("Risk (1-5): ");
                    double prio = (addedValue + penalty)/(effort + risk);

                    try {
                        Container.getInstance().addUserStory(new UserStory(id, title, addedValue, penalty, effort, risk, prio));
                    } catch (ContainerException e) {
                        System.out.print(TEXT_RED);
                        e.printStackTrace();
                        break;
                    }
                    System.out.println(TEXT_RED + "UserStory added" + TEXT_CYAN);
                    break;

                case "store":
                    if(container.getStrategy() == null) {
                        System.out.println(TEXT_CYAN + "Where would you like to save your UserStories?");
                        String storage = console.readLine("Enter " + TEXT_PURPLE + "HDD " + TEXT_CYAN + "or " + TEXT_PURPLE +  "DBMongo" + TEXT_CYAN  +": ");
                        if (storage.contains("HDD")) {
                            container.setStrategy(new PersistenceStrategyStream());
                        } else if(storage.contains("DBMongo")) {
                            container.setStrategy(new PersistenceStrategyMongoDB());
                        } else {
                            System.out.println(TEXT_RED + "Wrong input! Nothing set. Try again..." + TEXT_CYAN);
                        }
                    } else if(container.getStrategy() != null) {
                        System.out.println("Storage location is already set. Would you like to change it?");
                        String storage = console.readLine("Enter " + TEXT_PURPLE + "HDD " + TEXT_CYAN + "or " + TEXT_PURPLE +  "DBMongo" + TEXT_CYAN + ": ");
                        if (storage.contains("HDD")) {
                            container.setStrategy(new PersistenceStrategyStream());
                        } else if(storage.contains("DBMongo")) {
                            container.setStrategy(new PersistenceStrategyMongoDB());
                        } else {
                            System.out.println(TEXT_RED + "Wrong input! Nothing changed." + TEXT_CYAN);
                        }
                    }
                    container.store();
                    break;

                case "load":
                    if(container.getStrategy() == null) {
                        System.out.println(TEXT_CYAN + "From where would you like to load your UserStories?");
                        String storage = console.readLine("Enter " + TEXT_PURPLE + "HDD " + TEXT_CYAN + "or " + TEXT_PURPLE +  "DBMongo" + TEXT_CYAN  +": ");
                        if (storage.contains("HDD")) {
                            container.setStrategy(new PersistenceStrategyStream());
                        } else if(storage.contains("DBMongo")) {
                            container.setStrategy(new PersistenceStrategyMongoDB());
                        } else {
                            System.out.println(TEXT_RED + "Wrong input! Nothing set. Try again..." + TEXT_CYAN);
                        }
                    } else if(container.getStrategy() != null) {
                        System.out.println("Load location is already set. Would you like to change it?");
                        String storage = console.readLine("Enter " + TEXT_PURPLE + "HDD " + TEXT_CYAN + "or " + TEXT_PURPLE +  "DBMongo" + TEXT_CYAN + ": ");
                        if (storage.contains("HDD")) {
                            container.setStrategy(new PersistenceStrategyStream());
                        } else if(storage.contains("DBMongo")) {
                            container.setStrategy(new PersistenceStrategyMongoDB());
                        } else {
                            System.out.println(TEXT_RED + "Wrong input! Nothing changed." + TEXT_CYAN);
                        }
                    }
                    container.load();
                    break;

                case "dump":
                    this.startAusgabe();
                    break;

                case "help":
                    System.out.println(TEXT_RED + "\nFollowing commands are available:" +
                            TEXT_CYAN + "\nenter" + TEXT_GREEN + " - insert an UserStory " +
                            TEXT_CYAN + "\nstore" + TEXT_GREEN +  " - store all temporary UserStories to HDD" +
                            TEXT_CYAN + "\nload" + TEXT_GREEN + " - load UserStories from HDD" +
                            TEXT_CYAN + "\nmerge " + TEXT_GREEN + " - some random text" +
                            TEXT_CYAN + "\nforce " + TEXT_GREEN + " - some random text" +
                            TEXT_CYAN + "\ndump" + TEXT_GREEN + " - display all available UserStories " +
                            TEXT_CYAN + "\nexit" + TEXT_GREEN + " - will end the programm\n");
                    break;

                case "exit":
                    System.exit(0);
            }
        }
    }

    private void startAusgabe(){
        OutputDialog outputDialog = new OutputDialog();
        outputDialog.dump();
    }
}
