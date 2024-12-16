package main.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.Connection;
import java.util.List;

public class Consultas {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Consultas(){
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public void personajes(String apellidoProfesor){
        String sql = "select p from Person p inner join Enrollment e on p = e.personEnrollment inner join Course c on c = e.courseEnrollment inner join Person teacher on c.teacher = teacher where teacher.lastName =?1";
        Query query = em.createQuery(sql);
        query.setParameter(1, apellidoProfesor);
        List<Person> persons = query.getResultList();
        System.out.println("las personas que recibieron clase con " + apellidoProfesor + " fueron:");
        for(Person person: persons){
            System.out.println(person);
        }
    }

    public void masPuntos(){
        String sql = "select p from Person p inner join HousePoint hp on p = hp.receiver group by hp.receiver order by sum(hp.points) desc limit 1";
        Query query = em.createQuery(sql);
        Person person = (Person) query.getSingleResult();
        System.out.println("la persona con más puntos es: ");
        System.out.println(person);
    }

    public void puntosEntregados(){
        Query query = em.createNamedQuery("HousePoint.maxPoints");
        List<Object[]> results = query.getResultList();
        System.out.println("la persona que más puntos ha entregado es: ");
        for(Object[] result: results){
            System.out.println("persona: " + result[0] + " puntos: " + result[1]);
        }
    }

    public void datosProfesores(){
        String sql = "select c from Course c right join Person p on c.teacher = p";
        Query query = em.createQuery(sql);
        List<Object[]> results = query.getResultList();
        System.out.println("los profesores son: ");
        for(Object[] result: results){
            System.out.println("profesor: " + result[0] + " curso: " + result[1]);
        }
    }

    public void close(){
        em.close();
        emf.close();
    }


}
