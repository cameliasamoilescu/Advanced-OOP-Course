package util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatUtil {
    public static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(50);
}
