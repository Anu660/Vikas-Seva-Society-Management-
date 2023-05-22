
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naika
 */
public class Database {
    Connection cn=null;
    Statement st=null;
    
    String connectdb()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vikas_seva_society","root","root");
            return"Database Connected";
        }
        
        catch(Exception ex)
        {
           return ex.toString(); 
        }
    }
    String Insert(String sql)
    {
       try
       {
           
           st=cn.createStatement();
           st.executeUpdate(sql);
           return "inserted";
 
       }catch(Exception ex)
       {
          return ex.toString();
       }
    }
           String Update(String sql)
       {
       try
       {
       st=cn.createStatement();
       st.executeUpdate(sql);
       return "Record Updated";
       
       
       }catch(Exception ex)
       {
          return  ex.toString();
       }
       }
     
     
      String Delete(String sql)
       {
       try
       {
       st=cn.createStatement();
       st.executeUpdate(sql);
       return "Record Deleted";
       
       
       }catch(Exception ex)
       {
          return  ex.toString();
       }
       }
       String search(String sql,String column)
    {
    int id=1;
        try {
               Class.forName("com.mysql.jdbc.Driver");
    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vikas_seva_society","root","root");
    st=cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next())
    {
        id=Integer.parseInt(rs.getString(column))+1;
        
    }
    return (String.valueOf(id));
            
        } catch (Exception ex) {
            return (ex.toString());
        }
    }     
            
    
    
}
