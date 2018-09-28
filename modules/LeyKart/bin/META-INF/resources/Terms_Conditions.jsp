<%@ include file="/init.jsp" %>
<div id="fullpage" style="height: 100%;position: relative;margin-left: -30px;margin-top: -76px;margin-right: -25px;">
	
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
		
		<!-- inner banner strat-->
		<div class="header-container privacy-policy-banners">
			<div class="container">
				<div class="txt-container">
				<h1>Terms &amp; Conditions</h1>
				</div>
			</div>
		</div>
		<!-- inner banner end-->
		
		<!-- Content start-->
		<div class="container">
			<div class="row mtmb30">
				<div><img src="<%=request.getContextPath()%>/images/Address-logo.jpg" class="mb15" alt="Leykart logo" /></div>
				<p>Lorem ipsum dolor sit amet, ad quot erat option mea, alia diceret usu cu. Cu vel audiam constituam, unum sale ne eos, no ullum fastidii concludaturque has. Sanctus corpora argumentum ea sea, solum posse cu eum, omnesque accusata comprehensam ad est. Sed te quas scripta suscipit, qui vivendo similique ea. Id cum nibh persius, est at tation eruditi cotidieque. Mel ne oratio facete, quo illud facilisi referrentur ea. Nec ut purto ridens, eos posse moderatius et. Lorem ipsum dolor sit amet, ad quot erat option mea, alia diceret usu cu. Cu vel audiam constituam, unum sale ne eos, no ullum fastidii concludaturque has. Sanctus corpora argumentum ea sea, solum posse cu eum, omnesque accusata comprehensam ad est. Sed te quas scripta suscipit, qui vivendo similique ea. Id cum nibh persius, est at tation eruditi cotidieque. Mel ne oratio facete, quo illud facilisi referrentur ea. Nec ut purto ridens, eos posse moderatius et.</p>
				<p>Lorem ipsum dolor sit amet, ad quot erat option mea, alia diceret usu cu. Cu vel audiam constituam, unum sale ne eos, no ullum fastidii concludaturque has. Sanctus corpora argumentum ea sea, solum posse cu eum, omnesque accusata comprehensam ad est. Sed te quas scripta suscipit, qui vivendo similique ea. Id cum nibh persius, est at tation eruditi cotidieque. Mel ne oratio facete, quo illud facilisi referrentur ea. Nec ut purto ridens, eos posse moderatius et.</p>
			</div>
		</div>
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
	<script src="js/bootstrap.min.js"></script>
	<script src="js/showup.js"></script>
	<script src="js/wow.js"></script>
	
	<script>
	  new WOW().init();
	  </script>
	<script>
		$('.carousel').carousel({
			interval: 3000
		})
		
	</script>
	<script>
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
</body>
</html>
