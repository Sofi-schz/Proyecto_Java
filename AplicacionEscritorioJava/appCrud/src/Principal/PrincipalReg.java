
package Principal;

import Controlador.ConRegistro;
import Modelo.ConsultasReg;
import Modelo.Registro1;
import Vista.frmRegistro1;

public class PrincipalReg {
    
      public static void main(String[] args) {
        Registro1 mod=new Registro1();
        ConsultasReg modC=new ConsultasReg();
        frmRegistro1 frm=new frmRegistro1();
        ConRegistro  crtl=new ConRegistro(mod,modC,frm);
        crtl.iniciar();
        frm.setVisible(true);
    }
    
}
