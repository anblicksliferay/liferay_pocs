AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
		
		$ = AUI.$;
		
		$(document).ready(function() {
		
			if ($(window).width() > 1200 && $('#fullpage').length) {
				$('#fullpage').fullpage({
					anchors: ['first', 'second', 'third','fourth','fifth'],
					scrollBar: true
				});
			  //Add your javascript for large screens here 
			} 
			else {
			  //Add your javascript for small screens here 
			}
			
			
			
			new WOW().init();
			
			/*$(".carousel-inner").swipe({

				  swipe: function(event, direction, distance, duration, fingerCount, fingerData) {

				    if (direction == 'left') $(this).parent().carousel('next');
				    if (direction == 'right') $(this).parent().carousel('prev');

				  },
				  allowPageScroll:"vertical"

			});*/
			
			if($('.carousel').size() > 0){
			
				
				
				$(".carousel").on("touchstart", function(event){
			        var xClick = event.originalEvent.touches[0].pageX;
				    $(this).one("touchmove", function(event){
				        var xMove = event.originalEvent.touches[0].pageX;
				        if( Math.floor(xClick - xMove) > 5 ){
				            $(".carousel").carousel('next');
				            carouselAuto();
				        }
				        else if( Math.floor(xClick - xMove) < -5 ){
				            $(".carousel").carousel('prev');
				            carouselAuto();
				        }
				    });
				    $(".carousel").on("touchend", function(){
				            $(this).off("touchmove");
				    });
				});
				
				$(".carousel .carousel-indicators li").on("click", function(event){
					carouselAuto();
				});
				
				function carouselAuto(){
					$('.carousel').carousel({
						interval: 3000
				    })
				}
				
				carouselAuto();
				
			}
		
		});
	}
	
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);