package userDao;

import user.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userdao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/fooddesign", "root", "root");
            if (con != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Not Connected");
            }
        } catch (Exception e) {
            System.out.println("Driver not found in catch method");
        }
        return con;
    }
    public static int saveDetails(user u) {
        //  user u=new user();
        int result = 0;
        Connection con = getConnection();
        try {
            String createUser = "insert into food(candidatename,foodname,price) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(createUser);
            ps.setString(1,u.getName());
            ps.setString(2,u.getFoodname());
            ps.setInt(3,u.getPrice());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<user> viewDetails() {
        ArrayList<user> listitem = new ArrayList<>();
        Connection con = getConnection();
        try {
            String viewDetails = "select * from food";
            PreparedStatement ps = con.prepareStatement(viewDetails);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user User = new user();
                User.setSlno(rs.getInt("slno"));
                User.setName(rs.getString("candidatename"));
                User.setFoodname(rs.getString("foodname"));
                User.setPrice(rs.getInt("price"));
                listitem.add(User);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listitem;
    }
    public static int deleteUser(int slno){
        int result = 0;
        Connection con =getConnection();
        try{
            String deleteUser="delete from food where slno=?";
            PreparedStatement ps = con.prepareStatement(deleteUser);
            ps.setInt(1,slno);
            result =ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static  int updateUser(user e){
        int result =0;
        Connection con = getConnection();
        try{
            String updateUser="update food set candidatename=?,foodname=?,price=? where slno=?";
            PreparedStatement ps =con.prepareStatement(updateUser);
            ps.setString(1,e.getName());
            ps.setString(2,e.getFoodname());
            ps.setInt(3,e.getPrice());
            ps.setInt(4,e.getSlno());
            result=ps.executeUpdate();

        }
        catch (Exception f ){
            f.printStackTrace();
        }
        return result;
    }
    public static user getUserbyid(int slno) {
        user user = new user();

        Connection con = getConnection();
        try {
            String selectUserbyID="select slno,candidatename,foodname,price from food where slno=?";
            PreparedStatement ps = con.prepareStatement(selectUserbyID);
            ps.setInt(1, slno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setSlno(rs.getInt("slno"));
                user.setName(rs.getString("candidatename"));  // Here is where setName() is called
                user.setFoodname(rs.getString("foodname"));
                user.setPrice(rs.getInt("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
