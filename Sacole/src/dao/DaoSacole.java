/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Sacole;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoSacole {
     public static boolean inserir(Sacole objeto) {
        String sql = "INSERT INTO sacole (sabor, data_validade, preco, nr_serie) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSabor());
            ps.setDate(2, Date.valueOf(objeto.getData_validade()));
            ps.setDouble(3, objeto.getPreco());
            ps.setInt(4, objeto.getNr_serie());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     
     
      public static void main(String[] args) {
        Sacole objeto = new Sacole();
        objeto.setSabor("Chocolate preto");
        objeto.setPreco(2.3);
        objeto.setNr_serie(2);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      
      public static boolean alterar(Sacole objeto) {
        String sql = "UPDATE sacole SET sabor = ?, data_validade = ?, preco = ?, nr_serie WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSabor());
            ps.setDate(2, Date.valueOf(objeto.getData_validade()));
            ps.setDouble(3, objeto.getPreco());
            ps.setInt(4, objeto.getNr_serie());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
      
      
       public static boolean excluir(Sacole objeto) {
        String sql = "DELETE FROM sacole WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
       
       public static List<Sacole> consultar() {
        List<Sacole> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, sabor, data_validade preco, nr_serie FROM sacole";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sacole objeto = new Sacole();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setSabor(rs.getString("sabor"));
                objeto.setPreco(rs.getDouble("preco"));
                objeto.setNr_serie(rs.getInt("nr_serie"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
       
       
 public static Sacole consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, sabor, preco, nr_serie FROM sacole WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sacole objeto = new Sacole();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setSabor(rs.getString("sabor"));
                objeto.setPreco(rs.getDouble("preco"));
                objeto.setNr_serie(rs.getInt("nr_serie"));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }       
     
}
