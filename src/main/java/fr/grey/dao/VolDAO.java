package fr.grey.dao;

import fr.grey.test.Vol;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VolDAO {

    public static void createVol(Vol vol){
        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        em.persist(vol);
        DataBaseHelper.commitTxAndClose(em);
    }

    public static List<Vol> getListVols(){

        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        TypedQuery<Vol> query = em.createQuery(
                "select v " +
                        "from Vol v ", Vol.class);
        List<Vol> vols = query.getResultList();
        DataBaseHelper.commitTxAndClose(em);
        return vols;
    }
}
