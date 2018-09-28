<%@ include file="init.jsp"%>

<%@page import="com.liferay.portal.kernel.captcha.
CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.
CaptchaMaxChallengesException"%>

<c:if test="${mailSuccess == true}">
	<script type="text/javascript">
			$(document).ready(function(){
				$('html, body').animate({
					scrollTop: $("#contactForm").offset().top
				    }, 1000);
		});			
	</script>
</c:if>


<portlet:actionURL name="contactUs" var="contactUs" />

<!--Content start-->
<div class="container">
	<div class="row page-title">
		<div class="col-md-12">
			<h1>CONTACT US</h1>
		</div>
	</div>
</div>

<div class="container white-bg" style="padding-bottom: 40px;">			
	<div class="row">
		<div class="col-md-12 pull-left">
			<div style="border-bottom: 1px solid #afafb1; text-align: left;">
				<h2>Please fill in our contact form!</h2>
			</div>
		</div>
		<div class="clear"></div>
		<br />
		<br />
		<div class="col-md-12">
			<div class="col-md-5 col-xs-12 contact pad-50"
				style="padding-bottom: 25px;">
				<i class="fa fa-envelope fa-2x" aria-hidden="true"></i> <a
					href="mailto:support@servicemandi.com">support@servicemandi.com</a>
				<br /> <i class="fa fa-phone fa-2x" aria-hidden="true"
					style="margin-right: 22px;"></i>1800 208 8800
			</div>

			<div class="col-md-7 col-xs-12" id="contactForm">
			
			<c:if test="${mailSuccess == true}">
				<div class="col-md-4"></div>
				<div class="col-md-8 sucess-message-alert">
					<h3 style="text-align: left;">Thank you!</h3>
					<h5>Your Mail has been sent successfully.</h5>
				</div>
			</c:if>
			
			<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />

				<form action="${contactUs}" method="post" class="form-horizontal"
					role="form">

					<div class="form-group">
						<label for="name" class="col-md-4 control-label">Name:</label>
						<div class="col-md-8">
							<input type="text" class="form-control"
								id="<portlet:namespace/>name" name="<portlet:namespace/>name"
								placeholder="Enter Your Name" required
								oninvalid="this.setCustomValidity('Please enter name')"
								oninput="setCustomValidity('')" >
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-md-4 control-label">Contact
							Number:</label>
						<div class="col-md-8">
							<input type="text" class="form-control"
								id="<portlet:namespace/>contact"
								name="<portlet:namespace/>contact" pattern="[0-9]{10}"
								placeholder="Enter Your Contact Number" required
								oninvalid="setCustomValidity('Please enter valid phone number')"
								oninput="setCustomValidity('')">
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="col-md-4 control-label">E-mail
							ID:</label>
						<div class="col-md-8">
							<input type="email" class="form-control"
								id="<portlet:namespace/>email" name="<portlet:namespace/>email"
								placeholder="Enter Your Email ID" required
								oninvalid="this.setCustomValidity('Please enter valid email address')"
								oninput="setCustomValidity('')">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-4"></div>
						<div class="col-md-8 custom-capchaBox">
							<portlet:resourceURL var="captchaURL" />
								<liferay-captcha:captcha url="<%=captchaURL.toString()%>"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-8 btn-pad">
							<button type="submit" class="btn btn btn-orange">SUBMIT</button>
						</div>
						`
					</div>
				</form>
			</div>

		</div>
	</div>
</div>
<!--Content end-->