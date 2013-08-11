/*
 * WizardSelectIndicatorJPanel.java
 *
 * Created on June 17, 2007, 12:53 AM
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * Copyright (C) 2007 Cheok YanCheng <yccheok@yahoo.com>
 */

package org.yccheok.jstock.gui;

import java.text.MessageFormat;
import javax.swing.*;
import org.yccheok.jstock.analysis.*;
import org.yccheok.jstock.internationalization.GUIBundle;

/**
 *
 * @author  yccheok
 */
public class WizardSelectIndicatorJPanel extends javax.swing.JPanel {
    
    /** Creates new form WizardSelectIndicatorJPanel */
    public WizardSelectIndicatorJPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout(5, 5));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui"); // NOI18N
        jXHeader1.setDescription(bundle.getString("Main_WizardSelectIndicatorJPanel_Description")); // NOI18N
        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/64x64/viewmag.png"))); // NOI18N
        jXHeader1.setTitle(bundle.getString("Main_WizardSelectIndicatorJPanel_SelectStockIndicators")); // NOI18N
        add(jXHeader1, java.awt.BorderLayout.NORTH);

        jList1.setModel(new javax.swing.DefaultListModel());
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText(bundle.getString("Main_WizardSelectIndicatorJPanel_NoIndicatorBeingSelected")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        final int numOfSelectedItems = getSelectedProjects().size();
        
        if(numOfSelectedItems == 0) {
            jLabel1.setForeground(java.awt.Color.RED);
            jLabel1.setText(java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui").getString("Main_WizardSelectIndicatorJPanel_NoIndicatorBeingSelected"));
        }
        else {
            jLabel1.setForeground(java.awt.Color.BLUE);
            final String template = GUIBundle.getString("Main_WizardSelectIndicatorJPanel_Indicator(s)BeingSelected_template");
            final String message = MessageFormat.format(template, numOfSelectedItems);
            jLabel1.setText(message);
        }
    }//GEN-LAST:event_jList1ValueChanged
    
    public void addListSelectionListener(javax.swing.event.ListSelectionListener listener) {
        jList1.addListSelectionListener(listener);
    }
    
    public java.util.List<String> getSelectedProjects() {
        final javax.swing.ListModel listModel = jList1.getModel();
        final javax.swing.DefaultListModel defaultListModel = (javax.swing.DefaultListModel)listModel;
        
        Object[] selected = this.jList1.getSelectedValues();
        
        java.util.List<String> list = new java.util.ArrayList<String>();
        
        for(Object o : selected) {
            list.add(o.toString());
        }
        
        return list;
    }
    
    public void updateAlertIndicatorProjectManager() {
        /* We only update the indicator project manager once. */
        if (this.alertIndicatorProjectManager != null)
            return;
        
        final MainFrame m = MainFrame.getInstance();
        
        this.alertIndicatorProjectManager = m.getAlertIndicatorProjectManager();
        
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                final javax.swing.ListModel listModel = jList1.getModel();
                final javax.swing.DefaultListModel defaultListModel = (javax.swing.DefaultListModel)listModel;
                defaultListModel.removeAllElements();
                
                final int numOfProject = alertIndicatorProjectManager.getNumOfProject();
                for(int i = 0; i < numOfProject; i++) {
                    final String project = alertIndicatorProjectManager.getProject(i);
                    
                    final OperatorIndicator operatorIndicator = alertIndicatorProjectManager.getOperatorIndicator(project);
                    
                    // We only accept alert typed indicator.
                    if (operatorIndicator != null) {
                        if (operatorIndicator.getType() == OperatorIndicator.Type.AlertIndicator)
                            defaultListModel.addElement(project);
                    }
                }
           } 
        });        
    }
    
    private IndicatorProjectManager alertIndicatorProjectManager;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    // End of variables declaration//GEN-END:variables
    
}
