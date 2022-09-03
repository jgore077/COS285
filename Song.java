package student;

import java.util.*;

/*
 * Song objects contain Strings for a song's artist, title, and lyrics
 * 
 * Starting code by Prof. Boothe 2019
 */
public class Song implements Comparable<Song> {
    // fields
    String artist;
    String title;
    String lyrics;
    // constructor
    public Song(String artist, String title, String lyrics) {
    	this.artist = artist;
    	this.title = title;
    	this.lyrics = lyrics;
    	
    }

    public String getArtist() {
    	return artist;
    }

    public String getLyrics() {
    	return lyrics;
    }

    public String getTitle() {
    	return title;
    }

    public String toString() {
    	return "Title: "+title+"\n"+"Artist: "+ artist +"\n"+"Lyrics: " +lyrics;
    }

    /* 
     * the default comparison of songs
     * primary key: artist, secondary key: title
     * used for sorting and searching the song array
     * if two songs have the same artist and title they are considered the same
     */
    public int compareTo(Song song2) {
    	if(song2.artist.compareTo(this.artist)==0) {
    		return song2.lyrics.compareTo(this.lyrics);
    	}
    	return song2.artist.compareTo(this.artist);
    }

    // testing method to test this class
    public static void main(String[] args) {
        Song s1 = new Song("Professor B",
                "Small Steps",
                "Write your programs in small steps\n"+
                "small steps, small steps\n"+
                "Write your programs in small steps\n"+
                "Test and debug every step of the way.\n");

        Song s2 = new Song("Brian Dill",
                "Ode to Bobby B",
                "Professor Bobby B., can't you see,\n"+
                "sometimes your data structures mystify me,\n"+
                "the biggest algorithm pro since Donald Knuth,\n"+
                "here he is, he's Robert Boothe!\n");

        Song s3 = new Song("Professor B",
                "Debugger Love",
                "I didn't used to like her\n"+
                "I stuck with what I knew\n"+
                "She was waiting there to help me,\n"+
                "but I always thought print would do\n\n"+
                "Debugger love .........\n"+
                "Now I'm so in love with you\n");

        System.out.println("Testing getArtist: " + s1.getArtist());
        System.out.println("Testing getTitle: " + s1.getTitle());
        System.out.println("Testing getLyrics:\n" + s1.getLyrics());
        

        System.out.println();
        System.out.println("Testing toString:");
        System.out.println("Song 1: " + s1);
        System.out.println("Song 2: " + s2);
        System.out.println("Song 3: " + s3);

        System.out.println();
        System.out.println("Testing compareTo:");
        System.out.println("Song1 vs Song2 = " + s1.compareTo(s2));
        System.out.println("Song2 vs Song1 = " + s2.compareTo(s1));
        System.out.println("Song1 vs Song3 = " + s1.compareTo(s3));
        System.out.println("Song3 vs Song1 = " + s3.compareTo(s1));
        System.out.println("Song1 vs Song1 = " + s1.compareTo(s1));
    }
}
