package com.ecodeup.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.connection.Conexion;
import com.ecodeup.idao.IClienteDao;
import com.ecodeup.model.Cliente;
 
public class ClienteDaoImpl implements IClienteDao {	
	
	public boolean registrar(Cliente cliente) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO cliente values (NULL,'"+cliente.getName()+"','"+cliente.getFirstname()+"','"+cliente.getSecondname()+"','"+cliente.getDni()+"')";
		
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	public List<Cliente> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM CLIENTE ORDER BY ID";
		
		List<Cliente> listaCliente= new ArrayList<Cliente>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c= new Cliente(0, sql, sql, sql, sql);
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setFirstname(sql);
				c.setSecondname(sql);
				c.setDni(sql);
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
	}
 
	public boolean actualizar(Cliente cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE CLIENTE SET cedula='"+cliente.getName()+"', nombres='"+cliente.getFirstname()+"', apellidos='"+cliente.getSecondname()+"'" +" WHERE ID="+cliente.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	public boolean eliminar(Cliente cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}