<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:actionURL var="uplaodURL" name="uploadDocument"></portlet:actionURL>
<!DOCTYPE portlet:defineObjects PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.switch {
  position: relative;
  display: inline-block;
  width: 50px;
  height: 24px;
}

.switch input {display:none;}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 16px;
  width: 16px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
</head>
<body>
<center><h2>Please Upload the PI Files</h2></center><br>
<form action="<%=uplaodURL%>" method="post" enctype="multipart/form-data">
<center><input type="file" accept=".xls,.xlsx" name="uploadedFile"  multiple="multiple" style="position: absolute;left: 520px;" required="required"></center><br><br>
<b style="position: absolute;left: 590px;">Notify Me By Email</b>
<label class="switch" style="position: absolute;left: 530px;" ><input type="checkbox" name="toggle"><span class="slider round"></span></label><br><br>
<center><input type="Submit" name="Submit" value="Import PI Data"></center>
</form>
</body>
</html>






