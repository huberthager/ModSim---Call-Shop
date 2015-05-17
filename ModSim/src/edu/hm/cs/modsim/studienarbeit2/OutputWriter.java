package edu.hm.cs.modsim.studienarbeit2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputWriter {
	
	private String content = "";
	private byte[] bytes = content.getBytes();
	

	public void writeOutput(String content) throws IOException {
		try (OutputStream out = new BufferedOutputStream(new FileOutputStream("/home/user1301/Documents"))) {
            out.write(bytes);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
