package by.tc.web.service;

import by.tc.web.service.exception.ServiceException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class HashGenerator {
    /**
     * This method encodes the source string to crypted string
     *
     * @param password the source string
     * @return a crypted string
     */
    public static String encryptPassword(String password) throws ServiceException {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        } catch (UnsupportedEncodingException e) {
            throw new ServiceException(e);
        }
        return sha1;
    }

    /**
     * This method encodes the source string to crypted string
     *@param hash the source string
     * @return a crypted string
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
