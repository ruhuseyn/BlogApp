package rufethuseynov.blogapp.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class QLogger {

    final Logger logger;

    public QLogger(Logger logger) {
        this.logger = logger;
    }

    public static QLogger getLogger(Class<?> clazz) {
        Logger logger = (Logger) LoggerFactory.getLogger(clazz);
        return new QLogger(logger);
    }

    public String getName() {
        return logger.getName();
    }
}
