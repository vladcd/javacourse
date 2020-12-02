package ro.agilehub.javacourse.designpatterns;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public void commandDevice(String operation) {
        if (operation.equals("turnOffLights")) {
            System.out.println("The lights are off");
        } else if (operation.equals("turnOnLights")) {
            System.out.println("The lights are on");
        } else if (operation.equals("turnVolumeUp")) {
            System.out.println("The volume has been turned up");
        }
    }

    public void useStrategy(String firstName, String lastName, String strategy) {
        if (strategy.equals("firstNameFirst")) {
            System.out.println(firstName + " " + lastName);
        } else if (strategy.equals("lastNameFirst")) {
            System.out.println(lastName + " " + firstName);
        } else {
            System.out.println("Not a valid strategy");
        }
    }

    public static class HttpConnectionHandler {

        private URL url;

        public HttpConnectionHandler(URL url) {
            this.url = url;
        }

        public HttpURLConnection createConnection() throws IOException {
            return (HttpURLConnection) this.url.openConnection();
        }

        public Optional<String> sendBody(HttpURLConnection httpURLConnection, String requestMethod, String body) throws IOException {
            if (requestMethod.equals("POST")) {
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(body.getBytes());
                os.flush();
                os.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return Optional.of(response.toString());
            }
            return Optional.empty();
        }
    }

    @Data
    public static class BusyObject {

        private Integer id;
        private String name;
        private LocalDate creationDate;

        public void updateObjectAndDependencies(String name, LocalDate creationDate) {
            this.name = name;
            if (creationDate.isBefore(this.creationDate)) {
                throw new IllegalArgumentException("The date can't be set before the original creation date");
            }

            addHistoryMessage();
            updateChildren();
        }

        private void addHistoryMessage() {
            // do nothing
        }

        private void updateChildren() {
            // do nothing
        }

    }

}
