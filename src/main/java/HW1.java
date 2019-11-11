import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HW1 {
    public List<String> path(String packag) throws IOException {
        /*String resPaths = packag.replaceAll("\\.", "\\\\");
        List<String> files = new LinkedList<>();
        Files.walk(Paths.get(""))
                .filter(path -> Files.isRegularFile(path)
                        && path.toString().contains(resPaths)
                        && path.toString().endsWith(".class"))
                .collect(Collectors.toList())
                .forEach(path -> files.add(String.join(".",
                        (path.toString().substring(path.toString().indexOf(resPaths)))
                                .split("\\\\"))
                                .replaceAll(".class", "")));*/
        File fileEx = new File("").getCanonicalFile();
        String sourcePath = packag.replaceAll("\\.", "\\\\");
        //File file = new File(System.getProperty("java.class.path").split(";")[0] + "/" + packag.replaceAll("\\.", "/"));
        Queue<File> list = new LinkedList<>();
        List<String> files = new LinkedList<>();
        if (fileEx.exists()) {
            if (fileEx.isDirectory()) {
                Collections.addAll(list, fileEx.listFiles());
            }
            while (!list.isEmpty()) {
                File filePath = list.poll();
                String pathString = filePath.toString();
                if (filePath.isFile() && pathString.contains(sourcePath) && filePath.getName().endsWith(".class")) {
                    files.add(String.join(".",
                            (pathString.substring(pathString.indexOf(sourcePath)))
                                    .split("\\\\"))
                            .replaceAll(".class", ""));
                } else if (filePath.isDirectory()) {
                    Collections.addAll(list, filePath.listFiles());
                }
            }
        }
        return files;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //List<File> path = new HW1().path("org.lesson1.hW1");
        List<String> path = new HW1().path("org.lesson1.hW1");
        for (String cls : path) {
            Class<?> aClass = Class.forName(cls);
            Method toString = aClass.getDeclaredMethod("toString");
            Object o = aClass.getDeclaredConstructor().newInstance();
            System.out.println(toString.invoke(o));
        }
    }
}
