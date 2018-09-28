function portletContext(selector){
	return $("#financialdashboard-context ."+selector).text();
}

var worldMap = null;
function dashBoardInit(today,url,portletNameSpace){
	
	var debug =  false;
	var divisionOrProdcutLine = true;
	var expenseId = -1;
	var siteId = -1;
	var regionId = -1;
	var divisionId= -1;
	var productLineId = -1;
	var timeSeriesChartType = 'daily';
	
	var noData = false;
	var endDate = new Date();
	var startDate = new Date();
	var fromDate = $('#from').val();
	var todate = $('#to').val();
	
	if(fromDate.length > 0 && todate.length > 0){
		startDate = new Date(fromDate);
		endDate = new Date(todate);
	}

	function fetchData(cmd,cmdType,context){
		context = JSON.stringify(context);
		if(debug) console.log("fetchData: called with cmd :"+cmd+" cmdType "+cmdType+" context:"+context);
		
		var data  = {};
		data[portletNameSpace+'cmd'] = cmd;
		data[portletNameSpace+'cmdType'] = cmdType;
		data[portletNameSpace+'context'] = context;
		
		$.ajax({  
			url : url,
			data : data,

			type : "POST",
			dataType : "json",
			beforeSend:function(){
				localSpinner("#" + portletContext("portlet-namespace") + "spinner", "open");
			},
			complete:function(){
				localSpinner("#" + portletContext("portlet-namespace") + "spinner", "close");
			},
			success : function(data) {	
				debug=false;
				if(debug) console.log("Return data for "+cmdType );
				if(debug) console.log(data);
				//if(debug) console.log("is empty: "+$.isEmptyObject(data.divisionProdctChart));

				if(cmdType == "divisionProdctChart"){
					if($.isEmptyObject(data.divisionProdctChart)){
						if(debug) console.log('data divisionProdctChart is empty');
						//divisionProdctChart({divisionProdctChart:[]});
						noData = true;
						
					//	$("#divisionChartdiv").parent().hide();
					}else{
						divisionProdctChart(data);
						noData = false;
						
						$("#divisionChartdiv").parent().show();
					}
				}else if(cmdType == "trackerChart"){
					if( data.actualExepnse==0 	&&
						data.actualRevenue==0 	&&
						data.mtdExepnse==0 		&&
						data.mtdRevenue==0 		&&
						data.targetExpense==0 	&&
						data.targetRevenue==0 ){
						if(debug) console.log('data trackerChart is empty');
						//trackerChart(null);
						noData = true;

				//		$(".topchartarea").hide();
						$("#dashWarning").slideDown();
						
					}else{
						trackerChart(data);
						noData = false;

						$(".topchartarea").show();
						$("#dashWarning").slideUp();
						
					}
				}else if(cmdType == "categoryExpenseChart"){
					if($.isEmptyObject(data.categoryExpenseChart)){
						if(debug) console.log('data categoryExpenseChart is empty');
						/*
						var p = [];
						for(var i = 2; i <=6;i++){
							p.push({id:i,actualExepnse:0,mtdTarget:0,targetRevenue:0});
						}
						categoryExpenseChart({categoryExpenseChart:p});
						*/
						
					//	$("#bulletchartdiv").parent().hide();
					}else{
						categoryExpenseChart(data);
						
						$("#bulletchartdiv").parent().show();
					}
				}else if(cmdType='timeSeriesChart'){
					if($.isEmptyObject(data.timeSeriesChart)){
						if(debug) console.log('data timeSeriesChart is empty');
						//updateTimeSeriesChart({timeSeriesChart:[]},cmd);
						
						//$("#timeSeriesChartdiv").parent().hide();
					}else{
						updateTimeSeriesChart(data,cmd);
						
						$("#timeSeriesChartdiv").parent().show();
					}
				}
				localSpinner("#" + portletContext("portlet-namespace") + "spinner", "close");
			},
			error : function(response) {
				console.log("Error seen for updateValues");
				localSpinner("#" + portletContext("portlet-namespace") + "spinner", "close");
			}
		});
	}

	var delphiColors = {
			"mapSelectedColor":"#1b59c9",
			"mapRollOverColor":"#8aa8ce",
			"mapSelectedLocationColor":"#0039a6",
			"mapOutlineColor":"#253f4a",
			"expenseColorGood":"#168839",
			"expenseColorWarn":"#F4D342",
			"expenseColorBad":"#a12a2a"
		};

	var prefixesOfBigNumbers = [{"number":1e+3,"prefix":"k"},{"number":1e+6,"prefix":"M"},{"number":1e+9,"prefix":"B"}];
	
	var regionMap={
		EMEA:2,
		Americas:1,
		Asia:3
	}
	var continents = {
	EMEA: ["AO", "BF", "BI", "BJ", "BW", "CD", "CF", "CG", "CI", "CM", "DJ", "DZ", "EG", "ER", "ET", "GA", "GH", "GM", "GN", "GQ", "GW", "KE", "LR", "LS", "LY", "MA", "MG", "ML", "MR", "MW", "MZ", "NA", "NE", "NG", "RW", "SD", "SL", "SN", "SO", "SS", "SZ", "TD", "TG", "TN", "TZ", "UG", "ZA", "ZM", "ZW", "EH", "KM", "GO", "JU", "SH", "ST", "YT", "BV", "CV", "SC","AL", "AM", "AT", "AZ", "BA", "BE", "BG", "BY", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GB", "GE", "GR", "HR", "HU", "IE", "IS", "IT", "LT", "LU", "LV", "MD", "ME", "MK", "NL", "NO", "PL", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "TR", "UA", "RU", "VA", "MT", "MC", "XK", "LI", "IM", "GI", "FO", "AD", "AX", "GG", "SM","AE","IQ", "IR", "JO","YE","IL","KG","KW", "KZ","LB","OM","PS","QA", "SA", "SY",  "TJ",  "TM",  "UZ","TM","BH"],
	
	Americas: ["BS", "BZ", "CA", "CR", "CU", "DO", "GL", "GT", "HN", "HT", "JM", "MX", "NI", "PA", "PR", "SV", "US", "AG", "AW", "BB", "BL", "GD", "KN", "LC", "MQ", "TC", "VG", "AI", "BM", "DM", "PM", "GP", "KY", "MF", "MS", "SX", "TT", "VC", "VI", "BQ", "CW","AR", "BO", "BR", "CL", "CO", "EC", "FK", "GF", "GY", "PE", "PY", "SR", "UY", "VE", "GS"],
	
	Asia: ["AS", "AU", "BN", "CC", "CX", "FJ", "FM", "GU", "HM", "IO", "KI", "MH", "MO", "MP", "MU", "NC", "NF", "NR", "NU", "NZ", "PG", "PW", "RE", "SB", "TF", "TK", "TL", "TO", "TV", "TW","VU", "WF", "WS", "CK", "PF", "PN","TH","AF", "BD", "BN", "BT", "CN", "ID",  "IN",  "JP",  "KH", "KP", "KR",  "LA",  "LK", "MO","MM", "MN", "MY", "NP",  "PH", "PK",   "TH",  "TL", "TW",  "VN",  "HK", "MV", "SG"]
	};
	/**
	* SVG path for target icon
	*/
	var targetSVG = "M9,0C4.029,0,0,4.029,0,9s4.029,9,9,9s9-4.029,9-9S13.971,0,9,0z M9,15.93 c-3.83,0-6.93-3.1-6.93-6.93S5.17,2.07,9,2.07s6.93,3.1,6.93,6.93S12.83,15.93,9,15.93 M12.5,9c0,1.933-1.567,3.5-3.5,3.5S5.5,10.933,5.5,9S7.067,5.5,9,5.5 S12.5,7.067,12.5,9z";

	/**
	* Format areas array for all continents
	*/
	var color ='';
	var areas = [];
	for (var continent in continents) {
		for (var x in continents[continent]) {
			if(continent=='EMEA'){
				color = '#5b6c8f';
			}else if(continent=='Americas'){
				color = '#356f92';
			} if(continent=='Asia'){
				color = '#75718a';
			}
			if(debug) console.log(continents[continent][x])
		
			areas.push({
				id: continents[continent][x],
				groupId: continent,
				title:continent,
				color:color,
				outlineColor:delphiColors["mapOutlineColor"],
				rollOverColor:delphiColors["mapRollOverColor"],
				selectedColor:delphiColors["mapSelectedColor"]
			});
	}
	}

	/**
	* Create the map
	*/
	var images = [ {
			"id": "1",		
			"svgPath": targetSVG,
			"title": "Kokomo",
			"latitude": 40.486427,
			"longitude": -86.133603,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		},

		{
			"id": "2",		
			"svgPath": targetSVG,
			"title": "Reynosa",
			"latitude": 26.050841,
			"longitude": -98.297895, 
			"zoomLevel": 4.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]		

		}, {
			id: 3,
			"svgPath": targetSVG,
			"title": "Matamoros",
			"latitude": 25.869029,
			"longitude": -97.502738,
			
			"zoomLevel": 4.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		
		}, {
			id:4,
			"svgPath": targetSVG,
			"title": "Jambeiro",
			"latitude": -23.255872,
			"longitude": -45.697638,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		
		}, {
			id:5,
			"svgPath": targetSVG,
			"title": "Barcelona",
			"latitude": 41.385064,
			"longitude": 2.173403,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:6,
			"svgPath": targetSVG,
			"title": "Braga",
			"latitude": 41.545449,
			"longitude": -8.426507,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:7,
			"svgPath": targetSVG,
			"title": "Gdansk",
			"latitude": 54.352025,
			"longitude": 18.646638,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:8,
			"svgPath": targetSVG,
			"title": "Osberghausen",
			"latitude": 51.496334,
			"longitude": 6.863776,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:9,
			"svgPath": targetSVG,
			"title": "St. Aubin",
			"latitude": 46.889748,
			"longitude": 6.980620,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:10,
			"svgPath": targetSVG,
			"title": "Szombathely",
			"latitude": 47.230685,
			"longitude": 16.621844,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:11,
			"svgPath": targetSVG,
			"title": "Chennai",
			"latitude": 13.082680,
			"longitude": 80.270718,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:12,
			"svgPath": targetSVG,
			"title": "Suzhou",
			"latitude": 31.298979,
			"longitude": 120.585290,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:13,
			"svgPath": targetSVG,
			"title": "Singapore",
			"latitude": 1.352083,
			"longitude": 103.819836,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}, {
			id:14,
			"svgPath": targetSVG,
			"title": "Macedonia",
			"latitude": 41.608635,
			"longitude": 21.745275,
			"scale": 1.5,
			"zoomLevel": 2.74,
			"selectedColor":delphiColors["mapSelectedLocationColor"]
		}
		];
	var dataProvider ={
		"map": "worldHigh",
		"getAreasFromMap": false,
		"areas": areas,
		images:images
	};
	worldMap = AmCharts.makeChart("mapByRegiondiv", {
	"type": "map",
	"theme": "light",
	"dataProvider": dataProvider ,
	"balloon": {
		"drop": true
	},
	"areasSettings": {
		"selectable": true,
			outlineColor:delphiColors["mapOutlineColor"],
			rollOverColor:delphiColors["mapRollOverColor"],
			selectedColor:delphiColors["mapSelectedColor"],
			color:delphiColors["mapOutlineColor"]
	}
	});
	
	
	
	var revenueCycleChart = AmCharts.makeChart("revenueCycleDiv", {
		"type": "gauge",// for Expenses expected for month, and to date, and actual to date
		"theme": "light",
		/*"gaugeX":"60%",*/
		"usePrefixes" : "true",
		"allLabels": [{
			x:160
		}],
		"axes": [{
			"axisAlpha": 0,
			"tickAlpha": 0,
			"labelsEnabled": false,
			"startValue": 0,
			"endValue": 100,
			"startAngle": 0,
			"endAngle": 270,
			"bands": [{
			"color": "#eee",//outer band grey = band1
			"startValue": 0,
			"endValue": 100,
			"radius": "100%",
			"innerRadius": "85%"
			}, {
			"color": "#8aa8ce", // Outer band light blue 
			//"color": "#4286f4", // Outer band blue 
			"startValue": 0,
			"endValue": 0, //active end of outer band
			"radius": "100%",
			"innerRadius": "85%",
			"balloonText": "0"// Reynosa targ expense for October 
			}, {
			"color": "#eee",
			"startValue": 0,
			"endValue": 100,
			"radius": "80%",
			"innerRadius": "65%"
			}, {
			"color": "#656565", //middle band 
			"startValue": 0,
			"endValue": 0,
			"radius": "80%",
			"innerRadius": "65%",
			"balloonText": "0" //Reynosa targ daily cumulative expense to 10/15
			}, {
			"color": "#eee",
			"startValue": 0,
			"endValue": 100,
			"radius": "60%",
			"innerRadius": "45%"
			}, {
			"color": "#B9DE55", //Inner band color changes relative to target to date value
			//greenish when less than, yellowish when near but less than, redish when greater than.
			"startValue": 0,
			"endValue": 0,// color changes on a gradient from some green shade toward the middle bar value 
			// as it approaches, then, if greater than middle bar current value, color is some red shade
			//15 = #42F47A, 25 =  #9BE45E, 30=#B9DE55, 40=#F4D342, 41 & beyond=#FF3333
			"radius": "60%",
			"innerRadius": "45%",
			"balloonText": "0" //Actual to date for Reynosa 10/16
			}
		
			]
		}],
		"allLabels": [{
			"text": "Target for Period",
			"x": "49%",
			"y": "5%",
			"size": 10,
			"bold": true,
			//"color": "#4286f4",
			"color": "#8aa8ce", // light blue
			"align": "right"
		}, {
			"text": "Target to Date",
			"x": "49%",
			"y": "15%",
			"size": 10,
			"bold": true,
			"color": "#656565",
			"align": "right"
		}, {
			"text": "Actual to Date",
			"x": "49%",
			"y": "24%",
			"size": 10,
			"bold": true,
			"color": "#000000",
			"align": "right"
		},
		
		],
		"export": {
			"enabled": true
		}
		});
	
	var expenseCycleChart = AmCharts.makeChart("expenseCycleDiv", {
		"type": "gauge",// for Expenses expected for month, and to date, and actual to date
		"theme": "light",
		"usePrefixes" : "true",
		/*"gaugeX":"60%",*/
		"axes": [{
			"axisAlpha": 0,
			"tickAlpha": 0,
			"labelsEnabled": false,
			"startValue": 0,
			"endValue": 100,
			"startAngle": 0,
			"endAngle": 270,
			"bands": [{
			"color": "#eee",//outer band grey = band1
			"startValue": 0,
			"endValue": 100,
			"radius": "100%",
			"innerRadius": "85%"
			}, {
			"color": "#8aa8ce", // Outer band light blue
			//"color": "#4286f4", // Outer band blue
			"startValue": 0,
			"endValue": 0, //active end of outer band
			"radius": "100%",
			"innerRadius": "85%",
			"balloonText": "0"// Reynosa targ expense for October 
			}, {
			"color": "#eee",
			"startValue": 0,
			"endValue": 100,
			"radius": "80%",
			"innerRadius": "65%"
			}, {
			"color": "#ababab", //middle band 
			//"color": "#656565", 
			"startValue": 0,
			"endValue": 0,
			"radius": "80%",
			"innerRadius": "65%",
			"balloonText": "0" //Reynosa targ daily cumulative expense to 10/15
			}, {
			"color": "#eee",
			"startValue": 0,
			"endValue": 100,
			"radius": "60%",
			"innerRadius": "45%"
			}, {
			"color": "#B9DE55", //Inner band color changes relative to target to date value
			//greenish when less than, yellowish when near but less than, redish when greater than.
			"startValue": 0,
			"endValue": 0,// color changes on a gradient from some green shade toward the middle bar value 
			// as it approaches, then, if greater than middle bar current value, color is some red shade
			//15 = #42F47A, 25 =  #9BE45E, 30=#B9DE55, 40=#F4D342, 41 & beyond=#FF3333
			"radius": "60%",
			"innerRadius": "45%",
			"balloonText": "0" //Actual to date for Reynosa 10/16
			}
		
			]
		}],
		"allLabels": [{
			"text": "Target for Period",
			"x": "49%",
			"y": "5%",
			"size": 10,
			"bold": true,
			//"color": "#4286f4",
			"color": "#8aa8ce", 
			"align": "right"
		}, {
			"text": "Target to Date",
			"x": "49%",
			"y": "15%",
			"size": 10,
			"bold": true,
			"color": "#656565",
			"align": "right"
		}, {
			"text": "Actual to Date",
			"x": "49%",
			"y": "24%",
			"size": 10,
			"bold": true,
			"color": "#000000",
			"align": "right"
		},
		
		],
		"export": {
			"enabled": true
		}
		});
	
	var divisionChart = AmCharts.makeChart("divisionChartdiv", {
		"type": "serial",
		"theme": "light",
		"dataDateFormat": "YYYY-MM-DD",
		"precision": 2,
		"usePrefixes" : "true",
		"prefixesOfBigNumbers": prefixesOfBigNumbers,
		"valueAxes": [{
			"id": "v1",
			"title": "Revenue ($)",
			"position": "left",
			"autoGridCount": false,
			
		}, {
			"id": "v2",
			"title": "Expense ($)",
			"gridAlpha": 0,
			"position": "right",
			"autoGridCount": false,
			
		}],
		
		"graphs": [{
			"id": "g3",
			"valueAxis": "v1",
			"lineColor": "#c2c2c2", //light grey
			"fillColors": "#c2c2c2",
			//"lineColor": "#b7d1fb", //light blue
			//"fillColors": "#b7d1fb",
			"fillColorsField": "color",
			"fillAlphas": 1,
			"type": "column",
			"title": "Target Revenue to Date", //was Actual Sales
			"valueField": "sales2",
			"clustered": false,
			"columnWidth": 0.5,
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}, {
			"id": "g4",
			"valueAxis": "v1",
			//Making Actual Revenue different colors
			"fillColorsField":"revenueColor",
			"lineColor": "revenueColor",
			//"lineColor": "#62cf73", //green
			"fillColors": ["#168839", "#F4D342", "#a12a2a"],
			//"fillColors": "#62cf73",
			// "fillColorsField": "color",
			"fillAlphas": 1,
			"type": "column",
			"title": "Actual Revenue",
			"valueField": "sales1",
			"clustered": false,
			"columnWidth": 0.3,
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}, {
			"id": "g1",
			"valueAxis": "v2",
			"bullet": "line",
			"bulletBorderAlpha": 1,
			"bulletColor": "#656565",
			"bulletSize": 30,
			"type": "column", 
			"hideBulletsCount": 40,
			"lineThickness": 0,
			"lineColor": "#656565",  
			"type": "smoothedLine",
			"title": "Target Expense to Date",
			"useLineColorForBulletBorder": true,
			"valueField": "market1",
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}, {
			"id": "g2",
			"valueAxis": "v2",
			"bullet": "line",
			"bulletBorderAlpha": 1,
			"bulletColor":"#2f4050",
			"lineColor": "#2f4050",
			//"bulletColor":"#000000",
			//"lineColor": "#000000",
			//"bulletColor": "#2f4050",
			"bulletSize": 30,
			"hideBulletsCount": 40,
			"lineThickness": 0,
			//"lineColor": "#fb2316",
			"type": "smoothedLine", 
			"title": "Actual Expense",
			"useLineColorForBulletBorder": true,
			"valueField": "market2",
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}],
		"chartCursor": {
			"pan": true,
			"valueLineEnabled": true,
			"valueLineBalloonEnabled": true,
			"cursorAlpha": 0,
			"valueLineAlpha": 0.2
		},
		"categoryField": "division",
		"categoryAxis": {
			//"parseDates": true,
			"dashLength": 1,
			"minorGridEnabled": true
		},
		"legend": {
			"useGraphSettings": true,
			"position": "top",
		},
		"balloon": {
			"borderThickness": 1,
			"shadowAlpha": 0,
			"enabled": false
		},
		"export": {
		"enabled": true
		},
		"dataProvider": []
		});
	
	
	
	
/*  Bullet Charts */
	
	var packagingChart = AmCharts.makeChart( "bulletchartdiv1", {
		"type": "serial",//Reynosa, to Oct 27 
		"rotate": false,
		"theme": "light",
		"autoMargins": true,
		"marginTop": 30,
		"marginLeft": 80,
		"marginBottom": 30,
		"marginRight": 50,
		"usePrefixes" : "true",
			"prefixesOfBigNumbers": prefixesOfBigNumbers,
			"chartCursor": {
				"oneBalloonOnly": false
			},
		"dataProvider": [ {
			"category": "Packaging",
			"excelent": 142801,
			"good": 10,
			"average": 2,
			"poor": 1,
			"bad": 1,
			"limit": 0,//target to date
			"full": 0,//Month target
			"bullet": 0 //actual to date
		} ],
		"valueAxes": [ {
		// "maximum": 200000,//top of scale - greater than Month target to allow overage
			"stackType": "regular",
			"gridAlpha": 0
		} ],
		"startDuration": 1,
		"graphs": [ {
			"valueField": "full",//Outer bar - Month Target
			"showBalloon": true,
			"type": "column",
			"lineAlpha": 0,
			"fillAlphas": 0.8,
			"balloonText": "<b>$[[value]]</b>",
			"fillColors": [ "#8aa8ce" ], //Light Blue
		}, {
			"clustered": false,//Inner bar (actual to date)
			"columnWidth": 0.5,
			"fillAlphas": 1,
			"lineColor": "#a9a9a9", // Medium Grey
			//"lineColor": "#ffffff",
			"fillAlphas": 0.8,
			"fillColors": ["#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228",
						"#f6d32b", 
						"#fb2316", "#fb2316"],
			"gradientOrientation": "vertical",
			"stackable": false,
			"type": "column",
			"valueField": "bullet",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"columnWidth": 0.9,//Target to Date bar
			"lineColor": "#656565", // Dark Grey
			//"lineColor": delphiColors["expenseColorWarn"],
			"lineThickness": 5,
			"noStepRisers": true,
			"stackable": false,
			"type": "step",
			"valueField": "limit",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		} ],
		"columnWidth": 1,
		"categoryField": "category",
		"categoryAxis": {
			"gridAlpha": 0,
			"position": "left"
		}
		} );

		packagingChart.addListener("rollOverGraphItem", onBCTooltipRolloverEvent);
		packagingChart.addListener("rollOutGraphItem", onBCTooltipRolloutEvent);

		var elctricityChart = AmCharts.makeChart( "bulletchartdiv2", {
		"type": "serial",//Reynosa, to Oct 27 
		"rotate": false,
		"theme": "light",
		"autoMargins": true,
		"marginTop": 30,
		"marginLeft": 80,
		"marginBottom": 30,
		"usePrefixes" : "true",
		"prefixesOfBigNumbers": prefixesOfBigNumbers,
			"chartCursor": {
				"oneBalloonOnly": false
			},
		"marginRight": 50,
		"dataProvider": [ {
				"category": "Electricity",
			"excelent": 20,
			"good": 20,
			"average": 20,
			"poor": 20,
			"bad": 20,
			"limit": 0,//Target to date
			"full": 0,//Month target
			"bullet": 0 //Actual to date
		} ],
		"valueAxes": [ {
		//  "maximum": 315000,//top of scale- greater than Month target to allow overage
			"stackType": "regular",
			"gridAlpha": 0
		} ],
		"startDuration": 1,
		"graphs": [ {
			"valueField": "full",//Outer bar - Month Target
			"showBalloon": true,
			"type": "column",
			"lineAlpha": 0,
			"fillAlphas": 0.8,
			"fillColors": [ "#8aa8ce" ], //Light Blue
			//"fillColors": [ "#4286f4" ],
			"gradientOrientation": "vertical",
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"clustered": false,//Inner bar (actual to date)
			"columnWidth": 0.5,
			"fillAlphas": 1,
			"lineColor": "#a9a9a9", // Medium Grey
			//"lineColor": "#ffffff",
			"fillAlphas": 0.8,
			"fillColors": ["#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", 
						"#f6d32b", "#fb2316", 
						"#fb2316"],
			"gradientOrientation": "vertical",
			"stackable": false,
			"type": "column",
			"valueField": "bullet",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"columnWidth": 0.9,//Target to Date bar
			"lineColor": "#656565",
			//"lineColor": delphiColors["expenseColorWarn"],
			"lineThickness": 5,
			"noStepRisers": true,
			"stackable": false,
			"type": "step",
			"valueField": "limit",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		} ],
		"columnWidth": 1,
		"categoryField": "category",
		"categoryAxis": {
			"gridAlpha": 0,
			"position": "left"
		}
		} );
		
		elctricityChart.addListener("rollOverGraphItem", onBCTooltipRolloverEvent);
		elctricityChart.addListener("rollOutGraphItem", onBCTooltipRolloutEvent);

		var maintenanceChart = AmCharts.makeChart( "bulletchartdiv3", {
		"type": "serial",//Reynosa, to Oct 27 
		"rotate": false,
		"theme": "light",
		"autoMargins": true,
		"marginTop": 30,
		"usePrefixes" : "true",
		"prefixesOfBigNumbers": prefixesOfBigNumbers,
			"chartCursor": {
				"oneBalloonOnly": false
			},
		"marginLeft": 80,
		"marginBottom": 30,
		"marginRight": 50,
		"dataProvider": [ {
				"category": "Maint",
			"excelent": 20,
			"good": 20,
			"average": 20,
			"poor": 20,
			"bad": 20,
			"limit": 0,//Target to date
			"full": 0,//Month target
			"bullet": 0//actual to date
		} ],
		"valueAxes": [ {
		// "maximum": 175000,//top of scale - greater than Month target to allow overage
			"stackType": "regular",
			"gridAlpha": 0
		} ],
		"startDuration": 1,
		"graphs": [ {
			"valueField": "full",//Outer bar - Month Target
			"showBalloon": true,
			"type": "column",
			"lineAlpha": 0,
			"fillAlphas": 0.8,
			"fillColors": [ "#8aa8ce" ], // Light Blue
			//"fillColors": [ "#4286f4" ],
			"gradientOrientation": "vertical",
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"clustered": false,//Inner bar (actual to date)
			"columnWidth": 0.5,
			"fillAlphas": 1,
			"lineColor": "#a9a9a9", // Medium Grey
			//"lineColor": "#ffffff",
			"fillAlphas": 0.8,
			"fillColors": ["#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", 
						"#f6d32b", 
						"#fb2316", "#fb2316"],
			"gradientOrientation": "vertical",
			"stackable": false,
			"type": "column",
			"valueField": "bullet",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"columnWidth": 0.9,//Target to Date bar
			"lineColor": "#656565",
			//"lineColor": delphiColors["expenseColorWarn"],
			"lineThickness": 5,
			"noStepRisers": true,
			"stackable": false,
			"type": "step",
			"valueField": "limit",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		} ],
		"columnWidth": 1,
		"categoryField": "category",
		"categoryAxis": {
			"gridAlpha": 0,
			"position": "left"
		}
		} );
		
		maintenanceChart.addListener("rollOverGraphItem", onBCTooltipRolloverEvent);
		maintenanceChart.addListener("rollOutGraphItem", onBCTooltipRolloutEvent);

		var scrapChart = AmCharts.makeChart( "bulletchartdiv4", {
		"type": "serial",//Reynosa, to Oct 27 
		"rotate": false,
		"theme": "light",
		"autoMargins": true,
		"marginTop": 30,
		"marginLeft": 80,
		"marginBottom": 30,
		"marginRight": 50,
		"usePrefixes" : "true",
			"prefixesOfBigNumbers": prefixesOfBigNumbers,
			"chartCursor": {
				"oneBalloonOnly": false
			},
		"dataProvider": [ {
				"category": "Scrap",
			"excelent": 20,
			"good": 20,
			"average": 20,
			"poor": 20,
			"bad": 20,
			"limit": 0,//Target to date
			"full": 0,//Month target
			"bullet": 0//actual to date
		} ],
		"valueAxes": [ {
		// "maximum": 500000,//top of scale - greater than Month target to allow overage
			"stackType": "regular",
			"gridAlpha": 0
		} ],
		"startDuration": 1,
		"graphs": [ {
			"valueField": "full",//Outer bar - Month Target
			"showBalloon": true,
			"type": "column",
			"lineAlpha": 0,
			"fillAlphas": 0.8,
			"fillColors": [ "#8aa8ce" ], // Light Blue
			//"fillColors": [ "#4286f4" ],
			"gradientOrientation": "vertical",
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"clustered": false,//Inner bar (actual to date)
			"columnWidth": 0.5,
			"fillAlphas": 1,
			"lineColor": "#a9a9a9", // Medium Grey
			//"lineColor": "#ffffff",
			"fillAlphas": 0.8,
			"fillColors": ["#19d228", "#19d228","#19d228", "#19d228", "#19d228",
						"#19d228", "#f6d32b", "#fb2316","#fb2316","#fb2316",
						"#fb2316", "#fb2316", "#fb2316"],
			"gradientOrientation": "vertical",
			"stackable": false,
			"type": "column",
			"valueField": "bullet",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"columnWidth": 0.9,//Target to Date bar
			"lineColor": "#656565",
			//"lineColor": delphiColors["expenseColorWarn"],
			"lineThickness": 5,
			"noStepRisers": true,
			"stackable": false,
			"type": "step",
			"valueField": "limit",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		} ],
		"columnWidth": 1,
		"categoryField": "category",
		"categoryAxis": {
			"gridAlpha": 0,
			"position": "left"
		}
		} );
		
		scrapChart.addListener("rollOverGraphItem", onBCTooltipRolloverEvent);
		scrapChart.addListener("rollOutGraphItem", onBCTooltipRolloutEvent);

		var overtimeChart = AmCharts.makeChart( "bulletchartdiv5", {
		"type": "serial",//Reynosa, to Oct 27 
		"rotate": false,
		"theme": "light",
		"usePrefixes" : "true",
			"prefixesOfBigNumbers": prefixesOfBigNumbers,
		"autoMargins": true,
		"marginTop": 30,
		"marginLeft": 80,
		"marginBottom": 30,
		"marginRight": 50,
			"chartCursor": {
				"oneBalloonOnly": false
			},
		"dataProvider": [ {
				"category": "Overtime",
			"excelent": 20,
			"good": 20,
			"average": 20,
			"poor": 20,
			"bad": 20,
			"limit": 0,//Target to date
			"full": 0,//Target for month
			"bullet": 0//Actual to date
		} ],
		"valueAxes": [ {
		//  "maximum": 130000,//top of scale - greater than Month target to allow overage
			"stackType": "regular",
			"gridAlpha": 0
		} ],
		"startDuration": 1,
		"graphs": [ {
			"valueField": "full",//Outer bar - Month Target
			"showBalloon": true,
			"type": "column",
			"lineAlpha": 0,
			"fillAlphas": 0.8,
			"fillColors": [ "#8aa8ce" ], // Light Blue
			//"fillColors": [ "#4286f4" ],
			"gradientOrientation": "vertical",
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"clustered": false,//Inner bar (actual to date)
			"columnWidth": 0.5,
			"fillAlphas": 1,
			"lineColor": "#a9a9a9", // Medium Grey
			//"lineColor": "#ffffff",
			"fillAlphas": 0.8,
			"fillColors": ["#19d228", "#19d228","#19d228", "#19d228", "#19d228","#19d228",
						"#f6d32b"],
			"gradientOrientation": "vertical",
			"stackable": false,
			"type": "column",
			"valueField": "bullet",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		}, {
			"columnWidth": 0.9,//Target to Date bar
			"lineColor": "#656565",
			//"lineColor": delphiColors["expenseColorWarn"],
			"lineThickness": 5,
			"noStepRisers": true,
			"stackable": false,
			"type": "step",
			"valueField": "limit",
			"showBalloon": true,
			"balloonText": "<b>$[[value]]</b>"
		} ],
		"columnWidth": 1,
		"categoryField": "category",
		"categoryAxis": {
			"gridAlpha": 0,
			"position": "left"
		}
	} );
	
	overtimeChart.addListener("rollOverGraphItem", onBCTooltipRolloverEvent);
	overtimeChart.addListener("rollOutGraphItem", onBCTooltipRolloutEvent);
		

	function onBCTooltipRolloverEvent(event) {
		if(debug) console.log("BC TP Rollover");
		if(debug) console.log(event);
		$("#bc-tooltip-target-expense").text("$"+event.item.dataContext.limit);
		$("#bc-tooltip-tfp").text("$"+event.item.dataContext.full);
		if(event.chart.graphs[1].fillColors==delphiColors["expenseColorWarn"]){
			$("#bc-tooltip-expense-warn").text("$"+event.item.dataContext.bullet);
		}else if(event.chart.graphs[1].fillColors==delphiColors["expenseColorBad"]){
			$("#bc-tooltip-expense-bad").text("$"+event.item.dataContext.bullet);
		} else {
			$("#bc-tooltip-expense-good").text("$"+event.item.dataContext.bullet);
		}
	}

	function onBCTooltipRolloutEvent(event) {
		if(debug) console.log("BC TP Rollout");
		$("#bc-tooltip-target-expense").text("");
		$("#bc-tooltip-tfp").text("");
		$("#bc-tooltip-expense-bad").text("");
		$("#bc-tooltip-expense-warn").text("");
		$("#bc-tooltip-expense-good").text("");
	}
	
	$( "#tabs" ).tabs();
	$("#divisontabs").tabs();
		
	function mapListener(event){
		//console.log("--mapListener Event--");
		var mapObject =  event.mapObject;
		regionId = regionMap[mapObject.groupId];
		siteId = mapObject.id;
		var title = mapObject.title;
		for(var i = 0 ; i< images.length;i++){
			images[i].label='';
			images[i].validate();
		}
		mapObject.label = title;
		mapObject.labelColor='#FF0000';
		mapObject.labelColorReal='#FF0000';
		mapObject.validate();

		regionId = regionId?regionId:-1;
		siteId   = parseInt(siteId)?siteId:-1;
		divisionId = -1;
		productLineId = -1;

		//console.log("mapObject.id:"+mapObject.id);
		//console.log("mapObject.title:"+title);
		//console.log(mapObject);
		
		storedSiteId = siteId;
		//console.log(images);
		for(obj in images){
			//console.log(images[obj]);
			//console.log(title+"=="+images[obj]["title"] +" "+(title==images[obj].title));
			if(title==images[obj]["title"]){
				storedSiteId = images[obj].id;
			}
		}
		
		storeDefaultValues("Site", title+"|"+storedSiteId);	
		
		hideNavigationFilter();
		$('#regionNavigation').text(title);
		$('#regionNavigation').show();
		changeAll();

	}

	/**
	* Add event which catches click event and zooms 
	* the map to the corresponding group
	*/
	worldMap.addListener("clickMapObject", mapListener);
	
	worldMap.addListener("homeButtonClicked", function(event) {
		dash.clearFilter();
	});
	
	
	function divisionProdctChart(data){
	divisionChart.graphs[2].title="    "+divisionChart.graphs[2].title;
	divisionChart.graphs[3].title="   "+divisionChart.graphs[3].title;
	var selectedTabTitle = $("#categoryTabs .active").text();
	if(selectedTabTitle==	"Revenue & Expense"){
	//	timeSeriesChart.valueAxes[0].title=selectedTabTitle+" ($)";
		divisionChart.valueAxes[1].title="Expense ($)";
	//	$('#ExpenseId').html(timeSeriesChart.valueAxes[1].title);
	}else{
		//timeSeriesChart.valueAxes[0].title=selectedTabTitle+" Expense ($)";
		divisionChart.valueAxes[1].title=selectedTabTitle+" Expense ($)";
	//	$('#ExpenseId').html(timeSeriesChart.valueAxes[1].title);
	}
		var dataProvider = [];
		var chartData = data.divisionProdctChart;
		for (var i = 0; i < chartData.length ; i++) {
			var d = chartData[i];
			var data = {division:d.name,sales1:d.actualRevenue,sales2:d.targetRevenue,market1:d.targetExpense,market2:d.actualExepnse,expenseColor: getExpenseColor(d.actualExepnse, d.targetExpense), revenueColor: getRevenueColor(d.actualRevenue, d.targetRevenue),id:d.id};
			data.color = divisionOrProdcutLine ? ((d.id == divisionId)?"#FF9E01":""):((d.id == productLineId)?"#FF9E01":"");
			dataProvider.push(data);
		}
		divisionChart.dataProvider = dataProvider;
		divisionChart.validateData();
	}

	
	divisionChart.addListener('clickGraphItem',function(e){
		
		if(debug) console.log(e);
		
		var item = e.item.dataContext;
		
		var dataProvider =divisionChart.dataProvider  ;
		
		for(var i  in dataProvider){
			if(dataProvider[i].id == item.id){
				dataProvider[i].color = "#FF9E01";
			}else{
				dataProvider[i].color = "";
			}
		}
		
		if(debug) console.log("selected division id : "+item.id);
		if(divisionOrProdcutLine){
			divisionId = item.id;
			productLineId = -1;
			$('#divisionNavigation').text(item.division);
			$('#divisionNavigation').show();
			$('#productNavigation').hide();
		}else{
			productLineId = item.id;
		
			$('#productNavigation').text(item.division);
			$('#productNavigation').show();
		}
		
		divisionChart.validateData();
		updateAlltracker();
	});


	function trackerChart(data){
		var showMiddleBar = (new Date(today).getTime()) > (new Date($('#to').val()).getTime()) ? false: true;
		
		if(data.mtdExepnse == 0 || data.targetExpense == 0){
			if(debug) console.log('data.mtdExepnse == 0 || data.targetExpense == 0 ');
			var bands = expenseCycleChart.axes[0].bands;
			bands[1].endValue =0;
			bands[3].endValue =0;
			bands[5].endValue =0;
			expenseCycleChart.validateNow();
		
			bands = revenueCycleChart.axes[0].bands;
			bands[1].endValue =0;
			bands[3].endValue =0;
			bands[5].endValue =0;
			revenueCycleChart.validateNow(); 
			if(debug) console.log('there is no data for trackerChart ');
			return;
		}

		var bands = expenseCycleChart.axes[0].bands;
		var allLabels = expenseCycleChart.allLabels;
		bands[1].balloonText='$'+formatNumber(data.mtdExepnse);
		bands[1].endValue = 85;
		
		if(showMiddleBar){
			bands[3].color = "#656565";
			bands[3].balloonText='$'+formatNumber(data.targetExpense);
			if(debug) console.log('bands[3].endValue : '+((85*data.targetExpense)/data.mtdExepnse));
			bands[3].endValue =  (85*data.targetExpense)/data.mtdExepnse;
			allLabels[1].text="Target to Date";
			allLabels[2].text="Actual to Date";
		}else{
			bands[3].color = '#eee';
			bands[3].balloonText='';
			bands[3].endValue =  100;
			allLabels[1].text='';
			allLabels[2].text="Actual for Period";
		}
		
		bands[5].balloonText='$'+formatNumber(data.actualExepnse);
		bands[5].endValue =  (85*data.actualExepnse)/data.mtdExepnse;
		
		if(debug) console.log('bands[5].endValue : '+((85*data.actualExepnse)/data.mtdExepnse));
		
		var totalExpensePerct = (data.actualExepnse / data.targetExpense) * 100;
		if(totalExpensePerct < 95){
			//green
			bands[5].color = delphiColors["expenseColorGood"];
		}else if(totalExpensePerct > 105){
			//red
			bands[5].color = delphiColors["expenseColorBad"];
		}else{
			//yellow
			bands[5].color = delphiColors["expenseColorWarn"];
		}
		expenseCycleChart.validateNow();
		
		
		var bands = revenueCycleChart.axes[0].bands;
		allLabels = revenueCycleChart.allLabels;
		bands[1].balloonText='$'+formatNumber(data.mtdRevenue);
		bands[1].endValue = 85;
		
		if(showMiddleBar){
			bands[3].color = "#656565";
			bands[3].balloonText='$'+formatNumber(data.targetRevenue);
			bands[3].endValue =  (85*data.targetRevenue)/data.mtdRevenue;
			allLabels[1].text="Target to Date";
			allLabels[2].text="Actual to Date";
		}else{
			bands[3].color = '#eee';
			bands[3].balloonText='';
			bands[3].endValue =  100;
			allLabels[1].text='';
			allLabels[2].text="Actual for Period";
		}
		
		
		bands[5].balloonText='$'+formatNumber(data.actualRevenue);
		bands[5].endValue =  (85*data.actualRevenue)/data.mtdRevenue;	
		var totalRevPerct = (data.actualRevenue / data.targetRevenue) * 100;
		
		if(totalRevPerct < 95){
			//red
			bands[5].color = delphiColors["expenseColorBad"];
		}else if(totalRevPerct > 105){
			//green
			bands[5].color = delphiColors["expenseColorGood"];
		}else{
			//yellow
			bands[5].color = delphiColors["expenseColorWarn"];
		} 
		
		revenueCycleChart.validateNow(); 
	}

	function categoryExpenseChart(data){
		var chartData =  data.categoryExpenseChart;
		var chart;
		for (var i = chartData.length - 1; i >= 0; i--) {
			switch(chartData[i].id ){
				case 2: chart = elctricityChart; break;
				case 3: chart = maintenanceChart; break;
				case 4: chart = scrapChart; break;
				case 5: chart = overtimeChart; break;
				case 6: chart = packagingChart; break;
			}
			
			chart.dataProvider[0].limit=chartData[i].targetRevenue;
			chart.dataProvider[0].full=chartData[i].mtdTarget;
			chart.dataProvider[0].bullet=chartData[i].actualExepnse;
			chart.graphs[1].fillColors=getExpenseColor(chartData[i].actualExepnse, chartData[i].targetRevenue);
			//chart.valueAxes[0].maximum = (chartData[i].mtdTarget * 1.05);
			//chart.valueAxes[0].updateData();
			chart.validateData();
		}
	}

	function updateTimeSeriesChart(data,cmd){
		var selectedTabTitle = $("#categoryTabs .active").text();
		if(selectedTabTitle==	"Revenue & Expense"){
		//	timeSeriesChart.valueAxes[0].title=selectedTabTitle+" ($)";
			timeSeriesChart.valueAxes[1].title="Expense ($)";
			$('#ExpenseId').html(timeSeriesChart.valueAxes[1].title);
		}else{
			//timeSeriesChart.valueAxes[0].title=selectedTabTitle+" Expense ($)";
			timeSeriesChart.valueAxes[1].title=selectedTabTitle+" Expense ($)";
			$('#ExpenseId').html(timeSeriesChart.valueAxes[1].title);
		}
		
		if(cmd == 'daily'){
			timeSeriesChart.dataDateFormat = "YYYY-MM-DD";
			timeSeriesChart.categoryAxis.minPeriod = "DD";
		}else  if(cmd == 'monthly'){
				timeSeriesChart.dataDateFormat = "YYYY-MM";
				timeSeriesChart.categoryAxis.minPeriod = "MM";
		} else{
				timeSeriesChart.dataDateFormat = "YYYY";
				timeSeriesChart.categoryAxis.minPeriod = "YYYY";
		}
		
		timeSeriesChart.validateData();
		var dataProvider = [];
		var d;
		var chartData = data.timeSeriesChart;
		for(var i =0;i < chartData.length;i++){
			d = chartData[i];
			dataProvider.push({date:d.date,market1:d.targetExpense,market2:d.actualExepnse,sales1:d.actualRevenue,sales2:d.targetRevenue, expenseColor: getExpenseColor(d.actualExepnse, d.targetExpense), revenueColor: getRevenueColor(d.actualRevenue, d.targetRevenue)});
		}
		timeSeriesChart.dataProvider = dataProvider;
		timeSeriesChart.validateData();
		if(timeSeriesChartType =='daily'){
			var from = new Date($('#from').val());
			var to = new Date($('#to').val());
			var currentDate =  new Date(today);
			
			if(to.getMonth() == currentDate.getMonth()){
				timeSeriesChart.zoomToDates( from, currentDate);
			}else{
				timeSeriesChart.zoomOut();
			}
			
		}else{
			timeSeriesChart.zoomOut();
		}
	}	

	function getExpenseColor(actualExepnse,targetExpense){
		var totalExpensePerct = (actualExepnse / targetExpense) * 100;
		var color;
		if(totalExpensePerct < 95){
			//green
			color = delphiColors["expenseColorGood"];
		}else if(totalExpensePerct > 100){
			//red
			color = delphiColors["expenseColorBad"];
		}else{
			//yellow
			color = delphiColors["expenseColorWarn"];
		}
		return color;
	}
	
	function getRevenueColor(actualRevenue,targetRevenue){
		var totalRevenuePerct = (actualRevenue / targetRevenue) * 100;
		var color;
		if(totalRevenuePerct < 95){
			//red
			color = delphiColors["expenseColorBad"];
		}else if(totalRevenuePerct >= 100){
			//green
			color = delphiColors["expenseColorGood"];
		}else{
			//yellow
			color = delphiColors["expenseColorWarn"];
		}
		return color;
	}

	
	//changes for datePicker
	//$( function() {
		var dateFormat = "mm/dd/yy",
		from = $( "#from" )
			.datepick({
			showOn: "button",
		buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
		buttonImageOnly: true,
			defaultDate: "+1w",
			changeMonth: true,
			minDate : new Date( $("#allStartDate").val()),
			maxDate : new Date(),
			monthNames: monthNamesShort,
			todayText: todayText,
			clearText: clearText,
			closeText: closeText,
			prevText: "&lt;",
			nextText: "&gt;",
			numberOfMonths: 1,
			onSelect: function (dates) {
			$(".dashboard-controls input[type='button']").removeClass('activeButton');
			to.datepick( "option", "minDate", getDate( this ) );
			refreshDateChange();
			}
			}),
		to = $( "#to" ).datepick({
		showOn: "button",
		buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
		buttonImageOnly: true,
			defaultDate: "+1w",
			changeMonth: true,
			minDate : new Date( $("#allStartDate").val()),
			maxDate: new Date(new Date().getFullYear(), 11, 31),
			monthNames: monthNamesShort,
			todayText: todayText,
			clearText: clearText,
			closeText: closeText,
			prevText: "&lt;",
			nextText: "&gt;",
			numberOfMonths: 1,
			onSelect: function (dates) {
				$(".dashboard-controls input[type='button']").removeClass('activeButton');
				from.datepick( "option", "maxDate", getDate( this ) );
				refreshDateChange();
			}
		});
	
		function getDate( element ) {
			var date;
			try {
				date = $.datepicker.parseDate( dateFormat, element.value );
			} catch( error ) {
				date = null;
			}
		
			return date;
		}
		
		
		$( "#mtd" ).click(function() {
			$(".dashboard-controls input[type='button']").removeClass('activeButton');
			$("#mtd").toggleClass('activeButton');
			var today = new Date();
			var endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
			var priorDate = new Date(today.getFullYear(), today.getMonth(), 1);
			var startDate = (priorDate.getMonth()+1)  + '/' + priorDate.getDate() + '/' +  priorDate.getFullYear();
			var toDate = (endDate.getMonth()+1)  + '/' + endDate.getDate() + '/' +  endDate.getFullYear();
			$("#to").val(toDate);
			$("#from").val(startDate);
			refreshDateChange();
			storeDefaultValues("TimePeriod", "mtd");
		}); 
		
		$( "#3mtd" ).click(function() {
			$(".dashboard-controls input[type='button']").removeClass('activeButton');
			$("#3mtd").toggleClass('activeButton'); 
			var today = new Date();
			var endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
			var priorDate = new Date(today.getFullYear(), today.getMonth() - 2, 1);
			var startDate = (priorDate.getMonth()+1)  + '/' + priorDate.getDate() + '/' +  priorDate.getFullYear();
			var endDate = (endDate.getMonth()+1)  + '/' + endDate.getDate() + '/' +  endDate.getFullYear();
			$("#to").val(endDate);
			$("#from").val(startDate);
			refreshDateChange();
			storeDefaultValues("TimePeriod", "3mtd");
		}); 
		
		$( "#6mtd" ).click(function() {
			$(".dashboard-controls input[type='button']").removeClass('activeButton');
			$("#6mtd").toggleClass('activeButton'); 
			var today = new Date();
			var endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
			var priorDate = new Date(today.getFullYear(), today.getMonth() - 5, 1);
			var startDate = (priorDate.getMonth()+1)  + '/' + priorDate.getDate() + '/' +  priorDate.getFullYear();
			var endDate = (endDate.getMonth()+1)  + '/' + endDate.getDate() + '/' +  endDate.getFullYear();
			$("#to").val(endDate);
			$("#from").val(startDate);
			refreshDateChange();
			storeDefaultValues("TimePeriod", "6mtd");
		}); 
		
		$( "#ytd" ).click(function() {
			$(".dashboard-controls input[type='button']").removeClass('activeButton');
			$("#ytd").toggleClass('activeButton'); 
			var today = new Date();
			var endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
			var priorDate = new Date(today.getFullYear(), 0, 1);
			var startDate = (priorDate.getMonth()+1)  + '/' + priorDate.getDate() + '/' +  priorDate.getFullYear();
			var endDate = (endDate.getMonth()+1)  + '/' + endDate.getDate() + '/' +  endDate.getFullYear();
			$("#to").val(endDate);
			$("#from").val(startDate);
			refreshDateChange();
			storeDefaultValues("TimePeriod", "ytd");
		}); 
		
		$( "#all" ).click(function() {
			$(".dashboard-controls input[type='button']").removeClass('activeButton');
			$("#all").toggleClass('activeButton'); 
			var today = new Date();
			var endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
			var endDate = (endDate.getMonth()+1)  + '/' + endDate.getDate() + '/' +  endDate.getFullYear();
			var priorDate =new Date();
			var startValue =  $("#allStartDate").val();
			if( startValue!=null && startValue.length > 0){
				priorDate=new Date(startValue);
			}
			var startDate = (priorDate.getMonth()+1)  + '/' + priorDate.getDate() + '/' +  priorDate.getFullYear();
			$("#to").val(endDate);
			$("#from").val(startDate);
			refreshDateChange();
			storeDefaultValues("TimePeriod", "all");
		}); 
	//} );
	
	//on page load set the start and end date
	//MTD
	var today = new Date();
	var endDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
	var priorDate = new Date(today.getFullYear(), today.getMonth() , 1);
	var startDate = (priorDate.getMonth()+1)  + '/' + priorDate.getDate() + '/' +  priorDate.getFullYear();
	var endDate = (endDate.getMonth()+1)  + '/' + endDate.getDate() + '/' +  endDate.getFullYear();
	$("#to").val(endDate);
	$("#from").val(startDate);
	refreshDateChange();
	$(".dashboard-controls input[type='button']").removeClass('activeButton');
	$("#mtd").toggleClass('activeButton');
	
	function showBalloonAtCategory(){
		var cat = document.getElementById("category").value;
		chartCursor.showCursorAt(cat);
	}
	
	//changes for 
	var timeSeriesChart = AmCharts.makeChart("timeSeriesChartdiv", {
		"type": "serial",
		"theme": "light",
		"dataDateFormat": "YYYY-MM-DD",
		"usePrefixes" : "true",
			"prefixesOfBigNumbers": prefixesOfBigNumbers,
		"valueAxes": [{
			"id": "v1",
			"title": "Revenue ($)",
			"position": "left",
			"autoGridCount": false
		
		}, {
			"id": "v2",
			"title": "Expense ($)",
			"gridAlpha": 0,
			"position": "right",
			"autoGridCount": false
			}
		],
		
		"graphs": [{
			"id": "g3",
			"valueAxis": "v1",
			"lineColor": "#c2c2c2", //light grey
			"fillColors": "#c2c2c2",
		// "lineColor": "#b7d1fb", //light blue
		// "fillColors": "#b7d1fb",
			"fillAlphas": 1,
			"type": "column",
			"title": "Target Revenue", //was Actual Sales
			"valueField": "sales2",
			"clustered": false,
			"columnWidth": 0.5,
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}, {
			"id": "g4",
			"valueAxis": "v1",
			"lineColor": "revenueColor", //green
			"fillColorsField":"revenueColor",
			//"fillColors": "#62cf73",
			"fillColors": ["#168839", "#F4D342", "#a12a2a"], // legend color
			"fillAlphas": 1,
			"type": "column",
			"title": "Actual Revenue",
			"valueField": "sales1",
			"clustered": false,
			"columnWidth": 0.3,
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}, {
			"id": "g1",
			"valueAxis": "v2",
			"bullet": "round",
			"bulletBorderAlpha": 1,
			"bulletColor": "#808080",//pink
			"bulletSize": 5,
			"hideBulletsCount": 50,
			"lineThickness": 2,
			"lineColor": "#808080", 
			"type": "smoothedLine",
			"dashLength": 5,
			"title": "Target Expense",
			"useLineColorForBulletBorder": true,
			"valueField": "market1",
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}, {
			"id": "g2",
			"valueAxis": "v2",
			"bullet": "round",
			"bulletBorderAlpha": 1,
			"colorField": "expenseColor",
			"bulletColor": "#2f4050",
			//"bulletColor": "#000000",
			//"bulletColor": "#fb2316",
			"bulletSize": 7,
			"hideBulletsCount": 50,
			"lineThickness": 2,
			"lineColor": "#2f4050",
			//"lineColor": "#fb2316",
			//"lineColor": "#000000",
			"type": "smoothedLine", 
			"title": "Actual Expense",
			"useLineColorForBulletBorder": true,
			"bulletBorderThickness":1,
			"valueField": "market2",
			"legendValueText": "$[[value]]",
			"balloonText": "<b>$[[value]]</b>",
			"showBalloon" : false
		}],
		"chartScrollbar": {
			"graph": "g1",
			"oppositeAxis": false,
			"offset": 30,
			"scrollbarHeight": 50,
			"backgroundAlpha": 0,
			"selectedBackgroundAlpha": 0.1,
			"selectedBackgroundColor": "#888888",
			"graphFillAlpha": 0,
			"graphLineAlpha": 0.5,
			"selectedGraphFillAlpha": 0,
			"selectedGraphLineAlpha": 1,
			"autoGridCount": true,
			"color": "#AAAAAA"
		},
		"chartCursor": {
			"pan": true,
			"valueLineEnabled": true,
			"valueLineBalloonEnabled": true,
			"cursorAlpha": 0,
			"valueLineAlpha": 0.2
		},
		"categoryField": "date",
		"categoryAxis": {
			"parseDates": true,
			"dashLength": 1,
			"minorGridEnabled": true
		},
		"legend": {
			"useGraphSettings": true,
			"position": "top"
		},
		"balloon": {
			"borderThickness": 1,
			"shadowAlpha": 0,
			"enabled": false
		},
		"export": {
			"enabled": true
		},
		"zoomOutOnDataUpdate": false,
		"dataProvider": []
	});
		
	var ranges = [
	  { divider: 1e9 , suffix: 'B' },  
	  { divider: 1e6 , suffix: 'M' },
	  { divider: 1e3 , suffix: 'k' }
	];
	
	this.onDivisionChartToggle = function (elem){
		if(debug) console.log("--onDivisionChartToggle--");
		if(debug) console.log($(elem).val());
		$(elem).parent().find("span").removeClass("active");
		$(elem).addClass("active");
		
		divisionOrProdcutLine = ($(elem).text()=="Divisions");
		
		redrawDivisionProdctChart();
		if(divisionOrProdcutLine)
			storeDefaultValues("DivisionProductLine", "division");
		else
			storeDefaultValues("DivisionProductLine", "product");

		return false;
	}
	
	function formatNumber(n) {
		for (var i = 0; i < ranges.length; i++) {
			if (n >= ranges[i].divider) {
				return (n / ranges[i].divider).toFixed(2).toString() + ranges[i].suffix;
			}
		}
		return n.toString();
	}	
	
	function refreshDateChange(){
		var fromDate = $('#from').val();
		var todate = $('#to').val();
		var startDate = new Date(fromDate);
		var endDate = new Date(todate);
	
		changeAll();
	}
	
	function changeAll(){
		redrawDivisionProdctChart();
		updateAlltracker();
		if(noData == true){
			$("#dashWarning").slideDown();
		}else{
			$("#dashWarning").slideUp();
		}
	}
	
	$('#monthTab').click(function(e){
		e.preventDefault();
		$('#monthTab').addClass("active");
		$('#yearTab').removeClass("active");
		$('#dayTab').removeClass("active");
		timeSeriesChartType ='monthly';
		redrawTimeSeriesChart('monthly');
		storeDefaultValues("ChartDuration", "monthTab");
	});
	$('#yearTab').click(function(e){
		e.preventDefault();
		$('#monthTab').removeClass("active");
		$('#yearTab').addClass("active");
		$('#dayTab').removeClass("active");
		timeSeriesChartType ='yearly';
		redrawTimeSeriesChart('yearly');
		storeDefaultValues("ChartDuration", "yearTab");
	});
	$('#dayTab').click(function(e){
		e.preventDefault();
		$('#monthTab').removeClass("active");
		$('#yearTab').removeClass("active");
		$('#dayTab').addClass("active");
		timeSeriesChartType ='daily';
		redrawTimeSeriesChart('daily');
		storeDefaultValues("ChartDuration", "dayTab");
	});

	function hideNavigationFilter(){
		$('#regionNavigation').hide();
		$('#divisionNavigation').hide();
		$('#productNavigation').hide();
	}
	hideNavigationFilter();
	$('#regionNavigation').click(function(){
		dash.clearFilter();
	});
	$('#divisionNavigation').click(function(e){
		e.preventDefault();
		$('#divisionNavigation').hide();
		$('#productNavigation').hide();
		divisionId= -1;
		productLineId = -1;
		var dataProvider =divisionChart.dataProvider  ;

		for(var i  in dataProvider){
				dataProvider[i].color = "";		
		}
		divisionChart.validateData();
		updateAlltracker();
		
		if(!divisionOrProdcutLine){
			redrawDivisionProdctChart();
		}
	});
	$('#productNavigation').click(function(){
		$('#productNavigation').hide();
		productLineId = -1;
		var dataProvider =divisionChart.dataProvider  ;

		for(var i  in dataProvider){
				dataProvider[i].color = "";		
		}
		divisionChart.validateData();
		updateAlltracker();
	});

	function updateAlltracker(){
		redrawTimeSeriesChart();
		redrawTrackerChart();
		if(expenseId ==-1){
			redrawCategoryExpenseChart();	
		}
		if(noData == true){
			$("#dashWarninig").show();
		}else{
			$("#dashWarninig").hide();
		}
	}
	
	this.update = updateAlltracker;
	this.changeAll = changeAll;
	
	this.clearFilter =function (){
		hideNavigationFilter();
		for(var i = 0 ; i< images.length;i++){
			images[i].label='';
			images[i].validate();
		}
		worldMap.validateData();

		var dataProvider =divisionChart.dataProvider  ;

		for(var i  in dataProvider){
			dataProvider[i].color = "";		
		}
		divisionChart.validateData();
		divisionOrProdcutLine = true;
		siteId = -1;
		regionId = -1;
		divisionId= -1;
		productLineId = -1;
		changeAll();
	}

	function redrawTimeSeriesChart(cmd){
		var context = {siteId:siteId,expenseId:expenseId,regionId:regionId,startDate: $("#from").val(),endDate:$('#to').val(),productLineId: productLineId,divisionId: divisionId};		
		
		fetchData(timeSeriesChartType,"timeSeriesChart",context);
	}
	
	function redrawDivisionProdctChart(){
		var context = {siteId:siteId,expenseId:expenseId,regionId:regionId,startDate: $("#from").val(),endDate:$('#to').val()};
		var cmd = "product";
		if(divisionOrProdcutLine){			
				cmd = "division";				
		}else{
			context.divisionId = divisionId;
		}
		fetchData(cmd,"divisionProdctChart",context);
	}

	function redrawTrackerChart(){
		var context = {siteId:siteId,expenseId:expenseId,regionId:regionId,productLineId: productLineId,divisionId: divisionId,startDate: $("#from").val(),endDate:$('#to').val()};
		
		fetchData("trackerChart","trackerChart",context);
	}
	
	function redrawCategoryExpenseChart(){
		var context = {siteId:siteId,expenseId:expenseId,regionId:regionId,startDate: $("#from").val(),endDate:$('#to').val(),productLineId: productLineId,divisionId: divisionId};
		
		fetchData("categoryExpenseChart","categoryExpenseChart",context);
	}
	
	this.openTab = function (evt, index){
		expenseId = index;   
		
		if(debug) console.log('index : '+index);
		
		$('#categoryTabs').find('a').removeClass("active");
		evt.target.className += " active";
		
		if(index != -1){
			$('#bulletchartdiv').hide();
		}else{			
			$('#bulletchartdiv').show();
		}
		
		changeAll();
		storeDefaultValues("ExpenseCategory", "categoryTabs"+expenseId);
	}
	
	function toDateString(date){
		return date.getMonth()+'/'+date.getDate()+'/'+date.getFullYear();
	}
	
	function storeDefaultValues(id, value){
		
		var cmd = "storeDefault";
		var cmdType= "storeDefault";
		var context = {fieldid:id, fieldvalue:value};	
		context = JSON.stringify(context);
		console.log('context - '+ context);
		var data  = {};
		data[portletNameSpace+'cmd'] = cmd;
		data[portletNameSpace+'cmdType'] = cmdType;
		data[portletNameSpace+'context'] = context;
		
		$.ajax({  
				url : url,
				data : data,
	
				type : "POST",
				dataType : "json",
				success : function(data) {
					console.log("Sucessfully storeDefaultValues Response");
				},
				error : function(response) {
					console.log("Error seen for storeDefaultValues Response");
				}
		});
	}
}