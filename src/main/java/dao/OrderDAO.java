package dao;

import bll.validators.StockCheckValidator;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import model.Order;
import model.Product;
import presentation.CreateOrders;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.*;

/**
 * Through this class we will perform CRUD operations on new orders using a superclass
 * @see AbstractDAO
 *
 *
 * @author Szekely Maria-Robertha
 */

public class OrderDAO extends AbstractDAO<Order> {

    private Connection connection;
    private PreparedStatement statement;
    private CreateOrders createOrdersFrame;
    private int number = 1;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    public void makeOrder() {
        createOrdersFrame = new CreateOrders(connection);

        createOrdersFrame.getCb().addActionListener(ee -> {

            createOrdersFrame.getPb().addActionListener(eee -> {

                createOrdersFrame.getOk().addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        if (createOrdersFrame.getOk().isEnabled()) {

                            int q = (Integer) createOrdersFrame.getSpinner().getValue();

                            if (q == 0) {
                                JOptionPane.showMessageDialog(null, "Enter the quantity");
                            } else {
                                String c = String.valueOf(createOrdersFrame.getCb().getSelectedItem());
                                String[] cc = c.split(" ");
                                int idc = Integer.parseInt(cc[0]);

                                String p = String.valueOf(createOrdersFrame.getPb().getSelectedItem());
                                String[] pp = p.split(" ");
                                int idp = Integer.parseInt(pp[0]);

                                StringBuilder sql = new StringBuilder("SELECT stock, price FROM orderdb.Product WHERE id = ?");
                                double price = -1;
                                int stock = -1;

                                try {
                                    statement = connection.prepareStatement(sql.toString());
                                    statement.setString(1, pp[0]);
                                    ResultSet rs = statement.executeQuery();

                                    while (rs.next()) {
                                        stock = rs.getInt("stock");
                                        price = rs.getDouble("price");
                                    }
                                } catch (SQLException s) {
                                    s.printStackTrace();
                                }

                                StockCheckValidator stockCheckValidator = new StockCheckValidator();
                                if (stockCheckValidator.validate(idp, q)) {
                                    Order newOrder = new Order(0, idc, cc[1], idp, pp[1], q, q * price);
                                    insert(newOrder);
                                    int newStock = stock - q;
                                    update(new Product(0, null, 0, 0), idp, "stock", String.valueOf(newStock));
                                    pdf();
                                    createOrdersFrame.getOk().setEnabled(false);
                                } else {
                                    if (stock > 0 && stock < q) {
                                        JOptionPane.showMessageDialog(null, "We only have " + stock + " products left");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "UNDER STOCK");
                                    }
                                }
                                createOrdersFrame.dispose();
                            }
                        }
                    }
                });
            });
        });
    }


    /**
     * Also, this is the method that creates the bills for every order
     * @param namePDF represents the name of the pdf that the bill should have
     * @throws FileNotFoundException if the file with the specified pathname does not exist, or the file is inaccessible
     * @throws MalformedURLException if no legal protocol could be found in a specification string or the string could not be parsed
     */

    public void getPDF(String namePDF) throws FileNotFoundException, MalformedURLException {

        String dest = "C:/ROBE/programe/Git/projects/AN II/SEM II/PT2022_30223_Szekely_Maria_Assigment_03/PT2022_30223_Szekely_Maria_Assigment_03/" + namePDF;
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);
        String imFile = "C:/ROBE/programe/Git/projects/AN II/SEM II/PT2022_30223_Szekely_Maria_Assigment_03/PT2022_30223_Szekely_Maria_Assigment_03/image.jpg";
        ImageData data = ImageDataFactory.create(imFile);
        Image image = new Image(data);
        image.setFixedPosition(75, 500);
        document.add(image);

        String para = "Order details:";
        Paragraph paragraph = new Paragraph(para);
        paragraph.setFixedPosition(75, 450, 200);

        float [] pointColumnWidths = {150F, 150F, 150F, 150F, 150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);
        table.setFixedPosition(75, 400, 450);
        table.addCell(new Cell().add("ORDER ID"));
        table.addCell(new Cell().add("CLIENT ID"));
        table.addCell(new Cell().add("CLIENT NAME"));
        table.addCell(new Cell().add("PRODUCT ID"));
        table.addCell(new Cell().add("PRODUCT NAME"));
        table.addCell(new Cell().add("QUANTITY"));
        table.addCell(new Cell().add("PRICE"));

        ResultSet rs;
        try {
            this.statement = connection.prepareStatement("SELECT * FROM orderdb.orderr ORDER BY id DESC LIMIT 1;");
            rs = statement.executeQuery();
            while (rs.next()) {

                table.addCell(new Cell().add(String.valueOf(rs.getInt("id"))));
                table.addCell(new Cell().add(String.valueOf(rs.getInt("clientid"))));
                table.addCell(new Cell().add(rs.getString("clientname")));
                table.addCell(new Cell().add(String.valueOf(rs.getInt("productid"))));
                table.addCell(new Cell().add(rs.getString("productname")));
                table.addCell(new Cell().add(String.valueOf(rs.getInt("quantity"))));
                table.addCell(new Cell().add(String.valueOf(rs.getDouble("price"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        document.add(table);
        document.close();
    }

    /**
     * This is the method that gives the name of the pdf to method called getPDF
     * The name represents the order id
     */

    public void pdf(){

        ResultSet rs;
        String id = null;
        try {
            this.statement = connection.prepareStatement("SELECT id FROM orderdb.orderr ORDER BY id DESC LIMIT 1;");
            rs = statement.executeQuery();
            while (rs.next()) {

                id = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            getPDF( "Order_" + id +".pdf");

        } catch (FileNotFoundException | MalformedURLException exception) {
            exception.printStackTrace();
        }
    }
}
