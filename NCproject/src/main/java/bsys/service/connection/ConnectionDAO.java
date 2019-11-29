package bsys.service.connection;

import bsys.model.Connection;
import java.util.List;

public interface ConnectionDAO {
    List<Connection> allConnections();
    void addConnection(Connection connection);
    void deleteConnection(Connection connection);
    Connection getById(int idConnection);
}
