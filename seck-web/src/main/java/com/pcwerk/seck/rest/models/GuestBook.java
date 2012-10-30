package com.pcwerk.seck.rest.models;

import java.util.List;

import com.pcwerk.seck.rest.entities.GuestEntry;

public interface GuestBook {
	
	public boolean addGuestEntry(GuestEntry entry);

	public List<GuestEntry> getGuestEntries(String name);

	public boolean deleteGuestEntry(GuestEntry entry);

	public boolean updateGuestEntry(GuestEntry entry);

}