package org.ms.thinkInJava.atunit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import org.ms.thinkInJava.util.BinaryFile;
import org.ms.thinkInJava.util.ProcessFiles;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/4/2 0:23
 */
public class AtUnitRemover implements ProcessFiles.Strategy {

    private static boolean remove = false;

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("-r")) {
            remove = true;
            String[] nargs = new String[args.length - 1];
            System.arraycopy(args, 1, nargs, 0, nargs.length);
            args = nargs;
        }
        new ProcessFiles(new AtUnitRemover(), "class").start(args);
    }

    public void process(File cFile) {
        boolean modified = false;
        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.read(cFile));
            if (!cName.contains(".")) {
                return;  //Ignore unpackaged classes
            }
            ClassPool cPool = ClassPool.getDefault();
            CtClass ctClass = cPool.get(cName);
            for (CtMethod method : ctClass.getDeclaredMethods()) {
                javassist.bytecode.MethodInfo mi = method.getMethodInfo();
                AnnotationsAttribute attr = (AnnotationsAttribute)mi.getAttribute(AnnotationsAttribute.visibleTag);
                if (attr == null) {
                    continue;
                }
                for (javassist.bytecode.annotation.Annotation ann : attr.getAnnotations()) {
                    if (ann.getTypeName().startsWith("net.mindview.atunit")) {
                        System.out.println(ctClass.getName() + " Method: " + mi.getName() + " " + ann);
                        if (remove) {
                            ctClass.removeMethod(method);
                            modified = true;
                        }
                    }
                }
            }

            //Fields are not removed in thid version (see text).
            if (modified) {
                ctClass.toBytecode(new DataOutputStream(new FileOutputStream(cFile)));
            }
            ctClass.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
