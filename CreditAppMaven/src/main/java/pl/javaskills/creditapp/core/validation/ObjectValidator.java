package pl.javaskills.creditapp.core.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.annotation.ExactlyOneNotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.scoring.CompaundScoringCalculator;
import pl.javaskills.creditapp.core.validation.reflection.ClassAnnotationProcessor;
import pl.javaskills.creditapp.core.validation.reflection.FieldAnnotationProcessor;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class ObjectValidator {

    private final List<FieldAnnotationProcessor> fieldAnnotationProcessors;
    private final List<ClassAnnotationProcessor> classAnnotationProcessors;
    private static Logger log = LoggerFactory.getLogger(CompaundScoringCalculator.class);


    public ObjectValidator(List<FieldAnnotationProcessor> fieldAnnotationProcessors, List<ClassAnnotationProcessor> classAnnotationProcessors) {
        this.fieldAnnotationProcessors = fieldAnnotationProcessors;
        this.classAnnotationProcessors = classAnnotationProcessors;
    }

    public void validate(Object object) throws IllegalAccessException, ValidationException {
        if(object!=null)
        {
            final Class oClass = object.getClass();
            final Class superClass=object.getClass().getSuperclass();

            log.debug("Starting validation of class: " + oClass.getSimpleName());

            processClass(object, oClass);
            processClass(object, superClass);
        }


    }

    private void processClass(Object object, Class oClass) throws IllegalAccessException, ValidationException {
        //anotacje na klasie
        for (ClassAnnotationProcessor processor : classAnnotationProcessors) {
            processor.process(object, oClass);
        }

        //anotacje na polach
        //getDeclaredFields pobierze też pola prywatne, samo getFields tylko publiczne

        for (Field field : oClass.getDeclaredFields()) {
            processField(object, field);
        }
    }

    private void processField(Object object, Field field) throws IllegalAccessException, ValidationException {
        log.debug("Starting validation of field: " + field.getName());
        field.setAccessible(true); //dostep do pol prywatnych

        for (FieldAnnotationProcessor processor : fieldAnnotationProcessors) {
            processor.process(object, field);
        }
        Object fieldObject = field.get(object);
        if (field.isAnnotationPresent(ValidateObject.class)) {
            validate(fieldObject);
        } else if (field.isAnnotationPresent(ValidateCollection.class)) {
           Collection<Object> collection =(Collection<Object>) fieldObject;
            for (Object element : collection) {
                validate(element);
            }

        }
    }
}

