
package Principal;

import Controlador.ControladorR;
import Modelo.ConsultasR;
import Modelo.Registro;
import Vista.frmRegistro;


public class PrincipalR {
    
     public static void main(String[] args) {
        Registro mod=new Registro();
        ConsultasR modC=new ConsultasR();
        frmRegistro frm=new frmRegistro();
        ControladorR crtl=new ControladorR(mod,modC,frm);
        crtl.iniciar();
        frm.setVisible(true);
    }
    
}
