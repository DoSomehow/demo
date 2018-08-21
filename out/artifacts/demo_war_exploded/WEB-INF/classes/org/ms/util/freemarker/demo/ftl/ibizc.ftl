package ${package};

import java.util.List;
import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
import ${basePackage}.bo.${boClassName};
${importClass}

/**
* <${boName}> 服务层接口
* @author ${author}
*/
public interface I${boClassName}Bizc {
    <#list methodList as method>
    //${method.comment}
    public Integer ${method.name}(${boClassName} entity);
    </#list>
    //批量增删改
    public Integer batchCUD(<#list methodList as method>List<${boClassName}> ${method.name}s<#if method_has_next = true>, </#if></#list>);
    //查询
    public List<${boClassName}> query${boClassName}(Criteria criteria);
    //分页查询
    public Page queryPage(Criteria criteria);
}