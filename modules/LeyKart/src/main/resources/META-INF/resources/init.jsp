<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<script>
    define._amd = define.amd;
    define.amd = false;
</script>
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/fullPage.js/2.9.6/jquery.fullpage.css" />
	 <!-- Bootstrap -->
  <%--  <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet"> --%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/css/bootstrap.min.css" > -->
 <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet">

	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i" rel="stylesheet">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
	<link href="<%=request.getContextPath()%>/css/showup.css" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	

	<!--[if IE]>
		<script type="text/javascript">
			 var console = { log: function() {} };
		</script>
	<![endif]-->
   <!--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
   
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
	<script  type="text/javascript" src="<%=request.getContextPath()%>/vendors/jquery.easings.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/vendors/scrolloverflow.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.waterwheelCarousel.js"></script>
	<script  type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/fullPage.js/2.9.6/jquery.fullpage.js" ></script>
	<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/js/bootstrap.min.js" ></script>
 	<%-- <script  type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script> --%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/showup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/wow.js"></script>
	<script>
    define._amd = define.amd;
</script>
	