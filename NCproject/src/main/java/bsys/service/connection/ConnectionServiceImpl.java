package bsys.service.connection;

import bsys.model.Connection;
import bsys.service.connection.ConnectionDAO;
import bsys.service.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    private ConnectionDAO connectionDAO;

    @Autowired
    public void setConnectionDAO(ConnectionDAO connectionDAO) {
        this.connectionDAO = connectionDAO;
    }

    @Transactional
    public List<Connection> allConnections() {
        return connectionDAO.allConnections();
    }

    @Transactional
    public void addConnection(Connection connection) {
        connectionDAO.addConnection(connection);
    }

    @Transactional
    public void deleteConnection(Connection connection) {
        connectionDAO.deleteConnection(connection);
    }

    @Transactional
    public Connection getById(int idConnection) {
        return connectionDAO.getById(idConnection);
    }
}
