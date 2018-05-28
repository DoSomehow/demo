package ${package};

import java.io.Serializable;
import com.hzwq.mip.common.BaseBo;
${importClass}

/**
 * ${boName}
 * @author ${author}
*/
public class ${boClassName} extends BaseBo<${boClassName}> implements Serializable {
    private static final long serialVersionUID = 1L;
    <#list fieldList as field>
    private ${field.type} ${field.name};
    </#list>


    <#list fieldList as field>
    public ${field.type} get${field.name?cap_first}() {
        return ${field.name};
    }
    public void set${field.name?cap_first}(${field.type} ${field.name}) {
        this.${field.name} = ${field.name};
    }
    </#list>
}