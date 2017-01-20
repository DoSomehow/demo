package org.ms.util.freemarker.test;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class UpperFirstCharacter implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        // Check if no parameters were given:
        if  (!map.isEmpty()) {
            throw   new TemplateModelException(
                    "This directive doesn't allow parameters." );
        }
        if  (templateModels.length !=  0 ) {
            throw   new  TemplateModelException(
                    "This directive doesn't allow loop variables." );
        }
        // If there is non-empty nested content:
        if  (templateDirectiveBody !=  null ) {
            // Executes the nested body. Same as <#nested> in FTL, except
            // that we use our own writer instead of the current output writer.
            templateDirectiveBody.render(new  UpperCaseFilterWriter(environment.getOut()));
        } else  {
            throw   new  RuntimeException( "missing body" );
        }
    }

    private   static   class  UpperCaseFilterWriter  extends  Writer {
        private   final  Writer out;

        UpperCaseFilterWriter (Writer out) {
            this .out = out;
        }

        public   void  write( char [] cbuf,  int  off,  int  len)
                throws  IOException {
//            char[] transformedCbuf = new char[len];
//            for (int i = 0; i < len; i++) {
//                transformedCbuf[i] = Character.toUpperCase(cbuf[i + off]);
//            }
//            out.write(transformedCbuf);
            cbuf[0 ] = Character.toUpperCase(cbuf[ 0 ]);
            out.write(String.valueOf(cbuf).trim());///把右边空格去掉
        }

        public   void  flush()  throws  IOException {
            out.flush();
        }

        public   void  close()  throws  IOException {
            out.close();
        }
    }
}
