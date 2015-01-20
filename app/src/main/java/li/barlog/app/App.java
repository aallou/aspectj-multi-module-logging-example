package li.barlog.app;

import li.barlog.logging.annotation.LogAsUserAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String... args) {
		new App().run();
	}

	@LogAsUserAction
	public void logFoo() {
		log.debug("foo");
	}

	@Override
	public void run() {
		logFoo();
	}
}