package ${package};

import java.util.List;
import java.util.ArrayList;
import com.hzwq.mip.common.BaseDaoc;
import ${basePackage}.bo.${boClassName};
${importClass}

/**
* <${boName}> 持久层实现类
* @author ${author}
*/
public class ${boClassName}Daoc extends BaseDaoc implements I${boClassName}Daoc{

    <#list methodList as method>
    //${method.comment}
    public Integer ${method.name}(${boClassName} entity){
        StringBuffer sb = new StringBuffer();
        ${method.sql}

        Object[] params = new Object[]{
            ${method.params}
        };
        return super.update(sb.toString(), params);
    }

    </#list>
    <#list methodList as method>
    //批量${method.comment}
    public Integer batch${method.name?cap_first}(List<${boClassName}> entities){
        StringBuffer sb = new StringBuffer();
        ${method.sql}

        List<Object[]> paramsList = new ArrayList<Object[]>();
        for(${boClassName} entity:entities){
            Object[] params = new Object[]{
                ${method.params}
            };
        }
        return super.batchUpdate(sql, paramsList);
    }

    </#list>
    //查询
    public List<${boClassName}> query${boClassName}(Criteria criteria){
        StringBuffer sb = new StringBuffer();
        ${querySql}

        criteria.clearFilteredValues();
        <#list fieldList as field>
        if(criteria.isNotEmpty("${field.name}")){
            sb.append(" and ${field.dbName} = ? ");
            criteria.addFilteredValue(criteria.getStringValue("${field.name}"));
        }
        </#list>

        return super.queryForList(sb.toString(), criteria.getFilteredValuesByArray(), ${boClassName}.class);
    }

    //分页查询
    public Page queryPage(Criteria criteria){
        StringBuffer sb = new StringBuffer();
        ${querySql}

        criteria.clearFilteredValues();
        <#list fieldList as field>
        if(criteria.isNotEmpty("${field.name}")){
            sb.append(" and ${field.dbName} = ? ");
            criteria.addFilteredValue(criteria.getStringValue("${field.name}"));
        }
        </#list>

        return super.queryForList(sb.toString(), criteria.getFilteredValuesByArray(),
                criteria.getPageNo(), criteria.getPageSize(), ${boClassName}.class);
    }
}