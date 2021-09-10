package com.Merchant.Merchant.Transactions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@Service
@Transactional
public class TransactionService {


    @Autowired
    private TransactionRepository transactionRepository;


    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }



    public String tryThisTransaction(Transaction transaction) {
        BCryptPasswordEncoder bCryptPasswordEncoder;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();


        var block0 = transaction.getIncrementor().toString();
        var block1 = transaction.getCardNumber();
        var block2 = transaction.getFirstName();
        var block3 = transaction.getLastName();
        var block4 = transaction.getExp();
        var block5 = transaction.getPin();
        var block6 = transaction.getBin();
        var block7 = transaction.getCcv();
        var block8 = transaction.getAmount();
        var adjustedAmt = String.valueOf(block8);


        var hideMyCardNumber = bCryptPasswordEncoder.encode(block1);
        var hideMyFirstName = bCryptPasswordEncoder.encode(block2);
        var hideMyCLastName = bCryptPasswordEncoder.encode(block3);
        var hideMyExp = bCryptPasswordEncoder.encode(block4);
        var hideMyPin = bCryptPasswordEncoder.encode(block5);
        var hideMyBin = bCryptPasswordEncoder.encode(block6);
        var hideMyCCV = bCryptPasswordEncoder.encode(block7);


        transaction.setCardNumber(hideMyCardNumber);
        transaction.setFirstName(hideMyFirstName);
        transaction.setLastName(hideMyCLastName);
        transaction.setExp(hideMyExp);
        transaction.setPin(hideMyPin);
        transaction.setBin(hideMyBin);
        transaction.setCcv(hideMyCCV);
        transaction.setAmount(block8);

        transactionRepository.save(transaction);

        ArrayList<String> mylist = new ArrayList<>();
        mylist.add(block0);
        mylist.add(block1);
        mylist.add(block2);
        mylist.add(block3);
        mylist.add(block4);
        mylist.add(block5);
        mylist.add(block6);
        mylist.add(block7);
        mylist.add(adjustedAmt);


        StringBuilder sb = new StringBuilder();
        for (String s : mylist) {
            sb.append(s);
            sb.append(",");
        }


        return sb.toString();


    }


    public void saveTransactionToFile(String transaction)
    {
        var message = transaction;

        Timestamp timestamp = Timestamp.from(Instant.now());
        String filename = timestamp.toString() + ".txt";
        filename = filename.replace(":", "-");

        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        String currentPathString = currentDirectoryPath.toString();
        String result = currentPathString;
        String windowsCompliantPath =  result.replace("\\", "/");


        String dirName = windowsCompliantPath + "/Merchant" + "/transactionsAttemptFolders/" + filename;
        File dir = new File(dirName);


        try {
            Files.write(dir.toPath(), message.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
