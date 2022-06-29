package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        Member member = new Member();
//        member.setId(2L);
//        member.setName("helloB");
//        em.persist(member);

//        Member member = em.find(Member.class, 1L);
//        System.out.println("member.getName() = " + member.getName());
////        em.remove(member);
//        member.setName("HelloJPA");

        try {
            Member member = new Member();
            member.setUsername("AAA");
            Member member2 = new Member();
            member.setUsername("BBB");

            em.persist(member);
            em.persist(member2);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

//        em.clear(); //영속성 컨텍스트 전체 삭제
        emf.close();
    }
}
