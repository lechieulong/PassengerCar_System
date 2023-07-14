package booking.Service;

import booking.beans.Ticket;
import booking.beans.TicketModifie;
import booking.dao.SeatTransportDAO;
import booking.dao.TicketDAO;

public class TicketService extends Service<Ticket,TicketDAO> implements  TicketDAO{
    public TicketService() {
        super(TicketDAO.class);
    }

    @Override
    public void updateStatus() {
        jdbi.useExtension(TicketDAO.class, dao -> dao.updateStatus());
    }

    @Override
    public void updateStatusByID(long id) {
        jdbi.useExtension(TicketDAO.class, dao -> dao.updateStatusByID(id));
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

}
