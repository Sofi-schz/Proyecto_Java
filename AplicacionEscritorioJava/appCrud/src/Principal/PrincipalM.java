/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controlador.ConMedicamento;
import Modelo.ConsultasM;
import Modelo.Medicamento;
import Vista.frmMedicamento;

public class PrincipalM {
    
     public static void main(String[] args) {
        Medicamento mod=new Medicamento();
        ConsultasM modC=new ConsultasM();
        frmMedicamento frm=new frmMedicamento();
        ConMedicamento  crtl=new ConMedicamento(mod,modC,frm);
        crtl.iniciar();
        frm.setVisible(true);
    }
    
}
