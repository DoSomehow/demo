<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:webc="http://www.sgcc.com.cn/schema/sotower/webc"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
       http://www.sgcc.com.cn/schema/sotower/webc http://www.sgcc.com.cn/schema/sotower/webc/webc.xsd">

    <bean id="${boClassName?uncap_first}Daoc" class="${basePackage}.daoc.${boClassName}Daoc">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>

    <bean id="${boClassName?uncap_first}Bizc" class="${basePackage}.bizc.${boClassName}Bizc">
        <property name="${boClassName?uncap_first}Daoc" ref="${boClassName?uncap_first}Daoc"/>
    </bean>

    <webc:page id="${boClassName?uncap_first}Webc" >
        <webc:implementation target="${basePackage}.webc.${boClassName}Webc"/>
        <webc:service interface="${basePackage}.webc.I${boClassName}Webc"/>
        <webc:reference target="${boClassName?uncap_first}Bizc" type="bean"/>
        <webc:reference name="collection" target="${boClassName?uncap_first}Collection" type="bean"/>
        <webc:reference name="forwardView" target="forwardView0" type="forwardView"/>

        <webc:forwardSpecMap>
        <#list methodList as method>
            <webc:forwardSpec actionName="${method.name}" target="mip/${boClassName?uncap_first}Webc/queryPage.so" type="forward"/>
        </#list>
            <webc:forwardSpec actionName="batchCUD" target="mip/${boClassName?uncap_first}Webc/queryPage.so" type="forward"/>
            <webc:forwardSpec actionName="query${boClassName}" target="jsp/${moduleName}/${boClassName?uncap_first}/list.jsp" type="forward"/>
            <webc:forwardSpec actionName="queryPage" target="jsp/${moduleName}/${boClassName?uncap_first}/list.jsp" type="forward"/>

            <!-- ajax示例 -->
            <!-- <webc:forwardSpec actionName="save" target="" type="ajax"/> -->
        </webc:forwardSpecMap>
    </webc:page>

    <util:map id="${boClassName?uncap_first}Collection">
        <!-- <entry key="" value-ref=""/> -->
    </util:map>
</beans>
