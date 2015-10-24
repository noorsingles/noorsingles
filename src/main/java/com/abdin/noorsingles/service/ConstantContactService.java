package com.abdin.noorsingles.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabdin
 */
@Service
public class ConstantContactService {

    String API_KEY = "j23q8kzsmm3heq7mbx82uhwm";
    String API_SECRET="BjwwfX426XX3XED8tJKESqQF";
    String API_TOKEN="c215b8e1-5c91-4102-b46e-d37f5158b47a";
    private URL getURL() {
        URL oracle = null;
        try {
            oracle = new URL("https://api.constantcontact.com/v2/contacts?api_key=" + API_KEY+"&action_by=ACTION_BY_VISITOR");

        } catch (MalformedURLException ex) {
            Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return oracle;
    }

    public JSONObject addContact(String email) {

        JSONObject contact = getContactFromRequest(email);

        try {
            return addContactToCC(contact);
        } catch (IOException ex) {
            Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new JSONObject();
    }

    private JSONObject addContactToCC(JSONObject contact) throws IOException, JSONException {

        HttpURLConnection yc = (HttpURLConnection) getURL().openConnection();
        JSONObject results = null;
        yc.setDoOutput(true);

        yc.setRequestProperty("Content-Type", "application/json");
        yc.setRequestProperty("Authorization", " Bearer "+API_TOKEN);
        yc.setRequestProperty("action_by", "ACTION_BY_VISITOR");
        yc.setRequestProperty("X-Originating-Ip", getIp());

        byte[] outputBytes = contact.toString().getBytes("UTF-8");
        OutputStream os = yc.getOutputStream();
        os.write(outputBytes);
        os.close();


        try {
            InputStream inStream = yc.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
            results = getJSONfromBufferReader(in);
            in.close();

        } catch (IOException ex) {
            
            results = new JSONObject();
            results.append("code", yc.getResponseCode());
            results.append("message", yc.getResponseMessage());
            return results;

        }

        results.append("code", yc.getResponseCode());
        results.append("message", yc.getResponseMessage());

        return results;
    }

    private JSONObject getJSONfromBufferReader(BufferedReader br) {
        StringBuffer sb = new StringBuffer();
        try {

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            return new JSONObject(sb.toString());

        } catch (IOException ex) {
            Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new JSONObject();
    }

    private JSONObject getContactFromRequest(String email) {

        if (!email.isEmpty()) {
            try {
                JSONObject contact = new JSONObject();

                JSONArray lists = new JSONArray();
                JSONObject list = new JSONObject();
                list.putOpt("id", "1");
                lists.put(list);
                contact.put("lists", lists);

                JSONArray email_addresses = new JSONArray();
                JSONObject email_address = new JSONObject();
                email_addresses.put(email_address);

                email_address.putOpt("email_address", email);

                contact.put("email_addresses", email_addresses);

                return contact;

            } catch (JSONException ex) {
                Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
        return new JSONObject();
    }

    private String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConstantContactService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}
