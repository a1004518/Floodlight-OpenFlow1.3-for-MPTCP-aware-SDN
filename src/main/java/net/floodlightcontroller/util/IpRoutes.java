package net.floodlightcontroller.util;

import java.util.ArrayList;

import net.floodlightcontroller.routing.Path;
import net.floodlightcontroller.routing.PathId;

import org.projectfloodlight.openflow.types.IPv4Address;

public class IpRoutes {
	IPv4Address sourceIp;
	IPv4Address destinationIp;
	ArrayList<Path> availableRoutes;
	int currentSubflowNumber;
	
	public IpRoutes(IPv4Address source, IPv4Address destination, ArrayList<Path> v, int sub_num){
		this.sourceIp=source;
		this.destinationIp=destination;
		this.availableRoutes = v;
		this.currentSubflowNumber=sub_num;
	}
	public Path getNextRoute(){
		return availableRoutes.get(currentSubflowNumber);
	}
	public void increaseCurrentSubflowNumber(){
		this.currentSubflowNumber++;
		if(currentSubflowNumber>=availableRoutes.size()){
			currentSubflowNumber=0;
		}
	}
	public int getSubflowNumber(){
		return currentSubflowNumber;
	}
	public IPv4Address getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(IPv4Address sourceIp) {
		this.sourceIp = sourceIp;
	}

	public IPv4Address getDestinationIp() {
		return destinationIp;
	}

	public void setDestinationIp(IPv4Address destinationIp) {
		this.destinationIp = destinationIp;
	}

	public ArrayList<Path> getAvailableRoutes() {
		return availableRoutes;
	}

	public void setAvailableRoutes(ArrayList<Path> availableRoutes) {
		this.availableRoutes = availableRoutes;
	}
}
