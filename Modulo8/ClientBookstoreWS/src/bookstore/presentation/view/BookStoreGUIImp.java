package bookstore.presentation.view;

import java.util.List;
import javax.swing.JOptionPane;
import bookstore.presentation.controller.Controller;
import bookstore.presentation.controller.events.BusinessEvent;
import bookstore.presentation.controller.events.GUIEvent;
import bookstore.presentation.view.location.LocationManager;
import bookstore.presentation.view.location.message.MessageCode;
import ws.dto.bean.book.IBookBean;
import ws.dto.factory.DTOFactory;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BookStoreGUIImp extends BookStoreGUI {

    /**
     * Creates new form BookStoreGUI
     */
    
    private int Language = LocationManager.Language.ENGLISH;
    
    /**
     *
     */
    public BookStoreGUIImp() {    
        initComponents();
    }
    
    private void showMessageDialog(int messageCode, int titleCode, int language){
        String Message = LocationManager.getInstance().getMessage(messageCode, language);
        String Title = LocationManager.getInstance().getMessage(titleCode, language);
        JOptionPane.showMessageDialog(null, Message , Title,JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BooksTable = new javax.swing.JTable();
        BookPanel = new javax.swing.JPanel();
        TitleTextField = new javax.swing.JTextField();
        TitleLabel = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        AuthorTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescriptionTextArea = new javax.swing.JTextArea();
        EditorialTextField = new javax.swing.JTextField();
        EditorialLabel = new javax.swing.JLabel();
        PublicationYearLabel = new javax.swing.JLabel();
        PublicationYearTextField = new javax.swing.JTextField();
        ISBNTextField = new javax.swing.JTextField();
        ISBNLabel = new javax.swing.JLabel();
        PriceTextField = new javax.swing.JTextField();
        DescriptionLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        ModifyButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Title", "ISBN", "Price"
            }));
            BooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    BooksTableMouseReleased(evt);
                }
            });
            BooksTable.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    BooksTableKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    BooksTableKeyReleased(evt);
                }
            });
            jScrollPane1.setViewportView(BooksTable);

            BookPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Book info"));

            TitleLabel.setText("Title");

            AuthorLabel.setText("Author");

            DescriptionTextArea.setColumns(20);
            DescriptionTextArea.setLineWrap(true);
            DescriptionTextArea.setRows(5);
            DescriptionTextArea.setWrapStyleWord(true);
            jScrollPane2.setViewportView(DescriptionTextArea);

            EditorialLabel.setText("Editorial");

            PublicationYearLabel.setText("Publication Year");

            ISBNLabel.setText("ISBN");

            DescriptionLabel.setText("Description");

            PriceLabel.setText("Price");

            DeleteButton.setText("Delete");
            DeleteButton.setEnabled(false);
            DeleteButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeleteButtonActionPerformed(evt);
                }
            });

            ModifyButton.setText("Modify");
            ModifyButton.setEnabled(false);
            ModifyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ModifyButtonActionPerformed(evt);
                }
            });

            AddButton.setText("Add");
            AddButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout BookPanelLayout = new javax.swing.GroupLayout(BookPanel);
            BookPanel.setLayout(BookPanelLayout);
            BookPanelLayout.setHorizontalGroup(
                BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BookPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookPanelLayout.createSequentialGroup()
                            .addComponent(DescriptionLabel)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(BookPanelLayout.createSequentialGroup()
                            .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EditorialLabel)
                                .addComponent(TitleLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(BookPanelLayout.createSequentialGroup()
                                    .addComponent(TitleTextField)
                                    .addGap(64, 64, 64)
                                    .addComponent(AuthorLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(AuthorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(BookPanelLayout.createSequentialGroup()
                                    .addComponent(EditorialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ISBNLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                    .addComponent(ISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PublicationYearLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(PublicationYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PriceLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton)
                    .addGap(45, 45, 45)
                    .addComponent(ModifyButton)
                    .addGap(49, 49, 49)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(181, 181, 181))
            );
            BookPanelLayout.setVerticalGroup(
                BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BookPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TitleLabel)
                        .addComponent(AuthorLabel)
                        .addComponent(AuthorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditorialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditorialLabel)
                        .addComponent(ISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ISBNLabel)
                        .addComponent(PublicationYearLabel)
                        .addComponent(PublicationYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceLabel)
                        .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(DescriptionLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ModifyButton)
                        .addComponent(DeleteButton)
                        .addComponent(AddButton))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(BookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String isbn = (String)this.BooksTable.getValueAt(this.BooksTable.getSelectedRow(), 1);
        Controller.getInstance().action(BusinessEvent.DELETE_BOOK_ISBN, isbn);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        IBookBean Book = DTOFactory.getInstance().getBookBean();
        try{
            Book.setTitle(this.TitleTextField.getText());
            Book.setAuthor(this.AuthorTextField.getText());
            Book.setEditorial(this.EditorialTextField.getText());
            Book.setISBN(this.ISBNTextField.getText());
            Book.setPublicationYear(Integer.parseInt(this.PublicationYearTextField.getText()));
            Book.setPrice(Double.parseDouble(this.PriceTextField.getText()));
            Book.setDescription(this.DescriptionTextArea.getText());
            Controller.getInstance().action(BusinessEvent.ADD_BOOK, Book);
        }catch(NumberFormatException ex){
            showMessageDialog(MessageCode.INVALID_DATA, MessageCode.ERROR, this.Language);
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void BooksTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BooksTableKeyReleased
        String isbn = (String)this.BooksTable.getValueAt(this.BooksTable.getSelectedRow(), 1);
        Controller.getInstance().action(BusinessEvent.GET_BOOK_ISBN, isbn);
    }//GEN-LAST:event_BooksTableKeyReleased

    private void BooksTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BooksTableKeyPressed
        String isbn = (String)this.BooksTable.getValueAt(this.BooksTable.getSelectedRow(), 1);
        Controller.getInstance().action(BusinessEvent.GET_BOOK_ISBN, isbn);
    }//GEN-LAST:event_BooksTableKeyPressed

    private void BooksTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BooksTableMouseReleased
        String isbn = (String)this.BooksTable.getValueAt(this.BooksTable.getSelectedRow(), 1);
        Controller.getInstance().action(BusinessEvent.GET_BOOK_ISBN, isbn);
    }//GEN-LAST:event_BooksTableMouseReleased

    private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyButtonActionPerformed
        IBookBean Book = DTOFactory.getInstance().getBookBean();
        try{
            Book.setTitle(this.TitleTextField.getText());
            Book.setAuthor(this.AuthorTextField.getText());
            Book.setEditorial(this.EditorialTextField.getText());
            Book.setISBN(this.ISBNTextField.getText());
            Book.setPublicationYear(Integer.parseInt(this.PublicationYearTextField.getText()));
            Book.setPrice(Double.parseDouble(this.PriceTextField.getText()));
            Book.setDescription(this.DescriptionTextArea.getText());
            Controller.getInstance().action(BusinessEvent.MODIFY_BOOK, Book);
        }catch(NumberFormatException ex){
            showMessageDialog(MessageCode.INVALID_DATA, MessageCode.ERROR, this.Language);
        }
    }//GEN-LAST:event_ModifyButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JTextField AuthorTextField;
    private javax.swing.JPanel BookPanel;
    private javax.swing.JTable BooksTable;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextArea DescriptionTextArea;
    private javax.swing.JLabel EditorialLabel;
    private javax.swing.JTextField EditorialTextField;
    private javax.swing.JLabel ISBNLabel;
    private javax.swing.JTextField ISBNTextField;
    private javax.swing.JButton ModifyButton;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JLabel PublicationYearLabel;
    private javax.swing.JTextField PublicationYearTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param Event
     * @param data
     */
    @Override
    public void update(int Event, Object data) {
        switch(Event){
            case GUIEvent.SEARCH_ALL_BOOKS:
                Controller.getInstance().action(BusinessEvent.GET_ALL_BOOKS, null);
                break;
            case GUIEvent.REFRESH_ALL_BOOKS:
                refreshAllBooks((List<IBookBean>)data);
                break;
            case GUIEvent.REFRESH_BOOK:
                refreshBook((IBookBean)data);
                break;
            case GUIEvent.BOOK_DELETED:
                refreshAllBooks((List<IBookBean>)data);
                showMessageDialog(MessageCode.BOOK_DELETED, MessageCode.OK, this.Language);
                break;
            case GUIEvent.BOOK_ADDED:
                refreshAllBooks((List<IBookBean>)data);
                showMessageDialog(MessageCode.BOOK_ADDED, MessageCode.OK, this.Language);
                break;
            case GUIEvent.ERROR_DELETING_BOOK:
                showMessageDialog(MessageCode.ERROR_DELETING_BOOK, MessageCode.ERROR, this.Language);
                break;
            case GUIEvent.ERROR_ADDING_BOOK:
                showMessageDialog(MessageCode.ERROR_ADDING_BOOK, MessageCode.ERROR, this.Language);
                break;
            case GUIEvent.BOOK_MODIFIED:
                refreshAllBooks((List<IBookBean>)data);
                showMessageDialog(MessageCode.BOOK_MODIFIED, MessageCode.OK, this.Language);
                break;
            case GUIEvent.ERROR_MODIFYING_BOOK:
                showMessageDialog(MessageCode.ERROR_MODIFYING_BOOK, MessageCode.ERROR, this.Language);
                break;
            default:
                break;
        }
        
    }
    
    private void refreshBook(IBookBean book){
        if(book == null){
            this.TitleTextField.setText("");
            this.AuthorTextField.setText("");
            this.EditorialTextField.setText("");
            this.PublicationYearTextField.setText("");
            this.ISBNTextField.setText("");
            this.PriceTextField.setText("");
            this.DescriptionTextArea.setText("");
            this.DeleteButton.setEnabled(false);
            this.ModifyButton.setEnabled(false);
        }else{
            this.TitleTextField.setText(book.getTitle());
            this.AuthorTextField.setText(book.getAuthor());
            this.EditorialTextField.setText(book.getEditorial());
            this.PublicationYearTextField.setText(String.valueOf(book.getPublicationYear()));
            this.ISBNTextField.setText(book.getISBN());
            this.PriceTextField.setText(String.valueOf(book.getPrice()));
            this.DescriptionTextArea.setText(book.getDescription());
            this.DeleteButton.setEnabled(true);
            this.ModifyButton.setEnabled(true);
        }
    }
        
    private void refreshAllBooks(List<IBookBean> list){
        refreshBook(null);
        
        int columCount = this.BooksTable.getColumnCount();
        int rowCount = list.size();
        
        //Titles
        String [] titles = new String[columCount];
        for(int i = 0; i < columCount; i++){
            titles[i] = this.BooksTable.getColumnName(i);
        }
        
        //Rows
        Object [][] rows = new Object[rowCount][];
        for(int i = 0; i < rowCount; i++){
            rows[i] = new Object [] {list.get(i).getTitle(),
                                    list.get(i).getISBN(),
                                    list.get(i).getPrice()};
        }
        
        this.BooksTable.setModel(new MyTableModel(
            rows,
            titles
        ));
    }
    
    private class MyTableModel extends javax.swing.table.DefaultTableModel{
        public MyTableModel(Object [][] rows, String [] titles){
            super(rows, titles);
        }
        
        @Override
        public boolean isCellEditable (int row, int column)
        {
            return false;
        }
    }
}
