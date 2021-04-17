package ir.shayandaneshvar.i18n_spring_core_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class StudentService {
    //    @Autowired // field injection => Never do it!!!!!
//    @Inject in JEE CDI
    private final Connection connection;

    @Autowired // not usable when we have circular dependencies
    public StudentService(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void saveStudent(Student student) throws SQLException {
        connection.createStatement();
        // TODO: 4/11/2021
    }

}
