package domain.status;

import domain.DAO;

public class StatusService {
    private final DAO<Status, Integer> statusDAO = new StatusDAO();

    public StatusService() {

    }

    public void create(Status status) {
        statusDAO.create(status);
    }

    public void update(Status status) {
        statusDAO.update(status);
    }

    public void delete(Status status) {
        statusDAO.delete(status);
    }

    public final Status read(int id) {
        return statusDAO.read(id);
    }
}
