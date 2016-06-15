import java.util.Random;

public class Visitor {
    private int num = 0;
    private String identify;
    String[] type = {"Student", "Professor", "Business Person", "Blogger"};

    public Visitor() {

    }

    public void setNum(int num) { //number of visitors, 1-5
        if (num < 6 && num > 0) {
            this.num = num;
        }
    }

   public void setIdentify(Random rand) { //select visitor number randomly
        this.identify = type[rand.nextInt(4)];
    }

   public void setIdentify(String a) { //make sure only four type of visitors
       if (a.equalsIgnoreCase("Student") || a.equalsIgnoreCase("Professor") || a.equalsIgnoreCase("Business Person") ||a.equalsIgnoreCase("Blogger"))
            this.identify = a;
    }

    public int getNum() { //get the randomly number
        return num;
    }


    public String getIdentify() { //get the identity
        return identify;
    }

}