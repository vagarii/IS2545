import java.util.Random;
import java.util.Scanner;


public class CitySim9002 {

    static String[] location = {"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown", "left the city"};

    public static int checkInput(String input) { //check if valid int
        int seed = 0;
        try {
            seed = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter one integer argument, seed");
            System.exit(1);
        }
        return seed;
    }

    public boolean preferences(Visitor n,String location) { //check preferences
        if(n.getIdentify() == "Student") {
            if(location == "Squirrel Hill" || location == "Downtown" || location == "The Point") {
                return true;
            } else {
                return false;
            }

        }
        if(n.getIdentify() == "Business Person") {
            if(location == "Squirrel Hill" || location == "Downtown") {
                return true;
            } else {
                return false;
            }
        }
        if(n.getIdentify() == "Professor"){
            if(location == "left the city") {
                return false;
            } else if (location == "Squirrel Hill" || location == "Downtown" || location == "The Point" || location == "The Cathedral of Learning") {
                return true;
            }
        }

        return false;
    }

    public String displayPreference(Visitor n,String l){ //display preferences
        if(preferences(n,l)){
            return "Visitor " + n.getNum() + " did like " + l + ".";
        }
        else{
            return "Visitor " + n.getNum() + " did not like " + l + ".";
        }
    }

    public void traverse(Visitor n,Random rand) { //traverse the city
        String l = location[rand.nextInt(5)];
        while(l == "left the city"){ // first visitor function
            l = location[rand.nextInt(5)];
        }
        while(l != "left the city"){ //end of visiting
            System.out.println("Visitor " + n.getNum() + " is going to " + l + "!");
            System.out.println(displayPreference(n,l));
            l = location[rand.nextInt(5)];
        }
        System.out.println("Visitor " + n.getNum() + " has " + l);
    }

    public static void main(String[] args){
        CitySim9002 city = new CitySim9002();
        Scanner input = new Scanner(System.in);
        int seed = checkInput(input.next());
        System.out.println("Welcome to CitySim!	Your seed is " + seed + ".");
        Random rand = new Random(seed);
        for(int i = 1;i < 6; i++){
            Visitor visitor = new Visitor();
            visitor.setNum(i);
            visitor.setIdentify(rand);
            System.out.println("Visitor " + visitor.getNum() + " is a " + visitor.getIdentify());
            city.traverse(visitor,rand);
            System.out.println("***");
        }
    }

}
