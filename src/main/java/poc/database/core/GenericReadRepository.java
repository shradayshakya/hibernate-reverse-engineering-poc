package poc.database.core;

import io.micronaut.data.annotation.Repository;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.slf4j.LoggerFactory.*;

@Repository
public abstract class GenericReadRepository {
    private static final Logger LOG = getLogger(GenericReadRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    GenericReadRepository(EntityManager em) {
        this.entityManager = em;
    }

    @Transactional
    public <T> T findById(Class<T> resourceClass, BigDecimal id) {
        try {
            var instance = entityManager.find(resourceClass, id);
            LOG.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }

    @Transactional
    public <T> List<T> findAll(Class<T> resourceClass) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(resourceClass);
            Root<T> rootEntry = cq.from(resourceClass);
            CriteriaQuery<T> all = cq.select(rootEntry);
            TypedQuery<T> allQuery = entityManager.createQuery(all);
            LOG.debug("get successful");

            return allQuery.getResultList();
        }
        catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
