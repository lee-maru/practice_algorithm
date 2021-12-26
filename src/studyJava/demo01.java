package studyJava;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class demo01 {
    public static class DatabaseConnection implements Closeable {
        private final String dbName;

        public DatabaseConnection(String dbName) throws SQLException {
            if( null == dbName || "undefined".equals(dbName) ){
                throw new SQLException(dbName + " is invalid db name ");
            }
            this.dbName = dbName;
            System.out.println(dbName + "db Connection 완료");
        }

        @Override
        public void close() throws IOException {
            System.out.println(dbName + "db Connection 연결 종료");
        }
    }

    public static void main(String[] args) {
        try(DatabaseConnection myDb= new DatabaseConnection("myDb");
            DatabaseConnection undefined = new DatabaseConnection("undefined")){
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}