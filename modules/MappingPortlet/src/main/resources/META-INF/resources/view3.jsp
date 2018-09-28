<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects /> 
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<script type="text/javascript">
function check(){
	$.ajax({
	    url : '<%=resourceURL.toString()%>',
	    data : {
	    	data: $('#StartDate').serialize()
	    },
	    type : type: "post",
		success: function(data){
			console.log(data);
		}
	});
}
</script>
<script>
window.onload = function() {
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	title: {
		text: "PI DashBord"
	},
	data: [{
		type: "pie",
		startAngle: 240,
		yValueFormatString: "##0.00\"%\"",
		indexLabel: "{label} {y}",
		dataPoints: [
			{y: 60,label: "NonExported" },
			{y: 40,label: "Exported"}
		
		]
	}]
});
chart.render();

}
</script>

<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['PIS', 'PIS Info'],
          ['Exported',     50],
          ['NonExported',      50]
        
        ]);

        var options = {
          title: 'PI DashBord',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      
</script>
<script src="https://code.jquery.com/jquery-1.12.4.js" type="text/javascript"></script>
<%--
<portlet:resourceURL var="resourceURL" />
<button onclick="updateValuesForSelectedDepartment()"> pdf download</button>
<script>
function updateValuesForSelectedDepartment(){

$.ajax({
    url : '<%=resourceURL.toString()%>',
    data : {
        <portlet:namespace />cmd : 'LoadDivisionNames'
    },
      type : "POST",
      dataType: "text",
    success : function(data) {
        console.log(data);
    },
    error : function(response) {
       console.log("Error seen for loadDivisonDepName");
        $('#img').hide();
    }
});
}
</script>
--%>
 <portlet:resourceURL var="pdfDownloadUrl">
</portlet:resourceURL>
<button onclick="downloadpdf();"class="small button">pdf</button>
<%-- <a href="<%= request.getContextPath()%>/pdf/piinvocie1512928503289.pdf" target="_blank">
    downloadpdf
</a> --%>

<script>
function downloadpdf(){
	var ctx = "${pageContext.request.contextPath}"
	console.log("ContextPath :  "+ctx);
	console.log("Domain Name :  "+window.location.origin);
    $.ajax({
        url: '${pdfDownloadUrl}',
        data: {
            <portlet:namespace />cmd: 'downloadpdf',
        },
        type: "POST",
        dataType: "text",
        success: function(data) {
        	console.log("JSON_DATA :  "+data);
        	var obj = JSON.parse(data);
        	console.log("PDF_LINK :  "+obj.path);
        	var link= window.location.origin+ctx+"/pdf/"+obj.path;
        	console.log("URL :  "+link);
        	window.open(link);        	
        },
        error: function () {
            console.log("Error occured on server.");
        }
        });
}
</script> 