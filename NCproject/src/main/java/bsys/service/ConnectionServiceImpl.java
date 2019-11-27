package bsys.service;

import bsys.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ConnectionServiceImpl implements ConnectionService{
    private ConnectionDAO connectionDAO;

    @Autowired
    public void setConnectionDAO(ConnectionDAO connectionDAO) {
        this.connectionDAO = connectionDAO;
    }

    @Transactional
    public List<Connection> allSubServices() {
        return connectionDAO.allConnections();
    }

    @Transactional
    public void addSubService(Connection connection) {
        connectionDAO.addConnection(connection);
    }

    @Transactional
    public void deleteSubService(Connection connection) {
        connectionDAO.deleteConnection(connection);
    }

    @Transactional
    public Connection getById(int idConnection) {
        return connectionDAO.getById(idConnection);
    }
}
