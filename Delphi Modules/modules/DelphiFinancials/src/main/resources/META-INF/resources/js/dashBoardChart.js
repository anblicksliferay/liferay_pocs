var gaugeChart = AmCharts.makeChart("rightCycleChart", {
  "type": "gauge",// for Expenses expected for month, and to date, and actual to date
  "theme": "light",
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
      "color": "#4286f4", // Outer band blue
      "startValue": 0,
      "endValue": 80, //active end of outer band
      "radius": "100%",
      "innerRadius": "85%",
      "balloonText": "$164,173"// Reynosa targ expense for October 
    }, {
      "color": "#eee",
      "startValue": 0,
      "endValue": 100,
      "radius": "80%",
      "innerRadius": "65%"
    }, {
      "color": "#F4D342", //middle band 
      "startValue": 0,
      "endValue": 40,
      "radius": "80%",
      "innerRadius": "65%",
      "balloonText": "$82,090" //Reynosa targ daily cumulative expense to 10/15
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
      "endValue": 37,// color changes on a gradient from some green shade toward the middle bar value 
      // as it approaches, then, if greater than middle bar current value, color is some red shade
      //15 = #42F47A, 25 =  #9BE45E, 30=#B9DE55, 40=#F4D342, 41 & beyond=#FF3333
      "radius": "60%",
      "innerRadius": "45%",
      "balloonText": "$75,365" //Actual to date for Reynosa 10/16
    }
    //, {
//      "color": "#eee",
  //    "startValue": 0,
    //  "endValue": 100,
  //    "radius": "40%",
   //   "innerRadius": "25%"
//    },
    //{
   //   "color": "#67b7dc",
  //    "startValue": 0,
//      "endValue": 68,
    //  "radius": "40%",
  //    "innerRadius": "25%",
//      "balloonText": "68%"
    //}
    ]
  }],
  "allLabels": [{
    "text": "Target for Month",
    "x": "49%",
    "y": "5%",
    "size": 15,
    "bold": true,
    "color": "#4286f4",
    "align": "right"
  }, {
    "text": "Target to Date",
    "x": "49%",
    "y": "15%",
    "size": 15,
    "bold": true,
    "color": "#F4D342",
    "align": "right"
  }, {
    "text": "Actual to Date",
    "x": "49%",
    "y": "24%",
    "size": 15,
    "bold": true,
    "color": "#FF3333",
    "align": "right"
  },
  //, {
 //  "text": "Fourth option",
 //   "x": "49%",
 //   "y": "33%",
 //   "size": 15,
 //   "bold": true,
 //   "color": "#67b7dc",
 //   "align": "right"
 // }
  ],
  "export": {
    "enabled": true
  }
}); 


