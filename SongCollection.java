package student;
import java.io.*;
import java.util.*;

/*
 * SongCollection.java
 * Read the specified data file and build an array of songs.
 * 
 * Starting code by Prof. Boothe 2019
 */
public class SongCollection {
    private Song[] songs;
   //startsWith(), indexOf(), lastIndexOf(),substring()
    public SongCollection(String filename) {
    	//a song object designed for storing all song info
    	Song temp = new Song("","","");
    	//a list for storing songs
    	List<Song> songlist= new ArrayList<Song>();
    	//a string to concat lyrics into
    	String lyricstring ="";
    	
           
        // read in the song file and build the songs array
    	try {
    	BufferedReader reader = new BufferedReader(new FileReader(filename));
    	String line =reader.readLine();
    	while(line!=null) {
	    	if(line.startsWith("ARTIST")) {
	    		line =line.replace("ARTIST=","");line=line.replaceAll("\"",""); temp.artist=line;
	    		line=reader.readLine();
	    		
	    		}
	    	if(line.startsWith("TITLE")) {
	    		line =line.replace("TITLE=","");line=line.replaceAll("\"",""); temp.title=line;
	    		line=reader.readLine();
	    	
	    	}
	    	if(line.startsWith("LYRICS")) {
	    		line =line.replace("LYRICS=","");
	    		line =line.replaceAll("\"","");
	    		lyricstring =lyricstring.concat(line+" \n");
	    		//this code searches till the next quotation mark as a marker to end the lyrics
	    		while(!line.contains("\"")) {
	    			line=reader.readLine();
	    			lyricstring =lyricstring.concat(line+" \n");  
	    		}
	    		lyricstring.replaceAll("\"","");
	    		//this block adds a new song
	    		temp.lyrics=lyricstring;
	    		lyricstring="";
	    		Song added = new Song(temp.artist,temp.title,temp.lyrics);
	    		songlist.add(added);
	    		line =reader.readLine();
	    		
	    	
	    	}
	      
	    	
    	}
    	//this block initializes the songs array and stores songlist into it
    	songs = new Song[songlist.size()];
    	int i=0;
    	for(Song s:songlist) {
    		songs[i]=s;
    		i++;
    	}
    	Arrays.sort(songs);
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	
    		 
    	 

        // sort the songs array
    }

    // returns the array of all Songs
    // this is used as the data source for building other data structures
    public Song[] getAllSongs() {
        return songs;
    }
    
    // testing method
    // it gets the name of the song file as a command line argument
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("usage: prog songfile");
            return;
        }

        SongCollection sc = new SongCollection(args[0]);
       
        

        // todo: show song count and first 10 songs (name & title only, 1 per line)
        System.out.println("Total songs = "+sc.songs.length+", first songs:");
        for(int i =0;i<10;i++) {
        	System.out.println(sc.songs[i].artist +", \""+sc.songs[i].title+"\"");
        }
    }
}
