<%@page language="java"%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1>
	<acme:message code="xustemu.dashboard.form.label.title" />
</h1>
<h2>
	<acme:message code="xustemu.dashboard.form.label.toolsWithXustemu"/>
	<acme:print value="${totalNumberOfToolsWithXustemu}" />
</h2>

<table class="table table-sm">
	<jstl:forEach items="${ currency }" var="currency">
		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
				<jstl:set
					value="${ averageAmountOfToolsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
					var="entrySet" />
				<jstl:if test="${ entrySet.hasNext() }">
					<jstl:forEach items="${ entrySet }" var="entry">
						<th scope="row">
							<acme:message code="xustemu.dashboard.form.label.averageAmountOfToolsByCurrency" />
							<acme:print value="${ entry.getValue() }" />
						</th>
					</jstl:forEach>
				</jstl:if>
		</tr>
	</jstl:forEach>
	<jstl:forEach items="${ currency }" var="currency">
		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
				<jstl:set
					value="${ deviationAmountOfToolsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
					var="entrySet" />
				<jstl:if test="${ entrySet.hasNext() }">
					<jstl:forEach items="${ entrySet }" var="entry">
						<th scope="row">
							<acme:message code="xustemu.dashboard.form.label.deviationAmountOfToolsByCurrency" />
							<acme:print value="${ entry.getValue() }" />
						</th>
					</jstl:forEach>
				</jstl:if>
		</tr>
	</jstl:forEach>
	<jstl:forEach items="${ currency }" var="currency">
		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
				<jstl:set
					value="${ minimumAmountOfToolsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
					var="entrySet" />
				<jstl:if test="${ entrySet.hasNext() }">
					<jstl:forEach items="${ entrySet }" var="entry">
						<th scope="row">
							<acme:message code="xustemu.dashboard.form.label.minimumAmountOfToolsByCurrency" />
							<acme:print value="${ entry.getValue() }" />
						</th>
					</jstl:forEach>
				</jstl:if>
		</tr>
	</jstl:forEach>
	<jstl:forEach items="${ currency }" var="currency">
		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
				<jstl:set
					value="${ maximumAmountOfToolsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
					var="entrySet" />
				<jstl:if test="${ entrySet.hasNext() }">
					<jstl:forEach items="${ entrySet }" var="entry">
						<th scope="row">
							<acme:message code="xustemu.dashboard.form.label.maximumAmountOfToolsByCurrency" />
							<acme:print value="${ entry.getValue() }" />
						</th>
					</jstl:forEach>
				</jstl:if>
		</tr>
	</jstl:forEach>
</table>

<h2>
	<acme:message code="xustemu.dashboard.form.label.componentsWithXustemu"/>
	<acme:print value="${totalNumberOfComponentsWithXustemu}" />
</h2>

<table class="table table-sm">
	<jstl:forEach items="${ currency }" var="currency">

		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
			<jstl:set
				value="${ averageAmountOfComponentsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
				var="entrySet" />
			<jstl:if test="${ entrySet.hasNext() }">
				<jstl:forEach items="${ entrySet }" var="entry">

					<th scope="row">
						<acme:message code="xustemu.dashboard.form.label.averageAmountOfComponentsByCurrency" />
						<acme:print value="${ entry.getValue() }" />
					</th>

				</jstl:forEach>
			</jstl:if>
		</tr>
	</jstl:forEach>
	<jstl:forEach items="${ currency }" var="currency">

		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
			<jstl:set
				value="${ deviationAmountOfComponentsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
				var="entrySet" />
			<jstl:if test="${ entrySet.hasNext() }">
				<jstl:forEach items="${ entrySet }" var="entry">

					<th scope="row">
						<acme:message code="xustemu.dashboard.form.label.deviationAmountOfComponentsByCurrency"/>
						<acme:print value="${ entry.getValue() }" />
					</th>

				</jstl:forEach>
			</jstl:if>
		</tr>
	</jstl:forEach>
	<jstl:forEach items="${ currency }" var="currency">

		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
			<jstl:set
				value="${ minimumAmountOfComponentsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
				var="entrySet" />
			<jstl:if test="${ entrySet.hasNext() }">
				<jstl:forEach items="${ entrySet }" var="entry">

					<th scope="row">
						<acme:message code="xustemu.dashboard.form.label.minimumAmountOfComponentsByCurrency"/>
						<acme:print value="${ entry.getValue() }" />
					</th>

				</jstl:forEach>
			</jstl:if>
		</tr>
	</jstl:forEach>
	<jstl:forEach items="${ currency }" var="currency">

		<tr>
			<th scope="row"><acme:print value="${ currency }" /></th>
			<jstl:set
				value="${ maximumAmountOfComponentsByCurrency.entrySet().stream().filter(e -> e.getKey().equals(currency)).iterator() }"
				var="entrySet" />
			<jstl:if test="${ entrySet.hasNext() }">
				<jstl:forEach items="${ entrySet }" var="entry">

					<th scope="row">
						<acme:message code="xustemu.dashboard.form.label.maximumAmountOfComponentsByCurrency"/>
						<acme:print value="${ entry.getValue() }" />
					</th>

				</jstl:forEach>
			</jstl:if>
		</tr>
	</jstl:forEach>
</table>

<h2>
	<acme:message code="xustemu.dashboard.form.title.artifacts-xustemu"/>
</h2>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
					  "COMPONENTS WITH XUSTEMU"
			],
			datasets : [
				{
					data : [
						
						<jstl:out value="${totalNumberOfComponentsWithXustemu}"/>, 
						 
					]
				}
			]
		};
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0,
							suggestedMax : 10
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
	
		var canvas, context;
	
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>

<acme:return/>
