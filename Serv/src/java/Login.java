/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
* @author: Sanchez Mendez Edmundo Josue, Rodriguez Morua Genaro 
* @version:  1.0 29/agosto/2017 
**/
public class Login extends HttpServlet {
 
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //Ponemos la conexion y llamabos los campos que lleno
       Connection con = null;
        String cor = request.getParameter("ema");
        String contra = request.getParameter("passwo");
       try {
           //Hacemos la conexion
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/serv", "root","n0m3l0");
//Creamos steament para poder acceder al BD
   Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("Select * from logins where Correo='"+cor+"'");
   //Validamos campos
   if(rs.next()){
                   String pass = rs.getString("Contraseña");
                   if(contra.equals(pass)){
                       //En caso de datos correctos
                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println("Bienvenido :)");
                   }else{
                       //En caso de algun dato incorrecto
                        response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("Contra incorrecta :(");
                   }
               }else{
       //En caso de que no exista en la base
                    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("No existe :0");
               }
   //Cerramos las conexiones
   rs.close();
   st.close();

  } //En caso de errores
       catch (InstantiationException | IllegalAccessException
    | ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
 }
 
}