package obtener_factorialyfibonacci;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Touchier
 */
public class calcular implements ActionListener{
    private JFrame _Windows;
    private Container _Cont;
    private JTextField _Dato;
    private JButton _Factorial, _Fibonacci;
    private JLabel _Resultado, _Instruccion;
            
    public calcular(){
        _Cont= new Container();
        _Windows= new JFrame("MENU");
        _Dato= new JTextField();
        _Resultado= new JLabel();
        _Instruccion= new JLabel();
        _Factorial= new JButton();
        _Fibonacci= new JButton();
    }
    public void ventana(){
        _Windows.setBounds(200, 200, 700, 500);
        _Windows.setLocationRelativeTo(null);
        _Windows.setResizable(false);
        _Windows.setLayout(null);
        _Cont= _Windows.getContentPane();
        _Windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenido();
        mostrar();
    }
    public void mostrar(){
        _Windows.setVisible(true);
    }
    public void contenido(){
        //Texto
        _Dato.setBounds(120,100,100,50);
        _Dato.setForeground(Color.BLACK);
        _Dato.setVisible(true);
        //Label
        _Instruccion.setBounds(50,50,250,50);
        _Instruccion.setForeground(Color.BLACK);
        _Instruccion.setVisible(true);
        _Instruccion.setText("Escribe un Numero:");
        
        _Resultado.setBounds(250,200,250,50);
        _Resultado.setForeground(Color.BLACK);
        _Resultado.setVisible(true);
        
        //Boton
        _Fibonacci.setBounds(250,100,250,50);
        _Fibonacci.setForeground(Color.BLACK);
        _Fibonacci.setVisible(true);
        _Fibonacci.setText("Fibonacci (Menor o igual a 30)");
        _Fibonacci.addActionListener(this);
        
        _Factorial.setBounds(250,160,250,50);
        _Factorial.setForeground(Color.BLACK);
        _Factorial.setVisible(true);
        _Factorial.setText("Factorial (Menor o igual a 10)");
        _Factorial.addActionListener(this);
                
        _Cont.add(_Dato);
        _Cont.add(_Instruccion);
        _Cont.add(_Fibonacci);
        _Cont.add(_Factorial);
        _Cont.add(_Resultado);
    }
    public double proceso(char accion, int nume){  
        double numF= 0;
        double numI= 0;
        double numA= 0;
        if(accion == 'A'){
            numI= 1;
            for(int i= 1; i <= nume; i++) 
            {
                numF= numF + numI;
                numA= numF - numI;
                i++;
                if(i <= nume){	
                    numF= numF + numA;
                    numI= numF - numA;
                }
            }
        }else{
            if(accion == 'B'){
                if(nume <= 100)
                {
                    numI= nume;
                    for(int i= 1; i < nume; i++)
                    {
                        numI= numI*i;
                    }
                }
                numF= numI;
            }
        }
        return numF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dato= "";
        int nume= 0;
        double resultado= 0;
        if(e.getSource() == _Fibonacci){
            dato= _Dato.getText();
            dato= dato.replaceAll(" ", "");
            if(dato.length() != 0){
                nume= Integer.parseInt(dato);
                if(nume <= 30){
                    resultado= proceso('A', nume);
                    _Resultado.setText(resultado + "");
                }else{
                    _Resultado.setText("Numero muy grande.");
                }
            }
        }else{
            if(e.getSource() == _Factorial){
                dato= _Dato.getText();
                dato= dato.replaceAll(" ", "");
                if(dato.length() != 0){
                    nume= Integer.parseInt(dato);
                    if(nume <= 10){
                        resultado= proceso('B', nume);
                        _Resultado.setText(resultado + "");
                    }else{
                        _Resultado.setText("Numero muy grande.");
                    }
                }
            }
        }
    }
}