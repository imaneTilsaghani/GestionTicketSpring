package g3.g10.devoir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g3.g10.devoir.models.Client;
import g3.g10.devoir.models.Dev;
import g3.g10.devoir.models.Software;
import g3.g10.devoir.models.Status;
import g3.g10.devoir.models.Ticket;
import g3.g10.devoir.repo.SoftwareRepo;
import g3.g10.devoir.repo.TicketRepo;
import g3.g10.devoir.repo.UserRepo;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private UserRepo<Client> clientRepo;
    @Autowired
    private UserRepo<Dev> devRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private SoftwareRepo softwareRepo;

    @Override
    public Ticket add(Ticket ticket) {
        Client client = clientRepo.findById(ticket.getClient().getId()).get();
        if (client != null) {
            Software software = softwareRepo.findById(ticket.getSoftware().getId()).get();
            if (software != null) {
                ticket.setClient(client);
                ticket.setSoftware(software);
                ticket.setStatus(Status.OPEN);
                return ticketRepo.save(ticket);
            }
        }
        return null;
    }

    @Override
    public Ticket update(Ticket ticket) {
        if (ticketRepo.existsById(ticket.getId())) {
            return ticketRepo.save(ticket);
        }
        return null;
    }

    @Override
    public Ticket delete(Ticket ticket) {   
        if (ticketRepo.existsById(ticket.getId())) {
            ticketRepo.delete(ticket);
            return ticket;
        }
        return null;
    }

    @Override
    public Ticket findById(int id) {
        return ticketRepo.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> findByClientId(int id) {
        return ticketRepo.findByClientId(id).orElse(null);
    }

    @Override
    public List<Ticket> findByDevId(int id) {
        return ticketRepo.findByDevId(id).orElse(null);
    }

    @Override
    public Ticket assignToDev(int ticket_id, int dev_id) {
        if (ticketRepo.existsById(ticket_id) && devRepo.existsById(dev_id)) {
            Ticket ticket = ticketRepo.findById(ticket_id).get();
            ticket.setDev(devRepo.findById(dev_id).get());
            return ticketRepo.save(ticket);
        }
        return null;
    }

    @Override
    public Ticket updateStatus(Status status, int ticket_id) {
        Ticket ticket = ticketRepo.findById(ticket_id).get();
        ticket.setStatus(status);
        return ticketRepo.save(ticket);
    }
    
}
