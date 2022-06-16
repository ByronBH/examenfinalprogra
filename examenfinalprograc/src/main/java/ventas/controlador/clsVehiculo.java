package ventas.controlador;

public class clsVehiculo {
    private int vehiid;
    private String vehimarca;
    private String vehimodelo;
    private String vehicolor;
    private String vehitipo;
            

    public clsVehiculo() {
    }

    public clsVehiculo(int vehiid) {
        this.vehiid = vehiid;
    }
    
    public clsVehiculo(String smarca, String smodelo) {
        this.vehimarca = smarca;
        this.vehimodelo = smodelo;
    }
    
    public clsVehiculo(int vehiid, String smarca, String smodelo, String scolor, String stipo ) {
        this.vehiid = vehiid;
        this.vehimarca = smarca;
        this.vehimodelo = smodelo;
        this.vehicolor = scolor;
        this.vehitipo = stipo;
            }
    

    public int getvehiid() {
        return vehiid;
    }

    public void setvehiid(int vehiid) {
        this.vehiid = vehiid;
    }

    public String getvehimarca() {
        return vehimarca;
    }

    public void setvehimarca(String snombre) {
        this.vehimarca = snombre;
    }

    public String getvehimodelo() {
        return vehimodelo;
    }

    public void setvehimodelo(String smodelo) {
        this.vehimodelo = smodelo;
    }
     public String getvehicolor() {
        return vehicolor;
    }

    public void setvehicolor(String scolor) {
        this.vehicolor = scolor;
    }
    public String getvehitipo() {
        return vehitipo;
    }

    public void setvehitipo(String stipo) {
        this.vehitipo = stipo;
    }
    
    
    @Override
    public String toString() {
        return "tbl_vehiculo{" + "vehiid=" + vehiid + ", vehimarca="  +  vehimarca +", vehimarca=" + vehimodelo + ", vehicolor="+ vehicolor +", vehitipo"+vehitipo + "}";
    }
    
    
}
