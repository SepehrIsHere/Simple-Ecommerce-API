package org.pki.simpleecommerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.entities.MongoLogMessage;
import org.pki.simpleecommerproject.exception.LogOperationException;
import org.pki.simpleecommerproject.exception.NoResultFoundException;
import org.pki.simpleecommerproject.service.LogService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private MongoTemplate template;

    @Override
    public MongoLogMessage save(MongoLogMessage message) {
        try {
            return template.save(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(MongoLogMessage message) {
        try {
            template.remove(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findByClassName(String className) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("className").is(className));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findByMethodName(String methodName) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("methodName").is(methodName));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findExceptionLogs() {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is("EXCEPTION"));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findSaveLogs() {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is("SAVE"));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findDeleteLogs() {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is("DELETE"));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findLoadLogs() {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is("LOAD"));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }

    @Override
    public List<MongoLogMessage> findUpdateLogs() {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is("UPDATE"));
            List<MongoLogMessage> result = template.find(query, MongoLogMessage.class);
            if (result.isEmpty()) {
                throw new NoResultFoundException("No results been found");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
    }
}
