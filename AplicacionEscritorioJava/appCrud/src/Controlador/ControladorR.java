
package Controlador;

import Modelo.ConsultasR;
import Modelo.Registro;
import Vista.frmRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorR implements ActionListener{
    
     private Registro mod;
    private ConsultasR modC;
    private frmRegistro frm;

    public ControladorR(Registro mod, ConsultasR modC, frmRegistro frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        

    }

    //Método para iniciar la vista
    public void iniciar() {
        frm.setTitle("registro");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    //Métodos que van a escuchar los clic a los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
           mod.setCorreo_electronico(frm.txtCorreo.getText());
           mod.setContraseña(frm.TxtContrasena.getText());
          

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
    } 
    
    //Limpiar el formulario
    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCorreo.setText(null);
        frm.TxtContrasena.setText(null);

    }

}
