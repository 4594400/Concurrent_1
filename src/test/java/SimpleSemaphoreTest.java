import static org.testng.Assert.*;

public class SimpleSemaphoreTest {

    @org.testng.annotations.Test
    public void testGetAvailablePermits() throws Exception {
        SimpleSemaphore simpleSemaphore = new SimpleSemaphore();

        new Thread(new Producer(2000, simpleSemaphore, 3)).start();

        new Thread(new Consumer(1, simpleSemaphore)).start();
        new Thread(new Consumer(2, simpleSemaphore, 3)).start();

        assertTrue(simpleSemaphore.getAvailablePermits()<4);


    }
}