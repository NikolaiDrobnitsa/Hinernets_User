package Until;
import Models.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateFactoryUtil() {}
    public static SessionFactory getSessionFactory(){
        if ( sessionFactory == null ) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Client.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch ( Exception ex ) {
                System.out.println(ex.getMessage());
            }
        }
        return sessionFactory;
    }
}
