package ${package};

import java.util.List;
import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
import ${basePackage}.bo.${boClassName};
import ${basePackage}.daoc.I${boClassName}Daoc;
${importClass}

/**
* <${boName}> 服务层实现类
* @author ${author}
*/
public class ${boClassName}Bizc implements I${boClassName}Bizc {

    private I${boClassName}Daoc ${boClassName?uncap_first}Daoc;

    <#list methodList as method>
    //${method.comment}
    public Integer ${method.name}(${boClassName} entity){
        return ${boClassName?uncap_first}Daoc.${method.name}(entity);
    }

    </#list>
    //批量增删改
    public Integer batchCUD(<#list methodList as method>List<${boClassName}> ${method.name}s<#if method_has_next = true>, </#if></#list>){
        Integer num = 0;
        <#list methodList as method>
        //批量${method.comment}
        if(${method.name}s != null && ${method.name}s.size() != 0){
            num += ${boClassName?uncap_first}Daoc.batch${method.name?cap_first}(${method.name}s);
        }
        </#list>
        return num;
    }

    //查询
    public List<${boClassName}> query${boClassName}(Criteria criteria){
        return ${boClassName?uncap_first}Daoc.query${boClassName}(criteria);
    }

    //分页查询
    public Page queryPage(Criteria criteria){
        return ${boClassName?uncap_first}Daoc.queryPage(criteria);
    }


    public I${boClassName}Daoc get${boClassName}Daoc() {
        return ${boClassName?uncap_first}Daoc;
    }

    public void set${boClassName}Daoc(I${boClassName}Daoc ${boClassName?uncap_first}Daoc) {
        this.${boClassName?uncap_first}Daoc = ${boClassName?uncap_first}Daoc;
    }

}