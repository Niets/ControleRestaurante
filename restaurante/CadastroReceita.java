package restaurante;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CadastroReceita extends javax.swing.JFrame {

    private ControleReceita controleReceita;
    private Receita umaReceita;
    private boolean modoAlteracao;
    private boolean novoRegistro;
    private DefaultListModel ingredienteListModel;
    private DefaultListModel alergiaListModel;

    public CadastroReceita() {
        initComponents();
        this.habilitarDesabilitarCampos();
        this.controleReceita = new ControleReceita();
        this.ingredienteListModel = new DefaultListModel();
        this.alergiaListModel = new DefaultListModel();
        this.jListAlergia.setModel(alergiaListModel);
        this.jListIngredientes.setModel(ingredienteListModel);
        this.jTableListaReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void limparCampos() {
        jTextFieldNumPessoas.setText(null);
        jTextFieldNome.setText(null);
        ingredienteListModel.clear();
    }

    private void preencherCampos() {
        ArrayList<Ingrediente> ingredientes;
        ArrayList<String> alergias;

        jTextFieldNome.setText(umaReceita.getNome());
        jTextFieldNumPessoas.setText(Integer.toString(umaReceita.getNumeroPessoas()));

        ingredienteListModel.clear();
        ingredientes = umaReceita.getIngredientes();
        if(ingredientes != null){    
            for (Ingrediente p : ingredientes) {
                ingredienteListModel.addElement(p);
            }
        }

        alergiaListModel.clear();
        alergias = umaReceita.getAlergias();
        if(alergias != null){    
            for (String p : alergias) {
                alergiaListModel.addElement(p);
            }
        }
        
    }

    private boolean validarCampos() {
        if (jTextFieldNome.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            jTextFieldNome.requestFocus();
            return false;
        }

        return true;
    }

    private void habilitarDesabilitarCampos() {
        boolean registroSelecionado = (umaReceita != null);
        jTextFieldNumPessoas.setEnabled(modoAlteracao);
        jTextFieldNome.setEnabled(modoAlteracao);
        jButtonNovo.setEnabled(modoAlteracao == false);
        jButtonAlterar.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonExcluir.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonPesquisar.setEnabled(modoAlteracao == false);
        jButtonSalvar.setEnabled(modoAlteracao);
        jButtonCancelar.setEnabled(modoAlteracao);
        jButtonAdicionarIngrediente.setEnabled(modoAlteracao);
        jButtonRemoverIngrediente.setEnabled(modoAlteracao);
        jButtonAdicionarAlergia.setEnabled(modoAlteracao);
        jButtonRemoverAlergia.setEnabled(modoAlteracao);
        jTableListaReceitas.setEnabled(modoAlteracao == false);
                
    }

    private void salvarRegistro() {
        ArrayList<Ingrediente> ingredientes;
        ArrayList<String> alergias;

        if (this.validarCampos() == false) {
            return;
        }

        ingredientes = new ArrayList<Ingrediente>();
        for (int i = 0; i < ingredienteListModel.size(); i++) {
            Ingrediente ingrediente = (Ingrediente) ingredienteListModel.getElementAt(i);
            ingredientes.add(ingrediente);
        }

        alergias = new ArrayList<String>();
        for (int i = 0; i < alergiaListModel.size(); i++) {
            alergias.add(alergiaListModel.getElementAt(i).toString());
        }

        if (novoRegistro == true) {
            umaReceita = new Receita(jTextFieldNome.getText());
        } else {
            umaReceita.setNome(jTextFieldNome.getText());
        }
        umaReceita.setIngredientes(ingredientes);
        umaReceita.setAlergias(alergias);
        umaReceita.setNumeroPessoas(Integer.parseInt(jTextFieldNumPessoas.getText()));

        if (novoRegistro == true) {
            controleReceita.adicionar(umaReceita);
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.carregarListaReceitas();
        this.habilitarDesabilitarCampos();
    }
    
        private void exibirInformacao(String info) {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    private void carregarListaReceitas() {
        ArrayList<Receita> listaReceitas = controleReceita.getListaReceitas();
        DefaultTableModel model = (DefaultTableModel) jTableListaReceitas.getModel();
        model.setRowCount(0);
        for (Receita b : listaReceitas) {
            model.addRow(new String[]{b.getNome(), Integer.toString(b.getNumeroPessoas())});
        }
        jTableListaReceitas.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelNumPessoas = new javax.swing.JLabel();
        jButtonAdicionarIngrediente = new javax.swing.JButton();
        jButtonRemoverIngrediente = new javax.swing.JButton();
        jTextFieldNumPessoas = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListIngredientes = new javax.swing.JList();
        jLabelIngredientes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelAlergias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAlergia = new javax.swing.JList();
        jButtonAdicionarAlergia = new javax.swing.JButton();
        jButtonRemoverAlergia = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelListaReceitas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableListaReceitas = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        jLabelNumPessoas.setText("Número Pessoas:");

        jButtonAdicionarIngrediente.setText("+");
        jButtonAdicionarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarIngredienteActionPerformed(evt);
            }
        });

        jButtonRemoverIngrediente.setText("-");
        jButtonRemoverIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverIngredienteActionPerformed(evt);
            }
        });

        jTextFieldNumPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumPessoasActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jListIngredientes);

        jLabelIngredientes.setText("Ingredientes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNumPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                    .addComponent(jLabelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRemoverIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumPessoas)
                    .addComponent(jTextFieldNumPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarIngrediente)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRemoverIngrediente))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIngredientes))
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Informações Gerais", jPanel1);

        jLabelAlergias.setText("Alergias:");

        jScrollPane2.setViewportView(jListAlergia);

        jButtonAdicionarAlergia.setText("+");
        jButtonAdicionarAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarAlergiaActionPerformed(evt);
            }
        });

        jButtonRemoverAlergia.setText("-");
        jButtonRemoverAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverAlergiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAdicionarAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRemoverAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelAlergias))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAlergias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarAlergia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoverAlergia))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alergias", jPanel3);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar...");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabelListaReceitas.setText("Lista de Receitas:");

        jTableListaReceitas.setModel(new javax.swing.table.DefaultTableModel 
            (
                null,
                new String [] {
                    "Nome", "CPF"
                }
            )
            {
                @Override    
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jTableListaReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableListaReceitasMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(jTableListaReceitas);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelListaReceitas)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonAlterar)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonPesquisar)
                            .addGap(222, 222, 222)
                            .addComponent(jButtonSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addContainerGap(29, Short.MAX_VALUE))
            );

            layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAlterar, jButtonCancelar, jButtonExcluir, jButtonNovo, jButtonPesquisar, jButtonSalvar});

            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovo)
                        .addComponent(jButtonAlterar)
                        .addComponent(jButtonExcluir)
                        .addComponent(jButtonPesquisar)
                        .addComponent(jButtonSalvar)
                        .addComponent(jButtonCancelar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelListaReceitas)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        umaReceita = null;
        modoAlteracao = true;
        novoRegistro = true;
        this.limparCampos();
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        this.salvarRegistro();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (novoRegistro == true) {
            this.limparCampos();
        } else {
            this.preencherCampos();
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    
    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        modoAlteracao = true;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        this.controleReceita.remover(umaReceita);
        umaReceita = null;
        this.limparCampos();
        this.carregarListaReceitas();
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
    String pesquisa = JOptionPane.showInputDialog("Informe o nome da Receita.");
    if (pesquisa != null) {
        this.pesquisarReceita(pesquisa);
    }
}//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void pesquisarReceita(String nome) {
        Receita receitaPesquisada = controleReceita.pesquisar(nome);

        if (receitaPesquisada == null) {
            exibirInformacao("Receita não encontrada.");
        } else {
            this.umaReceita = receitaPesquisada;
            this.preencherCampos();
            this.habilitarDesabilitarCampos();
        }
    }

