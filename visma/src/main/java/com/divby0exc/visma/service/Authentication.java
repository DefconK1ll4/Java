package com.divby0exc.visma.service;

import com.divby0exc.visma.model.Registrator;
import com.divby0exc.visma.repository.VismaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.PseudoColumnUsage;
import java.util.Base64;

@Service
public class Authentication {
    private String algo = "AES/CBC/PKCS5Padding";
    @Autowired
    VismaRepository repo;

    public String validateNewUser(Registrator user) {
        final int MIN_LENGTH = 8;
        boolean isBlank = (user.getUsr() == null || user.getUsr().isBlank() || user.getUsr().isEmpty());
        String errorMsg = "";

        if (isBlank) {
            errorMsg = "Username cannot be blank";
        } else if(user.getUsr().length() < MIN_LENGTH) {
            errorMsg = "Your username needs to be atleast 8 characters";
        } else if(user.getPwd().length() < MIN_LENGTH) {
            errorMsg = "Your password needs to be atleast 8 characters";
        } else if(repo.findUserIfExist(user.getUsr())) {
            errorMsg = "Username already in use";
        } else {
            errorMsg = "success";
            repo.addUserToDB(user);
        }

        return errorMsg;
    }

    public boolean authenticateUser(Registrator user) {
        System.out.println(user.getUsr() + " From Form");
        System.out.println(user.getPwd() + " From Form");
        boolean userExist = repo.findUserIfExist(user.getUsr());

        if(!userExist) {
            System.err.println("User was not found in database");
            return false;
        } else if(repo.retrieveCredentials(user.getUsr())==null) {
            System.err.println("To be retrieved user was null");
            return false;
        } else if(!(repo.retrieveCredentials(user.getUsr()).getUsr().equals(user.getUsr())
        && repo.retrieveCredentials(user.getUsr()).getPwd().equals(user.getPwd()))) {
            System.err.println("User credentials didn't match");
            return false;
        } else return true;
    }
    public SecretKey pwdKey(String pwd, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(pwd.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        return secret;
    }
    public IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);

        return new IvParameterSpec(iv);
    }
    public String encrypt(String algo, String in, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algo);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherTxt = cipher.doFinal(in.getBytes());

        return Base64.getEncoder().encodeToString(cipherTxt);
    }
    public String decrypt(String algo, String cipherTxt, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algo);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainTxt = cipher.doFinal(Base64.getDecoder().decode(cipherTxt));

        return new String(plainTxt);
    }
    public SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();

        return key;
    }

}
