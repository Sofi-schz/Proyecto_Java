
package Controlador;

import Modelo.ConsultasReg;
import Modelo.Registro1;
import Vista.frmRegistro1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ConRegistro implements ActionListener {
    
    private Registro1 mod;
    private ConsultasReg modC;
    private frmRegistro1 frm;

    public ConRegistro(Registro1 mod, ConsultasReg modC, frmRegistro1 frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        
        

    }

    //Método para iniciar la vista
    public void iniciar() {
        frm.setTitle("Registro1");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    //Métodos que van a escuchar los clic a los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellido(frm.txtApellido.getText());
            mod.setDomicilio(frm.txtDomicilio.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            

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
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtDomicilio.setText(null);
        frm.txtTelefono.setText(null);
        

    }

}
    

