<%@ include file="/html/mynotification/init.jsp" %>

<portlet:resourceURL var="listURL"/>

<h2>Kafka Message Consumer Admin</h2>
<p>
   <label>Offset </label> 
	<input type="text" placeholder="Enter Offset for Kafka Message" class="form-control" id="offset" value="${offset}">

    <button type="button" class="btn btn-w-m btn-primary" id="start" >Start Consumer</button>
    <button type="button" class="btn-danger" id="stop">Stop Consumer</button>
   
</p>
<br/>
<div>
<p>Manual Process of message</p>

<div class="form-group" >
<label>Alarm ID </label> 
<input type="text" placeholder="Enter Alarm ID" class="form-control" id="alramId">
<label>Alarm StartTime </label> 
<input type="text" placeholder="Enter ST" class="form-control" id="alarmST">
<label>Status </label> 
<select name='status' >
	<option value="true">Active</option>
	<option value="false">Inactive</option>
</select>
<button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit" id="alarmSubmit"><strong >Send Messgage</strong></button>
</div>
</div>

 <div id='<portlet:namespace />spinner' style="border-color: transparent;">
    <div class="spiner-example"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
</div>

<script>
$('#alarmSubmit').click(function (){
	update('send');
});
$("#<portlet:namespace />spinner").dialog({
	     dialogClass: "no-close",
	     modal: true,
	     height:'100%',
	     width:'100%',
	     autoOpen: false,
	     draggable: false,
	     zIndex: 101
	});

$('#start').click(function(){
	update('start');
	$('#start').attr('disabled',true);
	$('#stop').attr('disabled',false);
});

$('#stop').click(function(){
	update('Stop');
	$('#start').attr('disabled',false);
	$('#stop').attr('disabled',true);
});

var debug = false;
function update(cmd){
	 	var context ={offset:$('#offset').val()};
	    if(cmd=='send'){
	    	  context ={Id:$('#alramId').val(),time:$('#alarmST').val(),active:$("select[name='status'] option:selected ").val()};
	    }
       
        var cmdType= 'nothing';
        if(debug) console.log("[Kafka view] updateValues: called with cmd : "+cmd +"cmdType : "+cmdType+" context:"+JSON.stringify(context));
        
        $.ajax({  
                url : '<%=listURL.toString()%>',
                data : {
                    <portlet:namespace />cmd: cmd,
                    <portlet:namespace />cmdType: cmdType,
                    <portlet:namespace />context: JSON.stringify(context)
                },
    
                type : "POST",
                dataType : "json",
                beforeSend:function(){$("#<portlet:namespace />spinner").dialog('open');console.time("spinner"); },
                complete:function(){$("#<portlet:namespace />spinner").dialog('close');console.timeEnd("spinner");  },
                success : function(data) {
                    if(debug) console.log(data);
                    if(data.msg == 'true'){
                        $('#start').attr('disabled',true);
						$('#stop').attr('disabled',false);
                     } else if(data.msg == 'false'){
                        $('#start').attr('disabled',false);
						$('#stop').attr('disabled',true);
                     } 
                },
                error : function(response) {
                    console.log("Error seen for update");
                }
        });
    }

   update('list') ;
</script>
