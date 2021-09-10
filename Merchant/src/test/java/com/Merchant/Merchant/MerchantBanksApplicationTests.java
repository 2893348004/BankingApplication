package com.Merchant.Merchant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
class MerchantBanksApplicationTests {

	@Test
	void contextLoadsds() throws IOException {

		var message = "transaction";

		Timestamp timestamp = Timestamp.from(Instant.now());
		String filename = timestamp.toString() + ".txt";
		filename = filename.replace(":", "-");

		Path currentDirectoryPath = Paths.get("").toAbsolutePath();
		String currentPathString = currentDirectoryPath.toString();
		String result = currentPathString;
		String windowsCompliantPath =  result.replace("\\", "/");


		//String dirName = windowsCompliantPath  + "/transactionsAttemptFolders/" + filename ;
		String dirName = windowsCompliantPath  + "/transactionsAttemptFolders/" + filename;
		File dir = new File(dirName);


		try {
			Files.write(dir.toPath(), message.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





	@Test
	void contextLoads() throws IOException {

		Timestamp timestamp = Timestamp.from(Instant.now());
		String filename = timestamp.toString() + ".txt";
		filename = filename.replace(":", "-");

		Path currentDirectoryPath = Paths.get("").toAbsolutePath();
		String currentPathString = currentDirectoryPath.toString();
		String result = currentPathString;
		String windowsCompliantPath =  result.replace("\\", "/");


		String dirName = windowsCompliantPath  + "/transactionsAttemptFolders/" + filename ;
		File dir = new File(dirName);

		String content = "hi";
		Files.write(dir.toPath(), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
	}


	@Test
	public void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect()
			throws IOException {
		FileWriter fileWriter = new FileWriter("transactionsAttemptFolder/"+"bon.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("Some String");
		printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
		printWriter.close();
	}


	@Test
	public void givenUsingJava7_whenWritingToFile_thenCorrect()
			throws IOException {
		String str = "Hello";

		Path path = Paths.get("D:/WorkProjectsFolder/BankingApplication/Merchant/transactionsAttemptFolder/ll");
		byte[] strToBytes = str.getBytes();

		Files.write(path, strToBytes);

		String read = Files.readAllLines(path).get(0);
		//assertEquals(str, read);
	}


	@Test
	public void givenUoFile_thenCorrect()
			throws IOException {
		var message = "transacgfgtion";

		Timestamp timestamp = Timestamp.from(Instant.now());
		String filename = timestamp.toString() + ".txt";
		filename = filename.replace(":", "-");

		Path currentDirectoryPath = Paths.get("").toAbsolutePath();
		String currentPathString = currentDirectoryPath.toString();
		String result = currentPathString;
		String windowsCompliantPath =  result.replace("\\", "/");


		String dirName = windowsCompliantPath   ;


		String fileName = "test.txt";
		File dir = new File(dirName);
		File actualFile = new File(dir, filename);




	}



}
