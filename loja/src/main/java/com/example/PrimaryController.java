package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.example.model.Usuario;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class PrimaryController implements Initializable{
    @FXML private TextField textetFieldNome;
    @FXML private TextField textetFieldemail;
    @FXML private PasswordField passwordField;
    @FXML private ChoiceBox<String> choiceBosxPerfil;

    String servidor = "oracle.fiap.com.br";
    //String baseDeDados = "";//
    String username = "RM93169";
    String senha = "120904";
    String url = "jdbc:oracle:thin:@" + servidor +":1521:orcl";

    public void salvar(){
        var usuario = carregarDadosDoFormulario();
        
        System.out.println(usuario);

        try {
            var conexao = conectar();
            conexao.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    private Connection conectar() {
        try{
            System.out.println("tentando conectar");
                Connection conexao = DriverManager.getConnection(url, username, senha);
            return conexao;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Object carregarDadosDoFormulario() {
            return new Usuario(
            textetFieldNome.getText(),
            textetFieldemail.getText(), 
            passwordField.getText(), 
            choiceBosxPerfil.getValue()
            
        );
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBosxPerfil.getItems().addAll("Vendedor","Gerente","Administrador");
        
    }
}
