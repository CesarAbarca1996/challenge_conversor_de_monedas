import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        double monto=0;
        double resultado=0;
        List<Moneda> monedas=new ArrayList<>();
        ConversorDeDivisa conversorDeDivisa= new ConversorDeDivisa();
        while (opcion!=9){
            System.out.println("========== MENÚ DE CONVERSIÓN DE MONEDAS ==========");
            System.out.println("Seleccione la conversión deseada:");
            System.out.println("1. Peso Chileno a Dólar");
            System.out.println("2. Dólar a Peso Chileno");
            System.out.println("3. Peso Argentino a Dólar");
            System.out.println("4. Dólar a Peso Argentino");
            System.out.println("5. Peso Colombiano a Dólar");
            System.out.println("6. Dólar a Peso Colombiano");
            System.out.println("7. Peso Peruano a Dólar");
            System.out.println("8. Dólar a Peso Peruano");
            System.out.println("9. Salir");
            System.out.println("==================================================");
            System.out.print("Ingrese su opción (1-9): ");
            opcion=teclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Cantidad de CLP a convertir en USD: ");
                    monto= teclado.nextDouble();
                    monedas=conversorDeDivisa.buscarDivisa("CLP");
                    for (Moneda mon : monedas){
                        if (mon.getNombre().equals("USD")){
                            Moneda moneda = new Moneda(mon.getNombre(),mon.getValor());
                            resultado=monto*moneda.getValor();
                            System.out.println(moneda);
                            System.out.println("El monto de "+monto+"[CLP] equivalen a "+resultado+" ["+moneda.getNombre()+"]");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Cantidad de USD a convertir en CLP: ");
                    monto=teclado.nextDouble();
                    monedas=conversorDeDivisa.buscarDivisa("USD");
                    for (Moneda mon : monedas){
                        if (mon.getNombre().equals("CLP")){
                            Moneda moneda = new Moneda(mon.getNombre(),mon.getValor());
                            resultado=monto*moneda.getValor();
                            System.out.println(moneda);
                            System.out.println("El monto de "+monto+"[USD] equivalen a "+resultado+" ["+moneda.getNombre()+"]");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Cantidad de ARS a convertir en USD: ");
                    monto=teclado.nextDouble();
                    monedas=conversorDeDivisa.buscarDivisa("ARS");
                    for (Moneda mon : monedas){
                        if (mon.getNombre().equals("USD")){
                            Moneda moneda = new Moneda(mon.getNombre(),mon.getValor());
                            resultado=monto*moneda.getValor();
                            System.out.println(moneda);
                            System.out.println("El monto de "+monto+"[ARS] equivalen a "+resultado+" ["+moneda.getNombre()+"]");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Cantidad de USD a convertir en ARS: ");
                    monto=teclado.nextDouble();
                    monedas=conversorDeDivisa.buscarDivisa("USD");
                    for (Moneda mon : monedas){
                        if (mon.getNombre().equals("ARS")){
                            Moneda moneda = new Moneda(mon.getNombre(),mon.getValor());
                            resultado=monto*moneda.getValor();
                            System.out.println(moneda);
                            System.out.println("El monto de "+monto+"[USD] equivalen a "+resultado+" ["+moneda.getNombre()+"]");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Cantidad de COP a convertir en USD: ");
                    monto=teclado.nextDouble();
                    monedas=conversorDeDivisa.buscarDivisa("COP");
                    for (Moneda mon : monedas){
                        if (mon.getNombre().equals("USD")){
                            Moneda moneda = new Moneda(mon.getNombre(),mon.getValor());
                            resultado=monto*moneda.getValor();
                            System.out.println(moneda);
                            System.out.println("El monto de "+monto+"[COP] equivalen a "+resultado+" ["+moneda.getNombre()+"]");
                        }
                    }
                    break;
                case 9:
                    opcion=9;
                    System.out.println("Hasta pronto, gracias por utilizar nuestro sistema");
                    break;
            }
        }
    }
}
