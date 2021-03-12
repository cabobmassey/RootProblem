package rootProblem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import rootProblem.Models.RootDriver;

public class RootFileWriter {

	public static void WriteFile(HashMap<String, RootDriver> drivers) {

		BufferedWriter bw = null;

		String date = new SimpleDateFormat("dd-MMM-yyyy-HH.mm.ss").format(new Date());

		try {

			// Specify the file name and path here
			File file = new File("src/main/resources/Root_Driver_Report_" + date + ".txt");

			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!file.exists()) {

				file.createNewFile();

			}

			FileWriter fw = new FileWriter(file);

			bw = new BufferedWriter(fw);

			for (RootDriver driver : drivers.values()) {

				bw.write(driver.getName() + ": " + driver.getMilesDriven() + " miles @ "
						+ driver.getAvgSpeed() + "mph" + "\n");

			}

			System.out.println("File written Successfully");

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

		finally

		{
			try {

				if (bw != null)

					bw.close();

			} catch (Exception ex) {

				System.out.println("Error in closing the BufferedWriter" + ex);

			}
		}
	}

}
