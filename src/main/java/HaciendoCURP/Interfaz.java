/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HaciendoCURP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author chilamguzman
 */
public class Interfaz extends JFrame implements ActionListener {
    
    /********************************
    *                               *
    * Componentes de la Interfaz    *
    *                               *
    ********************************/
    private Container c;
    private JLabel title;
    private JLabel nombre;
    private JTextField txt_nombre;
    private JLabel apaterno;
    private JTextField txt_apaterno;
    private JLabel amaterno;
    private JTextField txt_amaterno;
    private JLabel genero;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel entidadnac;
    private JComboBox combo_entidadnac;
    private JLabel fechanac;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private String dates[]
        = { "01", "02", "03", "04", "05",
            "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
        = { "Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre" };
    private String years[]
        = { "1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960",
            "1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971",
            "1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982",
            "1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993",
            "1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004",
            "2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
            "2016","2017","2018","2019","2020","2021"};
    private JButton sub;
    private JButton reset;
    private JLabel curp;
    private JTextField txt_curp;
    private String[] ENTIDAD_FEDERATIVA = {"AGUASCALIENTES",
                                           "BAJA CALIFORNIA NTE.",
                                           "BAJA CALIFORNIA SUR",
                                           "CAMPECHE",
                                           "COAHUILA",
                                           "COLIMA",
                                           "CHIAPAS",
                                           "CHIHUAHUA",
                                           "DISTRITO FEDERAL",
                                           "DURANGO",
                                           "GUANAJUATO",
                                           "GUERRERO",
                                           "HIDALGO",
                                           "JALISCO",
                                           "MEXICO",
                                           "MICHOACAN",
                                           "MORELOS",
                                           "NAYARIT",
                                           "NUEVO LEON",
                                           "OAXACA",
                                           "PUEBLA",
                                           "QUERETARO",
                                           "QUINTANA ROO",
                                           "SAN LUIS POTOSI",
                                           "SINALOA",
                                           "SONORA",
                                           "TABASCO",
                                           "TAMAULIPAS",
                                           "TLAXCALA",
                                           "VERACRUZ",
                                           "YUCATAN",
                                           "ZACATECAS",
                                           "SERV. EXTERIOR MEXICANO",
                                           "NACIDO EN EL EXTRANJERO"};
    private JButton next;
    
    /********************************
    *                               *
    * Constructor de la Interfaz    *
    *                               *
    ********************************/
    public Interfaz()
    {
        setTitle("Generación de CURP");
        setBounds(300, 90, 500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Generación de CURP");
        title.setFont(new Font("Arial", Font.PLAIN, 22));
        title.setSize(300, 30);
        title.setLocation(140, 30);
        c.add(title);
        
        // Nombre, label y textfield
        nombre = new JLabel("Nombre(s)");
        nombre.setFont(new Font("Arial", Font.PLAIN, 15));
        nombre.setSize(100, 20);
        nombre.setLocation(70, 100);
        c.add(nombre);
        txt_nombre = new JTextField();
        txt_nombre.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_nombre.setSize(230, 20);
        txt_nombre.setLocation(200, 100);
        c.add(txt_nombre);
        
        // Apellido Paterno, label y textfield
        apaterno = new JLabel("Apellido Paterno");
        apaterno.setFont(new Font("Arial", Font.PLAIN, 15));
        apaterno.setSize(110, 20);
        apaterno.setLocation(70, 150);
        c.add(apaterno);
        txt_apaterno = new JTextField();
        txt_apaterno.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_apaterno.setSize(230, 20);
        txt_apaterno.setLocation(200, 150);
        c.add(txt_apaterno);
        
        // Apellido Materno, label y textfield
        amaterno = new JLabel("Apellido Materno");
        amaterno.setFont(new Font("Arial", Font.PLAIN, 15));
        amaterno.setSize(110, 20);
        amaterno.setLocation(70, 200);
        c.add(amaterno);
        txt_amaterno = new JTextField();
        txt_amaterno.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_amaterno.setSize(230, 20);
        txt_amaterno.setLocation(200, 200);
        c.add(txt_amaterno);
        
        // Genero
        genero = new JLabel("Genero");
        genero.setFont(new Font("Arial", Font.PLAIN, 15));
        genero.setSize(100, 20);
        genero.setLocation(70, 250);
        c.add(genero);
        male = new JRadioButton("Hombre");
        male.setFont(new Font("Arial", Font.PLAIN, 13));
        male.setSelected(false);
        male.setSize(100, 20);
        male.setLocation(200, 250);
        c.add(male);
        female = new JRadioButton("Mujer");
        female.setFont(new Font("Arial", Font.PLAIN, 13));
        female.setSelected(false);
        female.setSize(100, 20);
        female.setLocation(300, 250);
        c.add(female);
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        
        // Entidad de Nacimiento
        entidadnac = new JLabel("Entidad Nacimiento");
        entidadnac.setFont(new Font("Arial", Font.PLAIN, 15));
        entidadnac.setSize(150, 20);
        entidadnac.setLocation(70, 300);
        c.add(entidadnac);
        combo_entidadnac = new JComboBox(ENTIDAD_FEDERATIVA);
        combo_entidadnac.setFont(new Font("Arial", Font.PLAIN, 12));
        combo_entidadnac.setSize(230, 20);
        combo_entidadnac.setLocation(200, 300);
        c.add(combo_entidadnac);
        
        // Fecha de Nacimiento
        fechanac = new JLabel("Fecha Nacimiento");
        fechanac.setFont(new Font("Arial", Font.PLAIN, 15));
        fechanac.setSize(150, 20);
        fechanac.setLocation(70, 350);
        c.add(fechanac);
        
        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 12));
        date.setSize(64, 20);
        date.setLocation(200, 350);
        c.add(date);
 
        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 12));
        month.setSize(108, 20);
        month.setLocation(255, 350);
        c.add(month);
 
        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 12));
        year.setSize(80, 20);
        year.setLocation(355, 350);
        c.add(year);
        
        // Botones
        sub = new JButton("Generar");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(140, 400);
        sub.addActionListener(this);
        c.add(sub);
        reset = new JButton("Reiniciar");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(260, 400);
        reset.addActionListener(this);
        c.add(reset);
        
        // CURP, label y textfield
        curp = new JLabel("CURP");
        curp.setFont(new Font("Arial", Font.PLAIN, 15));
        curp.setSize(110, 20);
        curp.setLocation(70, 450);
        c.add(curp);
        txt_curp = new JTextField();
        txt_curp.setEditable(false);
        txt_curp.setFont(new Font("Arial", Font.PLAIN, 13));
        txt_curp.setSize(230, 20);
        txt_curp.setLocation(200, 450);
        c.add(txt_curp);
        
        //Bot�n de Siguiente
        next = new JButton("Siguiente");
        next.setFont(new Font("Arial", Font.PLAIN, 15));
        next.setSize(100, 20);
        next.setLocation(190, 500);
        next.addActionListener(this);
        c.add(next);
        
        setVisible(true);
    }
    
    
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent eventPushed) {
        String CURP = "";
        if (eventPushed.getSource() == sub) {
            /********************************
            *                               *
            * Primero validamos los campos  *
            * que sean de tipo texto        *
            *                               *
            ********************************/
            Validaciones DoValidations = new Validaciones();
            if(DoValidations.validarTextField(txt_nombre.getText())){
                if(DoValidations.validarTextField(txt_apaterno.getText())){
                    if(DoValidations.validarTextField(txt_amaterno.getText())){
                        System.out.println("SEGUIMOS");
                        
                        CrearCURP hacerCURP = new CrearCURP();
                        CURP = CURP + hacerCURP.validacionAlfabetica(txt_nombre.getText().toUpperCase(), txt_apaterno.getText().toUpperCase(), txt_amaterno.getText().toUpperCase());
                        
                        String dia = (String) date.getSelectedItem();
                        String mes = (String) month.getSelectedItem();
                        String anio = (String) year.getSelectedItem();
                        CURP = CURP + hacerCURP.validacionNumerica(dia, mes, anio);

                        String sexo = "";
                        if(male.isSelected()){
                            sexo = "H";
                        } else {
                            sexo = "M";
                        }
                        String entidad = (String) combo_entidadnac.getSelectedItem();
                        CURP = CURP + hacerCURP.validacionAlfabeticaPte2(sexo, entidad, txt_nombre.getText().toUpperCase(), txt_apaterno.getText().toUpperCase(), txt_amaterno.getText().toUpperCase());
                        
                        txt_curp.setText(CURP);                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Verifique los datos ingresados en Apellido Materno");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique los datos ingresados en Apellido Paterno");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique los datos ingresados en Nombre");
            }
        } else if (eventPushed.getSource() == next) {
            setVisible(false);
            Interfaz2 InterfazDatosGenerales = new Interfaz2();
            InterfazDatosGenerales.setNombreCompleto(txt_nombre.getText().toUpperCase(), txt_apaterno.getText().toUpperCase(), txt_amaterno.getText().toUpperCase());
        }
    }
    
    
    
}
