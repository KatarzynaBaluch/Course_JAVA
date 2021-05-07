package Sekcja12_AnotacjeIRefreleksja;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME)
@Target(value = {ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface Author {
    String DEFAULT_NAME="Unknown2"; //tylko stałe, muszą byc zainicjalizowane, stałą można użyć tylko w ciele anitacji

    String name() default "Unknown";

}
