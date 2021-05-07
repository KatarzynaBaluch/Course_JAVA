package Sekcja12_AnotacjeIRefreleksja;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCreator {

    public static ICalculator createProxy(Calculator calculator) {
        InvocationHandler invocationHandler = new LoggingInvocationHandler(calculator);

        return (ICalculator) Proxy.newProxyInstance(ProxyCreator.class.getClassLoader(), new Class[]{ICalculator.class}, invocationHandler);
    }
}
