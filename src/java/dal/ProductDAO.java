/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Hieu
 */
public class ProductDAO extends DBContext{
    public List<Product>getAll(){
        List<Product>list=new ArrayList<>();
         String sql = "SELECT p.id,p.name,p.image,p.price,p.quantity,"
                 + "p.describe,p.releaseDate,"
                 + " p.cid cid,c.name cname"
                 + " FROM Products p inner join categories c "
                 + "on p.cid=c.id";
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = new Category(
                        rs.getInt("cid"),
                        rs.getString("cname")
                );
                p.setCategory(c);
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public List<Product>getListByPage(List<Product>list,int start,int end){
        ArrayList<Product>arr =new ArrayList<>();
        for(int i=start;i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    public static void main(String[] args) {
        ProductDAO c= new ProductDAO();
        List<Product>list=c.getAll();
        System.out.println(list.get(0).getCategory().getName());
    }
}
