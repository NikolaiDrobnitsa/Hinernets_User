package Controller;
import Models.Client;
import Until.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientController {
    public static Client searchClientById(int id) {
        return HibernateFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }
    public static List<Client> getAllClients(){
        List<Client> clientsList = (List<Client>)HibernateFactoryUtil.getSessionFactory().openSession().createQuery("From Client").list();
        return clientsList;
    }
    public static void addClient(Client client) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public void deleteClient ( Client client ) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(client);
        transaction.commit();
        session.close();
    }

    public static void updateClient(Client client) {
        Session session = HibernateFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

}
