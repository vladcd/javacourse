package ro.agilehub.javacourse.designpatterns.builder;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationUser {

    public static final String FIRST = "First";
    public static final String LAST = "Last";
    public static final String FIRST_LAST_EMAIL_DOMAIN = "first.last@email.domain";
    public static final String PASSWORD = "1Passw0rd;";
    public static final String FACEBOOK_ID = "1234567890";
    public static final String GOOGLE_ID = "12345667679";
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String facebookId;
    private String googleId;

    public static enum SocialNetwork {
        GOOGLE, FACEBOOK
    }

    // 1
    public ApplicationUser() {
    }

    public ApplicationUser(String firstName, String lastName, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public ApplicationUser(String firstName, String lastName, String id, SocialNetwork socialNetwork) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (socialNetwork.equals(SocialNetwork.GOOGLE)) {
            this.googleId = id;
        } else if (socialNetwork.equals(SocialNetwork.FACEBOOK)) {
            this.facebookId = id;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    // PROBLEM: we need to be able to create a user in 3 scenarios: if it's a sign up
    // via an email address, a facebook account or a google account

    // TODO 0: try to construct the object with setters, in a method (Factory method)
    // TODO 1: try to add a constructor for each scenario
    // TODO 2: try to add a constructor with all the parameters
    // TODO 3: add a builder

    public static ApplicationUserBuilder builder() {
        return new ApplicationUserBuilder();
    }

    // 3
    public static class ApplicationUserBuilder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String password;
        private String facebookId;
        private String googleId;

        public ApplicationUserBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ApplicationUserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ApplicationUserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ApplicationUserBuilder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public ApplicationUserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public ApplicationUserBuilder facebookId(String facebookId) {
            this.facebookId = facebookId;
            return this;
        }

        public ApplicationUserBuilder googleId(String googleId) {
            this.googleId = googleId;
            return this;
        }

        public ApplicationUser build() {
            ApplicationUser applicationUser = new ApplicationUser();
            applicationUser.setFirstName(firstName);
            applicationUser.setLastName(lastName);
            applicationUser.setEmailAddress(emailAddress);
            applicationUser.setPassword(password);
            applicationUser.setFacebookId(facebookId);
            applicationUser.setGoogleId(googleId);
            return applicationUser;
        }

    }

    public static void main(String[] args) {
        // 0
        createNewUser(FIRST, LAST, FIRST_LAST_EMAIL_DOMAIN, PASSWORD, null, null);
        createNewUser(FIRST, LAST, null, null, FACEBOOK_ID, null);
        createNewUser(FIRST, LAST, null, null, null, GOOGLE_ID);

        // 1
        ApplicationUser.builder()
                .firstName(FIRST)
                .lastName(LAST)
                .emailAddress(FIRST_LAST_EMAIL_DOMAIN)
                .password(PASSWORD)
                .build();

        ApplicationUserBuilder builder = ApplicationUser.builder()
                .firstName(FIRST)
                .lastName(LAST);

        if (args[0].equals(SocialNetwork.FACEBOOK.name())) {
            builder.facebookId(args[0]);
        }

        builder.build();
    }

    private static void createNewUser(String firstName, String lastName, String emailAddress, String password, String facebookId, String googleId) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setFirstName(firstName);
        applicationUser.setLastName(lastName);
        applicationUser.setEmailAddress(emailAddress);
        applicationUser.setPassword(password);
        applicationUser.setFacebookId(facebookId);
        applicationUser.setGoogleId(googleId);
    }
}
