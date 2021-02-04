package com.util;

import java.util.function.Function;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;

public class Utils {

    public static List<Integer> convertFileToIntList(File file) {
        return getFileContent(file, (stream) -> stream.mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
    }

    public static List<String> convertFileToStringList(File file) {
        return getFileContent(file, (stream) -> stream.collect(Collectors.toList()));
    }

    public static <V> V getFileContent(File file, Function<Stream<String>,V> processor) {

        try (Stream<String> lines = Files.lines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8)) {
            return processor.apply(lines);
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}