private void jTableListaReceitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaReceitasMouseClicked
    if (jTableListaReceitas.isEnabled()) {
        DefaultTableModel model = (DefaultTableModel) jTableListaReceitas.getModel();
        String nome = (String) model.getValueAt(jTableListaReceitas.getSelectedRow(), 0);
        this.pesquisarReceita(nome);
    }
}//GEN-LAST:event_jTableListaReceitasMouseClicked

    private void jButtonRemoverAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverAlergiaActionPerformed
        if (jListAlergia.getSelectedIndex() != -1) {
            alergiaListModel.removeElementAt(jListAlergia.getSelectedIndex());
        }
    }//GEN-LAST:event_jButtonRemoverAlergiaActionPerformed

    private void jButtonAdicionarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAlergiaActionPerformed
        CadastroAlergia cadastro = new CadastroAlergia(this, true);
        cadastro.setVisible(true);
        if (cadastro.getAlergia() != null) {
            alergiaListModel.addElement(cadastro.getAlergia());
        }
        cadastro.dispose();
    }//GEN-LAST:event_jButtonAdicionarAlergiaActionPerformed

    private void jTextFieldNumPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumPessoasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumPessoasActionPerformed

    private void jButtonRemoverIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverIngredienteActionPerformed
        if (jListIngredientes.getSelectedIndex() != -1) {
            ingredienteListModel.removeElementAt(jListIngredientes.getSelectedIndex());
        }
    }//GEN-LAST:event_jButtonRemoverIngredienteActionPerformed

    private void jButtonAdicionarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarIngredienteActionPerformed
        CadastroIngrediente cadastro = new CadastroIngrediente(this, true);
        cadastro.setVisible(true);
        if (cadastro.getIngrediente() != null) {
            ingredienteListModel.addElement(cadastro.getIngrediente());
        }
        cadastro.dispose();
    }//GEN-LAST:event_jButtonAdicionarIngredienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAlergia;
    private javax.swing.JButton jButtonAdicionarIngrediente;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemoverAlergia;
    private javax.swing.JButton jButtonRemoverIngrediente;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelAlergias;
    private javax.swing.JLabel jLabelIngredientes;
    private javax.swing.JLabel jLabelListaReceitas;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumPessoas;
    private javax.swing.JList jListAlergia;
    private javax.swing.JList jListIngredientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableListaReceitas;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumPessoas;
    // End of variables declaration//GEN-END:variables
}
