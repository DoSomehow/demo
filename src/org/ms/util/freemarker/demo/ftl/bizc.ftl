package ${package};

import java.util.List;
import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
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
    <#list methodList as method>
    //批量${method.comment}
    public Integer batch${method.name?cap_first}(List<${boClassName}> entities){
        return ${boClassName?uncap_first}Daoc.batch${method.name?cap_first}(entities);
    }

    </#list>
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