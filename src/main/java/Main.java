import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("resultado" + MethodCall.callProcedure("{call sumar(?,?,?)}",
                                                                "jdbc:mysql://localhost:3306/pruebasAFuturo",
                                                                "root",
                                                                "root"));

    }
}
