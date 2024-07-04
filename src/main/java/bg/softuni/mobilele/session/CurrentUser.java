//package bg.softuni.mobilele.session;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.SessionScope;
//
//@Component
//@SessionScope
//public class CurrentUser {
//    private Long id;
//    private String name;
//    private  String email;
//    private boolean isLoggedIn;
//
//    public CurrentUser() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public CurrentUser setId(Long id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public CurrentUser setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public boolean isAnonymous() {
//        return !isLoggedIn();
//    }
//
//    public boolean isLoggedIn() {
//        return this.email != null;
//    }
//
//    public CurrentUser setLoggedIn(boolean loggedIn) {
//        isLoggedIn = loggedIn;
//        return this;
//    }
//
//    public void login(Long id, String email) {
//        this.id = id;
//        this.email = email;
//    }
//
//    public void clear() {
////        isLoggedIn = false;
//        name = null;
//        email = null;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public CurrentUser setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//}