var chart = AmCharts.makeChart("leftBarChart", {
	  "type": "serial", // For Division / Product Line drill down chart
	  "theme": "light",
	  "dataDateFormat": "YYYY-MM-DD",
	  "precision": 2,
	  "valueAxes": [{
	    "id": "v1",
	    "title": "Revenue  x1000",
	    "position": "left",
	    "autoGridCount": false,
	    "labelFunction": function(value) {
	      return "$" + Math.round(value);
	    }
	  }, {
	    "id": "v2",
	    "title": "Expense",
	    "gridAlpha": 0,
	    "position": "right",
	    "autoGridCount": false,
	    "labelFunction": function(value) {
	      return "$" + Math.round(value);
	     }
	  }],
	  
	  "graphs": [{
	    "id": "g3",
	    "valueAxis": "v1",
	    "lineColor": "#b7d1fb", //light blue
	    "fillColors": "#b7d1fb",
	    "fillAlphas": 1,
	    "type": "column",
	    "title": "Target Revenue", //was Actual Sales
	    "valueField": "sales2",
	    "clustered": false,
	    "columnWidth": 0.5,
	    "legendValueText": "$[[value]]M",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>$[[value]]M</b>"
	  }, {
	    "id": "g4",
	    "valueAxis": "v1",
	    "lineColor": "#62cf73", //green
	    "fillColors": "#62cf73",
	    "fillAlphas": 1,
	    "type": "column",
	    "title": "Actual Revenue",
	    "valueField": "sales1",
	    "clustered": false,
	    "columnWidth": 0.3,
	    "legendValueText": "$[[value]]M",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>$[[value]]M</b>"
	  }, {
	    "id": "g1",
	    "valueAxis": "v2",
	    "bullet": "round",
	    "bulletBorderAlpha": 1,
	    "bulletColor": "#fd9f9b",//pink
	    "bulletSize": 5,
	    "hideBulletsCount": 50,
	    "lineThickness": 2,
	    "lineColor": "#fd9f9b", 
	    "type": "smoothedLine",
	     "dashLength": 5,
	    "title": "Target Expense",
	    "useLineColorForBulletBorder": true,
	    "valueField": "market1",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>[[value]]</b>"
	  }, {
	    "id": "g2",
	    "valueAxis": "v2",
	    "bullet": "round",
	    "bulletBorderAlpha": 1,
	    "bulletColor": "#fb2316",
	    "bulletSize": 5,
	    "hideBulletsCount": 50,
	    "lineThickness": 2,
	    "lineColor": "#fb2316",
	    "type": "smoothedLine", 
	    "title": "Actual Expense",
	    "useLineColorForBulletBorder": true,
	    "valueField": "market2",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>[[value]]</b>"
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
	    "shadowAlpha": 0
	  },
	  "export": {
	   "enabled": true
	  },
	  "dataProvider": [{
	    "date": "2016-10-16",
	    "market1": 495.4,//Target Expenses for Reynosa Oct 16, US$ (no multiplier)
	    "market2": 712.7,//Actual Expenses ..""
	    "sales1": 0,//Actual Revenue for Reynosa Oct 16, millions US$
	    "sales2": 0//Target Revenue for Reynosa Oct 16, millions US$
	  }, {
	    "date": "2016-10-17",
	    "market1": 38321,
	    "market2": 33713,
	    "sales1": 3259.460,
	    "sales2": 3062.000
	  }, {
	    "date": "2016-10-18",
	    "market1": 38321,
	    "market2": 43011,
	    "sales1": 3259.460,
	    "sales2": 3062.000
	  }, {
	    "date": "2016-10-19",
	    "market1": 38321,
	    "market2": 57805,
	    "sales1": 2352,
	    "sales2": 2407.900
	  }, {
	    "date": "2016-10-20",
	    "market1": 38321,
	    "market2": 72721,
	    "sales1": 4178.000,
	    "sales2": 4271.080
	  }, {
	    "date": "2016-10-21",
	    "market1": 76649,
	    "market2": 118405,
	    "sales1": 4692.74,
	    "sales2": 4389
	  }, {
	    "date": "2016-10-22",
	    "market1": 4954,
	    "market2": 8397,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-23",
	    "market1": 49545,
	    "market2": 14281,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-24",
	    "market1": 58534.3,
	    "market2": 57827.9,
	    "sales1": 19610.880,
	    "sales2": 42592.630
	   }, {
	    "date": "2016-10-25",
	    "market1": 38321,
	    "market2": 76412,
	    "sales1": 2830.125,
	    "sales2": 2844.46
	  }, {
	    "date": "2016-10-26",
	    "market1": 38321,
	    "market2": 66936,
	    "sales1": 2352.017,
	    "sales2": 3276.98
	  }, {
	    "date": "2016-10-27",
	    "market1": 38321,
	    "market2": 63288,
	    "sales1": 4177.580,
	    "sales2": 3533.920
	  }, {
	    "date": "2016-10-28",
	    "market1": 38321,
	    "market2": 39385,
	    "sales1": 4260.557,
	    "sales2": 6567.830
	  }, {
	    "date": "2016-10-29",
	    "market1": 4954,
	    "market2": 12184,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-30",
	    "market1": 4954,
	    "market2": 7043,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-31",
	    "market1": 3739,
	    "market2": 7476,
	    "sales1": 3234.200,
	    "sales2": 1090.060
	  }]
	});


var chart = AmCharts.makeChart("revenueChart", {
	  "type": "serial",
	  "theme": "light",
	  "dataDateFormat": "YYYY-MM-DD",
	  "precision": 2,
	  "valueAxes": [{
	    "id": "v1",
	    "title": "Revenue  x1000",
	    "position": "left",
	    "autoGridCount": false,
	    "labelFunction": function(value) {
	      return "$" + Math.round(value);
	    }
	  }, {
	    "id": "v2",
	    "title": "Expense",
	    "gridAlpha": 0,
	    "position": "right",
	    "autoGridCount": false,
	    "labelFunction": function(value) {
	      return "$" + Math.round(value);
	     }
	  }],
	  
	  "graphs": [{
	    "id": "g3",
	    "valueAxis": "v1",
	    "lineColor": "#b7d1fb", //light blue
	    "fillColors": "#b7d1fb",
	    "fillAlphas": 1,
	    "type": "column",
	    "title": "Target Revenue", //was Actual Sales
	    "valueField": "sales2",
	    "clustered": false,
	    "columnWidth": 0.5,
	    "legendValueText": "$[[value]]M",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>$[[value]]M</b>"
	  }, {
	    "id": "g4",
	    "valueAxis": "v1",
	    "lineColor": "#62cf73", //green
	    "fillColors": "#62cf73",
	    "fillAlphas": 1,
	    "type": "column",
	    "title": "Actual Revenue",
	    "valueField": "sales1",
	    "clustered": false,
	    "columnWidth": 0.3,
	    "legendValueText": "$[[value]]M",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>$[[value]]M</b>"
	  }, {
	    "id": "g1",
	    "valueAxis": "v2",
	    "bullet": "round",
	    "bulletBorderAlpha": 1,
	    "bulletColor": "#fd9f9b",//pink
	    "bulletSize": 5,
	    "hideBulletsCount": 50,
	    "lineThickness": 2,
	    "lineColor": "#fd9f9b", 
	    "type": "smoothedLine",
	     "dashLength": 5,
	    "title": "Target Expense",
	    "useLineColorForBulletBorder": true,
	    "valueField": "market1",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>[[value]]</b>"
	  }, {
	    "id": "g2",
	    "valueAxis": "v2",
	    "bullet": "round",
	    "bulletBorderAlpha": 1,
	    "bulletColor": "#fb2316",
	    "bulletSize": 5,
	    "hideBulletsCount": 50,
	    "lineThickness": 2,
	    "lineColor": "#fb2316",
	    "type": "smoothedLine", 
	    "title": "Actual Expense",
	    "useLineColorForBulletBorder": true,
	    "valueField": "market2",
	    "balloonText": "[[title]]<br /><b style='font-size: 130%'>[[value]]</b>"
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
	    "shadowAlpha": 0
	  },
	  "export": {
	   "enabled": true
	  },
	  "dataProvider": [{
	    "date": "2016-10-16",
	    "market1": 495.4,//Target Expenses for Reynosa Oct 16, US$ (no multiplier)
	    "market2": 712.7,//Actual Expenses ..""
	    "sales1": 0,//Actual Revenue for Reynosa Oct 16, millions US$
	    "sales2": 0//Target Revenue for Reynosa Oct 16, millions US$
	  }, {
	    "date": "2016-10-17",
	    "market1": 38321,
	    "market2": 33713,
	    "sales1": 3259.460,
	    "sales2": 3062.000
	  }, {
	    "date": "2016-10-18",
	    "market1": 38321,
	    "market2": 43011,
	    "sales1": 3259.460,
	    "sales2": 3062.000
	  }, {
	    "date": "2016-10-19",
	    "market1": 38321,
	    "market2": 57805,
	    "sales1": 2352,
	    "sales2": 2407.900
	  }, {
	    "date": "2016-10-20",
	    "market1": 38321,
	    "market2": 72721,
	    "sales1": 4178.000,
	    "sales2": 4271.080
	  }, {
	    "date": "2016-10-21",
	    "market1": 76649,
	    "market2": 118405,
	    "sales1": 4692.74,
	    "sales2": 4389
	  }, {
	    "date": "2016-10-22",
	    "market1": 4954,
	    "market2": 8397,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-23",
	    "market1": 49545,
	    "market2": 14281,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-24",
	    "market1": 38321,
	    "market2": 58872,
	    "sales1": 3062.108,
	    "sales2": 3283.88
	   }, {
	    "date": "2016-10-25",
	    "market1": 38321,
	    "market2": 76412,
	    "sales1": 2830.125,
	    "sales2": 2844.46
	  }, {
	    "date": "2016-10-26",
	    "market1": 38321,
	    "market2": 66936,
	    "sales1": 2352.017,
	    "sales2": 3276.98
	  }, {
	    "date": "2016-10-27",
	    "market1": 38321,
	    "market2": 63288,
	    "sales1": 4177.580,
	    "sales2": 3533.920
	  }, {
	    "date": "2016-10-28",
	    "market1": 38321,
	    "market2": 39385,
	    "sales1": 4260.557,
	    "sales2": 6567.830
	  }, {
	    "date": "2016-10-29",
	    "market1": 4954,
	    "market2": 12184,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-30",
	    "market1": 4954,
	    "market2": 7043,
	    "sales1": 0,
	    "sales2": 0
	  }, {
	    "date": "2016-10-31",
	    "market1": 3739,
	    "market2": 7476,
	    "sales1": 3234.200,
	    "sales2": 1090.060
	  }]
	});

var chart = AmCharts.makeChart( "catagoryChartDiv1", {
	  "type": "serial",//Reynosa, to Oct 27 
	  "rotate": false,
	  "theme": "light",
	  "autoMargins": true,
	  "marginTop": 30,
	  "marginLeft": 80,
	  "marginBottom": 30,
	  "marginRight": 50,
	  "dataProvider": [ {
	    "category": "Packaging [Oct 27]",
	    "excelent": 142801,
	    "good": 10,
	    "average": 2,
	    "poor": 1,
	    "bad": 1,
	    "limit": 142801,//target to date
	    "full": 164173,//Month target
	    "bullet": 159965 //actual to date
	  } ],
	  "valueAxes": [ {
	    "maximum": 200000,//top of scale - greater than Month target to allow overage
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
	    "fillColors": [ "#4286f4" ],  
	  }, {
	    "clustered": false,//Inner bar (actual to date)
	    "columnWidth": 0.5,
	    "fillAlphas": 1,
	    "lineColor": "#ffffff",
	    "fillAlphas": 0.8,
	    "fillColors": ["#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228",
	                   "#f6d32b", 
	                   "#fb2316", "#fb2316"],
	    "gradientOrientation": "vertical",
	    "stackable": false,
	    "type": "column",
	    "valueField": "bullet",
	    "showBalloon": true
	  }, {
	    "columnWidth": 0.9,//Target to Date bar
	    "lineColor": "#F4D342",
	    "lineThickness": 5,
	    "noStepRisers": true,
	    "stackable": false,
	    "type": "step",
	    "valueField": "limit",
	    "showBalloon": true
	  } ],
	  "columnWidth": 1,
	  "categoryField": "category",
	  "categoryAxis": {
	    "gridAlpha": 0,
	    "position": "left"
	  }
	} );

	var chart = AmCharts.makeChart( "catagoryChartDiv2", {
	  "type": "serial",//Reynosa, to Oct 27 
	  "rotate": false,
	  "theme": "light",
	  "autoMargins": true,
	  "marginTop": 30,
	  "marginLeft": 80,
	  "marginBottom": 30,
	  "marginRight": 50,
	  "dataProvider": [ {
		    "category": "Electricity [Oct 4th]",
	    "excelent": 20,
	    "good": 20,
	    "average": 20,
	    "poor": 20,
	    "bad": 20,
	    "limit": 30699,//Target to date
	    "full": 261184,//Month target
	    "bullet": 39971 //Actual to date
	  } ],
	  "valueAxes": [ {
	    "maximum": 315000,//top of scale- greater than Month target to allow overage
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
	    "fillColors": [ "#4286f4" ],
	    "gradientOrientation": "vertical",
	  }, {
	    "clustered": false,//Inner bar (actual to date)
	    "columnWidth": 0.5,
	    "fillAlphas": 1,
	    "lineColor": "#ffffff",
	    "fillAlphas": 0.8,
	    "fillColors": ["#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", 
	                   "#f6d32b", "#fb2316", 
	                   "#fb2316"],
	    "gradientOrientation": "vertical",
	    "stackable": false,
	    "type": "column",
	    "valueField": "bullet"
	  }, {
	    "columnWidth": 0.9,//Target to Date bar
	    "lineColor": "#F4D342",
	    "lineThickness": 5,
	    "noStepRisers": true,
	    "stackable": false,
	    "type": "step",
	    "valueField": "limit"
	  } ],
	  "columnWidth": 1,
	  "categoryField": "category",
	  "categoryAxis": {
	    "gridAlpha": 0,
	    "position": "left"
	  }
	} );

	var chart = AmCharts.makeChart( "catagoryChartDiv3", {
	  "type": "serial",//Reynosa, to Oct 27 
	  "rotate": false,
	  "theme": "light",
	  "autoMargins": true,
	  "marginTop": 30,
	  "marginLeft": 80,
	  "marginBottom": 30,
	  "marginRight": 50,
	  "dataProvider": [ {
		    "category": "Maint [Oct 15, 25% over]",
	    "excelent": 20,
	    "good": 20,
	    "average": 20,
	    "poor": 20,
	    "bad": 20,
	    "limit": 82087,//Target to date
	    "full": 165173,//Month target
	    "bullet": 102608//actual to date
	  } ],
	  "valueAxes": [ {
	    "maximum": 175000,//top of scale - greater than Month target to allow overage
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
	    "fillColors": [ "#4286f4" ],
	    "gradientOrientation": "vertical",
	  }, {
	    "clustered": false,//Inner bar (actual to date)
	    "columnWidth": 0.5,
	    "fillAlphas": 1,
	    "lineColor": "#ffffff",
	    "fillAlphas": 0.8,
	    "fillColors": ["#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", "#19d228", 
	                   "#f6d32b", 
	                   "#fb2316", "#fb2316"],
	    "gradientOrientation": "vertical",
	    "stackable": false,
	    "type": "column",
	    "valueField": "bullet"
	  }, {
	    "columnWidth": 0.9,//Target to Date bar
	    "lineColor": "#F4D342",
	    "lineThickness": 5,
	    "noStepRisers": true,
	    "stackable": false,
	    "type": "step",
	    "valueField": "limit"
	  } ],
	  "columnWidth": 1,
	  "categoryField": "category",
	  "categoryAxis": {
	    "gridAlpha": 0,
	    "position": "left"
	  }
	} );

	var chart = AmCharts.makeChart( "catagoryChartDiv4", {
	  "type": "serial",//Reynosa, to Oct 27 
	  "rotate": false,
	  "theme": "light",
	  "autoMargins": true,
	  "marginTop": 30,
	  "marginLeft": 80,
	  "marginBottom": 30,
	  "marginRight": 50,
	  "dataProvider": [ {
		    "category": "Scrap [Oct 31]",
	    "excelent": 20,
	    "good": 20,
	    "average": 20,
	    "poor": 20,
	    "bad": 20,
	    "limit": 250346,//Target to date
	    "full": 250346,//Month target
	    "bullet": 490584//actual to date
	  } ],
	  "valueAxes": [ {
	    "maximum": 500000,//top of scale - greater than Month target to allow overage
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
	    "fillColors": [ "#4286f4" ],
	    "gradientOrientation": "vertical",
	  }, {
	    "clustered": false,//Inner bar (actual to date)
	    "columnWidth": 0.5,
	    "fillAlphas": 1,
	    "lineColor": "#ffffff",
	    "fillAlphas": 0.8,
	    "fillColors": ["#19d228", "#19d228","#19d228", "#19d228", "#19d228","#19d228",
	                   "#f6d32b",
	                   "#fb2316","#fb2316","#fb2316","#fb2316", "#fb2316", "#fb2316"],
	    "gradientOrientation": "vertical",
	    "stackable": false,
	    "type": "column",
	    "valueField": "bullet"
	  }, {
	    "columnWidth": 0.9,//Target to Date bar
	    "lineColor": "#F4D342",
	    "lineThickness": 5,
	    "noStepRisers": true,
	    "stackable": false,
	    "type": "step",
	    "valueField": "limit"
	  } ],
	  "columnWidth": 1,
	  "categoryField": "category",
	  "categoryAxis": {
	    "gridAlpha": 0,
	    "position": "left"
	  }
	} );

	var chart = AmCharts.makeChart( "catagoryChartDiv5", {
	  "type": "serial",//Reynosa, to Oct 27 
	  "rotate": false,
	  "theme": "light",
	  "autoMargins": true,
	  "marginTop": 30,
	  "marginLeft": 80,
	  "marginBottom": 30,
	  "marginRight": 50,
	  "dataProvider": [ {
		    "category": "Overtime [Oct 15]",
	    "excelent": 20,
	    "good": 20,
	    "average": 20,
	    "poor": 20,
	    "bad": 20,
	    "limit": 76486,//Target to date
	    "full": 114814,//Target for month
	    "bullet": 66614//Actual to date
	  } ],
	  "valueAxes": [ {
	    "maximum": 130000,//top of scale - greater than Month target to allow overage
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
	    "fillColors": [ "#4286f4" ],
	    "gradientOrientation": "vertical",
	  }, {
	    "clustered": false,//Inner bar (actual to date)
	    "columnWidth": 0.5,
	    "fillAlphas": 1,
	    "lineColor": "#ffffff",
	    "fillAlphas": 0.8,
	    "fillColors": ["#19d228", "#19d228","#19d228", "#19d228", "#19d228","#19d228",
	                   "#f6d32b"],
	    "gradientOrientation": "vertical",
	    "stackable": false,
	    "type": "column",
	    "valueField": "bullet"
	  }, {
	    "columnWidth": 0.9,//Target to Date bar
	    "lineColor": "#F4D342",
	    "lineThickness": 5,
	    "noStepRisers": true,
	    "stackable": false,
	    "type": "step",
	    "valueField": "limit"
	  } ],
	  "columnWidth": 1,
	  "categoryField": "category",
	  "categoryAxis": {
	    "gridAlpha": 0,
	    "position": "left"
	  }
	} );
	
	
	
	var continentsDataProvider;
	var backIconSVG = "M16,1.466C7.973,1.466,1.466,7.973,1.466,16c0,8.027,6.507,14.534,14.534,14.534c8.027,0,14.534-6.507,14.534-14.534C30.534,7.973,24.027,1.466,16,1.466zM27.436,17.39c0.001,0.002,0.004,0.002,0.005,0.004c-0.022,0.187-0.054,0.37-0.085,0.554c-0.015-0.012-0.034-0.025-0.047-0.036c-0.103-0.09-0.254-0.128-0.318-0.115c-0.157,0.032,0.229,0.305,0.267,0.342c0.009,0.009,0.031,0.03,0.062,0.058c-1.029,5.312-5.709,9.338-11.319,9.338c-4.123,0-7.736-2.18-9.776-5.441c0.123-0.016,0.24-0.016,0.28-0.076c0.051-0.077,0.102-0.241,0.178-0.331c0.077-0.089,0.165-0.229,0.127-0.292c-0.039-0.064,0.101-0.344,0.088-0.419c-0.013-0.076-0.127-0.256,0.064-0.407s0.394-0.382,0.407-0.444c0.012-0.063,0.166-0.331,0.152-0.458c-0.012-0.127-0.152-0.28-0.24-0.318c-0.09-0.037-0.28-0.05-0.356-0.151c-0.077-0.103-0.292-0.203-0.368-0.178c-0.076,0.025-0.204,0.05-0.305-0.015c-0.102-0.062-0.267-0.139-0.33-0.189c-0.065-0.05-0.229-0.088-0.305-0.088c-0.077,0-0.065-0.052-0.178,0.101c-0.114,0.153,0,0.204-0.204,0.177c-0.204-0.023,0.025-0.036,0.141-0.189c0.113-0.152-0.013-0.242-0.141-0.203c-0.126,0.038-0.038,0.115-0.241,0.153c-0.203,0.036-0.203-0.09-0.076-0.115s0.355-0.139,0.355-0.19c0-0.051-0.025-0.191-0.127-0.191s-0.077-0.126-0.229-0.291c-0.092-0.101-0.196-0.164-0.299-0.204c-0.09-0.579-0.15-1.167-0.15-1.771c0-2.844,1.039-5.446,2.751-7.458c0.024-0.02,0.048-0.034,0.069-0.036c0.084-0.009,0.31-0.025,0.51-0.059c0.202-0.034,0.418-0.161,0.489-0.153c0.069,0.008,0.241,0.008,0.186-0.042C8.417,8.2,8.339,8.082,8.223,8.082S8.215,7.896,8.246,7.896c0.03,0,0.186,0.025,0.178,0.11C8.417,8.091,8.471,8.2,8.625,8.167c0.156-0.034,0.132-0.162,0.102-0.195C8.695,7.938,8.672,7.853,8.642,7.794c-0.031-0.06-0.023-0.136,0.14-0.153C8.944,7.625,9.168,7.708,9.16,7.573s0-0.28,0.046-0.356C9.253,7.142,9.354,7.09,9.299,7.065C9.246,7.04,9.176,7.099,9.121,6.972c-0.054-0.127,0.047-0.22,0.108-0.271c0.02-0.015,0.067-0.06,0.124-0.112C11.234,5.257,13.524,4.466,16,4.466c3.213,0,6.122,1.323,8.214,3.45c-0.008,0.022-0.01,0.052-0.031,0.056c-0.077,0.013-0.166,0.063-0.179-0.051c-0.013-0.114-0.013-0.331-0.102-0.203c-0.089,0.127-0.127,0.127-0.127,0.191c0,0.063,0.076,0.127,0.051,0.241C23.8,8.264,23.8,8.341,23.84,8.341c0.036,0,0.126-0.115,0.239-0.141c0.116-0.025,0.319-0.088,0.332,0.026c0.013,0.115,0.139,0.152,0.013,0.203c-0.128,0.051-0.267,0.026-0.293-0.051c-0.025-0.077-0.114-0.077-0.203-0.013c-0.088,0.063-0.279,0.292-0.279,0.292s-0.306,0.139-0.343,0.114c-0.04-0.025,0.101-0.165,0.203-0.228c0.102-0.064,0.178-0.204,0.14-0.242c-0.038-0.038-0.088-0.279-0.063-0.343c0.025-0.063,0.139-0.152,0.013-0.216c-0.127-0.063-0.217-0.14-0.318-0.178s-0.216,0.152-0.305,0.204c-0.089,0.051-0.076,0.114-0.191,0.127c-0.114,0.013-0.189,0.165,0,0.254c0.191,0.089,0.255,0.152,0.204,0.204c-0.051,0.051-0.267-0.025-0.267-0.025s-0.165-0.076-0.268-0.076c-0.101,0-0.229-0.063-0.33-0.076c-0.102-0.013-0.306-0.013-0.355,0.038c-0.051,0.051-0.179,0.203-0.28,0.152c-0.101-0.051-0.101-0.102-0.241-0.051c-0.14,0.051-0.279-0.038-0.355,0.038c-0.077,0.076-0.013,0.076-0.255,0c-0.241-0.076-0.189,0.051-0.419,0.089s-0.368-0.038-0.432,0.038c-0.064,0.077-0.153,0.217-0.19,0.127c-0.038-0.088,0.126-0.241,0.062-0.292c-0.062-0.051-0.33-0.025-0.367,0.013c-0.039,0.038-0.014,0.178,0.011,0.229c0.026,0.05,0.064,0.254-0.011,0.216c-0.077-0.038-0.064-0.166-0.141-0.152c-0.076,0.013-0.165,0.051-0.203,0.077c-0.038,0.025-0.191,0.025-0.229,0.076c-0.037,0.051,0.014,0.191-0.051,0.203c-0.063,0.013-0.114,0.064-0.254-0.025c-0.14-0.089-0.14-0.038-0.178-0.012c-0.038,0.025-0.216,0.127-0.229,0.012c-0.013-0.114,0.025-0.152-0.089-0.229c-0.115-0.076-0.026-0.076,0.127-0.025c0.152,0.05,0.343,0.075,0.622-0.013c0.28-0.089,0.395-0.127,0.28-0.178c-0.115-0.05-0.229-0.101-0.406-0.127c-0.179-0.025-0.42-0.025-0.7-0.127c-0.279-0.102-0.343-0.14-0.457-0.165c-0.115-0.026-0.813-0.14-1.132-0.089c-0.317,0.051-1.193,0.28-1.245,0.318s-0.128,0.19-0.292,0.318c-0.165,0.127-0.47,0.419-0.712,0.47c-0.241,0.051-0.521,0.254-0.521,0.305c0,0.051,0.101,0.242,0.076,0.28c-0.025,0.038,0.05,0.229,0.191,0.28c0.139,0.05,0.381,0.038,0.393-0.039c0.014-0.076,0.204-0.241,0.217-0.127c0.013,0.115,0.14,0.292,0.114,0.368c-0.025,0.077,0,0.153,0.09,0.14c0.088-0.012,0.559-0.114,0.559-0.114s0.153-0.064,0.127-0.166c-0.026-0.101,0.166-0.241,0.203-0.279c0.038-0.038,0.178-0.191,0.014-0.241c-0.167-0.051-0.293-0.064-0.115-0.216s0.292,0,0.521-0.229c0.229-0.229-0.051-0.292,0.191-0.305c0.241-0.013,0.496-0.025,0.444,0.051c-0.05,0.076-0.342,0.242-0.508,0.318c-0.166,0.077-0.14,0.216-0.076,0.292c0.063,0.076,0.09,0.254,0.204,0.229c0.113-0.025,0.254-0.114,0.38-0.101c0.128,0.012,0.383-0.013,0.42-0.013c0.039,0,0.216,0.178,0.114,0.203c-0.101,0.025-0.229,0.013-0.445,0.025c-0.215,0.013-0.456,0.013-0.456,0.051c0,0.039,0.292,0.127,0.19,0.191c-0.102,0.063-0.203-0.013-0.331-0.026c-0.127-0.012-0.203,0.166-0.241,0.267c-0.039,0.102,0.063,0.28-0.127,0.216c-0.191-0.063-0.331-0.063-0.381-0.038c-0.051,0.025-0.203,0.076-0.331,0.114c-0.126,0.038-0.076-0.063-0.242-0.063c-0.164,0-0.164,0-0.164,0l-0.103,0.013c0,0-0.101-0.063-0.114-0.165c-0.013-0.102,0.05-0.216-0.013-0.241c-0.064-0.026-0.292,0.012-0.33,0.088c-0.038,0.076-0.077,0.216-0.026,0.28c0.052,0.063,0.204,0.19,0.064,0.152c-0.14-0.038-0.317-0.051-0.419,0.026c-0.101,0.076-0.279,0.241-0.279,0.241s-0.318,0.025-0.318,0.102c0,0.077,0,0.178-0.114,0.191c-0.115,0.013-0.268,0.05-0.42,0.076c-0.153,0.025-0.139,0.088-0.317,0.102s-0.204,0.089-0.038,0.114c0.165,0.025,0.418,0.127,0.431,0.241c0.014,0.114-0.013,0.242-0.076,0.356c-0.043,0.079-0.305,0.026-0.458,0.026c-0.152,0-0.456-0.051-0.584,0c-0.127,0.051-0.102,0.305-0.064,0.419c0.039,0.114-0.012,0.178-0.063,0.216c-0.051,0.038-0.065,0.152,0,0.204c0.063,0.051,0.114,0.165,0.166,0.178c0.051,0.013,0.215-0.038,0.279,0.025c0.064,0.064,0.127,0.216,0.165,0.178c0.039-0.038,0.089-0.203,0.153-0.166c0.064,0.039,0.216-0.012,0.331-0.025s0.177-0.14,0.292-0.204c0.114-0.063,0.05-0.063,0.013-0.14c-0.038-0.076,0.114-0.165,0.204-0.254c0.088-0.089,0.253-0.013,0.292-0.115c0.038-0.102,0.051-0.279,0.151-0.267c0.103,0.013,0.243,0.076,0.331,0.076c0.089,0,0.279-0.14,0.332-0.165c0.05-0.025,0.241-0.013,0.267,0.102c0.025,0.114,0.241,0.254,0.292,0.279c0.051,0.025,0.381,0.127,0.433,0.165c0.05,0.038,0.126,0.153,0.152,0.254c0.025,0.102,0.114,0.102,0.128,0.013c0.012-0.089-0.065-0.254,0.025-0.242c0.088,0.013,0.191-0.026,0.191-0.026s-0.243-0.165-0.331-0.203c-0.088-0.038-0.255-0.114-0.331-0.241c-0.076-0.127-0.267-0.153-0.254-0.279c0.013-0.127,0.191-0.051,0.292,0.051c0.102,0.102,0.356,0.241,0.445,0.33c0.088,0.089,0.229,0.127,0.267,0.242c0.039,0.114,0.152,0.241,0.19,0.292c0.038,0.051,0.165,0.331,0.204,0.394c0.038,0.063,0.165-0.012,0.229-0.063c0.063-0.051,0.179-0.076,0.191-0.178c0.013-0.102-0.153-0.178-0.203-0.216c-0.051-0.038,0.127-0.076,0.191-0.127c0.063-0.05,0.177-0.14,0.228-0.063c0.051,0.077,0.026,0.381,0.051,0.432c0.025,0.051,0.279,0.127,0.331,0.191c0.05,0.063,0.267,0.089,0.304,0.051c0.039-0.038,0.242,0.026,0.294,0.038c0.049,0.013,0.202-0.025,0.304-0.05c0.103-0.025,0.204-0.102,0.191,0.063c-0.013,0.165-0.051,0.419-0.179,0.546c-0.127,0.127-0.076,0.191-0.202,0.191c-0.06,0-0.113,0-0.156,0.021c-0.041-0.065-0.098-0.117-0.175-0.097c-0.152,0.038-0.344,0.038-0.47,0.19c-0.128,0.153-0.178,0.165-0.204,0.114c-0.025-0.051,0.369-0.267,0.317-0.331c-0.05-0.063-0.355-0.038-0.521-0.038c-0.166,0-0.305-0.102-0.433-0.127c-0.126-0.025-0.292,0.127-0.418,0.254c-0.128,0.127-0.216,0.038-0.331,0.038c-0.115,0-0.331-0.165-0.331-0.165s-0.216-0.089-0.305-0.089c-0.088,0-0.267-0.165-0.318-0.165c-0.05,0-0.19-0.115-0.088-0.166c0.101-0.05,0.202,0.051,0.101-0.229c-0.101-0.279-0.33-0.216-0.419-0.178c-0.088,0.039-0.724,0.025-0.775,0.025c-0.051,0-0.419,0.127-0.533,0.178c-0.116,0.051-0.318,0.115-0.369,0.14c-0.051,0.025-0.318-0.051-0.433,0.013c-0.151,0.084-0.291,0.216-0.33,0.216c-0.038,0-0.153,0.089-0.229,0.28c-0.077,0.19,0.013,0.355-0.128,0.419c-0.139,0.063-0.394,0.204-0.495,0.305c-0.102,0.101-0.229,0.458-0.355,0.623c-0.127,0.165,0,0.317,0.025,0.419c0.025,0.101,0.114,0.292-0.025,0.471c-0.14,0.178-0.127,0.266-0.191,0.279c-0.063,0.013,0.063,0.063,0.088,0.19c0.025,0.128-0.114,0.255,0.128,0.369c0.241,0.113,0.355,0.217,0.418,0.367c0.064,0.153,0.382,0.407,0.382,0.407s0.229,0.205,0.344,0.293c0.114,0.089,0.152,0.038,0.177-0.05c0.025-0.09,0.178-0.104,0.355-0.104c0.178,0,0.305,0.04,0.483,0.014c0.178-0.025,0.356-0.141,0.42-0.166c0.063-0.025,0.279-0.164,0.443-0.063c0.166,0.103,0.141,0.241,0.23,0.332c0.088,0.088,0.24,0.037,0.355-0.051c0.114-0.09,0.064-0.052,0.203,0.025c0.14,0.075,0.204,0.151,0.077,0.267c-0.128,0.113-0.051,0.293-0.128,0.47c-0.076,0.178-0.063,0.203,0.077,0.278c0.14,0.076,0.394,0.548,0.47,0.638c0.077,0.088-0.025,0.342,0.064,0.495c0.089,0.151,0.178,0.254,0.077,0.331c-0.103,0.075-0.28,0.216-0.292,0.47s0.051,0.431,0.102,0.521s0.177,0.331,0.241,0.419c0.064,0.089,0.14,0.305,0.152,0.445c0.013,0.14-0.024,0.306,0.039,0.381c0.064,0.076,0.102,0.191,0.216,0.292c0.115,0.103,0.152,0.318,0.152,0.318s0.039,0.089,0.051,0.229c0.012,0.14,0.025,0.228,0.152,0.292c0.126,0.063,0.215,0.076,0.28,0.013c0.063-0.063,0.381-0.077,0.546-0.063c0.165,0.013,0.355-0.075,0.521-0.19s0.407-0.419,0.496-0.508c0.089-0.09,0.292-0.255,0.268-0.356c-0.025-0.101-0.077-0.203,0.024-0.254c0.102-0.052,0.344-0.152,0.356-0.229c0.013-0.077-0.09-0.395-0.115-0.457c-0.024-0.064,0.064-0.18,0.165-0.306c0.103-0.128,0.421-0.216,0.471-0.267c0.051-0.053,0.191-0.267,0.217-0.433c0.024-0.167-0.051-0.369,0-0.457c0.05-0.09,0.013-0.165-0.103-0.268c-0.114-0.102-0.089-0.407-0.127-0.457c-0.037-0.051-0.013-0.319,0.063-0.345c0.076-0.023,0.242-0.279,0.344-0.393c0.102-0.114,0.394-0.47,0.534-0.496c0.139-0.025,0.355-0.229,0.368-0.343c0.013-0.115,0.38-0.547,0.394-0.635c0.013-0.09,0.166-0.42,0.102-0.497c-0.062-0.076-0.559,0.115-0.622,0.141c-0.064,0.025-0.241,0.127-0.446,0.113c-0.202-0.013-0.114-0.177-0.127-0.254c-0.012-0.076-0.228-0.368-0.279-0.381c-0.051-0.012-0.203-0.166-0.267-0.317c-0.063-0.153-0.152-0.343-0.254-0.458c-0.102-0.114-0.165-0.38-0.268-0.559c-0.101-0.178-0.189-0.407-0.279-0.572c-0.021-0.041-0.045-0.079-0.067-0.117c0.118-0.029,0.289-0.082,0.31-0.009c0.024,0.088,0.165,0.279,0.19,0.419s0.165,0.089,0.178,0.216c0.014,0.128,0.14,0.433,0.19,0.47c0.052,0.038,0.28,0.242,0.318,0.318c0.038,0.076,0.089,0.178,0.127,0.369c0.038,0.19,0.076,0.444,0.179,0.482c0.102,0.038,0.444-0.064,0.508-0.102s0.482-0.242,0.635-0.255c0.153-0.012,0.179-0.115,0.368-0.152c0.191-0.038,0.331-0.177,0.458-0.28c0.127-0.101,0.28-0.355,0.33-0.444c0.052-0.088,0.179-0.152,0.115-0.253c-0.063-0.103-0.331-0.254-0.433-0.268c-0.102-0.012-0.089-0.178-0.152-0.178s-0.051,0.088-0.178,0.153c-0.127,0.063-0.255,0.19-0.344,0.165s0.026-0.089-0.113-0.203s-0.192-0.14-0.192-0.228c0-0.089-0.278-0.255-0.304-0.382c-0.026-0.127,0.19-0.305,0.254-0.19c0.063,0.114,0.115,0.292,0.279,0.368c0.165,0.076,0.318,0.204,0.395,0.229c0.076,0.025,0.267-0.14,0.33-0.114c0.063,0.024,0.191,0.253,0.306,0.292c0.113,0.038,0.495,0.051,0.559,0.051s0.33,0.013,0.381-0.063c0.051-0.076,0.089-0.076,0.153-0.076c0.062,0,0.177,0.229,0.267,0.254c0.089,0.025,0.254,0.013,0.241,0.179c-0.012,0.164,0.076,0.305,0.165,0.317c0.09,0.012,0.293-0.191,0.293-0.191s0,0.318-0.012,0.433c-0.014,0.113,0.139,0.534,0.139,0.534s0.19,0.393,0.241,0.482s0.267,0.355,0.267,0.47c0,0.115,0.025,0.293,0.103,0.293c0.076,0,0.152-0.203,0.24-0.331c0.091-0.126,0.116-0.305,0.153-0.432c0.038-0.127,0.038-0.356,0.038-0.444c0-0.09,0.075-0.166,0.255-0.242c0.178-0.076,0.304-0.292,0.456-0.407c0.153-0.115,0.141-0.305,0.446-0.305c0.305,0,0.278,0,0.355-0.077c0.076-0.076,0.151-0.127,0.19,0.013c0.038,0.14,0.254,0.343,0.292,0.394c0.038,0.052,0.114,0.191,0.103,0.344c-0.013,0.152,0.012,0.33,0.075,0.33s0.191-0.216,0.191-0.216s0.279-0.189,0.267,0.013c-0.014,0.203,0.025,0.419,0.025,0.545c0,0.053,0.042,0.135,0.088,0.21c-0.005,0.059-0.004,0.119-0.009,0.178C27.388,17.153,27.387,17.327,27.436,17.39zM20.382,12.064c0.076,0.05,0.102,0.127,0.152,0.203c0.052,0.076,0.14,0.05,0.203,0.114c0.063,0.064-0.178,0.14-0.075,0.216c0.101,0.077,0.151,0.381,0.165,0.458c0.013,0.076-0.279,0.114-0.369,0.102c-0.089-0.013-0.354-0.102-0.445-0.127c-0.089-0.026-0.139-0.343-0.025-0.331c0.116,0.013,0.141-0.025,0.267-0.139c0.128-0.115-0.189-0.166-0.278-0.191c-0.089-0.025-0.268-0.305-0.331-0.394c-0.062-0.089-0.014-0.228,0.141-0.331c0.076-0.051,0.279,0.063,0.381,0c0.101-0.063,0.203-0.14,0.241-0.165c0.039-0.025,0.293,0.038,0.33,0.114c0.039,0.076,0.191,0.191,0.141,0.229c-0.052,0.038-0.281,0.076-0.356,0c-0.075-0.077-0.255,0.012-0.268,0.152C20.242,12.115,20.307,12.013,20.382,12.064zM16.875,12.28c-0.077-0.025,0.025-0.178,0.102-0.229c0.075-0.051,0.164-0.178,0.241-0.305c0.076-0.127,0.178-0.14,0.241-0.127c0.063,0.013,0.203,0.241,0.241,0.318c0.038,0.076,0.165-0.026,0.217-0.051c0.05-0.025,0.127-0.102,0.14-0.165s0.127-0.102,0.254-0.102s0.013,0.102-0.076,0.127c-0.09,0.025-0.038,0.077,0.113,0.127c0.153,0.051,0.293,0.191,0.459,0.279c0.165,0.089,0.19,0.267,0.088,0.292c-0.101,0.025-0.406,0.051-0.521,0.038c-0.114-0.013-0.254-0.127-0.419-0.153c-0.165-0.025-0.369-0.013-0.433,0.077s-0.292,0.05-0.395,0.05c-0.102,0-0.228,0.127-0.253,0.077C16.875,12.534,16.951,12.306,16.875,12.28zM17.307,9.458c0.063-0.178,0.419,0.038,0.355,0.127C17.599,9.675,17.264,9.579,17.307,9.458zM17.802,18.584c0.063,0.102-0.14,0.431-0.254,0.407c-0.113-0.027-0.076-0.318-0.038-0.382C17.548,18.545,17.769,18.529,17.802,18.584zM13.189,12.674c0.025-0.051-0.039-0.153-0.127-0.013C13.032,12.71,13.164,12.725,13.189,12.674zM20.813,8.035c0.141,0.076,0.339,0.107,0.433,0.013c0.076-0.076,0.013-0.204-0.05-0.216c-0.064-0.013-0.104-0.115,0.062-0.203c0.165-0.089,0.343-0.204,0.534-0.229c0.19-0.025,0.622-0.038,0.774,0c0.152,0.039,0.382-0.166,0.445-0.254s-0.203-0.152-0.279-0.051c-0.077,0.102-0.444,0.076-0.521,0.051c-0.076-0.025-0.686,0.102-0.812,0.102c-0.128,0-0.179,0.152-0.356,0.229c-0.179,0.076-0.42,0.191-0.509,0.229c-0.088,0.038-0.177,0.19-0.101,0.216C20.509,7.947,20.674,7.959,20.813,8.035zM14.142,12.674c0.064-0.089-0.051-0.217-0.114-0.217c-0.12,0-0.178,0.191-0.103,0.254C14.002,12.776,14.078,12.763,14.142,12.674zM14.714,13.017c0.064,0.025,0.114,0.102,0.165,0.114c0.052,0.013,0.217,0,0.167-0.127s-0.167-0.127-0.204-0.127c-0.038,0-0.203-0.038-0.267,0C14.528,12.905,14.65,12.992,14.714,13.017zM11.308,10.958c0.101,0.013,0.217-0.063,0.305-0.101c0.088-0.038,0.216-0.114,0.216-0.229c0-0.114-0.025-0.216-0.077-0.267c-0.051-0.051-0.14-0.064-0.216-0.051c-0.115,0.02-0.127,0.14-0.203,0.14c-0.076,0-0.165,0.025-0.14,0.114s0.077,0.152,0,0.19C11.117,10.793,11.205,10.946,11.308,10.958zM11.931,10.412c0.127,0.051,0.394,0.102,0.292,0.153c-0.102,0.051-0.28,0.19-0.305,0.267s0.216,0.153,0.216,0.153s-0.077,0.089-0.013,0.114c0.063,0.025,0.102-0.089,0.203-0.089c0.101,0,0.304,0.063,0.406,0.063c0.103,0,0.267-0.14,0.254-0.229c-0.013-0.089-0.14-0.229-0.254-0.28c-0.113-0.051-0.241-0.28-0.317-0.331c-0.076-0.051,0.076-0.178-0.013-0.267c-0.09-0.089-0.153-0.076-0.255-0.14c-0.102-0.063-0.191,0.013-0.254,0.089c-0.063,0.076-0.14-0.013-0.217,0.012c-0.102,0.035-0.063,0.166-0.012,0.229C11.714,10.221,11.804,10.361,11.931,10.412zM24.729,17.198c-0.083,0.037-0.153,0.47,0,0.521c0.152,0.052,0.241-0.202,0.191-0.267C24.868,17.39,24.843,17.147,24.729,17.198zM20.114,20.464c-0.159-0.045-0.177,0.166-0.304,0.306c-0.128,0.141-0.267,0.254-0.317,0.241c-0.052-0.013-0.331,0.089-0.242,0.279c0.089,0.191,0.076,0.382-0.013,0.472c-0.089,0.088,0.076,0.342,0.052,0.482c-0.026,0.139,0.037,0.229,0.215,0.229s0.242-0.064,0.318-0.229c0.076-0.166,0.088-0.331,0.164-0.47c0.077-0.141,0.141-0.434,0.179-0.51c0.038-0.075,0.114-0.316,0.102-0.457C20.254,20.669,20.204,20.489,20.114,20.464zM10.391,8.802c-0.069-0.06-0.229-0.102-0.306-0.11c-0.076-0.008-0.152,0.06-0.321,0.06c-0.168,0-0.279,0.067-0.347,0C9.349,8.684,9.068,8.65,9.042,8.692C9.008,8.749,8.941,8.751,9.008,8.87c0.069,0.118,0.12,0.186,0.179,0.178s0.262-0.017,0.288,0.051C9.5,9.167,9.569,9.226,9.712,9.184c0.145-0.042,0.263-0.068,0.296-0.119c0.033-0.051,0.263-0.059,0.263-0.059S10.458,8.861,10.391,8.802z";

	var worldDataProvider = {
	  "map": "worldLow",
	  "getAreasFromMap": true,
	  "images": [ {
	    "svgPath": backIconSVG,
	    "id": "backButton",
	    "label": "Back to continents map",
	    "rollOverColor": "#9a7bca",
	    "labelRollOverColor": "#9a7bca",
	    "useTargetsZoomValues": true,
	    "left": 30,
	    "bottom": 30,
	    "labelFontSize": 15,
	    "selectable": true
	  } ]
	};



	var continentsDataProvider = {
	  "map": "continentsLow",

	  "areas": [ {
	    "id": "africa",
	    "linkToObject": worldDataProvider,
	    "color": "#605675",
	    "passZoomValuesToTarget": true
	  }, {
	    "id": "asia",
	    "linkToObject": worldDataProvider,
	    "color": "#a791b4",
	    "passZoomValuesToTarget": true
	  }, {
	    "id": "australia",
	    "linkToObject": worldDataProvider,
	    "color": "#7f7891",
	    "passZoomValuesToTarget": true
	  }, {
	    "id": "europe",
	    "linkToObject": worldDataProvider,
	    "color": "#9186a2",
	    "passZoomValuesToTarget": true
	  }, {
	    "id": "north_america",
	    "linkToObject": worldDataProvider,
	    "color": "#868191",
	    "passZoomValuesToTarget": true
	  }, {
	    "id": "south_america",
	    "linkToObject": worldDataProvider,
	    "color": "#8f7ea9",
	    "passZoomValuesToTarget": true
	  } ]

	};


	var map = AmCharts.makeChart( "mapDiv", {
	  "type": "map",
	  "theme": "light",
	  "projection": "winkel3",

	  "areasSettings": {
	    "autoZoom": true,
	    "rollOverOutlineColor": "#9a7bca",
	    "selectedColor": "#9a7bca",
	    "color": "#a791b4",
	    "rollOverColor": "#9a7bca"
	  },


	  "dataProvider": continentsDataProvider,

	  "listeners": [ {
	    "event": "homeButtonClicked",
	    "method": handleGoHome
	  }, {
	    "event": "clickMapObject",
	    "method": handleMapObjectClick
	  } ]

	} );

	function handleGoHome() {
	  map.dataProvider = continentsDataProvider;
	  map.validateNow();
	}

	function handleMapObjectClick( event ) {
	  if ( event.mapObject.id == "backButton" ) {
	    handleGoHome();
	  }
	}