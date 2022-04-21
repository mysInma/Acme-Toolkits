<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<style>
.column {
  float: left;
  width: 50%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
<acme:form readonly="true">
   <div>
	   	<strong><acme:message code="patron.patron-dashboard.form.label.total-components"/>:</strong> ${totalNumberOfComponents}
	   	<br>
	   	<div class="row">
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.average-components"/>
		      <canvas id="average-components-canvas"></canvas>
		   </div>
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.deviation-components"/>
		      <canvas id="deviation-components-canvas"></canvas>
		   </div>
	   	</div>
	   	<br>
	   	<div class="row">
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.minimum-components"/>
		      <canvas id="minimum-components-canvas"></canvas>
		   </div>
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.maximum-components"/>
		      <canvas id="maximum-components-canvas"></canvas>
		   </div>
	   	</div>
   </div>
   <div>
	   	<strong><acme:message code="patron.patron-dashboard.form.label.total-tools"/>:</strong> ${totalNumberOfTools}
	   	<br>
	   	<div class="row">
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.average-tools"/>
		      <canvas id="average-tools-canvas"></canvas>
		   </div>
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.deviation-tools"/>
		      <canvas id="deviation-tools-canvas"></canvas>
		   </div>
	   	</div>
	   	<br>
	   	<div class="row">
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.minimum-tools"/>
		      <canvas id="minimum-tools-canvas"></canvas>
		   </div>
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.maximum-tools"/>
		      <canvas id="maximum-tools-canvas"></canvas>
		   </div>
	   	</div>
   </div>
   <div>
	   	<strong><acme:message code="patron.patron-dashboard.form.label.total-patronages"/>:</strong> ${totalNumberOfPatronagesByStatus}
	   	<br>
	   	<div class="row">
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.average-patronages"/>
		      <canvas id="average-patronages-canvas"></canvas>
		   </div>
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.deviation-patronages"/>
		      <canvas id="deviation-patronages-canvas"></canvas>
		   </div>
	   	</div>
	   	<br>
	   	<div class="row">
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.minimum-patronages"/>
		      <canvas id="minimum-patronages-canvas"></canvas>
		   </div>
		   <div class="column">
		      <acme:message code="patron.patron-dashboard.form.label.maximum-patronages"/>
		      <canvas id="maximum-patronages-canvas"></canvas>
		   </div>
	   	</div>
   </div>
</acme:form>
<!-- Components -->
<script type="text/javascript">
   var averageRetailPriceOfComponentsByTechnologyCurrency = {
   	   	<jstl:forEach items="${averageRetailPriceOfComponentsByTechnologyCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const average_components_data = {
    labels: Object.keys(averageRetailPriceOfComponentsByTechnologyCurrency),
    datasets: [{
      data: Object.values(averageRetailPriceOfComponentsByTechnologyCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("average-components-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : average_components_data,
   });
</script>
<script type="text/javascript">
   var deviationRetailPriceOfComponentsByTechnologyCurrency = {
   	   	<jstl:forEach items="${deviationRetailPriceOfComponentsByTechnologyCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const deviation_components_data = {
    labels: Object.keys(deviationRetailPriceOfComponentsByTechnologyCurrency),
    datasets: [{
      data: Object.values(deviationRetailPriceOfComponentsByTechnologyCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("deviation-components-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : deviation_components_data,
   });
</script>
<script type="text/javascript">
   var minimumRetailPriceOfComponentsByTechnologyCurrency = {
   	   	<jstl:forEach items="${minimumRetailPriceOfComponentsByTechnologyCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const minimum_components_data = {
    labels: Object.keys(minimumRetailPriceOfComponentsByTechnologyCurrency),
    datasets: [{
      data: Object.values(minimumRetailPriceOfComponentsByTechnologyCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("minimum-components-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : minimum_components_data,
   });
</script>
<script type="text/javascript">
   var maximumRetailPriceOfComponentsByTechnologyCurrency = {
   	   	<jstl:forEach items="${maximumRetailPriceOfComponentsByTechnologyCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const maximum_components_data = {
    labels: Object.keys(maximumRetailPriceOfComponentsByTechnologyCurrency),
    datasets: [{
      data: Object.values(maximumRetailPriceOfComponentsByTechnologyCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("maximum-components-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : maximum_components_data,
   });
</script>
<!-- Tools -->
<script type="text/javascript">
   var averageRetailPriceOfToolsByCurrency = {
   	   	<jstl:forEach items="${averageRetailPriceOfToolsByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const average_tools_data = {
    labels: Object.keys(averageRetailPriceOfToolsByCurrency),
    datasets: [{
      data: Object.values(averageRetailPriceOfToolsByCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("average-tools-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : average_tools_data,
   });
</script>
<script type="text/javascript">
   var deviationRetailPriceOfToolsByCurrency = {
   	   	<jstl:forEach items="${deviationRetailPriceOfToolsByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const deviation_tools_data = {
    labels: Object.keys(deviationRetailPriceOfToolsByCurrency),
    datasets: [{
      data: Object.values(deviationRetailPriceOfToolsByCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("deviation-tools-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : deviation_tools_data,
   });
</script>
<script type="text/javascript">
   var minimumRetailPriceOfToolsByCurrency = {
   	   	<jstl:forEach items="${minimumRetailPriceOfToolsByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const minimum_tools_data = {
    labels: Object.keys(minimumRetailPriceOfToolsByCurrency),
    datasets: [{
      data: Object.values(minimumRetailPriceOfToolsByCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("minimum-tools-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : minimum_tools_data,
   });
</script>
<script type="text/javascript">
   var maximumRetailPriceOfToolsByCurrency = {
   	   	<jstl:forEach items="${maximumRetailPriceOfToolsByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const maximum_tools_data = {
    labels: Object.keys(maximumRetailPriceOfToolsByCurrency),
    datasets: [{
      data: Object.values(maximumRetailPriceOfToolsByCurrency),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("maximum-tools-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : maximum_tools_data,
   });
</script>
<!-- Patronages -->
<script type="text/javascript">
   var averagePatronagesBudgetByStatus = {
   	   	<jstl:forEach items="${averagePatronagesBudgetByStatus}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const average_patronages_data = {
    labels: Object.keys(averagePatronagesBudgetByStatus),
    datasets: [{
      data: Object.values(averagePatronagesBudgetByStatus),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("average-patronages-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : average_patronages_data,
   });
</script>
<script type="text/javascript">
   var deviationPatronagesBudgetByStatu = {
   	   	<jstl:forEach items="${deviationPatronagesBudgetByStatu}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const deviation_patronages_data = {
    labels: Object.keys(deviationPatronagesBudgetByStatu),
    datasets: [{
      data: Object.values(deviationPatronagesBudgetByStatu),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("deviation-patronages-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : deviation_patronages_data,
   });
</script>
<script type="text/javascript">
   var minimumPatronagesBudgetByStatus = {
   	   	<jstl:forEach items="${minimumPatronagesBudgetByStatus}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const minimum_patronages_data = {
    labels: Object.keys(minimumPatronagesBudgetByStatus),
    datasets: [{
      data: Object.values(minimumPatronagesBudgetByStatus),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("minimum-patronages-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : minimum_patronages_data,
   });
</script>
<script type="text/javascript">
   var maximumPatronagesBudgetByStatus = {
   	   	<jstl:forEach items="${maximumPatronagesBudgetByStatus}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const maximum_patronages_data = {
    labels: Object.keys(maximumPatronagesBudgetByStatus),
    datasets: [{
      data: Object.values(maximumPatronagesBudgetByStatus),
      backgroundColor: [
    	  "rgb(250, 110, 238)",
    	  "rgb(225, 114, 238)",
    	  "rgb(199, 116, 235)",
    	  "rgb(174, 117, 230)",
    	  "rgb(150, 117, 223)",
    	  "rgb(127, 116, 214)",
    	  "rgb(105, 114, 203)",
    	  "rgb(85, 111, 191)",
    	  "rgb(67, 107, 177)",
    	  "rgb(53, 103, 163)",
    	  "rgb(43, 97, 148)",
    	  "rgb(38, 92, 133)",
    	  "rgb(37, 85, 117)",
    	  "rgb(39, 79, 102)",
    	  "rgb(42, 72, 88)"
        ]
    }]
   };
   
   var canvas = document.getElementById("maximum-patronages-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : maximum_patronages_data,
   });
</script>