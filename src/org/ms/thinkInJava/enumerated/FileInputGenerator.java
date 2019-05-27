package org.ms.thinkInJava.enumerated;

import org.ms.thinkInJava.util.Generator;
import org.ms.thinkInJava.util.TextFile;

import java.util.Iterator;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/27 23:12
 */
public class FileInputGenerator implements Generator<Input> {

    private Iterator<String> input;

    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public Input next() {
        if(!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());  //根据字符串名称，得到对应枚举类型实例
    }
}
