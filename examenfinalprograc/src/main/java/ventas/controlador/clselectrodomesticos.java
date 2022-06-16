package ventas.controlador;

public class clselectrodomesticos {
    private int elecid;
    private String elecmarca;
    private String electipo;
    private String elecprecio;

            

    public clselectrodomesticos() {
    }

    public clselectrodomesticos(int elecid) {
        this.elecid = elecid;
    }
    
    public clselectrodomesticos(String smarca, String stipo) {
        this.elecmarca = smarca;
        this.electipo = stipo;
    }
    
    public clselectrodomesticos(int elecid, String smarca, String stipo, String sprecio ) {
        this.elecid = elecid;
        this.elecmarca = smarca;
        this.electipo = stipo;
        this.elecprecio = sprecio;
            }
    

    public int getelecid() {
        return elecid;
    }

    public void setelecid(int elecid) {
        this.elecid = elecid;
    }

    public String getelecmarca() {
        return elecmarca;
    }

    public void setelecmarca(String smarca) {
        this.elecmarca = smarca;
    }

    public String getelectipo() {
        return electipo;
    }

    public void setelectipo(String stipo) {
        this.electipo = stipo;
    }
     public String getelecprecio() {
        return elecprecio;
    }

    public void setelecprecio(String sprecio) {
        this.elecprecio = sprecio;
    }
   
    
    @Override
    public String toString() {
        return "tbl_vehiculo{" + "elecid=" + elecid + ", elecmarca="  +  elecmarca +", elecmarca=" + electipo + ", elecprecio="+ elecprecio  + "}";
    }
    
    
}
