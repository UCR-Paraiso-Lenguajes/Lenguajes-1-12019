package com.chat.domain.form;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MetricForm {

	@NotNull
	@Min(1)
	private int quantityRoom;
	@NotNull
	@Min(1)
	private int quantityUser;
	private double userPerRoomProm;
	private int longerMessage;
	private double averageOfUsersPerGroup;
	private Date dateOfThLastMessage;
	private Date dateOfTheFirstLogin;
	private String moreMessagesPerUser;
	private String longestMessage;
	private String lastGroupCreated;
	private String moreMessagesPerGroup;
	public MetricForm() {
		super();
	}
	public int getQuantityRoom() {
		return quantityRoom;
	}
	public void setQuantityRoom(int quantityRoom) {
		this.quantityRoom = quantityRoom;
	}
	public int getQuantityUser() {
		return quantityUser;
	}
	public void setQuantityUser(int quantityUser) {
		this.quantityUser = quantityUser;
	}
	public double getUserPerRoomProm() {
		return userPerRoomProm;
	}
	public void setUserPerRoomProm(double userPerRoomProm) {
		this.userPerRoomProm = userPerRoomProm;
	}
	public int getLongerMessage() {
		return longerMessage;
	}
	public void setLongerMessage(int longerMessage) {
		this.longerMessage = longerMessage;
	}
	public double getAverageOfUsersPerGroup() {
		return averageOfUsersPerGroup;
	}
	public void setAverageOfUsersPerGroup(double averageOfUsersPerGroup) {
		this.averageOfUsersPerGroup = averageOfUsersPerGroup;
	}
	public Date getDateOfThLastMessage() {
		return dateOfThLastMessage;
	}
	public void setDateOfThLastMessage(Date dateOfThLastMessage) {
		this.dateOfThLastMessage = dateOfThLastMessage;
	}
	public Date getDateOfTheFirstLogin() {
		return dateOfTheFirstLogin;
	}
	public void setDateOfTheFirstLogin(Date dateOfTheFirstLogin) {
		this.dateOfTheFirstLogin = dateOfTheFirstLogin;
	}
	public String getMoreMessagesPerUser() {
		return moreMessagesPerUser;
	}
	public void setMoreMessagesPerUser(String moreMessagesPerUser) {
		this.moreMessagesPerUser = moreMessagesPerUser;
	}
	public String getLongestMessage() {
		return longestMessage;
	}
	public void setLongestMessage(String longestMessage) {
		this.longestMessage = longestMessage;
	}
	public String getLastGroupCreated() {
		return lastGroupCreated;
	}
	public void setLastGroupCreated(String lastGroupCreated) {
		this.lastGroupCreated = lastGroupCreated;
	}
	public String getMoreMessagesPerGroup() {
		return moreMessagesPerGroup;
	}
	public void setMoreMessagesPerGroup(String moreMessagesPerGroup) {
		this.moreMessagesPerGroup = moreMessagesPerGroup;
	}
	@Override
	public String toString() {
		return "MetricForm [quantityRoom=" + quantityRoom + ", quantityUser=" + quantityUser + ", userPerRoomProm="
				+ userPerRoomProm + ", longerMessage=" + longerMessage + ", averageOfUsersPerGroup="
				+ averageOfUsersPerGroup + ", dateOfThLastMessage=" + dateOfThLastMessage + ", dateOfTheFirstLogin="
				+ dateOfTheFirstLogin + ", moreMessagesPerUser=" + moreMessagesPerUser + ", longestMessage="
				+ longestMessage + ", lastGroupCreated=" + lastGroupCreated + ", moreMessagesPerGroup="
				+ moreMessagesPerGroup + "]";
	}
	
	
}
