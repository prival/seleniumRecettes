package recettes.selenium.database;

import org.junit.Assert;

import java.sql.*;
import java.util.Properties;

public class RecettesDb {

    public Connection getConnection() {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "postgres");
        connectionProps.put("password", "redhat");

        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/recettes",
                    connectionProps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Connected to database");
        return conn;
    }


//    public void doRequete() {
//
//        Connection conn = getConnection();
//        try {
//            Statement stmt = conn.createStatement();
//            String strSelect = "select * from categorie";
//
//            ResultSet rset = stmt.executeQuery(strSelect);
//
//            int rowCount = 0;
//            while(rset.next()) {
//                String title = rset.getString("title");
//                double price = rset.getDouble("price");
//                int    qty   = rset.getInt("qty");
//                ++rowCount;
//            }
//
//            stmt.close();
//            conn.close();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public void supprimeToutesCategories() {

        supprimeToutesRecettes();

        Connection conn = getConnection();
        try {
            String requete = "delete from categorie;";

            PreparedStatement stmt = conn.prepareStatement(requete);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void verifieCreationCategorie(String libelle, int ordreExpected) {

        boolean resultExist = false;
        int ordreActual = 0;

        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String strSelect = "select * from categorie where libelle = '" + libelle + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next()) {
                ordreActual = rset.getInt("ordre");
                resultExist = true;
            }

            Assert.assertEquals(true, resultExist);
            Assert.assertEquals(ordreExpected, ordreActual);

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void verifieSuppressionCategorie(String libelle) {

        boolean oldResultatTrouve = false;
        int ordre = 0;

        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String strSelect = "select * from categorie where libelle = '" + libelle + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next()) {
                oldResultatTrouve = true;
            }

            Assert.assertEquals(false, oldResultatTrouve);

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void supprimeToutesRecettes() {

        supprimeTousIngredients();
        supprimeToutesEtapes();

        Connection conn = getConnection();
        try {
            String requete = "delete from recette;";

            PreparedStatement stmt = conn.prepareStatement(requete);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void verifieCreationRecette(String libelle, int ordreExpected) {

        boolean resultExist = false;
        int ordreActual = 0;

        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String strSelect = "select * from recette where libelle = '" + libelle + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()) {
                ordreActual = rset.getInt("ordre");
                resultExist = true;
            }

            Assert.assertEquals(true, resultExist);
            Assert.assertEquals(ordreExpected, ordreActual);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void supprimeTousIngredients() {

        Connection conn = getConnection();
        try {
            String requete = "delete from ingredient;";

            PreparedStatement stmt = conn.prepareStatement(requete);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void verifieCreationIngredient(String libelle, int ordreExpected) {

        boolean resultExist = false;
        int ordreActual = 0;

        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String strSelect = "select * from ingredient where libelle = '" + libelle + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next()) {
                ordreActual = rset.getInt("ordre");
                resultExist = true;
            }

            Assert.assertEquals(true, resultExist);
            Assert.assertEquals(ordreExpected, ordreActual);

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void supprimeToutesEtapes() {

        Connection conn = getConnection();
        try {
            String requete = "delete from etape;";

            PreparedStatement stmt = conn.prepareStatement(requete);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void verifieCreationEtape(String libelle, int ordreExpected) {

        boolean resultExist = false;
        int ordreActual = 0;

        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String strSelect = "select * from etape where libelle = '" + libelle + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset.next()) {
                ordreActual = rset.getInt("ordre");
                resultExist = true;
            }

            Assert.assertEquals(true, resultExist);
            Assert.assertEquals(ordreExpected, ordreActual);

            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
