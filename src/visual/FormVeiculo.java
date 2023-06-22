/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Veiculo;
import modelo.Funcionario;
import modelo.DAOGeral;
import modelo.Produto;

/**
 *
 * @author tulio
 */
public class FormVeiculo extends javax.swing.JDialog {

    /**
     * Creates new form FormCidade
     */
    DAOGeral daoGeral = new DAOGeral();

    public FormVeiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/logohead.png")).getImage());
        initComponents();
        atualizarTabela();
        trataEdicao(false);
        listFuncionario.clear();
        listFuncionario.addAll(daoGeral.getListaFuncionario());
        listProduto.clear();
        listProduto.addAll(daoGeral.getListaProduto()); //Produto
    }

    public void atualizarTabela() {
        listVeiculo.clear();
        listVeiculo.addAll(daoGeral.getListaVeiculo());
        int linha = listFuncionario.size() - 1;
        if (linha >= 0) {
            tblVeiculos.setRowSelectionInterval(linha, linha);
            tblVeiculos.scrollRectToVisible(tblVeiculos.getCellRect(linha, linha, true));
        }
    }

    private void trataEdicao(boolean editando) {
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        int linha = listVeiculo.size() - 1;
        if (linha < 0) {
            btnEditar.setEnabled(editando);
            btnExcluir.setEnabled(false);
            txtCodigo.setText("");
            txtNome.setText("");
            txtCompra.setText("");
            txtAno.setText("");
        } else {
            btnExcluir.setEnabled(!editando);
        }
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        txtNome.setEnabled(editando);
        cbxStatus.setEnabled(editando);
        txtCompra.setEnabled(editando);
        txtAno.setEnabled(editando);
        tblVeiculos.setEnabled(editando);
        cbxProduto.setEnabled(editando);
        txtQuantidade.setEditable(editando);
        cbxStatus.setEditable(editando);
    }

    public boolean validaCampos() {
        if (!(txtNome.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o nome do Veiculo");
            txtNome.requestFocus();
            return false;
        }
        if (!(cbxStatus.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Selecione um motorista para o Veiculo");
            cbxStatus.requestFocus();
            return false;
        }
        if (!(cbxProduto.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para transportar");
            cbxProduto.requestFocus();
            return false;
        }
        if (txtCompra.getText().length() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try{
                sdf.parse(txtCompra.getText());
            }
            catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Informe a data de compra do Veiculo");
            txtCompra.requestFocus();
            return false;
            }
       
        }
        if (!(txtAno.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o salário");
            txtAno.requestFocus();
            return false;
        }

        if ((txtAno.getText().length() > 0)) {
            try{
                Double.parseDouble(txtAno.getText());
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, "Digite apenas números para o ano do Veiculo");
            txtAno.requestFocus();
            return false;
            }
        }
        if (!(txtQuantidade.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade");
            txtQuantidade.requestFocus();
            return false;
        }

        if ((txtQuantidade.getText().length() > 0)) {
            try{
                Double.parseDouble(txtQuantidade.getText());
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, "Digite apenas números para a quantidade de carga de transporte");
            txtQuantidade.requestFocus();
            return false;
            }
        }
        if (!(cbxStatus.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Diga o status do transporte");
            cbxStatus.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listVeiculo = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Veiculo>())
        ;
        listFuncionario = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Funcionario>())
        ;
        converteData = new modelo.ConverteData();
        listProduto = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Produto>()) ;
        painelNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        painelAbas = new javax.swing.JTabbedPane();
        abaListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        abaDados = new javax.swing.JPanel();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        cbxStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskData = null;
        try{
            maskData = new javax.swing.text.MaskFormatter("dd/MM/yyyy");
            maskData.setPlaceholderCharacter('_');
        }catch (Exception e){

        }
        txtCompra = new javax.swing.JFormattedTextField(maskData);
        jLabel5 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxFuncionario1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro dos Veiculos");
        setBackground(new java.awt.Color(0, 51, 255));

        painelNavegacao.setBackground(new java.awt.Color(0, 51, 255));
        painelNavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Navegação"));
        painelNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        btnPrimeiro.setBackground(new java.awt.Color(0, 0, 0));
        btnPrimeiro.setForeground(new java.awt.Color(255, 255, 255));
        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnPrimeiro);

        btnAnterior.setBackground(new java.awt.Color(0, 0, 0));
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnAnterior);

        btnProximo.setBackground(new java.awt.Color(0, 0, 0));
        btnProximo.setForeground(new java.awt.Color(255, 255, 255));
        btnProximo.setText("Próximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnProximo);

        btnUltimo.setBackground(new java.awt.Color(0, 0, 0));
        btnUltimo.setForeground(new java.awt.Color(255, 255, 255));
        btnUltimo.setText("Último");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnUltimo);

        btnFechar.setBackground(new java.awt.Color(0, 0, 0));
        btnFechar.setForeground(new java.awt.Color(255, 255, 255));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnFechar);

        painelAbas.setBackground(new java.awt.Color(0, 51, 255));

        abaListagem.setBackground(new java.awt.Color(0, 51, 255));
        abaListagem.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 255));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listVeiculo, tblVeiculos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ano}"));
        columnBinding.setColumnName("Ano");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${espaco}"));
        columnBinding.setColumnName("Espaco");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${anoFormatado}"));
        columnBinding.setColumnName("Ano Formatado");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblVeiculos);

        abaListagem.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        painelAbas.addTab("Listagem", abaListagem);

        abaDados.setBackground(new java.awt.Color(0, 51, 255));

        painelAcoes.setBackground(new java.awt.Color(0, 51, 255));
        painelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        painelAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnNovo.setBackground(new java.awt.Color(0, 0, 0));
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        painelAcoes.add(btnNovo);

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnEditar);

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnCancelar);

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnSalvar);

        btnExcluir.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painelAcoes.add(btnExcluir);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Motorista:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigo}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.objFuncionairo}"), cbxStatus, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ano de compra:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.compra}"), txtCompra, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setConverter(converteData);
        bindingGroup.addBinding(binding);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ano do modelo:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ano}"), txtAno, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listProduto, cbxProduto);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.objProduto}"), cbxProduto, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Produto:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblVeiculos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantidade}"), txtQuantidade, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantidade:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status:");

        javax.swing.GroupLayout abaDadosLayout = new javax.swing.GroupLayout(abaDados);
        abaDados.setLayout(abaDadosLayout);
        abaDadosLayout.setHorizontalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(cbxFuncionario1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAno))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosLayout.createSequentialGroup()
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxProduto, javax.swing.GroupLayout.Alignment.TRAILING, 0, 249, Short.MAX_VALUE)
                            .addComponent(cbxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        abaDadosLayout.setVerticalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        painelAbas.addTab("Dados", abaDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelAbas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // TODO add your handling code here:
        int linha = tblVeiculos.getSelectedRow();
        if ((linha + 1) <= (tblVeiculos.getRowCount() - 1)) {
            linha++;
        }
        tblVeiculos.setRowSelectionInterval(linha, linha);
        tblVeiculos.scrollRectToVisible(tblVeiculos.getCellRect(linha, 0, true));

    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        listVeiculo.add((Veiculo) new Veiculo());
        int linha = listVeiculo.size() - 1;
        tblVeiculos.setRowSelectionInterval(linha, linha);
        txtNome.requestFocus();
        trataEdicao(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (validaCampos()) {
            int linhaSelecionada = tblVeiculos.getSelectedRow();
            Veiculo objVeiculo = listVeiculo.get(linhaSelecionada);
            daoGeral.salvarVeiculo(objVeiculo);
            atualizarTabela();
            trataEdicao(false);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        txtNome.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        trataEdicao(false);
        atualizarTabela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão",
                "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Sim", "Não"}, "Sim");

        if (opcao == 0) {
            int linhaSelecionada = tblVeiculos.getSelectedRow();
            Veiculo objVeiculo = listVeiculo.get(linhaSelecionada);
            daoGeral.removerVeiculo(objVeiculo);
            atualizarTabela();
            trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // TODO add your handling code here:
        tblVeiculos.setRowSelectionInterval(0, 0);
        tblVeiculos.scrollRectToVisible(tblVeiculos.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        int linha = tblVeiculos.getSelectedRow();
        if ((linha - 1) >= 0) {
            linha--;
        }
        tblVeiculos.setRowSelectionInterval(linha, linha);
        tblVeiculos.scrollRectToVisible(tblVeiculos.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        int linha = tblVeiculos.getRowCount() - 1;
        tblVeiculos.setRowSelectionInterval(linha, linha);
        tblVeiculos.scrollRectToVisible(tblVeiculos.getCellRect(linha, 0, true));

    }//GEN-LAST:event_btnUltimoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormVeiculo dialog = new FormVeiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaDados;
    private javax.swing.JPanel abaListagem;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbxFuncionario1;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JComboBox<String> cbxStatus;
    private modelo.ConverteData converteData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Funcionario> listFuncionario;
    private java.util.List<Produto> listProduto;
    private java.util.List<Veiculo> listVeiculo;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelNavegacao;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCompra;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
