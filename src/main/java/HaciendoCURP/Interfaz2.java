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
    public String hostWS = "https://framesds.com.mx/";
    public String pathWS = "moo/ws.php?cp=";
    
    private JLabel p1;
    private JComboBox combo_p1;
    private String[] lista_p1 = {"Sin Instrucción","Preescolar","Primaria Incompleta","Primaria Completa",
        "Secundaria Incompleta","Secundaria Completa","Preparatoria Incompleta","Preparatoria Completa",
        "Licenciatura Incompleta","Licenciatura Completa","Posgrado"};
    private JLabel p2;
    private JComboBox combo_p2;
    private String[] lista_p2 = {"0", "1", "2 o más"};
    private JLabel p3;
    private JComboBox combo_p3;
    private String[] lista_p3 = {"0", "1", "2 o más"};
    private JLabel p4;
    private JComboBox combo_p4;
    private String[] lista_p4 = {"NO TIENE", "SI TIENE"};
    private JLabel p5;
    private JComboBox combo_p5;
    private String[] lista_p5 = {"0", "1", "2", "3", "4 o más"};
    private JLabel p6;
    private JComboBox combo_p6;
    private String[] lista_p6 = {"0", "1", "2", "3", "4 o más"};
    private JLabel resultado;
    private JTextField txt_resultado;
    
    
    /********************************
    *                               *
    * Constructor de la Interfaz    *
    *                               *
    ********************************/
    public Interfaz2(){
        setTitle("Generación de CURP");
        setBounds(100, 100, 1200, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        title = new JLabel("Registros Básicos");
        title.setFont(new Font("Arial", Font.PLAIN, 22));
        title.setSize(300, 30);
        title.setLocation(400, 40);
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
        
        // Label de P1 y Combo
        p1 = new JLabel("¿Cuál fue el último grado de estudios?");
        p1.setFont(new Font("Arial", Font.PLAIN, 15));
        p1.setSize(500, 20);
        p1.setLocation(550, 100);
        contenedor.add(p1);
        combo_p1 = new JComboBox(lista_p1);
        combo_p1.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_p1.setSize(300, 20);
        combo_p1.setLocation(800, 100);
        contenedor.add(combo_p1);
        
        // Label de P2 y Combo
        p2 = new JLabel("¿Cuántos baños completos hay en tú casa?");
        p2.setFont(new Font("Arial", Font.PLAIN, 15));
        p2.setSize(500, 20);
        p2.setLocation(550, 150);
        contenedor.add(p2);
        combo_p2 = new JComboBox(lista_p2);
        combo_p2.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_p2.setSize(250, 20);
        combo_p2.setLocation(850, 150);
        contenedor.add(combo_p2);
        
        // Label de P3 y Combo
        p3 = new JLabel("¿Cuántos automóviles tienen en su hogar?");
        p3.setFont(new Font("Arial", Font.PLAIN, 15));
        p3.setSize(500, 20);
        p3.setLocation(550, 200);
        contenedor.add(p3);
        combo_p3 = new JComboBox(lista_p3);
        combo_p3.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_p3.setSize(250, 20);
        combo_p3.setLocation(850, 200);
        contenedor.add(combo_p3);
        
        // Label de P4 y Combo
        p4 = new JLabel("¿Este hogar cuenta con internet?");
        p4.setFont(new Font("Arial", Font.PLAIN, 15));
        p4.setSize(500, 20);
        p4.setLocation(550, 250);
        contenedor.add(p4);
        combo_p4 = new JComboBox(lista_p4);
        combo_p4.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_p4.setSize(300, 20);
        combo_p4.setLocation(800, 250);
        contenedor.add(combo_p4);
        
        // Label de P5 y Combo
        p5 = new JLabel("¿Cuántas personas trabajaron en el último mes?");
        p5.setFont(new Font("Arial", Font.PLAIN, 15));
        p5.setSize(500, 20);
        p5.setLocation(550, 300);
        contenedor.add(p5);
        combo_p5 = new JComboBox(lista_p5);
        combo_p5.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_p5.setSize(200, 20);
        combo_p5.setLocation(900, 300);
        contenedor.add(combo_p5);
        
        // Label de P6 y Combo
        p6 = new JLabel("¿Cuántos cuartos se usan para dormir?");
        p6.setFont(new Font("Arial", Font.PLAIN, 15));
        p6.setSize(500, 20);
        p6.setLocation(550, 350);
        contenedor.add(p6);
        combo_p6 = new JComboBox(lista_p6);
        combo_p6.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_p6.setSize(280, 20);
        combo_p6.setLocation(820, 350);
        contenedor.add(combo_p6);
        
        resultado = new JLabel("Nivel socioeconomico obtenido:");
        resultado.setFont(new Font("Arial", Font.PLAIN, 15));
        resultado.setSize(500, 20);
        resultado.setLocation(550, 400);
        contenedor.add(resultado);
        txt_resultado = new JTextField();
        txt_resultado.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_resultado.setEditable(false);
        txt_resultado.setSize(300, 20);
        txt_resultado.setLocation(800, 400);
        contenedor.add(txt_resultado);

        //Bot�n de aceptar
        aceptar = new JButton("Aceptar");
        aceptar.setFont(new Font("Arial", Font.PLAIN, 15));
        aceptar.setSize(100, 20);
        aceptar.setLocation(400, 450);
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
            
            Validaciones DoValidations = new Validaciones();
            if(DoValidations.validarTextFieldNumerico(txt_salario.getText())){
                if(DoValidations.validarTextFieldNumerico(txt_gastos.getText())){
                    double salario = Double.valueOf(txt_salario.getText());
                    double gastos_fijos = Double.valueOf(txt_gastos.getText());
                    double remanente = salario - gastos_fijos;
                    txt_remanente.setText(String.valueOf(remanente));
                    
                    EstudioSocioeconomico HacerEstudio = new EstudioSocioeconomico();
                    int puntaje_1 = HacerEstudio.pregunta_1((String) combo_p1.getSelectedItem());
                    int puntaje_2 = HacerEstudio.pregunta_2((String) combo_p2.getSelectedItem());
                    int puntaje_3 = HacerEstudio.pregunta_3((String) combo_p3.getSelectedItem());
                    int puntaje_4 = HacerEstudio.pregunta_4((String) combo_p4.getSelectedItem());
                    int puntaje_5 = HacerEstudio.pregunta_5((String) combo_p5.getSelectedItem());
                    int puntaje_6 = HacerEstudio.pregunta_6((String) combo_p6.getSelectedItem());
                    
                    String resultadoEstudio = HacerEstudio.obtenerResultado(puntaje_1, puntaje_2, puntaje_3, puntaje_4, puntaje_5, puntaje_6);
                    txt_resultado.setText(resultadoEstudio);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique los datos ingresados en Gastos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique los datos ingresados en Salario");
            }
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
