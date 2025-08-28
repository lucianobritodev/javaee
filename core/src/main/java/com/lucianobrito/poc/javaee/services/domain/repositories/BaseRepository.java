package com.lucianobrito.poc.javaee.services.domain.repositories;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @param <E> Entidade
 * @param <P> Primary Key
 */
public abstract class BaseRepository<E, P> {

    @PersistenceContext(unitName = "sitePU")
    private EntityManager em;

    private final Class<E> entityClass;

    protected BaseRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Consulta um registro da tabela mapeada para a entidade {@code E} com chave primária do tipo {@code P}.
     * @return E
     */
    public Optional<E> findById(P id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }

    /**
     * Consulta todos os registros da tabela mapeada para a entidade {@code E}.
     * @return {@code List<E>}
     */
    public List<E> findAll() {
        return em.createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    /**
     * @param <T> Tipo da entidade criada e que será retornada.
     * @param entity variável da classe {@code T}.
     * @return {@code T}
     */
    public <T extends E> T create(T entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * @param <T> Tipo da entidade criada e que será retornada.
     * @param entity variável da classe {@code T}.
     * @return {@code T}
     */
    public <T extends E> T update(T entity) {
        return em.merge(entity);
    }

    /**
     * @param entity Entidade a ser excluída
     */
    public void delete(E entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    /**
     * Exclui um registro pelo {@code id}.
     * @param id
     */
    public void deleteById(P id) {
        findById(id).ifPresent(this::delete);
    }
}
