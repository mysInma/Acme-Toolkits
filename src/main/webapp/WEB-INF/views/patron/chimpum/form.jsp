<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
    <acme:input-textbox code="patron.chimpum.form.label.code" path="code"/>
    <acme:input-moment code="patron.chimpum.form.label.creationMoment" path="creationMoment"/>
    <acme:input-textbox code="patron.chimpum.form.label.title" path="title"/>
    <acme:input-textarea code="patron.chimpum.form.label.description" path="description"/>
    <acme:input-moment code="patron.chimpum.form.label.startDate" path="startDate"/>
    <acme:input-moment code="patron.chimpum.form.label.finishDate" path="finishDate"/>
    <acme:input-url code="patron.chimpum.form.label.link" path="link"/>
    
    
      <jstl:choose>
      
      <jstl:when test="${acme:anyOf(command, 'show, update,delete')}"> 
      			 <acme:input-money readonly="true" code="patron.chimpum.form.label.budget" path="budget"/>
				<acme:input-textbox code="patron.chimpum.form.label.codeItem" path="codeItem"/>
				<acme:submit code="patron.chimpum.form.button.delete" action="/patron/chimpum/delete"/>
				<acme:submit code="patron.chimpum.form.button.update" action="/patron/chimpum/update?id=${id}"/>
		</jstl:when>

        <jstl:when test="${command == 'create'}">
        	<acme:input-money code="patron.chimpum.form.label.budget" path="budget"/>
          	<acme:input-select code="patron.chimpum.form.label.item" path="itemId">
            	<jstl:forEach items="${items}" var="item">
                		<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${ item.getId() == itemId}"/>
                </jstl:forEach>
            </acme:input-select>
			<acme:submit code="patron.chimpum.form.button.create" action="/patron/chimpum/create"/>
  
        </jstl:when>
    </jstl:choose>

</acme:form>