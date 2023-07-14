package booking.Service;

import booking.beans.TicketModifie;
import booking.dao.TicketDAO;
import booking.dao.TicketModifieDAO;

import java.util.List;
import java.util.Optional;

public class TicketModifieService extends Service<TicketModifie, TicketModifieDAO> implements  TicketModifieDAO{
    public TicketModifieService() {
        super(TicketModifieDAO.class);
    }

    @Override
    public int count() {
        return jdbi.withExtension(TicketDAO.class
                ,TicketDAO::count);
    }
    @Override
    public void hide(long id) {
        jdbi.useExtension(TicketDAO.class, dao -> dao.hide(id));
    }

    @Override
    public void show(long id) {
        jdbi.useExtension(TicketDAO.class, dao -> dao.show(id));
    }

    @Override
    public List<TicketModifie> getAllTicket(long userId) {
        return jdbi.withExtension(TicketModifieDAO.class, dao -> dao.getAllTicket(userId));
    }

    @Override
    public Optional<TicketModifie> getTicketByID(long ticketID) {
        return jdbi.withExtension(TicketModifieDAO.class, dao -> dao.getTicketByID(ticketID));
    }

}
