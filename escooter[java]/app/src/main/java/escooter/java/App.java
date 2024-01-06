/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package escooter.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatesUtils.HibernateUtils;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        // HibernateUtils.getSessionFactory();
         Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        System.out.println(configuration);
        System.out.println(configuration.getProperties());
         SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Apertura della sessione
        try (Session session = sessionFactory.openSession()) {
            // Inizio della transazione
            // Transaction transaction = session.beginTransaction();

            // // Esempio: salvataggio di un'entità nel database
            // TuaEntity tuaEntity = new TuaEntity();
            // tuaEntity.setId(1L);
            // tuaEntity.setCampo1("Valore1");
            // tuaEntity.setCampo2("Valore2");
            // session.save(tuaEntity);

            // // Commit della transazione
            System.out.println("Connesso");
            // transaction.commit();
        }

        // Chiusura della session factory
        sessionFactory.close();
    }
}
