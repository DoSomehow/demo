package ${package};

import org.sotower.webc.context.WebContext;
import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
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
    //查询
    public void query${boClassName}(WebContext context);
    //分页查询
    public void queryPage(WebContext context);
}