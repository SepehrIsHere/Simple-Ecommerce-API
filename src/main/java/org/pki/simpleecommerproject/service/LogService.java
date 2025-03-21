package org.pki.simpleecommerproject.service;

import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.entities.MongoLogMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LogService {
    MongoLogMessage save(MongoLogMessage message);

    void delete(MongoLogMessage message);

    List<MongoLogMessage> findByClassName(String className);

    List<MongoLogMessage> findByMethodName(String methodName);

    List<MongoLogMessage> findExceptionLogs();

    List<MongoLogMessage> findSaveLogs();

    List<MongoLogMessage> findDeleteLogs();

    List<MongoLogMessage> findLoadLogs();

    List<MongoLogMessage> findUpdateLogs();

}
