package com.ys.delphi.yieldalarm.model;

public class YieldAlarmDataPointModel {

		private String date ;
		private int hour ; 
		private int good; 
		private int total;
		private double yield ;
		
		public YieldAlarmDataPointModel(String date, int hour, int good, int total){
			this.date = date; 
			this.hour = hour; 
			this.good = good; 
			this.total = total ; 
			this.yield = ((double)good)/ ((double)total) ; 
		}
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public int getGood() {
			return good;
		}
		public void setGood(int good) {
			this.good = good;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public double getYield() {
			return yield;
		}
		public void setYield(double yield) {
			this.yield = yield;
		} 
		
		public String toString(){
			return ( "date=" + date + ",hour=" +hour + ",good = " + good+ ",total=" + total + ",yield=" + yield) ;
		}
		
}
