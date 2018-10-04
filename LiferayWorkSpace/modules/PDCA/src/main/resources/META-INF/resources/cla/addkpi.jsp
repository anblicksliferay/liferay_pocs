<%@ include file="/cla/init.jsp" %>

<div class="row">
<portlet:actionURL var="createKpi" name="createKpi"/>
<form name="createKpi" id="createKpi" action="<%=createKpi.toString() %>" method="post" name="update">
<div class="col-md-6">
<label>Company:   &nbsp </label><input type="text" id="<portlet:namespace/>company" name="<portlet:namespace/>company" required="required"/><br><br>
<label>Type:   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label>
<select id="<portlet:namespace/>type" name="<portlet:namespace/>type" required="required">
         <option value="Financial">Financial</option>
         <option value="Strategy">Strategy</option>
 </select><br><br>
<label>Weight(%):   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label><input type="text" id="<portlet:namespace/>weight" name="<portlet:namespace/>weight" required="required"/><br><br>
<label>Target:   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label><input type="text" id="<portlet:namespace/>target" name="<portlet:namespace/>target" required="required"/><br><br>

</div>
<div class="col-md-6">
<label>Year:   &nbsp&nbsp&nbsp&nbsp </label>
<select id="<portlet:namespace/>year" name="<portlet:namespace/>year" required="required">
         <option value="">Select Year</option>
         <option value="2018">2018</option>
         <option value="2017">2017</option>
 </select><br><br>
<label>Item Description:   &nbsp </label><input type="text" id="<portlet:namespace/>item" name="<portlet:namespace/>item" required="required"/><br><br>
<label>Unit:   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label><input type="text" id="<portlet:namespace/>unit" name="<portlet:namespace/>unit" required="required"/><br><br>
<label>Achivement Formula:   &nbsp&nbsp&nbsp&nbsp </label>
<select id="<portlet:namespace/>achivementformula" name="<portlet:namespace/>achivementformula" required="required">
                                 <option value="">Select Year</option>
                                 <option value="2018">2018</option>
                                 <option value="2017">2017</option>
                                 </select><br><br>
</div>
<button  class="btn-success">Submit</button>
</form>
</div>