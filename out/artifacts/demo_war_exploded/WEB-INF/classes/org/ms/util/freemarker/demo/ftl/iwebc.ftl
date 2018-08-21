package ${package};

import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
import org.sotower.webc.context.WebContext;
import ${basePackage}.bo.${boClassName};
${importClass}

/**
* <${boName}> 控制层接口
* @author ${author}
*/
public interface I${boClassName}Webc {
    <#list methodList as method>
    //${method.comment}
    public void ${method.name}(WebContext context);
    </#list>
    //批量增删改
    public void batchCUD(WebContext context);
    //查询
    public void query${boClassName}(WebContext context);
    //分页查询
    public void queryPage(WebContext context);
}