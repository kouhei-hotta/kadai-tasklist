package utils;

import javax.persistence.EntityManager;  // 永続コンテキストと対話するために使用されるインターフェース。
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; // JPAを使ったアクセスの処理


public class TaskelistDBUtil {
    private static final String PERSISTENCE_UNIT_NAME = "tasklist";
    private static EntityManagerFactory emf;

    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        return emf;
    }

}
