package com.pcwerk.seck.rest.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pcwerk.seck.rest.entities.GuestEntry;

/**
 * Data source for the guestbook model
 * 
 * @author mlbuising
 * 
 */
public class InMemoryGuestBook implements GuestBook {

	private Map<String, List<GuestEntry>> guestBookEntries;

	public InMemoryGuestBook() {
		this.guestBookEntries = new HashMap<String, List<GuestEntry>>();
	}

	public boolean addGuestEntry(GuestEntry entry) {
		List<GuestEntry> entryList;

		if (!this.guestBookEntries.containsKey(entry.getName())) {
			entryList = new ArrayList<GuestEntry>();
			entryList.add(entry);
			this.guestBookEntries.put(entry.getName(), entryList);

			return true;
		} else {
			entryList = this.getGuestEntries(entry.getName());
			if (!entryList.contains(entry)) {
				entryList.add(entry);
			}
		}

		return false;
	}

	public List<GuestEntry> getGuestEntries(String name) {
		List<GuestEntry> masterList = new ArrayList<GuestEntry>();

		if (name.isEmpty()) {
			for (List<GuestEntry> entryList : this.guestBookEntries.values()) {
				masterList.addAll(entryList);
			}
		}

		Collections.sort(masterList);
		
		if (guestBookEntries.containsKey(name)) {
			return guestBookEntries.get(name);
		}

		return masterList;
	}

	public boolean deleteGuestEntry(GuestEntry entry) {
		List<GuestEntry> entryList;

		if (this.guestBookEntries.containsKey(entry.getName())) {
			entryList = this.guestBookEntries.get(entry.getName());

			if (entryList.contains(entry)) {
				entryList.remove(entry);
				return true;
			}
		}

		return false;
	}

	public boolean updateGuestEntry(GuestEntry entry) {

		if (this.guestBookEntries.containsKey(entry.getName())) {
			List<GuestEntry> entryList = this.guestBookEntries.get(entry.getName());

			if (entryList.contains(entry)) {
				GuestEntry thisEntry = entryList.get(entryList.indexOf(entry));
				thisEntry.setMessage(entry.getMessage());
				thisEntry.setTimestamp(entry.getTimestamp());
				
				return true;
			}
		}

		return false;
	}
}