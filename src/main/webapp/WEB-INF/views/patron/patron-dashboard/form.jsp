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
   	  <acme:message code="patron.patron-dashboard.form.label.total"/>
      <canvas id="total-canvas"></canvas>
   </div>
   <br>
   <div class="row">
	   <div class="column">
	      <acme:message code="patron.patron-dashboard.form.label.average"/>
	      <canvas id="average-canvas"></canvas>
	   </div>
	   <div class="column">
	      <acme:message code="patron.patron-dashboard.form.label.deviation"/>
	      <canvas id="deviation-canvas"></canvas>
	   </div>
   </div>
   <br>
   <div class="row">
	   <div class="column">
	      <acme:message code="patron.patron-dashboard.form.label.min"/>
	      <canvas id="min-canvas"></canvas>
	   </div>
	   <div class="column">
	      <acme:message code="patron.patron-dashboard.form.label.max"/>
	      <canvas id="max-canvas"></canvas>
	   </div>
   </div>
</acme:form>
<script type="text/javascript">
   var totalNumberOfPatronagesByStatus = {
   	<jstl:forEach items="${totalNumberOfPatronagesByStatus}" var="item" varStatus="loop">
   	      ${item.key}: '${item.value}' ${not loop.last ? ',' : ''}
   	</jstl:forEach>
   };
   
   const total_data = {
     labels: Object.keys(totalNumberOfPatronagesByStatus),
     datasets: [{
       data: Object.values(totalNumberOfPatronagesByStatus),
       backgroundColor: [
         'rgba(255, 99, 132, 0.2)',
         'rgba(255, 159, 64, 0.2)',
         'rgba(255, 205, 86, 0.2)'
       ],
       borderColor: [
         'rgb(255, 99, 132)',
         'rgb(255, 159, 64)',
         'rgb(255, 205, 86)'
       ],
       borderWidth: 1
     }]
   };
   
   var options = {
   	    legend : { display : false },
   	    scales: {
   	        y: {
   	          beginAtZero: true
   	        }
   	      }
   	};
   
   var canvas = document.getElementById("total-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "bar",
   	data : total_data,
   	options: options
   });
</script>
<script type="text/javascript">
   var averageBudgetOfPatronagesStatusByCurrency = {
   	   	<jstl:forEach items="${averageBudgetOfPatronagesStatusByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const average_data = {
    labels: Object.keys(averageBudgetOfPatronagesStatusByCurrency),
    datasets: [{
      data: Object.values(averageBudgetOfPatronagesStatusByCurrency),
      backgroundColor: [
    	  'rgb(255, 99, 132)',
          'rgb(255, 159, 64)',
          'rgb(255, 205, 86)',
          'rgb(75, 192, 192)',
          'rgb(54, 162, 235)',
          'rgb(153, 102, 255)',
          'rgb(201, 203, 207)'
        ]
    }]
   };
   
   var canvas = document.getElementById("average-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : average_data,
   });
</script>
<script type="text/javascript">
   var deviationBudgetOfPatronagesStatusByCurrency = {
   	   	<jstl:forEach items="${deviationBudgetOfPatronagesStatusByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const deviation_data = {
    labels: Object.keys(deviationBudgetOfPatronagesStatusByCurrency),
    datasets: [{
      data: Object.values(deviationBudgetOfPatronagesStatusByCurrency),
      backgroundColor: [
    	  'rgb(255, 99, 132)',
          'rgb(255, 159, 64)',
          'rgb(255, 205, 86)',
          'rgb(75, 192, 192)',
          'rgb(54, 162, 235)',
          'rgb(153, 102, 255)',
          'rgb(201, 203, 207)'
        ]
    }]
   };
   
   var canvas = document.getElementById("deviation-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "pie",
   	data : deviation_data,
   });
</script>
<script type="text/javascript">
   var minimumBudgetOfPatronagesStatusByCurrency = {
   	   	<jstl:forEach items="${minimumBudgetOfPatronagesStatusByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const min_data = {
    labels: Object.keys(minimumBudgetOfPatronagesStatusByCurrency),
    datasets: [{
      data: Object.values(minimumBudgetOfPatronagesStatusByCurrency),
      backgroundColor: [
    	  'rgb(255, 99, 132)',
          'rgb(255, 159, 64)',
          'rgb(255, 205, 86)',
          'rgb(75, 192, 192)',
          'rgb(54, 162, 235)',
          'rgb(153, 102, 255)',
          'rgb(201, 203, 207)'
        ]
    }]
   };
   
   var canvas = document.getElementById("min-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : min_data,
   });
</script>
<script type="text/javascript">
   var maximumBudgetOfPatronagesStatusByCurrency = {
   	   	<jstl:forEach items="${maximumBudgetOfPatronagesStatusByCurrency}" var="item" varStatus="loop">
   	   	      "${item.key}": '${item.value}' ${not loop.last ? ',' : ''}
   	   	</jstl:forEach>
   	   };
   
   const max_data = {
    labels: Object.keys(maximumBudgetOfPatronagesStatusByCurrency),
    datasets: [{
      data: Object.values(maximumBudgetOfPatronagesStatusByCurrency),
      backgroundColor: [
    	  'rgb(255, 99, 132)',
          'rgb(255, 159, 64)',
          'rgb(255, 205, 86)',
          'rgb(75, 192, 192)',
          'rgb(54, 162, 235)',
          'rgb(153, 102, 255)',
          'rgb(201, 203, 207)'
        ]
    }]
   };
   
   var canvas = document.getElementById("max-canvas");
   var context = canvas.getContext("2d");
   new Chart(context, {
   	type : "doughnut",
   	data : max_data,
   });
</script>