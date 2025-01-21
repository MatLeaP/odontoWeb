/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.odontoweb.Persistencia;

import com.mycompany.odontoweb.Logica.Atencion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.odontoweb.Logica.Turno;
import com.mycompany.odontoweb.Persistencia.exceptions.IllegalOrphanException;
import com.mycompany.odontoweb.Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matias
 */
public class AtencionJpaController implements Serializable {

    public AtencionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public AtencionJpaController(){
        emf = Persistence.createEntityManagerFactory("odontoWebPU");
    }

    public void create(Atencion atencion) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Turno turnoOrphanCheck = atencion.getTurno();
        if (turnoOrphanCheck != null) {
            Atencion oldAtencionOfTurno = turnoOrphanCheck.getAtencion();
            if (oldAtencionOfTurno != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Turno " + turnoOrphanCheck + " already has an item of type Atencion whose turno column cannot be null. Please make another selection for the turno field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno = atencion.getTurno();
            if (turno != null) {
                turno = em.getReference(turno.getClass(), turno.getId_turno());
                atencion.setTurno(turno);
            }
            em.persist(atencion);
            if (turno != null) {
                turno.setAtencion(atencion);
                turno = em.merge(turno);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Atencion atencion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atencion persistentAtencion = em.find(Atencion.class, atencion.getId());
            Turno turnoOld = persistentAtencion.getTurno();
            Turno turnoNew = atencion.getTurno();
            List<String> illegalOrphanMessages = null;
            if (turnoNew != null && !turnoNew.equals(turnoOld)) {
                Atencion oldAtencionOfTurno = turnoNew.getAtencion();
                if (oldAtencionOfTurno != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Turno " + turnoNew + " already has an item of type Atencion whose turno column cannot be null. Please make another selection for the turno field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (turnoNew != null) {
                turnoNew = em.getReference(turnoNew.getClass(), turnoNew.getId_turno());
                atencion.setTurno(turnoNew);
            }
            atencion = em.merge(atencion);
            if (turnoOld != null && !turnoOld.equals(turnoNew)) {
                turnoOld.setAtencion(null);
                turnoOld = em.merge(turnoOld);
            }
            if (turnoNew != null && !turnoNew.equals(turnoOld)) {
                turnoNew.setAtencion(atencion);
                turnoNew = em.merge(turnoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = atencion.getId();
                if (findAtencion(id) == null) {
                    throw new NonexistentEntityException("The atencion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atencion atencion;
            try {
                atencion = em.getReference(Atencion.class, id);
                atencion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atencion with id " + id + " no longer exists.", enfe);
            }
            Turno turno = atencion.getTurno();
            if (turno != null) {
                turno.setAtencion(null);
                turno = em.merge(turno);
            }
            em.remove(atencion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Atencion> findAtencionEntities() {
        return findAtencionEntities(true, -1, -1);
    }

    public List<Atencion> findAtencionEntities(int maxResults, int firstResult) {
        return findAtencionEntities(false, maxResults, firstResult);
    }

    private List<Atencion> findAtencionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Atencion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Atencion findAtencion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atencion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtencionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atencion> rt = cq.from(Atencion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
