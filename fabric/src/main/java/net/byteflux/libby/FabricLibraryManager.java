package net.byteflux.libby;

import net.byteflux.libby.classloader.URLClassLoaderHelper;
import net.byteflux.libby.logging.adapters.SLF4JLogAdapter;
import org.slf4j.Logger;

import java.nio.file.Path;

/**
 * A runtime dependency manager for Velocity plugins.
 */
public class FabricLibraryManager<T> extends LibraryManager {
    /**
     * Velocity plugin manager used for adding files to the plugin's classpath
     */
    private final URLClassLoaderHelper classLoader;


    private FabricLibraryManager(Logger logger, Path basePath) throws ReflectiveOperationException {
        super(new SLF4JLogAdapter(logger), basePath, "libs");
        classLoader = new URLClassLoaderHelper(KnotUrlClassLoaderHelper.access(), this);
    }

    /**
     * Adds a file to the Velocity plugin's classpath.
     *
     * @param file the file to add
     */
    @Override
    protected void addToClasspath(Path file) {
        classLoader.addToClasspath(file);
    }

}
