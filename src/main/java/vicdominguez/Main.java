package vicdominguez;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.reflect.*;

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
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a solution");
        do {
            for (Class<?> item : classes)
                System.out.println(item);
            option = sc.nextInt();
        } while (option < 0 || option >= classes.size());

        return classes.get(option);
    }

    private static void execute (Class solution) throws InstantiationException, IllegalAccessException
    {
        if(Runnable.class.isAssignableFrom(solution))
        {
            Runnable item = (Runnable) solution.newInstance();
            item.run();
        }
    }
}
