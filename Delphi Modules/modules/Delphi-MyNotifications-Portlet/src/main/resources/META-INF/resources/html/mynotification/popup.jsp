<div class="table-responsive myNotificationPopupTable">

    <!-- table.search( "CHANGE" ).draw();-->
    <h1 style="text-align: center;font-size: 14px; margin: 4px 0 7px 0;"> <b>Current Alert Notifications</b></h1>
    <span id="mini-close"><i class="fa fa-close" style="margin:0px 5px 0 10px;"></i></span>
    
    <table class="myNotificationPopupTableGrid" class="table table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" width="100%">
        <thead>
            <tr>       
                <th width="40">Type</th>
                <th>Station</th>
                <th>Part No</th>
                <th>Deviation</th> 
                <th>Level and Duration</th> 
            </tr>
        </thead>
    </table>
    
	<div class="row miniLegend" style="margin-bottom:10px;">
		<span onclick="filterGrid(this,'CYCLETIME ALERT')"><i class="fa fa-clock-o"  style="margin:0px 5px 0 10px;"></i> Cycle Time</span>
		<span onclick="filterGrid(this,'DOWNTIME ALERT')"><i class="fa fa-arrow-circle-down" style="margin:0px 5px 0 10px;"></i> Downtime</span>
		<span onclick="filterGrid(this,'CHANGEOVER ALERT')"><i class="fa fa-cogs" style="margin:0px 5px 0 10px;"></i> Changeover</span>
		<span onclick="filterGrid(this,'YIELD ALERT')"><i class="fa fa-percent" style="margin:0px 5px 0 10px;"></i> Yield</span>
		<!-- <button onclick="location.href='/group/delphi/alerts-thresholds'" class="view-details-button"style="float:right;">View Details</button> -->
	</div>    
</div>
