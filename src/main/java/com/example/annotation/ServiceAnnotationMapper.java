package com.example.annotation;

import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.Internal;
import io.micronaut.inject.annotation.TypedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;

import java.util.LinkedList;
import java.util.List;

@Internal
public class ServiceAnnotationMapper implements TypedAnnotationMapper<Service> {

    @Override
    public Class<Service> annotationType() {
        return Service.class;
    }

    @Override
    public List<AnnotationValue<?>> map(AnnotationValue<Service> annotation, VisitorContext visitorContext) {
        List<AnnotationValue<?>> mappedAnnotations = new LinkedList<>();
        mappedAnnotations.add(AnnotationValue.builder(io.micronaut.context.annotation.Bean.class).build());
        mappedAnnotations.add(AnnotationValue.builder(io.micronaut.context.annotation.DefaultScope.class)
                .value(jakarta.inject.Singleton.class)
                .build());
        return mappedAnnotations;
    }
}