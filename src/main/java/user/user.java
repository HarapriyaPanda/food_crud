package user;

public class user {
    private int slno;
    private String candidatename;
    private String foodname;
    private int price;

    public int getSlno() {
        return slno;
    }

    // Setter for name
    public void setSlno(int slno) {
        this.slno = slno;
    }
    // Getter for name
    public String getName() {
        return candidatename;
    }

    // Setter for name
    public void setName(String name) {
        this.candidatename = name;
    }

    // Getter for foodname
    public String getFoodname() {
        return foodname;
    }

    // Setter for foodname
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }
}
