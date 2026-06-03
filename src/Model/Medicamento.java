package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Medicamento {
	
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int stockMinimo;
    private boolean requiereReceta;
    private String categoria;
    private String proveedor;
    private String lote;
    private Date fechaVencimiento;
    private String laboratorio;
    private boolean activo;
    private Timestamp fechaRegistro;
    
    public Medicamento() {}
 
    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }
    
    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }
    
    public String getDescripcion() { 
    	return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
    	this.descripcion = descripcion; 
    }
    
    public double getPrecio() { 
    	return precio; 
    }
    public void setPrecio(double precio) { 
    	this.precio = precio; 
    }
    
    public int getStock() { 
    	return stock; 
    }
    public void setStock(int stock) { 
    	this.stock = stock; 
    }
    
    public int getStockMinimo() {
    	return stockMinimo; 
    }
    public void setStockMinimo(int stockMinimo) { 
    	this.stockMinimo = stockMinimo; 
    }
    
    public boolean isRequiereReceta() { 
    	return requiereReceta; 
    }
    public void setRequiereReceta(boolean requiereReceta) { 
    	this.requiereReceta = requiereReceta; 
    }
    
    public String getCategoria() { 
    	return categoria; 
    }
    public void setCategoria(String categoria) { 
    	this.categoria = categoria; 
    }
    
    public String getProveedor() { 
    	return proveedor; 
    }
    public void setProveedor(String proveedor) { 
    	this.proveedor = proveedor; 
    }
    
    public String getLote() { 
    	return lote; 
    }
    public void setLote(String lote) { 
    	this.lote = lote; 
    }
    
    public Date getFechaVencimiento() { 
    	return fechaVencimiento; 
    }
    public void setFechaVencimiento(Date fechaVencimiento) { 
    	this.fechaVencimiento = fechaVencimiento; 
    }
    
    public String getLaboratorio() { 
    	return laboratorio; 
    }
    public void setLaboratorio(String laboratorio) { 
    	this.laboratorio = laboratorio; 
    }
    
    public boolean isActivo() { 
    	return activo; 
    }
    public void setActivo(boolean activo) { 
    	this.activo = activo; 
    }
    
    public Timestamp getFechaRegistro() { 
    	return fechaRegistro; 
    }
    public void setFechaRegistro(Timestamp fechaRegistro) { 
    	this.fechaRegistro = fechaRegistro; 
    }
}