package edu.hm.cs.modsim.studienarbeit2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class OutputWriter {
	
	  private File file;
	  private FileWriter writer;
	  
	  public OutputWriter(String filename) {
		  this.file = new File(filename + ".txt");
		  this.writer = null;
	  }
	  
	  public void writeOutputToFile(String output) {
	    try {
	        writer = new FileWriter(file);
	        writer.write(output);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    System.out.printf("File is located at %s%n", file.getAbsolutePath());
	  }
	
}
