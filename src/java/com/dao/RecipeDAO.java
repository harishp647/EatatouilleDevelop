/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.RecipeBean;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author saumil
 */
public class RecipeDAO {
    
    Connection con = null;
    PreparedStatement ps = null;
    Statement s = null;
    ResultSet rs = null;
    
    public ArrayList advanceSearch(RecipeBean rb){
    
        String name = rb.getName();
        String diet = rb.getDiet();
        String cusine = rb.getCusine();
        String calories = rb.getCalories();
        String time = rb.getTime();
        
        ArrayList<RecipeBean> recipe = new ArrayList<RecipeBean>();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where calories < ? && time < ? || name like ?"
                    + " || diet like ? || cusine like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, calories);
            ps.setString(2, time);
            ps.setString(3, "%"+name+"%");
            ps.setString(4, "%"+diet+"%");
            ps.setString(5, "%"+cusine+"%");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                RecipeBean recipeBean  = new RecipeBean();
                System.out.println("loop"+rs.getString("calories"));
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
           
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByCusine(RecipeBean rb, ArrayList recipe){
    
        String cusine = rb.getCusine();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where cusine like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+cusine+"%");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                RecipeBean recipeBean  = new RecipeBean();
                System.out.println("loop"+rs.getString("calories"));
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
           
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByDiet(RecipeBean rb, ArrayList recipe){
    
        String diet = rb.getDiet();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where diet like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+diet+"%");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                RecipeBean recipeBean  = new RecipeBean();
                System.out.println("loop"+rs.getString("calories"));
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
           
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByCalories(RecipeBean rb, ArrayList recipe){
    
        String calories = rb.getCalories();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where calories < ?";
            ps = con.prepareStatement(query);
            ps.setString(1, calories);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                RecipeBean recipeBean  = new RecipeBean();
                System.out.println("loop"+rs.getString("calories"));
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
           
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByTime(RecipeBean rb, ArrayList recipe){
    
        String time = rb.getTime();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where time < ?";
            ps = con.prepareStatement(query);
            ps.setString(1, time);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                RecipeBean recipeBean  = new RecipeBean();
                System.out.println("loop"+rs.getString("calories"));
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
           
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByName(String recipeName, ArrayList recipe){
        
        RecipeBean recipeBean  = new RecipeBean();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where name like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+recipeName+"%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByIngredients(String ingredients[], ArrayList recipe){
        
        ResultSet rs1;
        ResultSet rs2;
        ResultSet rs3;
        PreparedStatement ps1;
        PreparedStatement ps2;
        PreparedStatement ps3;
        
        RecipeBean recipeBean = new RecipeBean();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query1 = "select ingredientId from ingredientList where ingredient like ?";
            for(int i=0;i<ingredients.length;i++){
                if(ingredients[i].length() > 1){
                    ps1 = con.prepareStatement(query1);
                    ps1.setString(1, "%"+ingredients[i]+"%".toUpperCase());
                    rs1 = ps1.executeQuery();

                    while(rs1.next()){
                        String ingredientId = rs1.getString("ingredientId");
                        String query2 = "select recipeId from recipeIngredient where ingredientId = ?";
                        ps2 = con.prepareStatement(query2);
                        ps2.setString(1, ingredientId);
                        rs2 = ps2.executeQuery();

                        while(rs2.next()){
                            String query3 = "select * from recipeDetails where recipeId = ?";
                            ps3 = con.prepareStatement(query3);
                            ps3.setString(1, rs2.getString("recipeId"));
                            rs3 = ps3.executeQuery();

                            while(rs3.next()){
                                System.out.println("4");
                                recipeBean.setCalories(rs3.getString("calories"));
                                recipeBean.setCusine(rs3.getString("cusine"));
                                recipeBean.setDiet(rs3.getString("diet"));
                                recipeBean.setImage(rs3.getString("image"));
                                recipeBean.setName(rs3.getString("name"));
                                recipeBean.setTime(rs3.getString("time"));
                                recipeBean.setRecipeId(rs3.getString("recipeId"));
                                recipe.add(recipeBean);             
                            }

                        }

                    }
                }
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getRecipeByName(String recipeName){
        
        ArrayList<RecipeBean> recipe = new ArrayList<RecipeBean>();
        RecipeBean recipeBean  = new RecipeBean();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from recipeDetails where name like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+recipeName+"%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                recipeBean.setCalories(rs.getString("calories"));
                recipeBean.setCusine(rs.getString("cusine"));
                recipeBean.setDiet(rs.getString("diet"));
                recipeBean.setImage(rs.getString("image"));
                recipeBean.setName(rs.getString("name"));
                recipeBean.setTime(rs.getString("time"));
                recipeBean.setRecipeId(rs.getString("recipeId"));
                recipe.add(recipeBean);
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipe;
        
    }
    
    public ArrayList getAllRecipes(){
        
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        
        ArrayList list = new ArrayList();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query1 = "select * from recipeDetails";
            ps1 = con.prepareStatement(query1);
            rs1 = ps1.executeQuery();
            while(rs1.next()){
                RecipeBean recipeBean = new RecipeBean();
                String recipeId = rs1.getString("recipeId");
                recipeBean.setRecipeId(recipeId);
                recipeBean.setCalories(rs1.getString("calories"));
                recipeBean.setCusine(rs1.getString("cusine"));
                recipeBean.setDiet(rs1.getString("diet"));
                recipeBean.setImage(rs1.getString("image"));
                recipeBean.setName(rs1.getString("name"));
                recipeBean.setPeople(rs1.getString("people"));
                recipeBean.setSteps(rs1.getString("steps"));
                recipeBean.setTime(rs1.getString("time"));
                recipeBean.setUserId(rs1.getString("userId"));
                
                String query2 = "select mealId from recipeMeal where recipeId=?";
                ps2 = con.prepareStatement(query2);
                ps2.setString(1, recipeId);
                rs2 = ps2.executeQuery();
                ArrayList meal = new ArrayList();
                while(rs2.next()){
                    
                    String mealId = rs2.getString("mealId");
                    String query3 = "select mealName from meal where id=?";
                    ps3 = con.prepareStatement(query3);
                    ps3.setString(1, mealId);
                    rs3 = ps3.executeQuery();
                    while(rs3.next()){
                        meal.add(rs3.getString("mealName"));
                    }
                            
                }
                recipeBean.setMealList(meal);
                
                String query4 = "select ingredientId from recipeIngredient where recipeId=?";
                ps2 = con.prepareStatement(query4);
                ps2.setString(1, recipeId);
                rs2 = ps2.executeQuery();
                ArrayList ingredients = new ArrayList();
                while(rs2.next()){
                    
                    String ingredientId = rs2.getString("ingredientId");
                    String query5 = "select ingredient from ingredientList where ingredientId=?";
                    ps3 = con.prepareStatement(query5);
                    ps3.setString(1, ingredientId);
                    rs3 = ps3.executeQuery();
                    while(rs3.next()){
                        ingredients.add(rs3.getString("ingredient"));
                    }
                            
                }
                recipeBean.setIngredientsList(ingredients);
                
                list.add(recipeBean);
                
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return list;
        
    }
    
    public ArrayList getSingleRecipe(String rcpId){
        
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        
        ArrayList list = new ArrayList();
        try{
        
            con = DBConnection.createConnection();
            
            String query1 = "select * from recipeDetails where recipeId=?";
            ps1 = con.prepareStatement(query1);
            ps1.setString(1, rcpId);
            rs1 = ps1.executeQuery();
            while(rs1.next()){
                RecipeBean recipeBean = new RecipeBean();
                String recipeId = rs1.getString("recipeId");
                recipeBean.setRecipeId(recipeId);
                recipeBean.setCalories(rs1.getString("calories"));
                recipeBean.setCusine(rs1.getString("cusine"));
                recipeBean.setDiet(rs1.getString("diet"));
                recipeBean.setImage(rs1.getString("image"));
                recipeBean.setName(rs1.getString("name"));
                recipeBean.setPeople(rs1.getString("people"));
                recipeBean.setSteps(rs1.getString("steps"));
                recipeBean.setTime(rs1.getString("time"));
                recipeBean.setUserId(rs1.getString("userId"));
                
                String query2 = "select mealId from recipeMeal where recipeId=?";
                ps2 = con.prepareStatement(query2);
                ps2.setString(1, recipeId);
                rs2 = ps2.executeQuery();
                ArrayList meal = new ArrayList();
                while(rs2.next()){
                    
                    String mealId = rs2.getString("mealId");
                    String query3 = "select mealName from meal where id=?";
                    ps3 = con.prepareStatement(query3);
                    ps3.setString(1, mealId);
                    rs3 = ps3.executeQuery();
                    while(rs3.next()){
                        meal.add(rs3.getString("mealName"));
                    }
                            
                }
                recipeBean.setMealList(meal);
                
                String query4 = "select ingredientId from recipeIngredient where recipeId=?";
                ps2 = con.prepareStatement(query4);
                ps2.setString(1, recipeId);
                rs2 = ps2.executeQuery();
                ArrayList ingredients = new ArrayList();
                while(rs2.next()){
                    
                    String ingredientId = rs2.getString("ingredientId");
                    String query5 = "select ingredient from ingredientList where ingredientId=?";
                    ps3 = con.prepareStatement(query5);
                    ps3.setString(1, ingredientId);
                    rs3 = ps3.executeQuery();
                    while(rs3.next()){
                        ingredients.add(rs3.getString("ingredient"));
                    }
                            
                }
                recipeBean.setIngredientsList(ingredients);
                
                list.add(recipeBean);
                
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return list;
        
    }
    
    public String addRecipeDetails(RecipeBean recipeBean){
        
        String name = recipeBean.getName();
        String diet = recipeBean.getDiet();
        String cusine = recipeBean.getCusine();
        String people = recipeBean.getPeople();
        String calories = recipeBean.getCalories();
        String time = recipeBean.getTime();
        String steps = recipeBean.getSteps();
        String userId = recipeBean.getUserId();
        String recipeId = "";
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "insert into recipeDetails (name, calories, time, people, steps, cusine, diet, userId)"
                    + "values ('"+name+"', '"+calories+"', '"+time+"', '"+people+"', '"+steps+"', '"+cusine+"', '"+diet+"', '"+userId+"')";
            s = con.createStatement();
            s.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = s.getGeneratedKeys();
            if (rs.next()){
                recipeId = rs.getString(1);
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return recipeId;
        
    }
    
    public void addMealInfo(String meal[], String recipeId){
        
        try{
            
            con = DBConnection.createConnection();
            
            String query = "insert into recipeMeal (recipeId, mealId) values (?,?)";
            ps = con.prepareStatement(query);
            
            for(int i=0;i<meal.length;i++){
                ps.setString(1, recipeId);
                ps.setString(2, meal[i]);
                ps.addBatch();
            }
            ps.executeBatch();
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void addIngredients(String ingredients[], String recipeId){
        
        ResultSet rs1 = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Statement s1 = null;
        
        try{
            
            con = DBConnection.createConnection();
            
            String query1 = "insert into recipeIngredient (recipeId, ingredientId) values (?,?)";
            ps1 = con.prepareStatement(query1);
            
            String query2 = "select ingredientId from ingredientList where ingredient = ?";
            ps2 = con.prepareStatement(query2);
            for(int i=0;i<ingredients.length;i++){
                ps2.setString(1, ingredients[i].toUpperCase().trim());
                rs1 = ps2.executeQuery();
                boolean flag = false;
                while(rs1.next()){
                    flag = true;
                    ps1.setString(1, recipeId);
                    ps1.setString(2, rs1.getString(1));
                    ps1.addBatch();
                }
                if(!flag){
                    String ingredientId = "";
                    String query3 = "insert into ingredientList (ingredient) values ('"+ingredients[i].toUpperCase().trim()+"')";
                    s1 = con.createStatement();
                    s1.executeUpdate(query3, Statement.RETURN_GENERATED_KEYS);
                    rs = s1.getGeneratedKeys();
                    if (rs.next()){
                        ingredientId = rs.getString(1);
                    }
                    ps1.setString(1, recipeId);
                    ps1.setString(2, ingredientId);
                    ps1.addBatch();
                }
            }
            ps1.executeBatch();
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void addImage(String recipeId, String image){
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "update recipeDetails set image=? where recipeId=?";
            ps = con.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, recipeId);
            ps.executeUpdate();
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
