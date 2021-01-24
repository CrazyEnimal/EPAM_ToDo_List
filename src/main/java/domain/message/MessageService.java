package domain.message;

import domain.DAO;

public class MessageService {
    private final DAO<Message, Integer> messageDAO = new MessageDAO();

    public MessageService() {

    }

    public void create(Message message) {
        messageDAO.create(message);
    }

    public void update(Message message) {
        messageDAO.update(message);
    }

    public void delete(Message message) {
        messageDAO.delete(message);
    }

    public final Message read(int id) {
        return messageDAO.read(id);
    }
}