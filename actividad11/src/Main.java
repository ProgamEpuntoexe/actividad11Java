import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;
import java.nio.Buffer;
class circle implements shape{
    double radio = 0;
    public double getArea(){
        return Math.PI * Math.pow(radio, 2);
    }
    public double getPerimeter(){
        return (2 * Math.PI) * radio;
    }
}
class triangle implements shape{
    double lado1 = 0;
    double lado2 = 0;
    double lado3 = 0;
    double altura = 0;
    public double getArea(){
        return lado1 * altura;
    }
    public double getPerimeter(){
        return lado1 + lado2 + lado3;
    }
}
class square implements shape{
    double base = 0;
    double altura = 0;
    public double getArea(){
        return base * altura;
    }
    public double getPerimeter(){
        return base + altura;
    }
}
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char figuraID = 'a';
        char propiedad = 'a';
        String respuesta = "";
        circle circulo = new circle();
        triangle triangulo = new triangle();
        square cuadrado = new square();
        String resultado = "";
        //Menu de opciones
        System.out.println("Bienvenido al programa de figuras geometricas");
        do{
            System.out.println("---Estas son sus opciones---");
            System.out.println("a) Seleccionar propiedad:");
            System.out.println("    actual: "+getAtributo(propiedad));
            System.out.println("b) Seleccionar figura");
            System.out.println("    actual: "+getFigura(figuraID));
            System.out.println("c) Cambiar los atributos");
            System.out.println("    actuales:");
            //mostrar los datos de cada figura geometrica si se introdugeron
            switch(figuraID){
                case 'a':
                case 'A':{
                    System.out.println("    - Radio: "+circulo.radio);
                    break;
                }
                case 'b':
                case 'B':{
                    System.out.println("    - Lado1/Base: "+triangulo.lado1);
                    System.out.println("    - Lado2     : "+triangulo.lado2);
                    System.out.println("    - Lado3     : "+triangulo.lado3);
                    System.out.println("    - Altura    : "+triangulo.altura);
                    break;
                }
                case 'c':
                case 'C':{
                    System.out.println("    - Lado1/Base  : "+cuadrado.base);
                    System.out.println("    - Lado2/Altura: "+cuadrado.altura);
                    break;
                }
            }
            System.out.println("d) imprimir los resultados");
            System.out.println("e) salir del programa");
            System.out.print("Introdusca una opcion: ");
            respuesta = entrada.readLine();
            //Asegurar que la lista no este vacia, para evitar errores
            if (respuesta.isEmpty()){
                System.out.println("Favor de introducir una opcion, presione ENTER para continuar");
                respuesta = "0";
                entrada.readLine();
            }else{
                switch(respuesta.charAt(0)){
                    //Para cambiar si quiere perimetro o area
                    case 'a':
                    case 'A':{
                        try{
                            System.out.println("");
                            System.out.println("---Ingrese una opcion---");
                            System.out.println("a) Area");
                            System.out.println("b) Perimetro");
                            System.out.print("Escoja su opcion: ");
                            resultado = entrada.readLine();
                            switch (resultado.charAt(0)){
                                case 'a':
                                case 'A':
                                case 'b':
                                case 'B':{
                                    propiedad = resultado.charAt(0);
                                    break;
                                }
                                default: {
                                    System.out.println("El dato introducido es incorrecto");
                                };
                            }
                        }catch (Exception e){
                            System.out.println("Favor de introducir un dato valido, presione ENTER para continuar");
                            entrada.readLine();
                        }
                        break;
                    }
                    //Cambiar la figura
                    case 'b':
                    case 'B':{
                        try{
                            System.out.println("");
                            System.out.println("---Ingrese una opcion---");
                            System.out.println("a) Circulo");
                            System.out.println("b) Triangulo");
                            System.out.println("c) Cuadrado");
                            System.out.print("Escoja su opcion: ");
                            resultado = entrada.readLine();
                            switch (resultado.charAt(0)){
                                case 'a':
                                case 'A':
                                case 'b':
                                case 'B':
                                case 'c':
                                case 'C':{
                                    figuraID = resultado.charAt(0);
                                    break;
                                }
                                default: {
                                    System.out.println("El dato introducido es incorrecto");
                                };
                            }
                            switch(figuraID){
                                case 'a':
                                case 'A':{
                                    circulo = new circle();
                                }
                                case 'b':
                                case 'B':{
                                    triangulo = new triangle();
                                }
                                case 'c':
                                case 'C':{
                                    cuadrado = new square();
                                }
                            }
                        }catch (Exception e){
                            System.out.println("Favor de introducir un dato valido, presione ENTER para continuar");
                            entrada.readLine();
                            figuraID = 'a';
                        }
                        break;
                    }
                    //Solicitar las medidas segun la figura
                    case 'c':
                    case 'C':{
                        try{
                            System.out.println("");
                            System.out.println("---Ingrese los valores---");
                            switch(figuraID){
                                //Circulo
                                case 'a':
                                case 'A':{
                                    System.out.print("Valor del radio: ");
                                    resultado = entrada.readLine();
                                    if (resultado.isEmpty()){
                                        System.out.println("No se introdujo un numero");
                                    }else{
                                        circulo.radio = Double.parseDouble(resultado);
                                    }
                                    break;
                                }
                                //Triangulo
                                case 'b':
                                case 'B':{
                                    try {
                                        System.out.print("Valor del lado1/Base: ");
                                        resultado = entrada.readLine();
                                        triangulo.lado1 = Double.parseDouble(resultado);
                                        System.out.print("Valor del lado2: ");
                                        resultado = entrada.readLine();
                                        triangulo.lado2 = Double.parseDouble(resultado);
                                        System.out.print("Valor del lado3: ");
                                        resultado = entrada.readLine();
                                        triangulo.lado3 = Double.parseDouble(resultado);
                                        System.out.print("Valor del Altura: ");
                                        resultado = entrada.readLine();
                                        triangulo.altura = Double.parseDouble(resultado);
                                    }catch (Exception e){
                                        System.out.println("No se introdujo ningun valor");
                                    }
                                    break;
                                }
                                //Cuadrado
                                case 'c':
                                case 'C':{
                                    try{
                                        System.out.print("Valor del lado1/Base: ");
                                        resultado = entrada.readLine();
                                        cuadrado.base = Double.parseDouble(resultado);
                                        System.out.print("Valor del lado2/Altura: ");
                                        resultado = entrada.readLine();
                                        cuadrado.altura = Double.parseDouble(resultado);
                                    }catch (Exception e){
                                        System.out.println("No se introdujo ningun valor");
                                    }
                                    break;
                                }
                            }
                        }catch (Exception e){
                            System.out.println("Favor de introducir un dato valido, presione ENTER para continuar");
                            circulo.radio = 0;
                            entrada.readLine();
                            propiedad = 'a';
                        }
                        break;
                    }
                    //Calcular el valor de la figura
                    case 'd':
                    case 'D':{
                        switch(figuraID){
                            //Circulo
                            case 'a':
                            case 'A':{
                                switch(propiedad){
                                    case 'a':
                                    case 'A':{
                                        resultado = Double.toString(circulo.getArea());
                                        break;
                                    }
                                    case 'b':
                                    case 'B':{
                                        resultado = Double.toString(circulo.getPerimeter());
                                        break;
                                    }
                                }
                                break;
                            }
                            //Triangulo
                            case 'b':
                            case 'B':{
                                switch(propiedad){
                                    case 'a':
                                    case 'A':{
                                        resultado = Double.toString(triangulo.getArea());
                                        break;
                                    }
                                    case 'b':
                                    case 'B':{
                                        resultado = Double.toString(triangulo.getPerimeter());
                                        break;
                                    }
                                }
                                break;
                            }
                            //Cuadrado
                            case 'c':
                            case 'C':{
                                switch(propiedad){
                                    case 'a':
                                    case 'A':{
                                        resultado = Double.toString(cuadrado.getArea());
                                        break;
                                    }
                                    case 'b':
                                    case 'B':{
                                        resultado = Double.toString(cuadrado.getPerimeter());
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        System.out.println("    -El "+getAtributo(propiedad)+ " de "+getFigura(figuraID)+" es: "+resultado);
                        System.out.print("Oprima ENTER para continuar");
                        entrada.readLine();
                        break;
                    }
                    //Terminar el programa
                    case 'e':
                    case 'E':{
                        System.out.println("Gracias por usar el programa, presione ENTER para termianr");
                        entrada.readLine();
                        break;
                    }
                }
            }
            //Salir de verdad, y puse catch para evitar errores
            try{
                if (respuesta.charAt(0) == 'e' | respuesta.charAt(0) == 'E'){
                    break;
                }
            }catch (Exception e){
                System.out.println("Favor de introducir una opcion");
                entrada.readLine();
            }
        }while(true);
    }
    public static String getAtributo(char atributo){
        switch(atributo){
            case 'a':
            case 'A':{
                return "Area";
            }
            case 'b':
            case 'B':{
                return "Perimetro";
            }
        }
        return "A";
    }
    public static String getFigura(char idFigura){
        switch(idFigura) {
            case 'a':
            case 'A': {
                return "Circulo";
            }
            case 'b':
            case 'B': {
                return "Triangulo";
            }
            case 'c':
            case 'C': {
                return "Cuadrado";
            }
        }
        return "A";
    }
}