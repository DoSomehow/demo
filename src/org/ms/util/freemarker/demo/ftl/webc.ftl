package ${package};

import java.util.List;
import org.sotower.util.Page;
import com.hzwq.mip.common.Criteria;
import org.sotower.webc.context.WebContext;
import ${basePackage}.bo.${boClassName};
import ${basePackage}.bizc.I${boClassName}Bizc;
${importClass}

/**
* <${boName}> 控制层实现类
* @author ${author}
*/
public class ${boClassName}Webc extends BaseWebc implements I${boClassName}Webc {

    private I${boClassName}Bizc ${boClassName?uncap_first}Bizc;

    <#list methodList as method>
    //${method.comment}
    public void ${method.name}(WebContext context){
        ${boClassName} ${boClassName?uncap_first} = super.bindFormData(context, ${boClassName}.class);
        ${boClassName?uncap_first}Bizc.${method.name}(${boClassName?uncap_first});
    }

    </#list>
    //批量增删改
    public void batchCUD(WebContext context){
        List<${boClassName}>[] array = super.bindEditgridData(context, ${boClassName}.class, "${boClassName}Grid");
        //增：array[0] 改：array[1] 删：array[2]，请据此确认与batchCUD方法中参数的对应关系
        ${boClassName?uncap_first}Bizc.batchCUD(array[0], array[1], array[2]);
    }

    //查询
    public void query${boClassName}(WebContext context){
        Criteria criteria = new Criteria();
        super.bindSearchData(context, criteria);

        List<${boClassName}> dataList = ${boClassName?uncap_first}Bizc.query${boClassName}(criteria);

        super.setSearchData(context);
        super.setFlexgridData(context, dataList);
    }

    //分页查询
    public void queryPage(WebContext context){
        Criteria criteria = new Criteria();
        super.bindSearchData(context, criteria);
        super.bindPagepolitData(context, criteria);

        Page page = ${boClassName?uncap_first}Bizc.queryPage(criteria);
        if(page==null){
            page=new Page(null, criteria.getPageSize(), criteria.getPageNo(), 0, null);
        }

        super.setSearchData(context);
        super.setPagepolitData(context, page);
        super.setFlexgridData(context, page.getDatas());
    }


    public I${boClassName}Bizc get${boClassName}Bizc() {
        return ${boClassName?uncap_first}Bizc;
    }

    public void set${boClassName}Bizc(I${boClassName}Bizc ${boClassName?uncap_first}Bizc) {
        this.${boClassName?uncap_first}Bizc = ${boClassName?uncap_first}Bizc;
    }
}