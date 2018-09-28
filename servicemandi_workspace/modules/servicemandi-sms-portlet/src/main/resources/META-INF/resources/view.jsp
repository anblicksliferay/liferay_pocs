<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="init.jsp"%>

<portlet:resourceURL var="textLink" />

<script type="text/javascript">
	$(document).ready(function(){
		var input = $('#<portlet:namespace/>mobile');

		input.oninvalid = function(event) {
		    event.target.setCustomValidity('Mobile number is required, Please enter 10 digit valid number');
		} 
		$("#smsform").submit(function(e){
			var nodeObject = $('#hide');
		    var form = $(this);
		    $.ajax({ 
		         url   : form.attr('action'),
		         type  : form.attr('method'),
		         data  : form.serialize(), // data to be submitted
		         success: function(response){
		        	 var obj = JSON.parse(response)
		        	 var status = obj.sendStatus;
                 	if(status == "Success"){
                 		nodeObject.empty().html("<p class=\"wow fadeIn\" data-wow-duration=\"2.8s\" style=\"color: #000;padding-top: 10px;\"> SMS has been sent successfully</p><br/>");
                 	}else{
                 		nodeObject.empty().html("<p class=\"wow fadeIn\" data-wow-duration=\"2.8s\">There is problem in Request URL to send SMS.</p><br/>");
                 	}
		         }
		    });
		    return false;
		 });
	});
</script>	
	
<!--Section-3 start-->
<div class="" style="width: 100%; background: #ff7d00; color: #ffffff;">
	<div class="intro">
		<div class="getapp home" style="padding: 15px 0;">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-4 col-xs-12 wow fadeInUp"
							data-wow-duration="1.4s">
							<img
								src="<%=themeDisplay.getPathThemeImages()%>/get-app-mobile.png"
								class="img-responsive" style="float: none; margin: 0 auto;" />
						</div>
						<div class="col-md-8 col-xs-12">
							<h1 class="wow fadeInUp" data-wow-duration="1.8s">GET APP</h1>
							<h3 class="wow fadeInDown" data-wow-duration="1.8s">
								Email: <a href="mailto:support@servicemandi.com">support@servicemandi.com</a>
								| Call: 1800 208 8800
							</h3>

							<h2 style="margin-top: 25px;" class="wow fadeInDown"
								data-wow-duration="2.0s">Download the App</h2>
							<p class="wow fadeInUp" data-wow-duration="2.8s">Download the
								customer app on Google Play Store with Icon and something akin
								to below wherein the app download link can be sent by sms for
								interested customers.</p>
							<br />

							<p class="wow fadeInUp" data-wow-duration="2.8s">
								<strong>ServiceMandi Android App available in following
									languages</strong>
							</p>
							<div class="clear"></div>
							<div class="col-md-3 wow fadeInLeft" data-wow-duration="2.0s">
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									English</li>
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Hindi</li>
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Marathi</li>
							</div>
							<div class="col-md-3 wow fadeIn" data-wow-duration="2.8s">
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Gujarati</li>
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Telugu</li>
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Tamil</li>
							</div>
							<div class="col-md-3 wow fadeInRight" data-wow-duration="3.4s">
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Kannada</li>
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Odiya</li>
								<li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
									Bengali</li>
							</div>
							<div class="clear"></div>
							<br />
							<p class="wow fadeIn" data-wow-duration="2.8s">Send a link
								via SMS to install the App</p>

							<%-- <form action="${textLink}" name="smsform" method="post"> --%>
							<form id="smsform" name="smsform" action="${textLink}" method="post">
								<div class="form-group wow fadeIn animated"
									data-wow-duration="2.8s"
									style="visibility: visible; animation-duration: 2.8s; animation-name: fadeIn;">
									<div class="col-md-4" style="margin-bottom: 10px;">
										<input type="text" class="form-control"
											name="<portlet:namespace/>mobile"
											id="<portlet:namespace/>mobile" required="true" placeholder="Enter 10 Digit Mobile Number"
											pattern="[0-9]{10}"
											oninvalid="this.setCustomValidity('Mobile number is required, Please enter 10 digit valid number')"
											oninput="setCustomValidity('')">
									</div>
									<!-- <button type="submit" class="btn btn-primary pull-left"
										style="margin-bottom: 8px;">Text App Link</button> -->
										<button type="submit" class="btn btn-primary pull-left"
										style="margin-bottom: 8px;" >Text App Link</button> 
								</div>
							</form>
							
							
							<div class="clear" id="hide" style="visibility: hide">
								</div>
							<div class="clear">
								<a	href="https://play.google.com/store/apps/details?id=com.servicemandi.mechanic&hl=en" target="_blank" >
									<img
									src="<%=themeDisplay.getPathThemeImages()%>/android-app-img.png"
									class="wow fadeInDown" data-wow-duration="2.8s" />
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--Section-3 end-->