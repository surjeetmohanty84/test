package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DetectDeadLock {

	public static void main(String[] args) {
		ThreadMXBean bean= ManagementFactory.getThreadMXBean();
		long[] threadIds=bean.findDeadlockedThreads();
		boolean test=threadIds!=null && threadIds.length>0;
		System.out.println("Dead Lock Found:"+ test);
	}

}
