<%@page import="com.leykartservice.service.TestmonialsLocalServiceUtil"%>
<%@page import="com.leykartservice.model.Testmonials"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<style>
.red{
font-size: 120%;
color : rgb(255, 0, 0);
}
.green{
font-size: 120%;
color : rgb(60, 179, 113);
}

</style>
	<script type="text/javascript">
	$(document).ready(function() {
		if ( $(window).width() > 1200) { 
			$('#fullpage').fullpage({
				anchors: ['first', 'second', 'third','fourth','fifth'],
				
				scrollBar: true
			});
		  //Add your javascript for large screens here 
			} 
			else {
			  //Add your javascript for small screens here 
			}
		});
	</script>
	 <script type="text/javascript">
        $(document).ready(function () {
            window.setInterval(function () {
                /// call your function here
                carousel.next();
            }, 2000);
            

            var carousel = $("#carousel").waterwheelCarousel({
                flankingItems: 3,
                movingToCenter: function ($item) {
                    $('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
                },
                movedToCenter: function ($item) {
                    $('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
                },
                movingFromCenter: function ($item) {
                    $('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
                },
                movedFromCenter: function ($item) {
                    $('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
                },
                clickedCenter: function ($item) {
                    $('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
                }
            });

            $('#prev').bind('click', function () {
                carousel.prev();
                return false
            });

            $('#next').bind('click', function () {
                carousel.next();
                return false;
            });

            $('#reload').bind('click', function () {
                newOptions = eval("(" + $('#newoptions').val() + ")");
                carousel.reload(newOptions);
                return false;
            });

        });
    </script>
</head>
<body>

<div id="fullpage" class="fullpage-wrapper" style="height: 100%;position: relative;margin-left: -30px;margin-top: -76px;margin-right: -26px;">
	
	<!--Section-0 start-->
	<div class="section" id="section0" style="background-color:none !important;">
		<div class="intro">
			<!-- Fixed navbar -->
		
<%-- <%@ include file="/header.jsp" %> --%>
<nav class="navbar navbar-default">
				  <div class="container">
					<div class="pull-right" style="margin-right:15px; font-size:22px; color:#0288cf; font-weight:bold;"><img src="<%=request.getContextPath()%>/images/phone-top-icon.png" style="float:left; margin-right:14px;" />1800-208-2525</div>
					<div class="clear"></div>
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
					  <div id="logo">
						<a class="navbar-brand" href="/web/leykart/welcome"><img class="img-responsive" src="<%=request.getContextPath()%>/images/leykart-logo.png" alt="Leykart Ashok Leyland" /></a>
					  </div>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
					  <ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="/web/leykart/welcome">HOME</a></li>
						<li><a href="/web/leykart/return-and-cancellation-policy">RETURN &amp; CANCELLATION POLICY</a></li>
						<li><a href="/web/leykart/faq">FAQ'S</a></li>
						<li><a href="/web/leykart/enquiry">ENQUIRY</a></li>
					  </ul>
					</div>
				  </div>
				</nav> 
				<!-- Fixed navbar end-->
				<div id="bannerdiv" style="vertical-align:top !important; padding:0; margin:0;">
				<!--Carousel start-->
					<div class="carousel carousel-fade slide" id="my-carousel">
						<ol class="carousel-indicators">
							<li data-target="#my-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#my-carousel" data-slide-to="1"></li>
							<li data-target="#my-carousel" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner">
						  <div class="item active item-1">
						  
						  </div>
						  <div class="item item-2" >
						  
						  </div>
						  <div class="item item-3">
						  
						  </div>
						</div>
						<!--  remove the a href tag to remove link that does not need it -->
					</div>
				<!--Carousel end-->
				
								
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" >
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				  </ol>
				 
				  <!-- slides start -->
				  <div class="carousel-inner">
					<div class="item active">
					  <div class="box"><img src="<%=request.getContextPath()%>/images/leykart-shoping-for-spare-parts.jpg" alt="leykart shoping for spare parts"class="img-responsive" /></div>
					  <div class="carousel-caption"></div>
					</div>
					<div class="item">
					  <div class="box"><img src="<%=request.getContextPath()%>/images/leykart-features-of-the-app.jpg" alt="leykart features of the app" class="img-responsive" /></div>
					  <div class="carousel-caption"></div>
					</div>
					<div class="item">
					  <div class="box"><img src="<%=request.getContextPath()%>/images/leykart-free-delivery.jpg" alt="leykart-free-delivery" class="img-responsive" /></div>
					  <div class="carousel-caption"></div>
					</div>
				  </div>
				 
				  <!-- slides end -->
				</div> <!-- Carousel -->
				
				</div>
	
		</div>
	</div>
	<!--Section-0 end-->
	
	<!--Section-1 start-->
	<div class="section" id="section1">
	    <div class="intro">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="text-center text-white">How Leykart Works</h1>
						<div id="carousel" style="position:absolute;">
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step1.jpg" alt ="leykart app" id="item-1" width="250" height="450" /></a>
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step2.jpg" alt ="leykart app" id="item-2" width="250" height="450" /></a>
							<a><img src="<%=request.getContextPath()%>/images/leykart-app-install-step3.jpg" alt ="leykart app" id="item-3" width="250" height="450" /></a>
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step4.jpg" alt ="leykart app" id="item-4" width="250" height="450" /></a>
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step5.jpg" alt ="leykart app" id="item-5" width="250" height="450" /></a>
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step6.jpg" alt ="leykart app" id="item-6" width="250" height="450" /></a>
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step7.jpg" alt ="leykart app" id="item-7" width="250" height="450" /></a>
							<a><img src="<%=request.getContextPath()%>/images/leykart-app-install-step8.jpg" alt ="leykart app" id="item-8" width="250" height="450" /></a>
							<a ><img src="<%=request.getContextPath()%>/images/leykart-app-install-step9.jpg" alt ="leykart app" id="item-9" width="250" height="450" /></a>
						</div>
						<div class="text-center text-white"><a href="#" id="prev">Prev</a> | <a href="#" id="next">Next</a></div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Section-1 end-->
	
	<!--Section-2 start-->
	<div class="section" id="section2">
		<div class="testimonials">
			<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1 style="text-align:center; margin-bottom:80px;" class="wow fadeInDown" data-wow-duration="1.8s">TESTIMONIALS</h1>
							<div class='row'>
								<div class="col-md-12">
								  <div class="carousel slide media-carousel" id="media">
									<div class="carousel-inner">
									<%List<Testmonials> testmonialsList=TestmonialsLocalServiceUtil.getTestmonialses(0, TestmonialsLocalServiceUtil.getTestmonialsesCount());
									int i=0;
									
									while(i<TestmonialsLocalServiceUtil.getTestmonialsesCount()){%>
									
									  <div  <%if(i==0){ %> class="item active" <%}else{ %> class="item" <% }%>>
										<div class="row">
										  <!--testmonial start-->	
										 <%if(i<TestmonialsLocalServiceUtil.getTestmonialsesCount()){%>	
											<div class="col-md-4 col-sm-4 col-xs-12">
												 <div class="parent-box red">
													<div class="box">
														<div class="dialog-box">
															<p>
																<%=testmonialsList.get(i).getMessage() %>
															</p>
														</div>
														<div class="info">
															<div style="text-align:right">
																<h4><%=testmonialsList.get(i).getFullname() %></h4>
															</div>
															<div></div>
																								
														</div>
													</div>
												</div>
												<div class="profile-circle">
													<img style="border-radius: 50%; width:100px ; height: 100px"  src="<%=testmonialsList.get(i).getImagepath() %>" />
												</div>
											</div>
											<%} %>
											<!--testmonial end-->         
										  <!--testmonial start-->
										  <% if(i+1<TestmonialsLocalServiceUtil.getTestmonialsesCount()){ %>
											<div class="col-md-4 col-sm-4 col-xs-12">
												 <div class="parent-box red">
													<div class="box">
														<div class="dialog-box">
															<p>
																<%=testmonialsList.get(i+1).getMessage() %>
															</p>
														</div>
														<div class="info">
															<div style="text-align:right">
																<h4><%=testmonialsList.get(i+1).getFullname() %></h4>
															</div>
															<div></div>
																								
														</div>
													</div>
												</div>
												<div class="profile-circle">
													<img style="border-radius: 50%; width:100px ; height: 100px" src="<%=testmonialsList.get(i+1).getImagepath() %>" />
												</div>
											</div>
											<% } %>
											<!--testmonial end-->
											<% if(i+2<TestmonialsLocalServiceUtil.getTestmonialsesCount()){%>
										  <!--testmonial start-->
											<div class="col-md-4 col-sm-4 col-xs-12">
												 <div class="parent-box red">
													<div class="box">
														<div class="dialog-box">
															<p>
																<%=testmonialsList.get(i+2).getMessage() %>
															</p>
														</div>
														<div class="info">
															<div style="text-align:right">
																<h4><%=testmonialsList.get(i+2).getFullname() %></h4>
															</div>
															<div></div>
																								
														</div>
													</div>
												</div>
												<div class="profile-circle">
													<img style="border-radius: 50%; width:100px ; height: 100px" src="<%=testmonialsList.get(i+2).getImagepath() %>" />
												</div>
											</div>
											<% } %>
											<!--testmonial end-->        
										</div>
									  </div>
									  <%i=i+3;} %>
									</div>
									<a data-slide="prev" href="#media" class="left carousel-control glyphicon glyphicon-chevron-left"></a>
									<a data-slide="next" href="#media" class="right carousel-control glyphicon glyphicon-chevron-right"></a>
								    </div>                  
								</div>
							  </div>
							
						</div>
					</div>
			</div>
			
		</div>
	</div>
	<!--Section-4 end-->
	
	<!--Section-3 start-->
	<div class="section" id="section3">
		<div class="intro">
			<div class="getapp" style="padding:15px 0;">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-4 col-xs-12 wow fadeInUp" data-wow-duration="1.4s">
								<img src="<%=request.getContextPath()%>/images/leykart-get-app-and-key-features.png" class="img-responsive" alt="leykart get app and key features" style="float:none; margin:0 auto;"/>
							</div>
								<div class="col-md-8 col-xs-12">
									<div class="col-md-12 col-xs-12">
										<h1 class="wow fadeInUp" data-wow-duration="1.8s">GET APP</h1>
										<h3 class="wow fadeInDown" data-wow-duration="1.8s">Email: <a href="mailto:support@leykart.com">support@leykart.com</a>  | Call: 1800 208 2525</h3>
										
										<h2 style="margin-top:25px;" class="wow fadeInDown" data-wow-duration="2.0s">Download the App</h2>
										<p class="wow fadeInUp" data-wow-duration="2.8s">Download the customer app on Google Play Store with Icon and something akin to below wherein the app download link can be sent by sms for interested customers.</p>
									</div>
								
								<div class="col-md-12 col-xs-12 key-list">
									<div class="brtopbottom">
									<h2 class="wow fadeInDown" data-wow-duration="2.0s">KEY FEATURES OF THE APP :</h2>	
									<div class="clear"></div>
									<div class="col-md-7 wow fadeInLeft" data-wow-duration="2.0s" style="padding-left:0;">
										 <li><img src="<%=request.getContextPath()%>/images/getapp-icons01.png" /> User friendly app</li>
										 <li><img src="<%=request.getContextPath()%>/images/getapp-icons02.png" /> Multiple search options</li>
										 <li><img src="<%=request.getContextPath()%>/images/getapp-icons03.png" /> Quick and easy identification of spares</li>
										 <li><img src="<%=request.getContextPath()%>/images/getapp-icons04.png" /> 24x7 availability of spare parts</li>
									 </div>
									 <div class="col-md-5 wow fadeIn" data-wow-duration="2.8s">
										<li><img src="<%=request.getContextPath()%>/images/getapp-icons05.png" /> Wide range of parts</li>
										 <li><img src="<%=request.getContextPath()%>/images/getapp-icons06.png" /> Doorstep delivery</li>
										 <li><img src="<%=request.getContextPath()%>/images/getapp-icons07.png" /> Online payment facility</li>
									 </div>
									 <div class="clear"></div>
									</div> 
								</div>
								
								 <div class="col-md-12 col-xs-12">
									 <div class="languages brtopbottom" style="border-top:none;">
										 <p class="wow fadeInUp animated" data-wow-duration="2.8s" style="visibility: visible; animation-duration: 2.8s; animation-name: fadeInUp;">
											LEYKART ANDROID APP AVAILABLE IN FOLLOWING LANGUAGES:
										 </p>
										<div class="col-md-3 wow fadeInRight" data-wow-duration="3.4s" style="padding-left:0;">
											 <li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>English</li>
										 </div>
										 <div class="col-md-3 wow fadeInRight" data-wow-duration="3.4s" style="padding-left:0;">
											 <li><i class="fa fa-mobile fa-2x" aria-hidden="true"></i>Hindi</li>
										 </div>
										  <div class="clear"></div>
									</div>
								 </div>
								 
								 <div class="col-md-12 col-xs-12">
									<p class="wow fadeIn" data-wow-duration="2.8s">SEND A LINK VIA SMS TO INSTALL THE APP</p>
									<form>
										<div class="form-group wow fadeIn" data-wow-duration="2.8s">
										  <div class="col-md-4" style="margin-bottom:10px;">
											<input type="text" class="form-control" id="" placeholder="Enter 10 Digit Mobile Number">
										  </div>
										  <button type="button" class="btn btn-primary pull-left" style="margin-bottom:8px;">Text App Link</button>
										</div>
									</form>
									<div class="clear"></div>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Section-3 end-->
	
	
	
	<!--Section-5 start-->
	<div class="section" id="section4">
		<div class="intro">
				
			<div class="aboutus">
				<div class="container">
					<div class="row" style="margin:0">
							<h1 class="text-center wow flipInY" data-wow-duration="1.8s">ABOUT US</h1>
							<div class="brtopbottom">
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="mr80">
									<h5>LEYKART</h5>
									<p>
										LeyKart is a digital initiative launched by Ashok Leyland Limited to allow users to purchase spare parts online.
									</p>
									<p>
										LeyKart simplifies your spare parts purchase by allowing you to browse through a host of genuine Ashok Leyland spare parts to identify the correct part for your vehicles. The flexible search functionality provides you with various part identification methods to identify the exact part that matches your requirements.
									</p>
									<p>
										Through our extensive dealership network and efficient warehouse logistics, we commit to assist you in identifying the right part and ensure its delivery when you order on LeyKart. 
									</p>
									<p>
										LeyKart fulfils your spare part needs and helps save your valuable time by delivering genuine Ashok Leyland spare parts right at your doorstep.
									</p>
									</div>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-12">
									<h5>ADDRESS</h5>
									<address>
										<p>
											Lorem ipsum dolor sit amet,
											consectetur adipiscing elit.
											Integer varius tellus non nisl
											sodales semper. 
										</p>
										<p class="phone-email"><img src="<%=request.getContextPath()%>/images/phone-icon.png" style="margin-right:14px;" />1800-208-2525</p>
										<p class="phone-email"><img src="<%=request.getContextPath()%>/images/email-icon.png" style="margin-right:14px;" /><a href="mailto:sales@leykart.com">sales@leykart.com</a></p>
									</address>
								</div>
							</div>
						
					</div>
				</div>
			
				<!--newsletter faqs start-->
					<div class="container">
						<div class="row">
							<hr/>
								<div class="col-md-5 col-xs-12">
									<div class="col-xs-12">
										<h5 class="blue-italic">Subscribe for Our Newsletter:</h5>
										<div class="input-group">
											<input type="email" name=email" id="email" class="form-control" placeholder="Enter Your Email" required="required">
											<span class="input-group-btn">
												<button type="button" onclick="subscription()" class="btn btn-blue">SUBMIT</button>
											</span>
										</div>
										<div><b id="submsg" name="submsg"></b>
										</div>
										
									</div>						
								</div>
								
								<div class="col-md-4 col-xs-12">
									<img src="<%=request.getContextPath()%>/images/leykart-faqs.jpg" class="center-block" alt=""/>
								</div>
								
								<div class="col-md-3 col-xs-12">
									<img src="<%=request.getContextPath()%>/images/leykart-cancellation-policy.jpg" class="center-block" alt=""/>
								</div>
							
						</div>
					</div>
				<!--newsletter faqs end-->
			</div>

	
		<!-- Footer Start-->
		<footer class="footer">
		  <div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6 col-xs-12">
						© 2018 Ashok Leyland Limited, All Rights Reserved.
					</div>
					<div class="col-md-5 col-xs-12 privacy">
						<a href="/web/leykart/privacy-policy">Privacy Policy</a>&nbsp; &nbsp; | &nbsp; &nbsp;
						<a href="/web/leykart/terms-and-conditions">Terms &amp; Conditions</a>
					</div>
				</div>
			</div>
		  </div>
		</footer>
	<!-- Footer End-->
		
	
	
	</div>
	</div>
	<!--Section-5 end-->
	
</div>

	
	
	<script>
	  new WOW().init();
	  </script>
	<script>
		$('.carousel').carousel({
			interval: 3000
		})
		
	</script>
	 <portlet:resourceURL var="resourceURL" />
	<script>
	function subscription(){
		console.log($('#email').val());
		if($('#email').val()==''){
			if($('#submsg').hasClass( "green" )){
			$('#submsg').removeClass("green");}
			 $('#submsg').text('Please Enter EmailID..').addClass("red");
		}
		else{
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		  if (filter.test($('#email').val())) {
		$.ajax({
		    url : '<%=resourceURL.toString()%>',
		    data : {
		        <portlet:namespace />cmd : $('#email').val()
		    },
		      type : "POST",
		      dataType: "text",
		    success : function(data) {
		        console.log(data);
		        var obj = JSON.parse(data);
		        if(obj.path=='Success'){
		        if($('#submsg').hasClass( "red" )){
		    	$('#submsg').removeClass("red");}
		        $('#submsg').text('Thanks For Subscribing...').addClass("green");
		        $('#email').val('');  
		        }
		    },
		    error : function(response) {
		       console.log("Error seen for loadDivisonDepName");
		    }
		});
		
		}
		  else{
			  if($('#submsg').hasClass( "green" )){
					$('#submsg').removeClass("green");}
			  $('#submsg').text('Please Enter Valid EmailID..').addClass("red");
		  }
	}
	}
		$(document).ready(function() {
		  $('#media').carousel({
			pause: true,
			interval: false,
		  });
		});
		
	</script>
<!-- <script type="text/javascript">
    var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));

    if(!ismobile) document.write('<script src="/scrolloverflow.js"></script>');

</script> -->

