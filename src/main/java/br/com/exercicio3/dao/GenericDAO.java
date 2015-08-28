/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exercicio3.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author marcos
 * @param <T>
 */
public class GenericDAO<T> implements InterfaceDAO<T> {

    private EntityManager em = FabricaEntityManager.obterFabrica().createEntityManager();

    public GenericDAO() {
    }

    public boolean iniciarTransacao() {
        try {
            if (em.getTransaction().isActive()) {
                return true;
            }
            em.getTransaction().begin();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean concluirTransacao() {
        try {
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean cancelarTransacao() {
        try {
            em.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean criar(T o) {
        try {
            this.iniciarTransacao();
            em.persist(o);
            this.concluirTransacao();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public boolean excluir(T o) {
        try {
            this.iniciarTransacao();
            em.remove(em.merge(o));
            this.concluirTransacao();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public boolean alterar(T o) {
        try {
            this.iniciarTransacao();
            em.merge(o);
            this.concluirTransacao();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public T obter(Class<T> classe, Object id) {
        if (id == null) {
            return null;
        }
        String query = classe.getSimpleName() + ".findById";
        final Query q = em.createNamedQuery(query);
        try {
            return (T) q.setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<T> obterTodos(Class<T> classe) {
        String query = classe.getSimpleName() + ".findAll";
        Query q = em.createNamedQuery(query);
        return (List<T>) q.getResultList();
    }

    /**
     * @return the entityManager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * @param entityManager the entityManager to set
     */
    protected void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (this.em != null && this.em.isOpen()) {
            this.em.flush();
            this.em.clear();
            this.em.close();
        }
    }
}
