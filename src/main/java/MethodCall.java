import java.sql.*;
public class MethodCall {

    public static String callProcedure() throws SQLException {

        Connection cn = null;
        try {
            // Conecta con la base de datos con el usuario root y la contraseña root
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebasAFututo", "root", "root");
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call sumar(?,?,?)}");

            // Parametro 1 y 2 del procedimiento almacenado
            cst.setInt(1, 5);
            cst.setInt(2, 5);

            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(3, Types.NUMERIC);
            // Ejecuta el procedimiento almacenado
            cst.execute();

            // Se obtienen la salida del procedimineto almacenado
            String resultado = cst.getString(3);

            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            cn.close();
        }
        return null;
    }
}


