package Sekcja12_AnotacjeIRefreleksja;

import Sekcja11_KolekcjeIMapy.HashColor;
import Sekcja11_KolekcjeIMapy.HashMap.HashMapMain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class LoggingInvocationHandler implements InvocationHandler {

    private final Object targetObject;

    private final Map<String, Method> methods = new HashMap<>();

    public LoggingInvocationHandler(Calculator targetObject) {
        this.targetObject = targetObject;
        for (Method method : targetObject.getClass().getMethods()) {
            if (method.isAnnotationPresent(LogInutParams.class)) {
                methods.put(method.getName(), method);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (methods.containsKey(method.getName())) {
            for (int i = 0; i < method.getParameters().length; i++) {
                System.out.println(String.format("Param %s = %s", method.getParameters()[i].getName(), args[i]));
            }
        }

        return method.invoke(targetObject, args);
    }
}
