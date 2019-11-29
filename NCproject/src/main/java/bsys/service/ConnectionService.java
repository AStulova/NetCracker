package bsys.service;

import bsys.model.Connection;
import java.util.List;

public interface ConnectionService {
    List<Connection> allConnections();
    void addConnection(Connection connection);
    void deleteConnection(Connection connection);
    Connection getById(int idConnection);
}
