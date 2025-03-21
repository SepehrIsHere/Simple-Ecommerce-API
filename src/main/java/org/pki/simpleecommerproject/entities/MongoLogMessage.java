package org.pki.simpleecommerproject.entities;

import jakarta.persistence.PrePersist;
import lombok.*;
import org.pki.simpleecommerproject.entities.enumerations.LogMessageType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class MongoLogMessage {
    @Field(name = "message")
    private String message;

    @Field(name = "class_name")
    private String className;

    @Field(name = "method_name")
    private String methodName;

    @Field(name = "log_message_type")
    private LogMessageType type;

    @Field(name = "time")
    private LocalDateTime time;

}
