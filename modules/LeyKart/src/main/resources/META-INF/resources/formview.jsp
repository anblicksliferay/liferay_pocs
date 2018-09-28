<%@ include file="/init.jsp" %>
<h2 style="margin-left: 17px;">Add User Form</h2>
<portlet:actionURL var="addTestmonials" name="addTestmonials"/>
<form name="addTestmonialsForm" id="addTestmonialsForm"  action="<%=addTestmonials.toString() %>" method="post"  enctype="multipart/form-data" >
<div class="col-md-6">
    <input type="text" name="<portlet:namespace/>firstName" id="<portlet:namespace/>firstName" required="required" class="form" placeholder="FullName" />
    <input type="file" name="<portlet:namespace/>image" id="<portlet:namespace/>image"  required="required" class="form" placeholder="UserImage" />
</div>
<div class="relative fullwidth col-md-12">
	<textarea name="<portlet:namespace/>message" id="<portlet:namespace/>message" class="form textarea"  placeholder="Message"></textarea>
</div>
<div class="relative fullwidth col-md-12">
	<div class="pull-left" style="margin-right:20px;"><button type="submit" id="submit" name="submit" class="btn btn-orange">SUBMIT</button></div>
	<div class="pull-left"><button id="cancel" name="cancel" class="btn btn-gray" onclick="reset();">CLEAR</button> </div>
</div>
<div class="clear"></div>
</form>		

<script>
	function reset(){
		$("#contact-us")[0].reset();
	}
</script>