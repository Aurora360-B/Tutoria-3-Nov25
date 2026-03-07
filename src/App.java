import java.sql.RowIdLifetime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //Variables del vendedor
        String nombreVendedor = "";
        double salarioBase = 1400000;
        double comisionTotal = 0.0;
        int ventasRealizadas = 0;
        double metaMensual = 2000000;
        double totalVendido = 0.0;
        boolean esSupervisor = false;
        int clientesAtendidos = 0;
        double descuentoOtorgado = 0.0;

        //Bienvenida
        System.out.println("========================================");
        System.out.println("Bienvenido a Tech Store");
        System.out.println("========================================");
        System.out.println("Bienvenido al Sistema Gestión de Ventas");
        System.out.print("Ingrese su nombre: ");
        nombreVendedor = scanner.nextLine();

        System.out.println("¿Usted es supervisor? (1 = Si, 2 = No) ");
        int rolDecision = scanner.nextInt();

        esSupervisor = (rolDecision == 1) ? true : false;

        String cargo = esSupervisor ? "Supervisor de ventas" : "Vendedor"; 

        //Montar información del vendedor
        System.out.println("Hola" + nombreVendedor + ". ¡Bienvenido! ");
        System.out.println("Cargo " + cargo);
        System.out.println("Salario base " + salarioBase);
        System.out.println("Meta mensual de ventas " + metaMensual);

        //Menú principal con do-White
        int opcionMenu;
        boolean sistemaActivo = true;

        do {
        
            System.out.println("Resumen actual.");
            System.out.println("===============================");
            System.out.println("Nombre del vendedor " + nombreVendedor + " cargo " + cargo);
            System.out.println("Total vendido: " + totalVendido);
            System.out.println("Meta mensual: " + metaMensual);
            System.out.println("Prgreso: " + (totalVendido/metaMensual));
            System.out.println(" Ventas realizadas " + ventasRealizadas);
            System.out.println("Clientes atendidos: " + clientesAtendidos);
            System.out.println("Comisión acumulada $: " + comisionTotal);

            //Menú principal de opciones

            System.out.println("Menú pricnipal.");
            System.out.print("1. Registrar una nueva venta.");
            System.out.print("2. Ver estadisticas detalladas.");
            System.out.println("3. Calcular el salario mensual.");
            System.out.println("4. Evaluar el cumplimiento de las metas");
            System.out.println("5. Procesar devolución.");
            System.out.println("6. Cerra sesión.");
            System.out.print("Seleccione una opción.");

            opcionMenu = scanner.nextInt();

            while (opcionMenu < 1 || opcionMenu > 6 ) {
                System.out.println("Opción inválida, por favor seleccionar una opción válida en el menú. ");
                opcionMenu = scanner.nextInt();
            }

            switch (opcionMenu) {
                case 1:
                    System.out.println("Registra nueva venta");
                    System.out.println("===========================");
                    clientesAtendidos++;

                    System.out.println("Catálogo de productos.");
                    System.out.println("1. Computador de mesa - $ 2_000_000");
                    System.out.println("2. Tablet - $1_000_000");
                    System.out.println("3. Monitor - $400_000");
                    System.out.println("4. Mouse inalámbrico - 300_000");
                    System.out.println("Cuantos productos diferentes comprará el cliente.");
                    int cantidadProductos = scanner.nextInt();

                    while (cantidadProductos < 1 || cantidadProductos > 4) {
                        System.out.print("Ingrese un número válido del ID del producto.");
                        cantidadProductos = scanner.nextInt();
                        
                    }
                double totalVenta = 0.0;
                for (int i  =  1; i <= cantidadProductos; i++){
                    System.out.println("Producto " + i + "----");
                    System.out.println("Seleccione un producto que esté entre la opción 1 y 4. ");
                    int productoSeleccionado = scanner.nextInt();

                    System.out.println("Cantidad a comprar.");
                    int cantidad = scanner.nextInt();

                    double precioUnitario = 0.0;
                    String nombreProducto = "";

                    switch (productoSeleccionado) {
                        case 1:
                            precioUnitario = 2_000_000;
                            nombreProducto = "Computador de mesa.";
                            break;
                        case 2:
                            precioUnitario = 1_000_000;
                            nombreProducto = "Tablet";
                        break;
                        case 3:
                            precioUnitario = 400_000;
                            nombreProducto = "Monitor";
                        break;
                        case 4:
                            precioUnitario = 300_000;
                            nombreProducto =  "Mouse inalámbrico";
                        break;

                        default:
                        precioUnitario = 0.0;
                        nombreProducto = "";
                            break;
                    }

                double subTotal = precioUnitario * cantidad; 
                totalVenta = totalVenta + subTotal;

                System.out.println("Cantidad " + cantidad + " nombre producto " + nombreProducto + " $ " + subTotal);

                }

                System.out.println("Subtotal " + totalVenta);

                //aPLICAR DESCUENTO A SUPERVISOR
                System.out.println("El cliente tiene tarjeta de fidelidad (1 = si, 2 = no)");
                int tieneTarjeta = scanner.nextInt();

                double descuento = 0.0;

                if (tieneTarjeta == 1) {
                    if (totalVenta >= 100_000) {
                        descuento = totalVenta * 0.15;
                        //15% descuento
                        
                    } else if (totalVenta >= 50_000) {
                        descuento = totalVenta * 0.10;
                    } else if (totalVenta >= 35_000) {
                        descuento = totalVenta * 0.05;
                    } else {
                        System.out.println("Compra mínima para descuento tiene que ser de $35_000");
                    }

                    descuentoOtorgado = descuentoOtorgado + descuento;

                }

                totalVenta = totalVenta - descuento;
                System.out.println("Total a pagar" + totalVenta);

                System.out.println("Método de pago");
                System.out.println("===================");
                System.out.println("1. Efectivo.");
                System.out.println("2. Tarjeta de crédito.");
                System.out.println("3. Transferencia bancaria.");
                System.out.println("Seleccione.");
                int metodoPago = scanner.nextInt();

                String metodoTexto = "";
                switch (metodoPago) {
                    case 1:
                        metodoTexto = "efectivo";
                        System.out.println("Monto a recibir.");
                        double montoRecibido = scanner.nextDouble();
                        double cambio = montoRecibido - totalVenta;

                    //Operador ternario para validar el monto. 
                    String mensaje = (cambio >= 0 ? "cambio" + cambio: "monto insuficiente");
                    System.out.println(mensaje);

                    if (cambio < 0) {
                        System.out.println("Venta cancelada");
                        break;
                    }
                        break;
                
                
                case 2:
                    metodoTexto = "Tarjeta de crédito";
                    System.out.println("Pago procesado correctamente.");
                    break; 
                case 3: 
                metodoTexto = "Transferencia bancaria";
                System.out.println("Transferencia confirmada");
                break; 

                default:
                    metodoTexto = "Metodo de pago no válido. ";
                    System.out.println("Método de pago no válido, venta cancelada.");
                        break;
                }
//Calcular comisión 
                if (metodoPago >= 1 && metodoPago <= 3) {
                    //calcular comisión
                    double comision = 0.0;
                    if (totalVenta >= 100_000) {
                        comision = totalVenta * 0.08;  
                    } else if (totalVenta >= 50_000) {
                        comision = totalVenta * 0.05;
                    } else {
                        comision = totalVenta * 0.03;
                    } 

                // bonus por ser supervisor
                comision = esSupervisor ? comision * 1.2 : comision;

                comisionTotal = comisionTotal + comision;
                totalVendido = totalVendido + totalVenta;
                ventasRealizadas ++;
                System.out.println("Venta resgistrada exitosamente.");
                System.out.println("Ticket " + ventasRealizadas);
                System.out.println("Monto " + totalVenta);
                System.out.println("Método" + metodoTexto);
                System.out.println("Comisión " +  comision);
                }
                    break;
            case 2:
                //Estadisticas detalladas. 
                System.out.println("============================");
                System.out.println("Estadisticas detalladas.");
                System.out.println("============================");

                System.out.println("Nombre del vendedor " + nombreVendedor);
                System.out.println("Cargo " + cargo);
                System.out.println("Salario base " + salarioBase);
                System.out.println("---Rendimiento---");
                System.out.println("Ventas realizadas " + ventasRealizadas);
                System.out.println("Clientes atendidos " + clientesAtendidos);
                System.out.println("Total vendido " + totalVendido);
                System.out.println("Meta mensual " + metaMensual);

                double porcentajeMeta = (totalVendido/metaMensual) * 100;

                System.out.println("Cumplimiento " + porcentajeMeta + "%");

                System.out.println("Comisiones ");
                System.out.println("Comision acumulada " + comisionTotal);

                // promedio de ventas

                double promedioVenta = (ventasRealizadas > 0 ) ? totalVendido / ventasRealizadas : 0;
                System.out.println("Promedio de venta " + promedioVenta);
                System.out.println("Descuento otorgados " + descuentoOtorgado);
                
                //calificación del vendedor 
                if (totalVendido >= metaMensual * 1.5) {
                    System.out.println("Superaste la meta en un 150%");
                } else if (totalVendido >= metaMensual) {
                    System.out.println("Cumpliste con la meta");
                } else if (totalVendido >= metaMensual * 0.7) {
                    System.out.println("Buen trabajo, estas cerca de la meta.");
                } else {
                    System.out.println("No cumpliste la meta.");
                }
                break; //quede en 1 hora con 8 min 

            
            
                default:
                    break;
            }





            
        } while (sistemaActivo);

    }
}
