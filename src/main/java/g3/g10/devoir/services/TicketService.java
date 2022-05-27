package g3.g10.devoir.services;

import java.util.List;

import g3.g10.devoir.models.Status;
import g3.g10.devoir.models.Ticket;

public interface TicketService {
    Ticket add(Ticket ticket);

    Ticket update(Ticket ticket);

    Ticket delete(Ticket ticket);

    Ticket findById(int id);

    List<Ticket> findAll();

    List<Ticket> findByClientId(int id);

    List<Ticket> findByDevId(int id);

    Ticket assignToDev(int ticket_id, int dev_id);

    Ticket updateStatus(Status status, int ticket_id);
}
