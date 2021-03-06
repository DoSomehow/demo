package ${package};

import java.util.List;
import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
import ${basePackage}.bo.${boClassName};
${importClass}

/**
 * <${boName}> 持久层接口
 * @author ${author}
 */
public interface I${boClassName}Daoc {
    <#list methodList as method>
    //${method.comment}
    public Integer ${method.name}(${boClassName} entity);
    </#list>
    <#list methodList as method>
    //批量${method.comment}
    public Integer batch${method.name?cap_first}(List<${boClassName}> entities);
    </#list>
    //查询
    public List<${boClassName}> query${boClassName}(Criteria criteria);
    //分页查询
    public Page queryPage(Criteria criteria);
}