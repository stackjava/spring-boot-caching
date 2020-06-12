package stackjava.com.springbootcaching.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import stackjava.com.springbootcaching.models.User;

@Service
public class UserService {

    @Cacheable("user")
    public User findUserById(int id) {
        simulateSlowService();
        return new User(id, "Any name");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @CacheEvict("user")
    public void clearCacheById(int id) {
    }

    @CacheEvict(value = "user", allEntries = true)
    public void clearCache() {
    }

    @CachePut(value = "user")
    public User reloadAndFindUserById(int id) {
        simulateSlowService();
        return new User(id, "reload Any name");
    }
}
