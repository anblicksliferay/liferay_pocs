<%@ include file="/init.jsp" %>
<html>
<body>
<div id="fullpage" style="margin-top: -75px;  margin-left: -23px;  margin-right: -25px;">
	
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
						<li><a href="/web/leykart/welcome">HOME</a></li>
						<li><a href="/web/leykart/return-and-cancellation-policy">RETURN &amp; CANCELLATION POLICY</a></li>
						<li class="active"><a href="/web/leykart/faq">FAQ'S</a></li>
						<li><a href="/web/leykart/enquiry">ENQUIRY</a></li>
					  </ul>
					</div>
				  </div>
				</nav> 
		<!-- Fixed navbar end-->
		
		<!-- inner banner strat-->
		<div class="header-container faqs-banner">
			<div class="container">
				<div class="txt-container">
				<h1>FAQ's</h1>
				</div>
			</div>
		</div>
		<!-- inner banner end-->
		
		<!-- <div class="inner-banner">
			<img src="images/faqs-banners.jpg" class="img-responsive" alt="leykart Return and Cancellation Policy" />
		</div> -->
		<!-- inner banner end-->
		
		<!-- Content start-->
		


		<!--main-->
		<div class="container">
			<div class="row">
			  <!--left-->
			  <div class="col-md-3" id="leftCol">
				<ul class="nav nav-stacked" id="sidebar" ">
					<h5 style="font-weight:600">Categories:</h5>
				  <li><i class="fa fa-angle-double-right"></i><a href="#sec0">Account settings</a></li>
				  <li><i class="fa fa-angle-double-right"></i><a href="#sec1">Searching</a></li>
				  <li><i class="fa fa-angle-double-right"></i><a href="#sec2">Payments and pricing</a></li>
				  <li><i class="fa fa-angle-double-right"></i><a href="#sec3">Shipping and Delivery</a></li>
				  <li><i class="fa fa-angle-double-right"></i><a href="#sec4">Returns and Replacements</a></li>
				  <li><i class="fa fa-angle-double-right"></i><a href="#sec5">Security and Privacy</a></li>
				</ul>
			  </div><!--/left-->
			  
			  <!--right-->
			  <div class="col-md-9">
			  <div class="ver-br">
				<h2 id="sec0">Account Settings</h2>
				<h6>I want to change my account details. What should I do?</h6>
				<p>Please contact the call centre to change your registered name, email ID, mobile number, address or preferred language.</p>
				<h6>Why am I asked for an OTP every time I open the app?</h6>
				<p>You will be asked to enter an OTP every time only if you "sign out" of the app, restart your phone or change your handset. To avoid having to enter an OTP every time, you can simply close the app without signing out. </p>
				<h6>What are loyalty points and how do they benefit me?</h6>
				<p>Loyalty points are rewards that you receive for purchasing certain Ashok Leyland parts on LEYKART and offline channels. You can view your accumulated loyalty points on the "My Accounts" page of the app. You can redeem these points in offline channels by using them to get discounts on your purchases.</p>	
				
				<hr/>
				
				<h2 id="sec1">Searching</h2>
				<h6>How can I search for a specific part?</h6>
				<p>You can choose among the multiple search options offered on LEYKART to search for the exact part to suit your requirements. To begin searching, click on the Search button and choose your preferred search option. You will be prompted to enter some information. Once you input all the information and click Enter, you will be taken to the search results page where you can find the part that suits your requirements.</p>
				<h6>What are the various search features available?</h6>
				<p>To make it easy to identify the products that you require, we provide the following search methods on the LEYKART app:</p>
				<p><strong>Text Search:</strong> You may input any text related to the part you are looking for. The text can be inclusive of but not limited to part number or part name. You shall receive an output of all matches that are related to the input text that you have entered. You are then free to choose a product by browsing the list of results.</p>
				<p><strong>Part Number Search:</strong> If you know the exact part number, you may select the ‘Part Number’ search icon and input the number. The part number that matches in the system shall be displayed to you.</p>
				<p><strong>Aggregate Search:</strong> If you are aware of the part belonging to a specific aggregate, you can select the ‘Aggregate’ search icon. A list of key aggregates shall be populated in front of you from which you can select parts from the list of parts populated in each aggregate.</p>
				<p><strong>VIN Search:</strong> If you know the VIN (Vehicle Identification Number) or the chassis number for your vehicle, you may select the ‘VIN’ search icon and input the 15-digit VIN to get a list of part numbers that exactly match the parts valid for the vehicle listed aggregate-wise.</p>
				<p><strong>Registration Number Search</strong> If you know the registration number of your vehicle at the time of purchase, you may select the ‘Registration Number’ search icon and enter the same to get a list of part numbers that exactly match the parts valid for the vehicle listed aggregate-wise. </p>
				<p><strong>Model Lookup Search:</strong> If you know the model name/ number of your vehicle, you can enter the same to get a list of part numbers that exactly match the parts valid for the vehicle listed aggregate-wise.</p>
				<h6>The part that I am searching for is not available in the list. What should I do?</h6>
				<p>At LEYKART, we endeavour to offer all those parts that you may need on a regular basis. However, if you are unable to find a part on LEYKART, we request you to contact our Customer Support team to help you accurately locate the requested part.</p>
				
				<hr/>
				
				<h2 id="sec2">Payments and Pricing</h2>
				<h6>What are the payment options available?</h6>
				<p>We accept payment through credit cards, debit cards, payment wallets, net banking, UPI and cash cards.</p>
				<h6>How can I apply discounts on my order?</h6>
				<p>Discounts will be automatically applied to your cart as you add items to it, based on the available promo codes. By default, the promo offering the maximum discount is applied to your order.</p>
				<h6>Can I ask my customer to pay for the order on my behalf?</h6>
				<p>If you are a mechanic, LEYKART provides you with the option to place an order yourself while requesting your customer to make the necessary payment for that order. You just need to enter your customer’s contact details and a link will be sent to the customer who can make the payment online.</p>
				<h6>Is any transaction charge applicable for online payment?</h6>
				<p>Yes, Transaction fee is applicable, transaction fees will be borne by the customer</p>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>
									Transaction Type
								</th>
								<th>
									Transaction Charges
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>* TDR For Credit Card  (Master Card/ Visa) INR</td>
								<td>1.90%+ taxes as applicable</td>
							</tr>
							<tr>
								<td>* TDR For (Amex) INR</td>
								<td>2.60%+ taxes as applicable</td>
							</tr>
							<tr>
								<td rowspan="3">* TDR For  (Debit Cards) Visa, Master Card, Maestro, Rupay , ATM- cum- PIN Debit Card</td>
								<td>0.25% for transaction below INR 1000 + taxes as applicable.</td>
							</tr>
							<tr>
								<td>0.50% for transaction above INR   1000 and below INR 2000 + taxes as applicable.</td>
							</tr>
							<tr>
								<td>1.00% for transaction INR 2000 and above + taxes as applicable.</td>
							</tr>
							
							<tr>
								<td>*   TDR For  ( Net Banking)   HDFC and ICICI </td>
								<td>1.65%+ taxes as applicable</td>
							</tr>
							<tr>
								<td>* TDR For  ( Net Banking) other</td>
								<td>1.35%+ taxes as applicable</td>
							</tr>
							<tr>
								<td rowspan="2">* TDR For  UPI (All available Banks)</td>
								<td>0.75% for transaction below INR 2000 + taxes as applicable</td>
							</tr>
							<tr>
								<td>1.00% for transaction INR 2000 and above+ taxes as applicable</td>
							</tr>
							<tr>
								<td>* TDR For  Cash Card (All available cash card)</td>
								<td>1.99%+ taxes as applicable</td>
							</tr>
							<tr>
								<td>*TDR for Wallets  Payzapp (HDFC)</td>
								<td>2.00%+ taxes as applicable</td>
							</tr>
							<tr>
								<td>*TDR for Wallets  Reliance Jio Money</td>
								<td>0.75%+ taxes as applicable</td>
							</tr>
							<tr>
								<td>*TDR for Wallets  Other</td>
								<td>1.85% + taxes as applicable</td>
							</tr>
							
							
						</tbody>
					</table>
					<h6>Service tax and other tax/ taxes if any applicable, will be charged in addition</h6>
					</div>
				
				<hr/>
				
				<h2 id="sec3">Shipping and delivery</h2>
				<h6>Do I have to pay a delivery charge while placing an order?</h6>
				<p>No, LEYKART does not charge delivery fees.</p>
				<h6>Why do I have different estimated delivery dates for different items in my order?</h6>
				<p>The differences in delivery dates for a single order are due to the items being sourced from different sellers.</p>
				<p>As far as possible, we try to deliver all your ordered items together. However, your ordered items may be sourced from different sellers in case they are not available at a single location. This may lead to different delivery times.</p>
				<h6>I missed the delivery of my order. What should I do?</h6>
				<p>The delivery service provider attempts delivery three times. In case you have missed the delivery order at all times, you should the call centre on 18002082525 to know the status of your delivery.</p>
				<h6>The delivery of my order is delayed. What should I do?</h6>
				<p>If the time for your order exceeds the estimated delivery time mentioned in the order status, you should contact the call centre which will take the necessary measures to ensure the fulfilment of your order at the earliest.</p>
				
				<hr/>
				
				<h2 id="sec4">Returns and replacements</h2>
				<h6>Can I cancel an order?</h6>
				<p>You can cancel the order based on preset conditions. Please refer to the Returns, Refunds and Cancellation Policy for the same.</p>
				<h6>Will I get a refund if I cancel my order?</h6>
				<p>You are entitled to receive a refund if you cancel your order based on preset conditions. Please refer to the Returns, Refunds and Cancellation Policy for the same.</p>
				<h6>How many days does a refund take?</h6>
				<p>According to bank policies, a refund shall be reflected within 15 days from the day of initiating the refund. If it is not reflected within this timeframe, please contact the call centre to know the status of the refund.</p>
				<h6>I am not satisfied with the part delivered to me. What should I do?</h6>
				<p>Please refer to the Returns, Refunds and Cancellation Policy in case you want to return the product. For any further queries, please contact the call centre.</p>
				
				<hr/>
				
				<h2 id="sec5">Security and Privacy</h2>
				<h6>Is it safe to make an online payment on LEYKART?</h6>
				<p>The payment gateway merchant is PCI DSS certified and continues to be certified as per required regulations with respect to security obligations.</p>
				<h6>I have spotted a listing infringement. What should I do?</h6>
				<p>We take any infringement report seriously and we ensure severe action is taken against the concerned party. Please contact the call centre if you come across any listing infringement anywhere.</p>
				<h6>I have found a security bug/ issue. What should I do?</h6>
				<p>Please contact the call centre to report the security bug/ issue.</p>
				
				</div>
				</div><!--/right-->
				
			</div><!--/row-->
		</div><!--/container-->



		<!-- Content end-->
		
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
</div><!-- fullPageDiv End-->
	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/showup.js"></script>
	<script src="js/wow.js"></script>
	 -->
	

	
	<script>
		/* activate sidebar */
		$('#sidebar').affix({
		  offset: {
			top: 235
		  }
		});

		/* activate scrollspy menu */
		var $body   = $(document.body);
		var navHeight = $('.navbar').outerHeight(true);

		 $body.scrollspy({
		//	target: '#leftCol',
			offset: navHeight
		});

		/* smooth scrolling sections */
		$('a[href*=#]:not([href=#])').click(function() {
			if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			  var target = $(this.hash);
			  target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			  if (target.length) {
				$('html,body').animate({
				  scrollTop: target.offset().top - 50
				}, 1000);
				return false;
			  }
			}
		});
	</script>
<!-- <script type="text/javascript">
    var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));

    if(!ismobile) document.write('<script src="/scrolloverflow.js"></script>');

</script> -->
</body>
</html>
