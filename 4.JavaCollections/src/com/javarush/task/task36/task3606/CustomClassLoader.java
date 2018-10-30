package com.javarush.task.task36.task3606;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomClassLoader extends ClassLoader {

    private static final Logger LOG = LoggerFactory.getLogger(CustomClassLoader.class);

    private String pathToFiles;

    public CustomClassLoader(String pathToFiles) {
        this.pathToFiles = pathToFiles.substring(1);
    }

    public Class findClass(Path path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return defineClass(pathToFullClassname(path), bytes, 0, bytes.length);
    }

    public Set<Class> loadAllClasses()  throws ClassNotFoundException {
        LOG.debug("Loading all classes in: " + pathToFiles);
        Set<Class> classes = new HashSet<>();
        List<Path> paths = null;
        try {
            paths = Files.walk(Paths.get(pathToFiles))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Path path : paths) {
            classes.add(findClass(path));
        }

        return classes;
    }

    private String pathToFullClassname(Path path) {
        return path.toString()
                .replaceAll("[\\\\/]", ".")
                .replaceFirst(".*.com", "com")
                .replaceFirst(".class", "");
    }
}
