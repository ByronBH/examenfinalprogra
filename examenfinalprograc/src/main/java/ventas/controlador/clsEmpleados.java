package ventas.controlador;

import ventas.controlador.*;
import seguridad.controlador.*;

public class clsEmpleados {
    
    private int empid;
    private String empnombre;
    private String empsueldo; 
    private String empestado;
    private String empcargo;

   
    public clsEmpleados() {
    }

    public clsEmpleados(int p_empid) {
        this.empid = p_empid;
    }
    
    public clsEmpleados(String empnombre, String empsueldo, String empestado, String empcargo) {
        this.empnombre = empnombre;
        this.empsueldo = empsueldo;
        this.empestado = empestado;
        this.empcargo = empcargo;
     
    }
    
    public clsEmpleados(int empid, String empnombre, String empsueldo, String empestado, String empcargo) {
        this.empid = empid;
        this.empnombre = empnombre;
        this.empsueldo = empsueldo;
        this.empestado = empestado;
        this.empcargo = empcargo;
        
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getempid() {
        return empid;
    }

    public void setempid(int empid) {
        this.empid = empid;
    }

    public String getempnombre() {
        return empnombre;
    }

    public void setempnombre(String empnombre) {
        this.empnombre = empnombre;
    }

    public String getempsueldo() {
        return empsueldo;
    }

    public void setempsueldo(String empsueldo) {
        this.empsueldo = empsueldo;
    }

    public String getempestado() {
        return empestado;
    }

    public void setempestado(String empestado) {
        this.empestado = empestado;
    }

      
     public String getempcargo() {
        return empcargo;
    }

    public void setempcargo(String empcargo) {
        this.empcargo = empcargo;
    }

      public int setempid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
