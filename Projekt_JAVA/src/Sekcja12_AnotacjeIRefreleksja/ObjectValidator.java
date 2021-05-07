package Sekcja12_AnotacjeIRefreleksja;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjectValidator {
    public static void validate(Object object) throws IllegalAccessException {
        final Class oClass = object.getClass();

        //anotacje na klasie
        processExactlyOneNotNull(object, oClass);


        //anotacje na polach
        //getDeclaredFields pobierze też pola prywatne, samo getFields tylko publiczne

        for (Field field : oClass.getDeclaredFields()) {
            field.setAccessible(true); //dostep do pol prywatnych

            processNotNull(object, field);
            processRegex(object, field);
        }
    }

    private static void processExactlyOneNotNull(Object object, Class oClass) throws IllegalAccessException {
        if (oClass.isAnnotationPresent(ExactlyOneNotNull.class)) {
            ExactlyOneNotNull annotation = (ExactlyOneNotNull) oClass.getAnnotation(ExactlyOneNotNull.class);
            List<Field> fields = new ArrayList<>();

            for (String fieldName : annotation.value()) {
                for (Field field : oClass.getDeclaredFields()) {
                    field.setAccessible(true);

                    if (field.getName().equals(fieldName)) {
                        fields.add(field);
                    }
                }
            }

            int numOfNotNullFields = 0;
            for (Field field : fields) {

                if (field.get(object) != null) {
                    numOfNotNullFields++;
                }
            }
            if (numOfNotNullFields != 1) {
                throw new IllegalAccessException("Exactly one field must be not null");
            }
        }
    }

    private static void processRegex(Object object, Field field) throws IllegalAccessException {
        if (field.isAnnotationPresent(Regex.class)) {
            Regex annotation = field.getAnnotation(Regex.class);
            String fieldValue = (String) field.get(object);

            if (!fieldValue.matches(annotation.value())) {
                throw new IllegalArgumentException(annotation.message());
            }
        }
    }


    private static void processNotNull(Object object, Field field) throws IllegalAccessException {
        if (field.isAnnotationPresent(NotNull.class)) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            String fieldValue = (String) field.get(object);

            if (fieldValue == null) {
                throw new IllegalArgumentException(annotation.message());
            }
        }
    }
}
