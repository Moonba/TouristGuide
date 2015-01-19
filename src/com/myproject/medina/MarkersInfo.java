package com.myproject.medina;

import com.google.android.gms.maps.model.LatLng;

public class MarkersInfo {

	 private LatLng latLong;
	 private String name;
	 private String petitext ;
	 
	 private int identite ;
	 
	

	 public MarkersInfo(int identite , LatLng latLong, String name, String petitext) {

	  super();
      this.identite = identite ;
	  this.latLong = latLong;

	  this.name = name;

	  this.petitext = petitext ;
	 


	 }

	 public int getIdentite() {
		 return identite ;
	 }
	 
	 public void setIdentite(int id) {

		  this.identite = id;

		 }

	 

	public LatLng getLatLong() {

	  return latLong;

	 }

	 public void setLatLong(LatLng latLong) {

	  this.latLong = latLong;

	 }

	 public String getName() {

	  return name;

	 }

	 public void setName(String name) {

	  this.name = name;

	 }
 

	 public void setPetitext(String petitext) {

		  this.petitext = petitext ;

		 }

		 public String getPetitext() {

		  return petitext ;

		 }

	}
