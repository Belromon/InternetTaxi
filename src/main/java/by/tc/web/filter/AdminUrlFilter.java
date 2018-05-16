package by.tc.web.filter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class AdminUrlFilter implements Filter{
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
