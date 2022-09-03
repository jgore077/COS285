package student;
import java.io.*;
import java.util.*;

/*
 * SearchByArtistPrefix.java
 * starting code
 * Boothe 2016
 */
public class SearchByArtistPrefix {

	private Song[] songs;  // The constructor fetches and saves a reference to the song array here

	public SearchByArtistPrefix(SongCollection sc) {
		songs = sc.getAllSongs();
	}

	/**
	 * find all songs matching artist prefix
	 * uses binary search
	 * should operate in time log n + k (# matches)
	 */
	public Song[] search(String artistPrefix) {
		// write this method
	}


	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("usage: prog songfile [search string]");
			return;
		}

		SongCollection sc = new SongCollection(args[0]);
		SearchByArtistPrefix sbap = new SearchByArtistPrefix(sc);

		if (args.length > 1){
			System.out.println("searching for: "+args[1]);
			Song[] byArtistResult = sbap.search(args[1]);

			// to do: show first 10 matches
		}
	}
}
