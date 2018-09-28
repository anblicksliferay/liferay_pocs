AUI().ready(function() {

	console.log("MFG Cookie is set to "+$.cookie("delphi_mfg_mobile_pin"));
	
	$(".toggle-controls").removeClass("visible-xs");
	
	$(".dropdown-toggle").on("click",function(){
		$(this).parent().find("> .dropdown-menu").toggle();
	})
	
	if(undefined == $.cookie("delphi_mfg_mobile_pin") ){
		$("html").addClass("pinned");
		$("i.icon-pushpin").addClass("active");
	} else if ("on" ==  $.cookie("delphi_mfg_mobile_pin") ){
		$("html").addClass("pinned");
		$("i.icon-pushpin").addClass("active");
	} else {
		$("html").removeClass("pinned");
		$("i.icon-pushpin").removeClass("active");
		$("body").addClass("mini-navbar");
	}
	
	$(".icon-pushpin").on("click",function(){

		$(this).toggleClass("active");
		
		if(!$("body").hasClass("mini-navbar")){
			$("body").addClass("mini-navbar");
            SmoothlyMenu();
            //event.preventDefault();
		}
		
		if($(this).hasClass("active")){
			$("html body.mini-navbar #page-wrapper").css("marginLeft","");
			$.cookie("delphi_mfg_mobile_pin","on");
			$("html").addClass("pinned");
		}else{
			$("html").removeClass("pinned");
			$.cookie("delphi_mfg_mobile_pin","off");
		}
	});
	
	if( !$("html").hasClass("pinned") ){
	    $('.li-display').addClass('hidden');
	    console.log("Defaulting to hidden for .li-display");
	}

	$('#top-navigation').hover(function () {
		if( !$("html").hasClass("pinned") ){
			$('.li-display').removeClass('hidden');
			$("html body.mini-navbar #page-wrapper").css("marginLeft",55);
		}
	}, function () {
		if( !$("html").hasClass("pinned") ){
			$('.li-display').addClass('hidden');
		}
	});


	// Clones Control Menu to Wrapper
	setTimeout(function(){
		$( "#controlMenu" ).clone().appendTo( "#UserControls" );
	}, 500);
	$( "#controlMenu" ).animate({opacity:1.0},600);
	
	// Hide portlet topper for non-admin users
	$(".portlet-topper").each(function(){
	    if($(this).find(".portlet-options").length==0) $(this).addClass("hidden");
	});
});



Liferay.Portlet.ready(
	function(portletId, node) {
	}
);

Liferay.on('allPortletsReady',
	function() {
	
	}
);





