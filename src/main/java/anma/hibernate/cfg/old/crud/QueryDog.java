package anma.hibernate.cfg.old.crud;

import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryDog {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("old-hibernate.cfg.xml")
                .addAnnotatedClass(Dog.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Dog> dogs = session.createQuery("from Dog").getResultList();

//            dogs = session.createQuery("from Dog d where d.name='Barsik'").getResultList();

//            dogs =
//                    session.createQuery("from Dog d where"
//                            + " d.name='Barsik' OR d.age='5'").getResultList();

            session.getTransaction().commit();

            System.out.println("Getting dogs......");
            for (Dog dog : dogs) {
                System.out.println(dog);
            }


        }
        finally {
            factory.close();
        }

    }
}
