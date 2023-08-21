
package Controlador;

import Modelo.ConsultasM;
import Modelo.Medicamento;
import Vista.frmMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ConMedicamento implements ActionListener {
    
    private Medicamento mod;
    private ConsultasM modC;
    private frmMedicamento frm;

    public ConMedicamento(Medicamento mod, ConsultasM modC, frmMedicamento frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);

    }

    //Método para iniciar la vista
    public void iniciar() {
        frm.setTitle("Medicamento");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    //Métodos que van a escuchar los clic a los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setLote(frm.txtLote.getText());
            mod.setFabricante(frm.txtFabricante.getText());
            mod.setCantidad(frm.txtCantidad.getText());
            mod.setPrecio(Double.valueOf(frm.txtPrecio.getText()));

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        //***----------Boton modificar
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setLote(frm.txtLote.getText());
            mod.setFabricante(frm.txtFabricante.getText());
            mod.setCantidad(frm.txtCantidad.getText());
            mod.setPrecio(Double.valueOf(frm.txtPrecio.getText()));

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        //***
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Elliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        //*****
        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            if (modC.buscar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtLote.setText(mod.getLote());
                frm.txtFabricante.setText(mod.getFabricante());
                frm.txtCantidad.setText(mod.getCantidad());
                frm.txtCodigo.setText(mod.getCodigo());
                 frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                
                       } else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            }
        }
        //**********************
          if (e.getSource() == frm.btnLimpiar)
          {
             limpiar();
          }
    }

    //Limpiar el formulario
    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtLote.setText(null);
        frm.txtFabricante.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtPrecio.setText(null);

    }

    
}
