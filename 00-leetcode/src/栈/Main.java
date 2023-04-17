package 栈;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author one
 * @description TODO
 * @date 2023-3-29
 */
public class Main {
    private static final ThreadLocal<List<Long>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                List<Long> ids = threadLocal.get();
                if (ids == null) {
                    ids = new LinkedList<>();
                    threadLocal.set(ids);
                }
                ids.add(1L);
            } finally {
//                threadLocal.remove();
            }
        });
        executorService.execute(() -> {
            List<Long> ids = threadLocal.get();
            if (ids == null) {
                ids = new LinkedList<>();
                threadLocal.set(ids);
            }
            ids.add(2L);
            System.out.println(threadLocal.get());
        });
    }
}
