<%@ include file="/init.jsp" %>

<div class="col-span 12">
<portlet:actionURL var="addUser" name="addUser"/>
<form name="adduserFrom" id="adduserFrom" action="<%=addUser.toString() %>" method="post" name="update">
<label>FirstName:   &nbsp </label><input type="text" id="<portlet:namespace/>fname" name="<portlet:namespace/>fname" required="required"/><br><br>
<label>LastName:   &nbsp </label><input type="text" id="<portlet:namespace/>lname" name="<portlet:namespace/>lname" required="required"/><br><br>
<label>EmailId:   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label><input type="text" id="<portlet:namespace/>email" name="<portlet:namespace/>email" required="required"/><br><br>
<label>Location:   &nbsp&nbsp&nbsp&nbsp </label><select id="<portlet:namespace/>loc" name="<portlet:namespace/>loc" required="required">
                                 <option value="Hyderabad">Hyderabad</option>
                                 <option value="Delhi">Delhi</option>
                                 <option value="Mumbai">Mumabai</option>
                                 <option value="Banglore">Banglore</option></select><br><br>
<button  class="btn-success">Submit</button>
</form> 
 </div>