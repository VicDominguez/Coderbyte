package vicdominguez;

import com.google.common.collect.Lists;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private final static String PACKAGE_NAME = "vicdominguez.coderbyte.solutions";

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException
    {
        List<Class<?>> packageClasses = readPackage();
        Class solutionToExecute = menu(packageClasses);
        execute(solutionToExecute);
    }

    private static List<Class<?>> readPackage() throws IOException
    {
        List<Class<?>> classes = Lists.newArrayList();
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();

        for(final ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses())
        {
            if(info.getName().startsWith(PACKAGE_NAME))
                classes.add(info.load());
        }
        return classes;
    }

    private static Class menu(List<Class<?>> classes)
    {
        int option, lastPointIndex, elementNumber = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a solution");
        do {
            for (Class<?> item : classes) {
                String name = item.getName(), pattern = "Option %d: solution %s";
                lastPointIndex = name.lastIndexOf(".");
                System.out.println(String.format(pattern, elementNumber, name.substring(lastPointIndex + 1)));
                elementNumber++;
            }
            option = sc.nextInt();
        } while (option < 1 || option > classes.size());

        return classes.get(option - 1);
    }

    //TODO: fix newInstance() method
    private static void execute(Class solution) throws InstantiationException, IllegalAccessException {
        if (Runnable.class.isAssignableFrom(solution)) {
            Runnable item = (Runnable) solution.newInstance();
            item.run();
        }
    }
}
