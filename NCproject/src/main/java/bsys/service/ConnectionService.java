package bsys.service;

import bsys.model.Connection;
import java.util.List;

public interface ConnectionService {
    List<Connection> allSubServices();
    void addSubService(Connection connection);
    void deleteSubService(Connection connection);
    Connection getById(int idConnection);
}
