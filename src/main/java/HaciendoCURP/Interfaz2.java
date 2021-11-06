/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HaciendoCURP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Chilam Guzman
 */
public class Interfaz2 extends JFrame implements ActionListener {
    
    /********************************
    *                               *
    * Componentes de la Interfaz    *
    *                               *
    ********************************/
    private Container contenedor;
    private JLabel title;
    private JLabel nombre;
    private JTextField txt_nombre;
    private JLabel cp;
    private JTextField txt_cp;
    private JLabel colonia;
    private JComboBox combo_colonia;
    public String[] lista_colonias = {};
    private JButton btn_cp;
    private JLabel salario;
    private JTextField txt_salario;
    private JLabel vivienda;
    private JComboBox combo_vivienda;
    private String[] lista_vivienda = {"Rentada", "Prestada", "Propia"};
    private JLabel gastos;
    private JTextField txt_gastos;
    private JLabel remanente;
    private JTextField txt_remanente;
    private JButton aceptar;
    public String hostWS = "http://localhost/";
    public String pathWS = "moo/ws.php?cp=";
    
    /********************************
    *                               *
    * Constructor de la Interfaz    *
    *                               *
    ********************************/
    public Interfaz2(){
        setTitle("Generación de CURP");
        setBounds(310, 100, 600, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        title = new JLabel("Registros Básicos");
        title.setFont(new Font("Arial", Font.PLAIN, 22));
        title.setSize(300, 30);
        title.setLocation(210, 40);
        contenedor.add(title);
        
        // Nombre, label y textfield
        nombre = new JLabel("Nombre Completo");
        nombre.setFont(new Font("Arial", Font.PLAIN, 15));
        nombre.setSize(150, 20);
        nombre.setLocation(70, 100);
        contenedor.add(nombre);
        txt_nombre = new JTextField();
        txt_nombre.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_nombre.setEditable(false);
        txt_nombre.setSize(300, 20);
        txt_nombre.setLocation(200, 100);
        contenedor.add(txt_nombre);
        
        // codigo postal, label y textfield
        cp = new JLabel("Código Postal");
        cp.setFont(new Font("Arial", Font.PLAIN, 15));
        cp.setSize(150, 20);
        cp.setLocation(70, 150);
        contenedor.add(cp);
        txt_cp = new JTextField();
        txt_cp.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_cp.setSize(100, 20);
        txt_cp.setLocation(200, 150);
        contenedor.add(txt_cp);
        btn_cp = new JButton("Validar");
        btn_cp.setFont(new Font("Arial", Font.PLAIN, 15));
        btn_cp.setSize(100, 20);
        btn_cp.setLocation(310, 150);
        btn_cp.addActionListener(this);
        contenedor.add(btn_cp);
        
        // Colonia, label y textfield
        colonia = new JLabel("Colonia");
        colonia.setFont(new Font("Arial", Font.PLAIN, 15));
        colonia.setSize(150, 20);
        colonia.setLocation(70, 200);
        contenedor.add(colonia);
        combo_colonia = new JComboBox();
        combo_colonia.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_colonia.setEditable(false);
        combo_colonia.setSize(300, 20);
        combo_colonia.setLocation(200, 200);
        contenedor.add(combo_colonia);
        
        // Salario, label y textfield
        salario = new JLabel("Salario Mensual");
        salario.setFont(new Font("Arial", Font.PLAIN, 15));
        salario.setSize(150, 20);
        salario.setLocation(70, 250);
        contenedor.add(salario);
        txt_salario = new JTextField();
        txt_salario.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_salario.setSize(300, 20);
        txt_salario.setLocation(200, 250);
        contenedor.add(txt_salario);
        
        // Vivienda, label y textfield
        vivienda = new JLabel("Vivienda");
        vivienda.setFont(new Font("Arial", Font.PLAIN, 15));
        vivienda.setSize(150, 20);
        vivienda.setLocation(70, 300);
        contenedor.add(vivienda);
        combo_vivienda = new JComboBox(lista_vivienda);
        combo_vivienda.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_vivienda.setSize(300, 20);
        combo_vivienda.setLocation(200, 300);
        contenedor.add(combo_vivienda);
        
        // Gastos fijos, label y textfield
        gastos = new JLabel("Gastos Fijos");
        gastos.setFont(new Font("Arial", Font.PLAIN, 15));
        gastos.setSize(150, 20);
        gastos.setLocation(70, 350);
        contenedor.add(gastos);
        txt_gastos = new JTextField();
        txt_gastos.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_gastos.setSize(300, 20);
        txt_gastos.setLocation(200, 350);
        contenedor.add(txt_gastos);
        
        // Remanente, label y textfield
        remanente = new JLabel("Remanente");
        remanente.setFont(new Font("Arial", Font.PLAIN, 15));
        remanente.setSize(150, 20);
        remanente.setLocation(70, 400);
        contenedor.add(remanente);
        txt_remanente = new JTextField();
        txt_remanente.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_remanente.setEditable(false);
        txt_remanente.setSize(300, 20);
        txt_remanente.setLocation(200, 400);
        contenedor.add(txt_remanente);
        
        //Botón de aceptar
        aceptar = new JButton("Aceptar");
        aceptar.setFont(new Font("Arial", Font.PLAIN, 15));
        aceptar.setSize(100, 20);
        aceptar.setLocation(250, 450);
        aceptar.addActionListener(this);
        contenedor.add(aceptar);
        
        setVisible(true);
    }

    public void setNombreCompleto(String nombre, String ape_paterno, String ape_materno){
        txt_nombre.setText(nombre + " " + ape_paterno + " " + ape_materno);
    }
    
    
    
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn_cp) {
            System.out.println("vamos  bien xD");
            obtenerCols();
        } else if (event.getSource() == aceptar) {
            
            double salario = Double.valueOf(txt_salario.getText());
            double gastos_fijos = Double.valueOf(txt_gastos.getText());
            double remanente = salario - gastos_fijos;
            txt_remanente.setText(String.valueOf(remanente));
        }
    }
    
    public void obtenerCols(){        
        try {
            String endPoint = hostWS + pathWS;
            URL url = new URL(endPoint + txt_cp.getText());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            
            String output;
            while ((output = br.readLine()) != null) {
                String[] parts = output.split(",");
                combo_colonia.removeAllItems();
                for (int i = 0; i<=(parts.length)-1; i++) {
                    System.out.println(parts[i]);
                    combo_colonia.addItem(parts[i]);
                }
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
    
}
