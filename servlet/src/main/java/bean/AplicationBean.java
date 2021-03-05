package bean;

import java.util.Random;
import javax.faces.bean.*;

@ApplicationScoped
@ManagedBean(name = "aplicationBean")
public class AplicationBean {
    
    private final Random numero = new Random();
    private int intentos = 0;
    private int acumulado = 100000;
    private String estado = "";
    private int numeroRandom = numero.nextInt(10);
    private int intento = 5;
    private int valor = 4;
    
    public AplicationBean(){
        
    }
    
    public void guess(){
        if(intentos > 10){
            setEstado("PERDIÓ");
            restart();
        }else if(valor < 0 | valor > 10){
            intentos += 1;
            setEstado("Seleccione un número mayor o igual a 0 y menor que 10");
            acumulado -= 10000;
        }else if(valor==numeroRandom){
            intentos += 1;
            setEstado("GANÓ");
            restart();
        } else{
            intentos += 1;
            setEstado("ESTE NO ES EL NÚMERO");
            acumulado -= 10000;
        }
    }
    
    public void restart(){
        numeroRandom = numero.nextInt(10);
        setIntentos(0);
        setAcumulado(100000);
        setEstado("");
    }

    public int getIntentos() {
        return intentos;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public String getEstado() {
        return estado;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroRandom() {
        return numeroRandom;
    }
    
    public int getIntento(){
        return intento;
    }
    
    public void setIntento(int intento){
        this.intento = intento;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
