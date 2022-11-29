package com.hali.spring;

import de.flapdoodle.embed.mongo.commands.MongodArguments;
import de.flapdoodle.embed.mongo.spring.autoconfigure.TypedBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@TestConfiguration
public class EmbeddedMongoDBTransactionalConfig {
    @Bean
    BeanPostProcessor mongodArgumentsPostProcessor() {
        return new TypedBeanPostProcessor<>(MongodArguments.class, EmbeddedMongoDBTransactionalConfig::enableTransaction, Function.identity());
    }

    private static MongodArguments enableTransaction(MongodArguments src) {
        return MongodArguments.builder()
                .from(src)
                .useNoJournal(false)
                .build();
    }
}
