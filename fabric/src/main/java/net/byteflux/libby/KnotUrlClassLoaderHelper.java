package net.byteflux.libby;

import java.lang.reflect.Field;
import java.net.URLClassLoader;

public class KnotUrlClassLoaderHelper {

    public static URLClassLoader access() throws ReflectiveOperationException {

        ClassLoader classLoader = KnotUrlClassLoaderHelper.class.getClassLoader();

        if(!classLoader.getClass().getName().equals("net.fabricmc.loader.impl.launch.knot.KnotClassLoader")){
            throw new RuntimeException("This class loader is not compatible");
        }

        Field urlLoader = classLoader.getClass().getDeclaredField("urlLoader");
        urlLoader.setAccessible(true);

        return (URLClassLoader) urlLoader.get(classLoader);

    }

}
