package edu.hm.cs.modsim.studienarbeit2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputWriter {
	//TODO: InterArrivalTimes und ServingTimes in seperate Files schreiben
	private OutputStream out2;
	
	public OutputWriter(String location) {
		try {
		out2 = new BufferedOutputStream(new FileOutputStream("/home/user1301/Documents/output2"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOutput(String content) throws IOException {
		byte[] bytes = content.getBytes();
		try (OutputStream out = new BufferedOutputStream(new FileOutputStream("/home/user1301/Documents/output"))) {
            out.write(bytes);
            out.flush();
            out2.write(bytes);
            out2.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
