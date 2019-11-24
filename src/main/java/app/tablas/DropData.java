/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tablas;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariel
 */
public class DropData implements DropTargetListener {

    private DropTarget dt;
    private JTable tablaOrigen;
    private JTable tablaDestino;

    public DropData(JTable tablaOrigen, JTable tablaDestino) {

        this.tablaOrigen = tablaOrigen;
        this.tablaDestino = tablaDestino;

        dt = new DropTarget(tablaDestino, this);

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {

        DefaultTableModel modeloOrigen = (DefaultTableModel) tablaOrigen.getModel();
        DefaultTableModel modeloDestino = (DefaultTableModel) tablaDestino.getModel();

        int filaSeleccionada = tablaOrigen.getSelectedRow();

        Object[] nuevaFila = new Object[modeloOrigen.getRowCount()];

        for (int i = 0; i < modeloOrigen.getColumnCount(); i++) {

            nuevaFila[i] = modeloOrigen.getValueAt(filaSeleccionada, i);

        }

        // Por defecto es necesario dejar una fila par que el drag and drop funcione
        // por tanto cuando añado una fila borro esa fila en blanco inicial.
        if (modeloDestino.getValueAt(0, 0) == null) {
            modeloDestino.removeRow(0);
        }

        modeloDestino.addRow(nuevaFila);

    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
    }
}
