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
public class CategoryDAO extends DBContext{
//    Lay list category
     public List<Category>getAll(){
        List<Category>list=new ArrayList<>();
         String sql = "SELECT [ID]\n"
                 + "      ,[name]\n"
                 + "  FROM [dbo].[Categories]";
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name"));
                list.add(c);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        CategoryDAO c= new CategoryDAO();
        List<Category>list=c.getAll();
        System.out.println(list.get(0).getName());
    }
}
